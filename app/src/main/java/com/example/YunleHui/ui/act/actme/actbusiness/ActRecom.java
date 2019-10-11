package com.example.YunleHui.ui.act.actme.actbusiness;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.YunleHui.Bean.BeanImgs;
import com.example.YunleHui.Bean.Bean_details;
import com.example.YunleHui.Bean.Bean_dhcb;
import com.example.YunleHui.Bean.Bean_imgde;
import com.example.YunleHui.Bean.Bean_shopUrl;
import com.example.YunleHui.Bean.Bean_suc;
import com.example.YunleHui.Bean.Bean_xiao;
import com.example.YunleHui.MainActivity;
import com.example.YunleHui.R;
import com.example.YunleHui.adpter.FullyGridLayoutManager;
import com.example.YunleHui.adpter.GridPublishGoods;
import com.example.YunleHui.adpter.GridPublishGoodsTao;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.InputTextMsgDialog;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.datapick.DataPickerDialog;
import com.example.YunleHui.view.datapick.DatePickerDialog;
import com.example.YunleHui.view.datapick.DateUtil;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.permissions.RxPermissions;
import com.luck.picture.lib.tools.PictureFileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.example.YunleHui.ui.act.actme.actbusiness.ActRefunds.actRefunds;

public class ActRecom extends BaseAct {


    private int as = -1;


    //  Json传递
    Map<Object, Object> goodsInfor = new HashMap<>();


    //商品的头部的数据
    private ArrayList<LocalMedia> headList = new ArrayList<>();

    //    商品套餐的数据
    ArrayList<BeanImgs> dataTao = new ArrayList<>();


    private List<String> list = new ArrayList<>();


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    @BindView(R.id.recycler_tao)
    RecyclerView recycler_tao;

    //套餐的所有的值
    ArrayList<BeanImgs> datassss = new ArrayList<>();

    private MyRecycleViewAdapter myRecycleViewAdapter;

    private int themeId;
    private int chooseMode = PictureMimeType.ofImage();

    private InputTextMsgDialog inputTextMsgDialog;

    //宣传海报
    @BindView(R.id.recycler_head)
    RecyclerView recycler_head;


    @BindView(R.id.lin_Posters)
    LinearLayout lin_Posters;

    @BindView(R.id.lin_xiang)
    LinearLayout lin_xiang;

    //    发布
    @BindView(R.id.text_Release)
    TextView text_Release;

    @BindView(R.id.lin_xia)
    LinearLayout lin_xia;

    //店铺名字
    private String goodNmae;
    //    店铺介绍
    private String intro;

    //    总的图片数量
    private int all = 0;

