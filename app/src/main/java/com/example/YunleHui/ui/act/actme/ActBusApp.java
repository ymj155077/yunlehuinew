package com.example.YunleHui.ui.act.actme;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.Bean_cityList;
import com.example.YunleHui.Bean.Bean_shopList;
import com.example.YunleHui.Bean.Bean_shopState;
import com.example.YunleHui.Bean.Bean_shopUrl;
import com.example.YunleHui.Bean.Bean_you;
import com.example.YunleHui.MainActivity;
import com.example.YunleHui.R;
import com.example.YunleHui.adpter.FullyGridLayoutManager;
import com.example.YunleHui.adpter.GridImageAdapter;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.ClearEditText;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.permissions.RxPermissions;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.makeramen.roundedimageview.RoundedImageView;

import org.json.JSONException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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


//商户申请
public class ActBusApp extends BaseAct {


    @BindView(R.id.text_Up)
    TextView text_Up;


    @BindView(R.id.lin_yun_xiang)
    LinearLayout lin_yun_xiang;


    private Bean_cityList bean_cityList;
    private boolean success_cityList;
    private int code_cityList;
    private String msg_cityList;
    private List<Bean_cityList.DataBean> data_cityList;

    private ArrayList<Bean_cityList.DataBean> data_cityALL = new ArrayList<>();


    @BindView(R.id.text_address)
    TextView text_address;


    @BindView(R.id.text_type)
    TextView text_type;

    @BindView(R.id.lin_choice_address)
    LinearLayout lin_choice_address;


    private final static String TAG = MainActivity.class.getSimpleName();

    private Bean_shopList bean_shopList;
    private boolean success;
    private int code;
    private String msg;
    private List<Bean_shopList.DataBean> data;


    private ArrayList<Bean_shopList.DataBean> data_all = new ArrayList<>();


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    @BindView(R.id.lin_choice)
    LinearLayout lin_choice;


    private ListView list_Pay_method;


    private MyListAdpter myListAdpter;

    private int themeId;
    private int chooseMode = PictureMimeType.ofImage();

    private int maxSelectNum = 1;

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    private GridImageAdapter adapter;

    private List<LocalMedia> selectList = new ArrayList<>();


    //    身份证
    @BindView(R.id.edit_card)
    ClearEditText edit_card;

    //    地址
    @BindView(R.id.edit_address)
    ClearEditText edit_address;
    //店铺名字
    @BindView(R.id.edit_shopName)
    ClearEditText edit_shopName;

    //    电话
    @BindView(R.id.edit_phone)
    ClearEditText edit_phone;


    //                        店铺 类型

    //    云享商户的类型，营销达人，核销商户，营销商户
    private int type_shop = 0;


    //行业id
    private int industry_id = 0;


    private int classNatue = 0;


