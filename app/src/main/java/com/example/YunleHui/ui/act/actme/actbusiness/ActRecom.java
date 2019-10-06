package com.example.YunleHui.ui.act.actme.actbusiness;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.platform.comapi.map.A;
import com.example.YunleHui.Bean.BeanImgs;
import com.example.YunleHui.MainActivity;
import com.example.YunleHui.R;
import com.example.YunleHui.adpter.FullyGridLayoutManager;
import com.example.YunleHui.adpter.GridPublishGoods;
import com.example.YunleHui.adpter.GridPublishGoodsTao;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.utils.InputTextMsgDialog;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.ClearEditText;
import com.example.YunleHui.view.datapick.DataPickerDialog;
import com.example.YunleHui.view.datapick.DatePickerDialog;
import com.example.YunleHui.view.datapick.DateUtil;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.permissions.RxPermissions;
import com.luck.picture.lib.tools.PictureFileUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ActRecom extends BaseAct {
    private List<String> list = new ArrayList<>();


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    @BindView(R.id.recycler_tao)
    RecyclerView recycler_tao;


    ArrayList<BeanImgs> datassss = new ArrayList<>();


    private MyRecycleViewAdapter myRecycleViewAdapter;


    private int themeId;
    private int chooseMode = PictureMimeType.ofImage();

    private InputTextMsgDialog inputTextMsgDialog;

    //    宣传海报
    @BindView(R.id.recycler_head)
    RecyclerView recycler_head;


    @BindView(R.id.lin_Posters)
    LinearLayout lin_Posters;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this,clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_recom;
    }

    @Override
    protected void findViews() {
        if (toolbar_all!=null){
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("发布商品");
        }
    }

    @Override
    public void initData() {


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
            datassss.add(new BeanImgs("", imgs, "", "0.00", "0.00", "0.00", "0.00"));
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

                    if (datassss.size()<11){
                        List<LocalMedia> selectListTao = new ArrayList<>();
                        selectListTao.clear();
                        datassss.add(new BeanImgs("", selectListTao, "0.00", "0.00", "0.00", "", "0.00"));
                        myRecycleViewAdapter = new MyRecycleViewAdapter(datassss, ActRecom.this);
                        recycler_tao.setAdapter(myRecycleViewAdapter);
                    }else {
                        Toast.makeText(ActRecom.this,"最多添加10个描述！",Toast.LENGTH_SHORT).show();
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

                    if (datassss.get(positionss).getDetails()!=null&&datassss.get(positionss).getDetails().length()>0){
                        inputTextMsgDialog.setHint(datassss.get(postionTao).getDetails());
                    }else {
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


            private TextView text_shan,text_add;


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

            Toast.makeText(ActRecom.this, "===222===" + "---" + contexts + position, Toast.LENGTH_SHORT).show();

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
    }


    private List<LocalMedia> selectListTao = new ArrayList<>();

    private final static String TAG = MainActivity.class.getSimpleName();



    //头部的数据
    private GridPublishGoods.onAddPicClickListener onAddPicClickListener = new GridPublishGoods.onAddPicClickListener() {
        @Override
        public void onAddPicClick() {

            Toast.makeText(ActRecom.this, "===111===", Toast.LENGTH_SHORT).show();


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


    @OnClick({R.id.lin_Posters,R.id.lin_appointment,R.id.lin_Effective})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.lin_Posters:




                break;
//                预约时间
            case R.id.lin_appointment:
                showChooseDialog(list);
                break;
//                有效时间
            case R.id.lin_Effective:

                showDateDialog(DateUtil.getDateForString("1990-01-01"));

                break;
        }
    }


    @BindView(R.id.text_Time)
TextView text_Time;


    private void showChooseDialog(List<String> mlist) {
        DataPickerDialog.Builder builder = new DataPickerDialog.Builder(this);
        chooseDialog = builder.setData(mlist).setSelection(1).setTitle("取消")
                .setOnDataSelectedListener(new DataPickerDialog.OnDataSelectedListener() {
                    @Override
                    public void onDataSelected(String itemValue, int position) {
                        text_Time.setText(itemValue);
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

                text_huo.setText(dates[0] + "-" + (dates[1] > 9 ? dates[1] : ("0" + dates[1])) + "-"
                        + (dates[2] > 9 ? dates[2] : ("0" + dates[2])));

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

}