    private List<Integer> paisize = new ArrayList<>();




    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_recom;
    }

    @Override
    protected void findViews() {
        if (toolbar_all != null) {
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("发布商品");
        }
    }
















    @Override
    public void initData() {

        banners.clear();

        headList.clear();
        dataTao.clear();


        goodsInfor.clear();
        paisize.clear();

        Intent intent = getIntent();

        headList = intent.getParcelableArrayListExtra("head");

        dataTao = intent.getParcelableArrayListExtra("tao");

        goodNmae = intent.getStringExtra("shopNmae");

        intro = intent.getStringExtra("intro");


        String[] data = getResources().getStringArray(R.array.list);
        for (String str : data) {
            list.add(str);
        }

        themeId = R.style.picture_default_style;

        FullyGridLayoutManager manager = new FullyGridLayoutManager(ActRecom.this, 4, GridLayoutManager.VERTICAL, false);
        recycler_head.setLayoutManager(manager);
        adapter = new GridPublishGoods(ActRecom.this, onAddPicClickListener);
        adapter.setList(selectList);
        adapter.setSelectMax(maxSelectNum);
        recycler_head.setAdapter(adapter);


        adapter.setOnItemClickListener(new GridPublishGoods.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                if (selectList.size() > 0) {
                    LocalMedia media = selectList.get(position);
                    String pictureType = media.getPictureType();
                    int mediaType = PictureMimeType.pictureToVideo(pictureType);
                    switch (mediaType) {
                        case 1:
                            // 预览图片 可自定长按保存路径
                            //PictureSelector.create(MainActivity.this).themeStyle(themeId).externalPicturePreview(position, "/custom_file", selectList);
                            PictureSelector.create(ActRecom.this).themeStyle(themeId).openExternalPreview(position, selectList);
                            break;
                        case 2:
                            // 预览视频
                            PictureSelector.create(ActRecom.this).externalPictureVideo(media.getPath());
                            break;
                        case 3:
                            // 预览音频
                            PictureSelector.create(ActRecom.this).externalPictureAudio(media.getPath());
                            break;
                    }
                }
            }
        });


        // 清空图片缓存，包括裁剪、压缩后的图片 注意:必须要在上传完成后调用 必须要获取权限
        RxPermissions permissions = new RxPermissions(this);
        permissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE).subscribe(new Observer<Boolean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Boolean aBoolean) {
                if (aBoolean) {
                    PictureFileUtils.deleteCacheDirFile(ActRecom.this);
                } else {
                    Toast.makeText(ActRecom.this,
                            getString(R.string.picture_jurisdiction), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {

            }
        });


        LinearLayoutManager layoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        recycler_tao.setLayoutManager(layoutManager);

        datassss.clear();

        List<LocalMedia> imgs = new ArrayList<>();
        imgs.clear();
        for (int i = 0; i < 1; i++) {
            datassss.add(new BeanImgs("", "", imgs, "", "0.00", "0.00", "0.00", "0.00"));
        }

        myRecycleViewAdapter = new MyRecycleViewAdapter(datassss, this);

        recycler_tao.setAdapter(myRecycleViewAdapter);

        //传true 可以滑动 false不可以滑动
        recycler_tao.setNestedScrollingEnabled(false);


        inputTextMsgDialog = new InputTextMsgDialog(ActRecom.this, R.style.dialog_center);
        inputTextMsgDialog.setHint("请输入"); //设置输入提示文字
        inputTextMsgDialog.setBtnText("确定"); //设置按钮的文字 默认为：发送
        inputTextMsgDialog.setMaxNumber(200);//最大输入字数 默认200


        inputTextMsgDialog.setmOnTextSendListener(new InputTextMsgDialog.OnTextSendListener() {
            @Override
            public void onTextSend(String msg) {
                if (msg.length() > 0) {
                    datassss.get(postionTao).setDetails(msg);
                }
                myRecycleViewAdapter = new MyRecycleViewAdapter(datassss, ActRecom.this);
                recycler_tao.setAdapter(myRecycleViewAdapter);
                inputTextMsgDialog.dismiss(); //隐藏此dialog
            }
        });
    }


    private int maxSelectNum = 6;


    private int postionTao = 0;


    public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {

        private LayoutInflater inflater;
        private ArrayList<BeanImgs> datas = new ArrayList<>();
        private Context context;

        public MyRecycleViewAdapter(ArrayList<BeanImgs> datas, Context context) {
            this.datas.clear();
            this.datas.addAll(datas);
            this.context = context;
            this.inflater = LayoutInflater.from(context);
        }


        //        获取所有的数据
        public ArrayList<BeanImgs> getTaoDatas() {
            return datas;
        }


        @Override
        public MyRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_refundbao, parent, false);
            return new MyRecycleViewAdapter.ViewHolder(view);
        }

        public ArrayList<BeanImgs> getData() {
            return datas;
        }

        @Override
        public void onBindViewHolder(MyRecycleViewAdapter.ViewHolder holder, final int positionss) {

            holder.text_shan.setText("删除描述");
            holder.text_add.setText("添加描述");
            holder.lin_Price.setVisibility(View.GONE);


            try {
                if (datas.get(positionss).getDetails() != null && datas.get(positionss).getDetails().length() > 0) {
                    holder.text_kkk.setText(datas.get(positionss).getDetails());
                } else {
                    holder.text_kkk.setHint("顾客更喜欢细节说明");
                }
            } catch (Exception e) {

            }
            managerOne = new FullyGridLayoutManager(ActRecom.this, 4, GridLayoutManager.VERTICAL, false);
            holder.xr_refund.setLayoutManager(managerOne);
            adapterTao = new GridPublishGoodsTao(ActRecom.this, onAddPicClickListeners, positionss, holder.text_kkk.getText().toString());
            Log.i("GridPublishGoodsTao", datas.get(positionss).getImgs().size() + "----" + "----");
            adapterTao.setList(datas.get(positionss).getImgs());
            adapterTao.setSelectMax(maxSelectNum);
            holder.xr_refund.setAdapter(adapterTao);
            holder.xr_refund.setNestedScrollingEnabled(false);
            adapterTao.setOnItemClickListener(new GridPublishGoodsTao.OnItemClickListener() {
                @Override
                public void onItemClick(int position, View v) {
                    Toast.makeText(ActRecom.this, postionTao + "----" + positionss, Toast.LENGTH_SHORT).show();
                    Log.i("adapterTao", postionTao + "---" + positionss);
                    if (datas.get(positionss).getImgs().size() > 0) {
                        LocalMedia media = datas.get(positionss).getImgs().get(position);
                        String pictureType = media.getPictureType();
                        int mediaType = PictureMimeType.pictureToVideo(pictureType);
                        switch (mediaType) {
                            case 1:
                                // 预览图片 可自定长按保存路径
                                //PictureSelector.create(MainActivity.this).themeStyle(themeId).externalPicturePreview(position, "/custom_file", selectList);
                                PictureSelector.create(ActRecom.this).themeStyle(themeId).openExternalPreview(position, datas.get(positionss).getImgs());
                                break;
                            case 2:
                                // 预览视频
                                PictureSelector.create(ActRecom.this).externalPictureVideo(media.getPath());
                                break;
                            case 3:
                                // 预览音频
                                PictureSelector.create(ActRecom.this).externalPictureAudio(media.getPath());
                                break;
                        }
                    }
                }
            });

            holder.lin_addItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (datassss.size() < 11) {
                        List<LocalMedia> selectListTao = new ArrayList<>();
                        selectListTao.clear();
                        datassss.add(new BeanImgs("", "", selectListTao, "0.00", "0.00", "0.00", "", "0.00"));
                        myRecycleViewAdapter = new MyRecycleViewAdapter(datassss, ActRecom.this);
                        recycler_tao.setAdapter(myRecycleViewAdapter);
                    } else {
                        Toast.makeText(ActRecom.this, "最多添加10个描述！", Toast.LENGTH_SHORT).show();
                    }

                }
            });

            holder.lin_RemoveItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    datassss.remove(positionss);
                    myRecycleViewAdapter = new MyRecycleViewAdapter(datassss, ActRecom.this);
                    recycler_tao.setAdapter(myRecycleViewAdapter);
                }
            });


            holder.text_kkk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    postionTao = positionss;

                    if (datassss.get(positionss).getDetails() != null && datassss.get(positionss).getDetails().length() > 0) {
                        inputTextMsgDialog.setTextNow(datassss.get(postionTao).getDetails());
                    } else {
                        inputTextMsgDialog.setHint("请输入套餐详情");
                    }
                    inputTextMsgDialog.show();

                }
            });

        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private RecyclerView xr_refund;
            private LinearLayout lin_addItem;
            private LinearLayout lin_RemoveItem;
            private LinearLayout lin_Price;
            private TextView text_yuan;
            private TextView text_kkk;
            private TextView text_name, text_shan, text_add;

            public ViewHolder(View itemView) {
                super(itemView);
                xr_refund = (RecyclerView) itemView.findViewById(R.id.xr_refund);
                lin_addItem = (LinearLayout) itemView.findViewById(R.id.lin_addItem);
                lin_RemoveItem = (LinearLayout) itemView.findViewById(R.id.lin_RemoveItem);
                lin_Price = (LinearLayout) itemView.findViewById(R.id.lin_Price);
                text_yuan = (TextView) itemView.findViewById(R.id.text_yuan);
                text_kkk = (TextView) itemView.findViewById(R.id.text_kkk);
                text_shan = (TextView) itemView.findViewById(R.id.text_shan);
                text_add = (TextView) itemView.findViewById(R.id.text_add);
                text_name = (TextView) itemView.findViewById(R.id.text_name);
            }
        }
    }


    //套餐一个的时候显示
    FullyGridLayoutManager managerOne;

    private GridPublishGoodsTao adapterTao;


    //套餐的数据
    GridPublishGoodsTao.onAddPicClickListener onAddPicClickListeners = new GridPublishGoodsTao.onAddPicClickListener() {
        @Override
        public void onAddPicClick(int position, String contexts) {

//            Toast.makeText(ActRecom.this, "===222===" + "---" + contexts + position, Toast.LENGTH_SHORT).show();

            postionTao = position;

            Moder = 1;

//          相册or单独拍照

            boolean mode = true;
            if (mode) {
                // 进入相册 以下是例子：不需要的api可以不写
                PictureSelector.create(ActRecom.this)
                        .openGallery(chooseMode)// 全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                        .theme(themeId)// 主题样式设置 具体参考 values/styles   用法：R.style.picture.white.style
                        .maxSelectNum(maxSelectNum)// 最大图片选择数量
                        .minSelectNum(1)// 最小选择数量
                        .imageSpanCount(4)// 每行显示个数
                        .selectionMode(true ?
                                PictureConfig.MULTIPLE : PictureConfig.SINGLE)// 多选 or 单选
                        .previewImage(true)// 是否可预览图片
                        .previewVideo(false)// 是否可预览视频
                        .enablePreviewAudio(false) // 是否可播放音频
                        .isCamera(true)// 是否显示拍照按钮
                        .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                        //.imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                        //.setOutputCameraPath("/CustomPath")// 自定义拍照保存路径
                        .enableCrop(false)// 是否裁剪
                        .compress(true)// 是否压缩
                        .synOrAsy(true)//同步true或异步false 压缩 默认同步
                        //.compressSavePath(getPath())//压缩图片保存地址
                        //.sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                        .glideOverride(160, 160)// glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                        .withAspectRatio(1, 1)// 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                        .hideBottomControls(false ? false : true)// 是否显示uCrop工具栏，默认不显示
                        .isGif(false)// 是否显示gif图片
                        .freeStyleCropEnabled(true)// 裁剪框是否可拖拽
                        .circleDimmedLayer(false)// 是否圆形裁剪
                        .showCropFrame(false)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false
                        .showCropGrid(false)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false
                        .openClickSound(false)// 是否开启点击声音
                        .selectionMedia(datassss.get(postionTao).getImgs())// 是否传入已选图片
                        //.isDragFrame(false)// 是否可拖动裁剪框(固定)
//                        .videoMaxSecond(15)
//                        .videoMinSecond(10)
                        //.previewEggs(false)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中)
                        //.cropCompressQuality(90)// 裁剪压缩质量 默认100
                        .minimumCompressSize(100)// 小于100kb的图片不压缩
                        //.cropWH()// 裁剪宽高比，设置如果大于图片本身宽高则无效
                        //.rotateEnabled(true) // 裁剪是否可旋转图片
                        //.scaleEnabled(true)// 裁剪是否可放大缩小图片
                        //.videoQuality()// 视频录制质量 0 or 1
                        //.videoSecond()//显示多少秒以内的视频or音频也可适用
                        //.recordVideoSecond()//录制视频秒数 默认60s
                        .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
            } else {
                // 单独拍照
                PictureSelector.create(ActRecom.this)
                        .openCamera(chooseMode)// 单独拍照，也可录像或也可音频 看你传入的类型是图片or视频
                        .theme(themeId)// 主题样式设置 具体参考 values/styles
                        .maxSelectNum(maxSelectNum)// 最大图片选择数量
                        .minSelectNum(1)// 最小选择数量
                        .selectionMode(true ?
                                PictureConfig.MULTIPLE : PictureConfig.SINGLE)// 多选 or 单选
                        .previewImage(true)// 是否可预览图片
                        .previewVideo(true)// 是否可预览视频
                        .enablePreviewAudio(false) // 是否可播放音频
                        .isCamera(true)// 是否显示拍照按钮
                        .enableCrop(false)// 是否裁剪
                        .compress(true)// 是否压缩
                        .glideOverride(160, 160)// glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                        .withAspectRatio(1, 1)// 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                        .hideBottomControls(false ? false : true)// 是否显示uCrop工具栏，默认不显示
                        .isGif(false)// 是否显示gif图片
                        .freeStyleCropEnabled(false)// 裁剪框是否可拖拽
                        .circleDimmedLayer(false)// 是否圆形裁剪
                        .showCropFrame(false)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false
                        .showCropGrid(false)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false
                        .openClickSound(false)// 是否开启点击声音
                        .selectionMedia(datassss.get(postionTao).getImgs())// 是否传入已选图片
                        .previewEggs(false)//预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中)
                        //.previewEggs(false)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中)
                        //.cropCompressQuality(90)// 裁剪压缩质量 默认为100
                        .minimumCompressSize(100)// 小于100kb的图片不压缩
                        //.cropWH()// 裁剪宽高比，设置如果大于图片本身宽高则无效
                        //.rotateEnabled() // 裁剪是否可旋转图片
                        //.scaleEnabled()// 裁剪是否可放大缩小图片
                        //.videoQuality()// 视频录制质量 0 or 1
                        //.videoSecond()////显示多少秒以内的视频or音频也可适用
                        .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
            }
        }
    };


    private List<LocalMedia> selectList = new ArrayList<>();
    private GridPublishGoods adapter;

    // 0 头部的数据，1套餐的数据
    private int Moder = 0;
    private String path_img;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    if (Moder == 0) {
                        // 图片选择结果回调
                        selectList = PictureSelector.obtainMultipleResult(data);
                        // 例如 LocalMedia 里面返回三种path
                        // 1.media.getPath(); 为原图path
                        // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                        // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                        // 如果裁剪并压缩了，已取压缩路径为准，因为是先裁剪后压缩的
                        for (LocalMedia media : selectList) {
                            path_img = media.getCompressPath();
                            Log.i(TAG, "压缩---->" + media.getCompressPath());
                            Log.i(TAG, "原图---->" + media.getPath());
                            Log.i(TAG, "裁剪---->" + media.getCutPath());
                        }
                        adapter.setList(selectList);
                        adapter.notifyDataSetChanged();
                    } else if (Moder == 1) {


//                      类型，外面还是 里面
//                      刷新数据
                        selectListTao = PictureSelector.obtainMultipleResult(data);
                        Log.i("postionTao", adapterTao.getPositions() + "---");

                        datassss.get(postionTao).setImgs(selectListTao);
                        myRecycleViewAdapter = new MyRecycleViewAdapter(datassss, this);
                        recycler_tao.setAdapter(myRecycleViewAdapter);

                    }

                    break;
            }
        }