    @BindView(R.id.edit_name)
    ClearEditText edit_name;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_bus_app;
    }

    @Override
    protected void findViews() {

        if (toolbar_all != null) {
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("商城商户入驻");
        }

    }

    @Override
    public void initData() {

        themeId = R.style.picture_default_style;

        FullyGridLayoutManager manager = new FullyGridLayoutManager(ActBusApp.this, 1, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        adapter = new GridImageAdapter(ActBusApp.this, onAddPicClickListener);
        adapter.setList(selectList);
        adapter.setSelectMax(maxSelectNum);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new GridImageAdapter.OnItemClickListener() {
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
                            PictureSelector.create(ActBusApp.this).themeStyle(themeId).openExternalPreview(position, selectList);
                            break;
                        case 2:
                            // 预览视频
                            PictureSelector.create(ActBusApp.this).externalPictureVideo(media.getPath());
                            break;
                        case 3:
                            // 预览音频
                            PictureSelector.create(ActBusApp.this).externalPictureAudio(media.getPath());
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
                    PictureFileUtils.deleteCacheDirFile(ActBusApp.this);
                } else {
                    Toast.makeText(ActBusApp.this,
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


    }


    private GridImageAdapter.onAddPicClickListener onAddPicClickListener = new GridImageAdapter.onAddPicClickListener() {
        @Override
        public void onAddPicClick() {

//            相册or单独拍照

            boolean mode = true;
            if (mode) {
                // 进入相册 以下是例子：不需要的api可以不写
                PictureSelector.create(ActBusApp.this)
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
                PictureSelector.create(ActBusApp.this)
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


    //    选中的那一项
    private int hffhfh = 0;

    ArrayList<String> datas = new ArrayList<>();


    @OnClick({R.id.lin_choice, R.id.lin_choice_address, R.id.lin_yun_xiang, R.id.text_Up})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.lin_choice:

                hffhfh = 0;

                HttpUtil.getAsynHttp("shopApply/shopClassList?" + "areaCode=" + -1);

                getdata("shopApply/shopClassList");

//              Tools.mBottomSheetPop.dismiss();

                break;


//                选择省市区
            case R.id.lin_choice_address:
//                城市选择
                HttpUtil.getAsynHttp("frontShop/allCity");
                getdata("frontShop/allCity");
                break;
//                云享优汇 商家 选择 类型
            case R.id.lin_yun_xiang:
                type_shop = 0;
                View view_list = Tools.setRebuildPop(this, R.layout.pop_busi_type, R.layout.activity_act_bus_app);
                LinearLayout lin0ne = view_list.findViewById(R.id.lin0ne);
                lin0ne.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        type_shop = 1;
                        text_type.setText("身份证正面");
                        text_leixing.setText("营销达人");
                        Tools.mBottomSheetPop.dismiss();
                    }
                });
                LinearLayout linTwo = view_list.findViewById(R.id.linTwo);
                linTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        type_shop = 2;
                        text_type.setText("营业执照");
                        text_leixing.setText("核销商户");
                        Tools.mBottomSheetPop.dismiss();
                    }
                });
                LinearLayout linThree = view_list.findViewById(R.id.linThree);
                linThree.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        type_shop = 3;
                        text_type.setText("营业执照");
                        text_leixing.setText("营销商户");
                        Tools.mBottomSheetPop.dismiss();
                    }
                });

