package com.example.YunleHui.ui.act.actme.actbusiness;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.YunleHui.Bean.Bean_shopUrl;
import com.example.YunleHui.MainActivity;
import com.example.YunleHui.R;
import com.example.YunleHui.adpter.FullyGridLayoutManager;
import com.example.YunleHui.adpter.FullyGridLayoutManagerll;
import com.example.YunleHui.adpter.GridImageAdapter;
import com.example.YunleHui.adpter.GridPublishGoods;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.act.actme.ActBusApp;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.permissions.RxPermissions;
import com.luck.picture.lib.tools.PictureFileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

//发布商品

public class ActPublishGoods extends BaseAct implements CompoundButton.OnCheckedChangeListener {

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    private int themeId;
    private int chooseMode = PictureMimeType.ofImage();

    private int maxSelectNum = 6;

    private List<LocalMedia> selectList = new ArrayList<>();

    private GridImageAdapter adapter;


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_publish_goods;
    }

    private int receiveWay = 1;

    private RadioButton[] checkBoxes = new RadioButton[2];

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b) {
            for (int i = 0; i < checkBoxes.length; i++) {
                //不等于当前选中的就变成false
                if (checkBoxes[i].getText().toString().equals(compoundButton.getText().toString())) {
                    checkBoxes[i].setChecked(true);
                    if (checkBoxes[i].getText().toString().equals("配送")) {
                        receiveWay = 1;
                    }
                    if (checkBoxes[i].getText().toString().equals("不支持配送")) {
                        receiveWay = 2;
                    }
                } else {
                    checkBoxes[i].setChecked(false);
                }
            }
        }
    }


    @BindView(R.id.text_Release)
    TextView text_Release;

    @Override
    protected void findViews() {


        if (toolbar_all != null) {
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("发布商品");
        }


        checkBoxes[0] = (RadioButton) findViewById(R.id.radio00);
        checkBoxes[1] = (RadioButton) findViewById(R.id.radio01);

        checkBoxes[0].setOnCheckedChangeListener(this);
        checkBoxes[1].setOnCheckedChangeListener(this);

    }

    @Override
    public void initData() {

        themeId = R.style.picture_default_style;

        FullyGridLayoutManagerll manager = new FullyGridLayoutManagerll(ActPublishGoods.this, 4, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        adapter = new GridImageAdapter(ActPublishGoods.this, onAddPicClickListener);
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
                            PictureSelector.create(ActPublishGoods.this).themeStyle(themeId).openExternalPreview(position, selectList);
                            break;
                        case 2:
                            // 预览视频
                            PictureSelector.create(ActPublishGoods.this).externalPictureVideo(media.getPath());
                            break;
                        case 3:
                            // 预览音频
                            PictureSelector.create(ActPublishGoods.this).externalPictureAudio(media.getPath());
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
                    PictureFileUtils.deleteCacheDirFile(ActPublishGoods.this);
                } else {
                    Toast.makeText(ActPublishGoods.this,
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

            Toast.makeText(ActPublishGoods.this, "===111===", Toast.LENGTH_SHORT).show();
//            相册or单独拍照

            boolean mode = true;
            if (mode) {
                // 进入相册 以下是例子：不需要的api可以不写
                PictureSelector.create(ActPublishGoods.this)
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
                PictureSelector.create(ActPublishGoods.this)
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

    private final static String TAG = MainActivity.class.getSimpleName();


    private List<LocalMedia> headList = new ArrayList<>();


    @OnClick({R.id.text_Release})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.text_Release:
                Toast.makeText(this, "提示sasadsa", Toast.LENGTH_SHORT).show();

                headList = adapter.getList();

                for (LocalMedia media : headList) {
                    path_img = media.getCompressPath();
                    Log.i(TAG, "压缩---->" + media.getCompressPath());
                    Log.i(TAG, "原图---->" + media.getPath());
                    Log.i(TAG, "裁剪---->" + media.getCutPath());

//6张图的展示
                    uploadImage(path_img, headList.size());
                }

                finish();
                break;
        }
    }



    private Bean_shopUrl bean_shopUrl;
    private boolean success_shopUrl;
    private int code_shopUrl;
    private String msg_shopUrl;
    private Bean_shopUrl.DataBean data_shopUrl;


    private int i = 0;


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
//                                banners.add(img_url);
//                                String bannerimg = String.join(",", banners.toArray(new String[banners.size()]));

//                                Log.i("bannerimg", i + "---" + imgSize + bannerimg);

//                                if (i == imgSize) {
//
//                                    i = 0;

//                                    --
//                                    上传套餐图
//                                    goodsInfor.put("goodsName", goodNmae);
//                                    goodsInfor.put("banner", bannerimg);
//                                    goodsInfor.put("intro", intro);
//                                    goodsInfor.put("logoUrl", banners.get(0));
//                                    goodsInfor.put("orderEffeDate", text_huo.getText().toString());
//                                    goodsInfor.put("goodsEffeDate", text_Lower.getText().toString());
//                                    goodsInfor.put("preTime", hour + "");
////详情页的列表 个数，先计算个数，然后图片逐一上传
//                                    for (int i = 0; i < myRecycleViewAdapter.getTaoDatas().size(); i++) {
//                                        all += myRecycleViewAdapter.getTaoDatas().get(i).getImgs().size();
//                                        Log.i("path_xiang", "path_xiang" + datassss.size() +"---"+all+"---"+ "详情---" + myRecycleViewAdapter.getTaoDatas().size() + "---" +
//                                                myRecycleViewAdapter.getTaoDatas().get(i).getImgs().size());
//                                        Log.i("danzhang", all+"++++++all+++++++");
//                                        //详情列表
////                                        for (LocalMedia media : myRecycleViewAdapter.getTaoDatas().get(i).getImgs()) {
////                                            path_xiang = media.getCompressPath();
//////                                            Log.i(TAG, "path_xiang" + media.getCompressPath());
//////                                            Log.i(TAG, "原图---->" + media.getPath());
//////                                            Log.i(TAG, "裁剪---->" + media.getCutPath());
//////                                          单张图片，所有的图片的个数，第几个  datassss 换了一下
////                                            detail(path_xiang, myRecycleViewAdapter.getTaoDatas().get(i).getImgs().size(), i);
////                                        }
////详情页    图片添加
////                                        除了问题
////为了排序弄得下标
//
//
//
////每一排的数据添加进去
//                                        paisize.add(myRecycleViewAdapter.getTaoDatas().get(i).getImgs().size());
//
//
//                                        for (int j = 0; j < myRecycleViewAdapter.getTaoDatas().get(i).getImgs().size(); j++) {
//
//                                            path_xiang = myRecycleViewAdapter.getTaoDatas().get(i).getImgs().get(j).getCompressPath();
//
//                                            Posdetail(path_xiang,  ++number, i);
//                                        }


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
//                                    }
//                                }
                            }
                        });
                    }
                });
            }
        });
    }
}