//        获取核销店铺传递回来的数据
        else {


            try {
                datsds.clear();

                Bundle bundle = data.getExtras();
                datsds = (ArrayList<Bean_xiao>) bundle.getSerializable("gates");
            } catch (Exception e) {

            }


        }
    }

    //选择的核销的商家
    ArrayList<Bean_xiao> datsds = new ArrayList<Bean_xiao>();


    private List<LocalMedia> selectListTao = new ArrayList<>();

    private final static String TAG = MainActivity.class.getSimpleName();


    //头部的数据
    private GridPublishGoods.onAddPicClickListener onAddPicClickListener = new GridPublishGoods.onAddPicClickListener() {
        @Override
        public void onAddPicClick() {

//           Toast.makeText(ActRecom.this, "===111===", Toast.LENGTH_SHORT).show();


            Moder = 0;


//          相册or单独拍照

            boolean mode = true;
            if (mode) {
                // 进入相册 以下是例子：不需要的api可以不写
                PictureSelector.create(ActRecom.this)
                        .openGallery(chooseMode)// 全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                        .theme(themeId)// 主题样式设置 具体参考 values/styles   用法：R.style.picture.white.style
                        .maxSelectNum(maxSelectNum)// 最大图片选择数量
                        .minSelectNum(1)// 最小选择数量
                        .imageSpanCount(4)// 每行显示个数
                        .selectionMode(true ?
                                PictureConfig.MULTIPLE : PictureConfig.SINGLE)// 多选 or 单选
                        .previewImage(true)// 是否可预览图片
                        .previewVideo(false)// 是否可预览视频
                        .enablePreviewAudio(false) // 是否可播放音频
                        .isCamera(true)// 是否显示拍照按钮
                        .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                        //.imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                        //.setOutputCameraPath("/CustomPath")// 自定义拍照保存路径
                        .enableCrop(false)// 是否裁剪
                        .compress(true)// 是否压缩
                        .synOrAsy(true)//同步true或异步false 压缩 默认同步
                        //.compressSavePath(getPath())//压缩图片保存地址
                        //.sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                        .glideOverride(160, 160)// glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                        .withAspectRatio(1, 1)// 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                        .hideBottomControls(false ? false : true)// 是否显示uCrop工具栏，默认不显示
                        .isGif(false)// 是否显示gif图片
                        .freeStyleCropEnabled(true)// 裁剪框是否可拖拽
                        .circleDimmedLayer(false)// 是否圆形裁剪
                        .showCropFrame(false)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false
                        .showCropGrid(false)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false
                        .openClickSound(false)// 是否开启点击声音
                        .selectionMedia(selectList)// 是否传入已选图片
                        //.isDragFrame(false)// 是否可拖动裁剪框(固定)
//                        .videoMaxSecond(15)
//                        .videoMinSecond(10)
                        //.previewEggs(false)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中)
                        //.cropCompressQuality(90)// 裁剪压缩质量 默认100
                        .minimumCompressSize(100)// 小于100kb的图片不压缩
                        //.cropWH()// 裁剪宽高比，设置如果大于图片本身宽高则无效
                        //.rotateEnabled(true) // 裁剪是否可旋转图片
                        //.scaleEnabled(true)// 裁剪是否可放大缩小图片
                        //.videoQuality()// 视频录制质量 0 or 1
                        //.videoSecond()//显示多少秒以内的视频or音频也可适用
                        //.recordVideoSecond()//录制视频秒数 默认60s
                        .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
            } else {
                // 单独拍照
                PictureSelector.create(ActRecom.this)
                        .openCamera(chooseMode)// 单独拍照，也可录像或也可音频 看你传入的类型是图片or视频
                        .theme(themeId)// 主题样式设置 具体参考 values/styles
                        .maxSelectNum(maxSelectNum)// 最大图片选择数量
                        .minSelectNum(1)// 最小选择数量
                        .selectionMode(true ?
                                PictureConfig.MULTIPLE : PictureConfig.SINGLE)// 多选 or 单选
                        .previewImage(true)// 是否可预览图片
                        .previewVideo(true)// 是否可预览视频
                        .enablePreviewAudio(false) // 是否可播放音频
                        .isCamera(true)// 是否显示拍照按钮
                        .enableCrop(false)// 是否裁剪
                        .compress(true)// 是否压缩
                        .glideOverride(160, 160)// glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                        .withAspectRatio(1, 1)// 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                        .hideBottomControls(false ? false : true)// 是否显示uCrop工具栏，默认不显示
                        .isGif(false)// 是否显示gif图片
                        .freeStyleCropEnabled(false)// 裁剪框是否可拖拽
                        .circleDimmedLayer(false)// 是否圆形裁剪
                        .showCropFrame(false)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false
                        .showCropGrid(false)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false
                        .openClickSound(false)// 是否开启点击声音
                        .selectionMedia(selectList)// 是否传入已选图片
                        .previewEggs(false)//预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中)
                        //.previewEggs(false)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中)
                        //.cropCompressQuality(90)// 裁剪压缩质量 默认为100
                        .minimumCompressSize(100)// 小于100kb的图片不压缩
                        //.cropWH()// 裁剪宽高比，设置如果大于图片本身宽高则无效
                        //.rotateEnabled() // 裁剪是否可旋转图片
                        //.scaleEnabled()// 裁剪是否可放大缩小图片
                        //.videoQuality()// 视频录制质量 0 or 1
                        //.videoSecond()////显示多少秒以内的视频or音频也可适用
                        .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
            }
        }
    };


    @BindView(R.id.lin_appointment)
    LinearLayout lin_appointment;


    @BindView(R.id.lin_four)
    LinearLayout lin_four;


    @OnClick({R.id.lin_Posters, R.id.lin_appointment, R.id.lin_Effective, R.id.lin_merchants,
            R.id.lin_xiang, R.id.lin_four, R.id.text_Release, R.id.lin_xia})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.lin_Posters:
                Intent intent3 = new Intent(this, ActExample.class);

                intent3.putExtra("type", 3);

                startActivity(intent3);
                break;