//一
                TextView text_one = (TextView) view_list.findViewById(R.id.text_one);
                SpannableString spannableString = new SpannableString("营销商户是非实体商户，和营销+核销商户达成协议后，可在线发布该商户的产品。赚取差价");
                StyleSpan styleSpan_B  = new StyleSpan(Typeface.BOLD);
                spannableString.setSpan(styleSpan_B, 12, 19, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                text_one.setHighlightColor(Color.parseColor("#333333"));
                text_one.setText(spannableString);
//                二

                TextView text_two = (TextView) view_list.findViewById(R.id.text_two);
                SpannableString spannable = new SpannableString("核销商户是营销+核销商户的分销商户，核销商户经营 销商户添加后，可核销营销商户指定的产品");
                StyleSpan styleSpa  = new StyleSpan(Typeface.BOLD);
                spannableString.setSpan(styleSpa, 5, 12, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                text_two.setHighlightColor(Color.parseColor("#333333"));
                text_two.setText(spannable);



                TextView text_three = (TextView) view_list.findViewById(R.id.text_three);
                SpannableString spanna = new SpannableString("营销+核销是线下实体商户，可以在线发布产品，线下核 销产品，可以有多个分销商户");
                StyleSpan style  = new StyleSpan(Typeface.BOLD);
                spannableString.setSpan(style, 0, 5, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                text_three.setHighlightColor(Color.parseColor("#333333"));
                text_three.setText(spanna);




                LinearLayout lin_pop_type = (LinearLayout) view_list.findViewById(R.id.lin_pop_type);
                lin_pop_type.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Tools.mBottomSheetPop.dismiss();
                    }
                });
                break;
            case R.id.text_Up:
                try {
                    uploadImage("http://192.168.110.187:8082/media/uploadMedia", path_img);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private Bean_shopUrl bean_shopUrl;
    private boolean success_shopUrl;
    private int code_shopUrl;
    private String msg_shopUrl;
    private Bean_shopUrl.DataBean data_shopUrl;


    /**
     * 上传图片
     *
     * @param url
     * @param imagePath 图片路径
     * @return 新图片的路径
     * @throws IOException
     * @throws JSONException
     */
    public void uploadImage(String url, String imagePath) throws IOException, JSONException {

        OkHttpClient okHttpClient = new OkHttpClient();
        Log.d("imagePath", imagePath);
        File file = new File(imagePath);
        RequestBody image = RequestBody.create(MediaType.parse("image/png"), file);
        RequestBody requestBody = null;
        try {
            requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("mediaFile", imagePath, image)
                    .addFormDataPart("mediaType", "0")
                    .addFormDataPart("businessType", "1")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Request request = new Request.Builder()
                .url(url)
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
                        Log.i("response", img);
                        bean_shopUrl = MyApp.gson.fromJson(img, Bean_shopUrl.class);
                        data_shopUrl = bean_shopUrl.getData();
                        String img_url = data_shopUrl.getMediaUrl();
//提交申请数据
                        HttpUtil.addMapparams();
                        Map<Object, Object> params_order = new HashMap<>();
                        params_order.clear();
//上传的 图片
                        params_order.put("applyPicUrl", img_url);
//城市id
                        params_order.put("cityId", area_Id);
//店铺类型id
                        params_order.put("classId", industry_id);
//店铺性质
                        params_order.put("shopNature",classNatue);
//                        区 id
                        params_order.put("districtId", area_you);

                        params_order.put("userName",edit_name.getText().toString().trim());
                        int id = 0;
                        params_order.put("id", id);
                        params_order.put("idCard", edit_card.getText().toString().trim());
                        params_order.put("latitude", 0);
                        params_order.put("longitude", 0);
                        params_order.put("shopAddress", edit_address.getText().toString().trim());
                        params_order.put("shopName", edit_shopName.getText().toString().trim());
                        params_order.put("typeId", type_shop);
                        params_order.put("userId", MyApp.user);
                        params_order.put("userTel", edit_phone.getText().toString().trim());
//                        HttpUtil.params.put("shopApplyDto", params_order);
//                        HttpUtil.params.put("userId", MyApp.user);
                        HttpUtil.postRaw("shopApply/info", params_order);
                        getdata("shopApply/info");
                    }
                });
            }
        });
    }


    public class MyListAdpter extends BaseAdapter {

        private int mCurrentItem = 0;
        private boolean isClick = false;

        private ArrayList<Bean_shopList.DataBean> datas = new ArrayList<>();

        private LayoutInflater inflater;

        public MyListAdpter(ArrayList<Bean_shopList.DataBean> datas, Context context) {
            this.datas.clear();
            this.datas.addAll(datas);
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int i) {
            return datas.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            final MyViewHolder myViewHolder = new MyViewHolder();
            convertView = inflater.inflate(R.layout.item_method, parent, false);
            myViewHolder.img_choose = (ImageView) convertView.findViewById(R.id.img_choose);


            myViewHolder.img_head = (RoundedImageView) convertView.findViewById(R.id.img_head);

            myViewHolder.text_name = (TextView) convertView.findViewById(R.id.text_name);


            Glide.with(ActBusApp.this).load(datas.get(position).getClassLogoUrl()).into(myViewHolder.img_head);

            myViewHolder.text_name.setText(datas.get(position).getClassName());


//            myViewHolder.lin_item.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                }
//            });
            if (mCurrentItem == position & isClick) {
                Glide.with(ActBusApp.this).load(R.drawable.icon_choose).into(myViewHolder.img_choose);
            } else {
                Glide.with(ActBusApp.this).load(R.drawable.hui).into(myViewHolder.img_choose);
            }
            return convertView;
        }


        public class MyViewHolder {
            private ImageView img_choose;

            private RoundedImageView img_head;

            private TextView text_name;

        }

        public void setCurrentItem(int currentItem) {
            this.mCurrentItem = currentItem;
        }

        public void setClick(boolean click) {
            this.isClick = click;
        }

    }


    private Bean_you bean_you;
    private boolean success_you;
    private int code_you;
    private String msg_you;
    private List<Bean_you.DataBean> data_you;
    private ArrayList<Bean_you.DataBean> data_you_all = new ArrayList<>();


    @BindView(R.id.text_industry)
    TextView text_industry;


    @Override
    public void StringResulit(String key, String value) {

        try {
            if (key.equals("shopApply/shopClassList")) {
                bean_shopList = MyApp.gson.fromJson(value, Bean_shopList.class);
                data = bean_shopList.getData();
                data_all.clear();
                data_all.addAll(data);
                View view_list = Tools.setRebuildPop(this, R.layout.pop_, R.layout.activity_act_bus_app);
                list_Pay_method = view_list.findViewById(R.id.list_Pay_method);
                TextView text_click = view_list.findViewById(R.id.text_click);
                text_click.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//              ClassNature  0 云享优汇商家 1 社区购商家
                        Toast.makeText(ActBusApp.this, data_all.get(hffhfh).getId() + "---" + data_all.get(hffhfh).getClassName() + data_all.get(hffhfh).getClassNature(), Toast.LENGTH_SHORT).show();
                        if (data_all.get(hffhfh).getClassNature() == 0) {
//云享优惠商户显示
                            lin_yun_xiang.setVisibility(View.VISIBLE);
                            text_type.setText("营业执照");
                        } else {
//社区购的 显示
                            lin_yun_xiang.setVisibility(View.GONE);
                            text_type.setText("营业执照");
                        }


                        text_industry.setText(data_all.get(hffhfh).getClassName());

//                    行业id；

                        industry_id = data_all.get(hffhfh).getId();

                        classNatue = data_all.get(hffhfh).getClassNature();


                        Tools.mBottomSheetPop.dismiss();
                    }
                });
                myListAdpter = new MyListAdpter(data_all, this);
                list_Pay_method.setAdapter(myListAdpter);
                myListAdpter.setCurrentItem(hffhfh);
                myListAdpter.setClick(true);
                list_Pay_method.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        myListAdpter.setCurrentItem(i);
                        myListAdpter.setClick(true);
                        myListAdpter.notifyDataSetChanged();
                        hffhfh = i;
                    }
                });
                LinearLayout lin_pop_type = (LinearLayout) view_list.findViewById(R.id.lin_pop_type);
                lin_pop_type.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Tools.mBottomSheetPop.dismiss();
                    }
                });
            }
        }catch (Exception E){

        }


        try {
            //城市列表
            if (key.equals("frontShop/allCity")) {


                bean_cityList = MyApp.gson.fromJson(value, Bean_cityList.class);
                data_cityList = bean_cityList.getData();
                data_cityALL.clear();
                data_cityALL.addAll(data_cityList);


                showPopupWindow2(lin_choice_address, data_cityALL);

            }

        }catch (Exception e){

        }