//                预约时间
            case R.id.lin_appointment:
                showChooseDialog(list);
                break;
//                有效时间
            case R.id.lin_Effective:

                timeType = 0;

                showDateDialog(DateUtil.getDateForString("1990-01-01"));

                break;
//                选择核销类型
            case R.id.lin_merchants:


                Intent intentsd = new Intent(this, ActSelecBus.class);

                startActivityForResult(intentsd, 123);


                break;
            case R.id.lin_xiang:

                Intent intent = new Intent(this, ActExample.class);

                intent.putExtra("type", 2);

                startActivity(intent);

                break;

            case R.id.lin_four:
                Intent intent4 = new Intent(this, ActExample.class);

                intent4.putExtra("type", 4);

                startActivity(intent4);

                break;

//                商品下架时间

            case R.id.lin_xia:


                timeType = 1;

                showDateDialog(DateUtil.getDateForString("1990-01-01"));

                break;


//                发布
            case R.id.text_Release:


                showLoadingDialog();

                //商品的头部的数据
//                private ArrayList<LocalMedia> headList = new ArrayList<>();
//
//                //    商品套餐的数据
//                ArrayList<BeanImgs> dataTao = new ArrayList<>();

                HttpUtil.addMapparams();


//              ArrayList<BeanImgs> datassss = new ArrayList<>();

                for (LocalMedia media : headList) {
                    path_img = media.getCompressPath();
                    Log.i(TAG, "压缩---->" + media.getCompressPath());
                    Log.i(TAG, "原图---->" + media.getPath());
                    Log.i(TAG, "裁剪---->" + media.getCutPath());

//6张图的展示
                    uploadImage(path_img, headList.size());
                }


//上传图片
                break;
        }
    }


    @BindView(R.id.text_Time)
    TextView text_Time;


//    选择日期的类型

    private int timeType = 0;


    private int hour = 0;


    private void showChooseDialog(List<String> mlist) {
        DataPickerDialog.Builder builder = new DataPickerDialog.Builder(this);
        chooseDialog = builder.setData(mlist).setSelection(1).setTitle("取消")
                .setOnDataSelectedListener(new DataPickerDialog.OnDataSelectedListener() {
                    @Override
                    public void onDataSelected(String itemValue, int position) {

                        hour = Integer.valueOf(itemValue);

                        text_Time.setText("提前" + itemValue + "小时预约");

                    }

                    @Override
                    public void onCancel() {

                    }
                }).create();
        chooseDialog.show();
    }


    private Dialog dateDialog, chooseDialog;


    //年月日选择
    public void date(View v) {
        showDateDialog(DateUtil.getDateForString("1990-01-01"));
    }

    private void showDateDialog(List<Integer> date) {
        DatePickerDialog.Builder builder = new DatePickerDialog.Builder(this);
        builder.setOnDateSelectedListener(new DatePickerDialog.OnDateSelectedListener() {
            @Override
            public void onDateSelected(int[] dates) {
                if (timeType == 0) {
                    text_huo.setText(dates[0] + "-" + (dates[1] > 9 ? dates[1] : ("0" + dates[1])) + "-"
                            + (dates[2] > 9 ? dates[2] : ("0" + dates[2])));
                } else if (timeType == 1) {
                    text_Lower.setText(dates[0] + "-" + (dates[1] > 9 ? dates[1] : ("0" + dates[1])) + "-"
                            + (dates[2] > 9 ? dates[2] : ("0" + dates[2])));
                }
            }

            @Override
            public void onCancel() {

            }
        })
                .setSelectYear(date.get(0) - 1)
                .setSelectMonth(date.get(1) - 1)
                .setSelectDay(date.get(2) - 1);
        builder.setMaxYear(DateUtil.getYear());
        builder.setMaxMonth(DateUtil.getDateForString(DateUtil.getToday()).get(1));
        builder.setMaxDay(DateUtil.getDateForString(DateUtil.getToday()).get(2));
        dateDialog = builder.create();
        dateDialog.show();
    }


    @BindView(R.id.text_huo)
    TextView text_huo;

    @BindView(R.id.text_Lower)
    TextView text_Lower;

    private Bean_shopUrl bean_shopUrl;
    private boolean success_shopUrl;
    private int code_shopUrl;
    private String msg_shopUrl;
    private Bean_shopUrl.DataBean data_shopUrl;