try {
    //获取区县的列表
    if (key.equals("frontShop/getAllArea")) {


//            private Bean_you bean_you;
//            private boolean success_you;
//            private int code_you;
//            private String msg_you;
//            private List<Bean_you.DataBean> data_you;
//            private ArrayList<Bean_you.DataBean> data_you_all = new ArrayList<>();


        bean_you = MyApp.gson.fromJson(value, Bean_you.class);

        data_you = bean_you.getData();

        data_you_all.clear();

        data_you_all.addAll(data_you);


        MyAraeyou myAraeyou = new MyAraeyou(data_you_all, ActBusApp.this);

        no_list_you.setAdapter(myAraeyou);


    }
}catch (Exception e){

}


        try {
            //上传店铺 信息
            if (key.equals("shopApply/info")) {
                bean_shopState = MyApp.gson.fromJson(value, Bean_shopState.class);
                code_shopState = bean_shopState.getCode();
                if (code_shopState == 200) {
                    Toast.makeText(ActBusApp.this, "申请已提交！请耐心等待！", Toast.LENGTH_SHORT).show();
                    finish();
                }
            } else {

                Toast.makeText(ActBusApp.this, bean_shopState.getMsg(), Toast.LENGTH_SHORT).show();

            }
        } catch (Exception e) {

        }


    }


    private Bean_shopState bean_shopState;
    private boolean success_shopState;
    private int code_shopState;
    private String msg_shopState;
    private Object data_shopState;


    private String path_img;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
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
                    break;
            }
        }
    }


    private PopupWindow window;

    View view;

    TextView text_title;

    ListView no_list_you;

    ListView no_list_pop;

    TextView text_you;

    private void showPopupWindow2(View view1, ArrayList<Bean_cityList.DataBean> data_all) {
        //自定义布局，显示内容
        view = LayoutInflater.from(ActBusApp.this).inflate(R.layout.pop_aa, null);


        no_list_pop = view.findViewById(R.id.no_list_pop);

        no_list_you = view.findViewById(R.id.no_list_you);

        text_you = view.findViewById(R.id.text_you);

        text_title = view.findViewById(R.id.text_title);


        MyAraeAdapter myAraeAdapter = new MyAraeAdapter(data_all, ActBusApp.this);


        no_list_pop.setAdapter(myAraeAdapter);

        window = new PopupWindow(view, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, true);

        window.setTouchable(true);
        window.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                //这里如果返回true的话，touch事件将被拦截
                //拦截后 PoppWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        //（注意一下！！）如果不设置popupWindow的背景，无论是点击外部区域还是Back键都无法弹框
        window.setBackgroundDrawable(null);

        window.showAsDropDown(view1);

    }


    @BindView(R.id.text_leixing)
    TextView text_leixing;

    private int area_Id = 0;
    //区的id
    private int area_you = 0;

    public class MyAraeAdapter extends BaseAdapter {

        private ArrayList<Bean_cityList.DataBean> datas = new ArrayList<>();
        private LayoutInflater inflater;


        public MyAraeAdapter(ArrayList<Bean_cityList.DataBean> datas, Context context) {
            this.datas.clear();
            this.datas.addAll(datas);
            this.inflater = LayoutInflater.from(context);
        }


        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int i) {
            return datas.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            MyViewHolder myViewHolder = new MyAraeAdapter.MyViewHolder();


            convertView = inflater.inflate(R.layout.item_area, parent, false);

            myViewHolder.lin_are = (LinearLayout) convertView.findViewById(R.id.lin_are);

            myViewHolder.text_qu = (TextView) convertView.findViewById(R.id.text_qu);


            myViewHolder.text_qu.setText(datas.get(position).getCityName());


            myViewHolder.lin_are.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    area_Id = datas.get(position).getId();

                    text_title.setText(datas.get(position).getCityName());


                    HttpUtil.getAsynHttp("frontShop/getAllArea?" + "code=" + datas.get(position).getId());

                    getdata("frontShop/getAllArea");


                }
            });
            return convertView;
        }

        public class MyViewHolder {

            private TextView text_qu;

            private LinearLayout lin_are;
        }
    }


    public class MyAraeyou extends BaseAdapter {

        private ArrayList<Bean_you.DataBean> datas = new ArrayList<>();
        private LayoutInflater inflater;


        public MyAraeyou(ArrayList<Bean_you.DataBean> datas, Context context) {
            this.datas.clear();
            this.datas.addAll(datas);
            this.inflater = LayoutInflater.from(context);
        }


        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int i) {
            return datas.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            MyViewHolder myViewHolder = new MyViewHolder();


            convertView = inflater.inflate(R.layout.item_area, parent, false);

            myViewHolder.lin_are = (LinearLayout) convertView.findViewById(R.id.lin_are);

            myViewHolder.text_qu = (TextView) convertView.findViewById(R.id.text_qu);


            myViewHolder.text_qu.setText(datas.get(position).getAreaName());


            myViewHolder.lin_are.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//区的id
                    area_you = datas.get(position).getId();

                    text_you.setText(datas.get(position).getAreaName());


                    text_address.setText(text_title.getText().toString() + " " + text_you.getText().toString());

                    window.dismiss();


                }
            });
            return convertView;
        }

        public class MyViewHolder {

            private TextView text_qu;

            private LinearLayout lin_are;
        }
    }


}