//    //商品的头部的数据
//    private ArrayList<LocalMedia> headList = new ArrayList<>();
//
//    //    商品套餐的数据
//    ArrayList<BeanImgs> dataTao = new ArrayList<>();
//    ArrayList<Bean_Tao> dataTao = new ArrayList<>();


    private String path_xiang;


    private int i = 0;
    int number = 0;

    //上传图片
    public void uploadImage(String path_img, int imgSize) {


        OkHttpClient okHttpClient = new OkHttpClient();

        Log.d("imagePath", path_img);

        File file = new File(path_img);
        RequestBody image = RequestBody.create(MediaType.parse("image/png"), file);
        RequestBody requestBody = null;
        try {
            requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("mediaFile", path_img, image)
                    .addFormDataPart("mediaType", "0")
                    .addFormDataPart("businessType", "1")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Request request = new Request.Builder()
                .url("http://192.168.110.187:8082/media/uploadMedia")
                .post(requestBody)
                .build();
//        Response response = okHttpClient.newCall(request);


        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String img = response.body().string();
//                {"success":true,"code":200,"msg":"成功","data":{"id":469,"mediaType":0,"businessType":1,"mediaSize":37309,"mediaName":"1166535384595828736","mediaUrl":"http://pwa27iixx.bkt.clouddn.com/1166535384595828736"}}
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("response", "----" + img);
                        bean_shopUrl = MyApp.gson.fromJson(img, Bean_shopUrl.class);
                        data_shopUrl = bean_shopUrl.getData();
                        String img_url = data_shopUrl.getMediaUrl();
                        ++i;
//添加图片
                        runOnUiThread(new Runnable() {
                            @RequiresApi(api = Build.VERSION_CODES.O)
                            @Override
                            public void run() {
//上传图片
//                                banner图添加
                                banners.add(img_url);
                                String bannerimg = String.join(",", banners.toArray(new String[banners.size()]));

                                Log.i("bannerimg", i + "---" + imgSize + bannerimg);

                                if (i == imgSize) {

                                    i = 0;

//                                    --
//                                    上传套餐图
                                    goodsInfor.put("goodsName", goodNmae);
                                    goodsInfor.put("banner", bannerimg);
                                    goodsInfor.put("intro", intro);
                                    goodsInfor.put("logoUrl", banners.get(0));
                                    goodsInfor.put("orderEffeDate", text_huo.getText().toString());
                                    goodsInfor.put("goodsEffeDate", text_Lower.getText().toString());
                                    goodsInfor.put("preTime", hour + "");
//详情页的列表 个数，先计算个数，然后图片逐一上传
                                    for (int i = 0; i < myRecycleViewAdapter.getTaoDatas().size(); i++) {
                                        all += myRecycleViewAdapter.getTaoDatas().get(i).getImgs().size();
                                        Log.i("path_xiang", "path_xiang" + datassss.size() +"---"+all+"---"+ "详情---" + myRecycleViewAdapter.getTaoDatas().size() + "---" +
                                                myRecycleViewAdapter.getTaoDatas().get(i).getImgs().size());
                                        Log.i("danzhang", all+"++++++all+++++++");
                                        //详情列表
//                                        for (LocalMedia media : myRecycleViewAdapter.getTaoDatas().get(i).getImgs()) {
//                                            path_xiang = media.getCompressPath();
////                                            Log.i(TAG, "path_xiang" + media.getCompressPath());
////                                            Log.i(TAG, "原图---->" + media.getPath());
////                                            Log.i(TAG, "裁剪---->" + media.getCutPath());
////                                          单张图片，所有的图片的个数，第几个  datassss 换了一下
//                                            detail(path_xiang, myRecycleViewAdapter.getTaoDatas().get(i).getImgs().size(), i);
//                                        }
//详情页    图片添加
//                                        除了问题
//为了排序弄得下标



//每一排的数据添加进去
                                        paisize.add(myRecycleViewAdapter.getTaoDatas().get(i).getImgs().size());


                                        for (int j = 0; j < myRecycleViewAdapter.getTaoDatas().get(i).getImgs().size(); j++) {

                                            path_xiang = myRecycleViewAdapter.getTaoDatas().get(i).getImgs().get(j).getCompressPath();

                                            Posdetail(path_xiang,  ++number, i);
                                        }


                                        Log.i("danzhang", "++++++wai+++++++");

//                                        datadetail.add(new Bean_details(myRecycleViewAdapter.getTaoDatas().get(i).getDetails(), detailImgs));
////---
//                                        details.clear();
////                                    i是第几排
////                                    Log.i("datassss", myRecycleViewAdapter.getTaoDatas().size() - 1 + "----" + pai + "---" + "----" + bannerimg);
//                                        Log.i("pai",  myRecycleViewAdapter.getTaoDatas().size()-1+"----" + i + "---" + "----");
////                                    int size = 0;
//                                        //                                    详情数据添加完成
//                                        if (i == myRecycleViewAdapter.getTaoDatas().size() - 1) {
//
//                                        Log.i("datadetail","--执行了几次--"+ MyApp.gson.toJson(datadetail));
//
//                                        goodsInfor.put("detail", MyApp.gson.toJson(datadetail).toString());
////                                      haiBao(selectList);
////                                      海报执行多次
////                                      获取最新的数据 海报图
//                                        haiBao(adapter.getList());
//                                        }
                                    }
                                }
                            }
                        });
                    }
                });
            }
        });
    }

    private String detailImgs = "";


    List<String> banners = new ArrayList<>();
    List<Bean_imgde> details = new ArrayList<>();


//    图片的集合
List<String> detai = new ArrayList<>();



    private List<Bean_details> datadetail = new ArrayList<Bean_details>();


    //上传详情  单张图片，单行所有的数量,行数
    public void Posdetail(String path_img, int number, int pai) {


        OkHttpClient okHttpClient = new OkHttpClient();

        Log.i("Posdetail", path_img + "----");

        File file = new File(path_img);
        RequestBody image = RequestBody.create(MediaType.parse("image/png"), file);
        RequestBody requestBody = null;
        try {
            requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("mediaFile", path_img, image)
                    .addFormDataPart("mediaType", "0")
                    .addFormDataPart("businessType", "1")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Request request = new Request.Builder()
                .url("http://192.168.110.187:8082/media/uploadMedia")
                .post(requestBody)
                .build();
//        Response response = okHttpClient.newCall(request);


        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String img = response.body().string();
//                {"success":true,"code":200,"msg":"成功","data":{"id":469,"mediaType":0,"businessType":1,"mediaSize":37309,"mediaName":"1166535384595828736","mediaUrl":"http://pwa27iixx.bkt.clouddn.com/1166535384595828736"}}
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("responsePosdetail", "----" + img);
                        bean_shopUrl = MyApp.gson.fromJson(img, Bean_shopUrl.class);
                        data_shopUrl = bean_shopUrl.getData();
                        String img_url = data_shopUrl.getMediaUrl();
//添加图片
                        runOnUiThread(new Runnable() {
                            @RequiresApi(api = Build.VERSION_CODES.O)
                            @Override
                            public void run() {
//上传图片
                                details.add(new Bean_imgde(img_url, number, pai));

                                Log.i("danzhang", img_url +"--"+all+"++++++li+++++++" + pai+"--"+"---"+number +"---"+details.size());

                                if (all == details.size()) {
                                    Collections.sort(details, new Comparator<Bean_imgde>() {
                                        /*
                                         * int compare(Person p1, Person p2) 返回一个基本类型的整型，
                                         * 返回负数表示：p1 小于p2，
                                         * 返回0 表示：p1和p2相等，
                                         * 返回正数表示：p1大于p2
                                         */
                                        @Override
                                        public int compare(Bean_imgde p1, Bean_imgde p2) {
                                            //按照Person的年龄进行升序排列
                                            if (p1.getNumber() > p2.getNumber()) {
                                                return 1;
                                            }
                                            if (p1.getNumber() == p2.getNumber()) {
                                                return 0;
                                            }
                                            return -1;
                                        }
                                    });
                                    Log.i("排序后的结果：", details + "");

                                    for (int i = 0; i < details.size(); i++) {
                                        Log.i("detailsdetails",details.get(i).getImg()+"--"+details.get(i).getNumber()+"---"+details.get(i).getPai());

                                        try {



                                            if (details.get(i).getPai() == details.get(i+1).getPai()){
                                                detai.add(details.get(i).getImg());
                                            }else {
                                                Log.i("detailsdetails","-----------------");
                                                detai.add(details.get(i).getImg());
                                                detailImgs = String.join(",", detai.toArray(new String[detai.size()]));
                                                datadetail.add(new Bean_details(myRecycleViewAdapter.getTaoDatas().get(++as).getDetails(), detailImgs));
                                                detai.clear();
                                            }
                                        }catch (Exception e){

                                            detai.add(details.get(i).getImg());
                                            detailImgs = String.join(",", detai.toArray(new String[detai.size()]));

//                                           int a =  ++as;

                                           Log.i("spppppppsa",as+"-----");

                                            datadetail.add(new Bean_details(myRecycleViewAdapter.getTaoDatas().get(as++).getDetails(), detailImgs));
                                            detai.clear();


                                            goodsInfor.put("detail", MyApp.gson.toJson(datadetail).toString());
                                            Tools.i("MyAppdatadetail",MyApp.gson.toJson(datadetail).toString());
//                                        haiBao(selectList);
//                                        海报执行多次
//                                        获取最新的数据 海报图
                                            haiBao(adapter.getList());
                                        }
                                    }

//                                    if (details.size() == myRecycleViewAdapter.getTaoDatas().get(pai).getImgs().size()) {
//                                        detailImgs = String.join(",", details.toArray(new String[details.size()]));
//                                        datadetail.add(new Bean_details(myRecycleViewAdapter.getTaoDatas().get(pai).getDetails(), detailImgs));
//                                        details.clear();
//
//                                        Log.i("datadetail", "----" + MyApp.gson.toJson(datadetail));
//
//                                        if (pai == datadetail.size()) {
//                                            Log.i("datadetail", "--执行了几次--" + MyApp.gson.toJson(datadetail));
//
//                                            goodsInfor.put("detail", MyApp.gson.toJson(datadetail).toString());
////                                        haiBao(selectList);
////                                        海报执行多次
////                                        获取最新的数据 海报图
//                                            haiBao(adapter.getList());
//                                        }
//                                    }
                                }
////                                ++ide;
//                                Log.i("detaikkk", imgSize + "------" + ide + "---");
////                                if (ide == imgSize) {
//
//                                if (details.size()-1==imgSize){
//
//                                    detailImgs = String.join(",", details.toArray(new String[details.size()]));
//
//                                    Log.i("detailsxia", imgSize + "------" + ide + "---" + "----" + detailImgs);
////                                    ide = 0;
////                                    --------------------
//                                    datadetail.add(new Bean_details(myRecycleViewAdapter.getTaoDatas().get(pai).getDetails(), detailImgs));
////                                    details.clear();
//////                                    i是第几排
//////                                    Log.i("datassss", myRecycleViewAdapter.getTaoDatas().size() - 1 + "----" + pai + "---" + "----" + bannerimg);
////                                    Log.i("pai",  myRecycleViewAdapter.getTaoDatas().size()-1+"----" + pai + "---" + "----");
//////                                    int size = 0;
////                                    //                                    详情数据添加完成
//                                    if (pai == myRecycleViewAdapter.getTaoDatas().size() - 1) {
//
//                                        Log.i("datadetail","--执行了几次--"+ MyApp.gson.toJson(datadetail));
//
//                                        goodsInfor.put("detail", MyApp.gson.toJson(datadetail).toString());
////                                        haiBao(selectList);
////                                        海报执行多次
////                                        获取最新的数据 海报图
//                                        haiBao(adapter.getList());
//                                    }
//
//
//                                }
                            }
                        });
                    }
                });
            }
        });
    }


    //上传宣传海报
    public void haiBao(List<LocalMedia> selectList) {

//上传以后把上面的数据清掉
        datadetail.clear();


        String path_img = selectList.get(0).getCompressPath();

        OkHttpClient okHttpClient = new OkHttpClient();

        Log.d("imagePath", path_img);

        File file = new File(path_img);
        RequestBody image = RequestBody.create(MediaType.parse("image/png"), file);
        RequestBody requestBody = null;
        try {
            requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("mediaFile", path_img, image)
                    .addFormDataPart("mediaType", "0")
                    .addFormDataPart("businessType", "1")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Request request = new Request.Builder()
                .url("http://192.168.110.187:8082/media/uploadMedia")
                .post(requestBody)
                .build();
//        Response response = okHttpClient.newCall(request);


        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String img = response.body().string();
//                {"success":true,"code":200,"msg":"成功","data":{"id":469,"mediaType":0,"businessType":1,"mediaSize":37309,"mediaName":"1166535384595828736","mediaUrl":"http://pwa27iixx.bkt.clouddn.com/1166535384595828736"}}
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("response", "----" + img);
                        bean_shopUrl = MyApp.gson.fromJson(img, Bean_shopUrl.class);
                        data_shopUrl = bean_shopUrl.getData();
                        String img_url = data_shopUrl.getMediaUrl();
//添加图片
                        runOnUiThread(new Runnable() {
                            @RequiresApi(api = Build.VERSION_CODES.O)
                            @Override
                            public void run() {
//海报
                                goodsInfor.put("postersUrl", img_url);
//                              核销店铺列表
                                goodsInfor.put("verifyPowerDtoList", MyApp.gson.toJson(datsds).toString());
                                Log.i("dataTao", MyApp.gson.toJson(dataTao));
//                                上传套餐循环
                                for (int i = 0; i < dataTao.size(); i++) {
                                    Taopost(dataTao.get(i).getImgs().get(0).getCompressPath(), dataTao.size());
                                }
                            }
                        });
                    }
                });
            }
        });
    }


    int sei = 0;


    //上传套餐
    public void Taopost(String Taopath, int Taosize) {

//        for (LocalMedia media : dataTao.get(sei).getImgs()) {


        OkHttpClient okHttpClient = new OkHttpClient();

        Log.d("imagePath", Taopath);

        File file = new File(Taopath);
        RequestBody image = RequestBody.create(MediaType.parse("image/png"), file);
        RequestBody requestBody = null;
        try {
            requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("mediaFile", Taopath, image)
                    .addFormDataPart("mediaType", "0")
                    .addFormDataPart("businessType", "1")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Request request = new Request.Builder()
                .url("http://192.168.110.187:8082/media/uploadMedia")
                .post(requestBody)
                .build();
//      Response response = okHttpClient.newCall(request);
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String img = response.body().string();
//                {"success":true,"code":200,"msg":"成功","data":{"id":469,"mediaType":0,"businessType":1,"mediaSize":37309,"mediaName":"1166535384595828736","mediaUrl":"http://pwa27iixx.bkt.clouddn.com/1166535384595828736"}}
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("response", "----" + img);
                        bean_shopUrl = MyApp.gson.fromJson(img, Bean_shopUrl.class);
                        data_shopUrl = bean_shopUrl.getData();
                        String img_url = data_shopUrl.getMediaUrl();
//添加图片
                        runOnUiThread(new Runnable() {
                            @RequiresApi(api = Build.VERSION_CODES.O)
                            @Override
                            public void run() {
                                dats.add(new Bean_dhcb(
                                        img_url, dataTao.get(sei).getTaoName(),
                                        dataTao.get(sei).getDetails(),
                                        Integer.valueOf(dataTao.get(sei).getOriginalprice()) * 1000,
                                        Integer.valueOf(dataTao.get(sei).getPresentprice()) * 1000,
                                        dataTao.get(sei).getStock(),
                                        Integer.valueOf(dataTao.get(sei).getSettlementprice()) * 1000,
                                        Integer.valueOf(dataTao.get(sei).getCommission()) * 1000));
                                ++sei;
                                Tools.i("setMealDtoList", Taosize + "---" + sei + "---" + dats.size() + "----" + MyApp.gson.toJson(dats) + "");
//                                数据传递完成
                                if (Taosize == sei) {
                                    sei = 0;
                                    goodsInfor.put("setMealDtoList", MyApp.gson.toJson(dats).toString());
                                    goodsInfor.put("specifications", "件");
                                    goodsInfor.put("id", "0");
                                    HttpUtil.PostFaBu("backShop/goods/info", MyApp.gson.toJson(dats).replace("\\\"", "") + "", MyApp.gson.toJson(datsds).replace("\\\"", ""), goodsInfor);
                                    getdata("backShop/goods/info");
                                }
//                                    else {
//                                        Taopost(dataTao, dataTao.size());
//                                    }
                            }
                        });
                    }
                });
            }
        });
//        }
//        String path_img = dataTao.get(sei).getImgs().get(0).getCompressPath();
//        OkHttpClient okHttpClient = new OkHttpClient();
//        Log.d("imagePath", path_img1);
//        File file = new File(path_img1);
//        RequestBody image = RequestBody.create(MediaType.parse("image/png"), file);
//        RequestBody requestBody = null;
//        try {
//            requestBody = new MultipartBody.Builder()
//                    .setType(MultipartBody.FORM)
//                    .addFormDataPart("mediaFile", path_img1, image)
//                    .addFormDataPart("mediaType", "0")
//                    .addFormDataPart("businessType", "1")
//                    .build();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Request request = new Request.Builder()
//                .url("http://192.168.110.187:8082/media/uploadMedia")
//                .post(requestBody)
//                .build();
////      Response response = okHttpClient.newCall(request);
//        okHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//            }
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String img = response.body().string();
////                {"success":true,"code":200,"msg":"成功","data":{"id":469,"mediaType":0,"businessType":1,"mediaSize":37309,"mediaName":"1166535384595828736","mediaUrl":"http://pwa27iixx.bkt.clouddn.com/1166535384595828736"}}
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Log.i("response", "----" + img);
//                        bean_shopUrl = MyApp.gson.fromJson(img, Bean_shopUrl.class);
//                        data_shopUrl = bean_shopUrl.getData();
//                        String img_url = data_shopUrl.getMediaUrl();
////添加图片
//                        runOnUiThread(new Runnable() {
//                            @RequiresApi(api = Build.VERSION_CODES.O)
//                            @Override
//                            public void run() {
//                                dats.add(new Bean_dhcb(
//                                        img_url, dataTao.get(sei).getTaoName(),
//                                        dataTao.get(sei).getDetails(),
//                                        Integer.valueOf(dataTao.get(sei).getOriginalprice()) * 1000,
//                                        Integer.valueOf(dataTao.get(sei).getPresentprice()) * 1000,
//                                        dataTao.get(sei).getStock(),
//                                        Integer.valueOf(dataTao.get(sei).getSettlementprice()) * 1000,
//                                        Integer.valueOf(dataTao.get(sei).getCommission()) * 1000));
//                                ++sei;
//
//                                Log.i("setMealDtoList",  size+ "---" + sei+"---"+dats+"");
////                                数据传递完成
//                                if (size-1 == sei) {
//
//                                    sei = 0;
//
//                                    HttpUtil.params.put("setMealDtoList", dats);
//
//                                    goodsInfor.put("specifications","件");
//                                    goodsInfor.put("id","0");
//                                    HttpUtil.PostFaBu("backShop/goods/info", dats+"",MyApp.gson.toJson(datsds).replace("\\\"",""),goodsInfor);
//                                    getdata("backShop/goods/info");
//                                }
//                            }
//                        });
//                    }
//                });
//            }
//        });
    }


    //套餐需要传递的数据
    List<Bean_dhcb> dats = new ArrayList<>();


    private Bean_suc bean_suc;
    private boolean success;
    private int code;
    private String msg;
    private Object data;


    @Override
    public void stringResulit(String key, String value) {
        try {
            if (key.equals("backShop/goods/info")) {

                dismissLoadingDialog();

                bean_suc = MyApp.gson.fromJson(value, Bean_suc.class);
                code = bean_suc.getCode();
                if (code == 200) {
                    Toast.makeText(ActRecom.this, bean_suc.getMsg(), Toast.LENGTH_SHORT).show();
                    actRefunds.finish();
                    finish();

                } else {
                    Toast.makeText(ActRecom.this, bean_suc.getMsg(), Toast.LENGTH_SHORT).show();
                }


            }
        } catch (Exception e) {

        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            moveTaskToBack(true);
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }


}
