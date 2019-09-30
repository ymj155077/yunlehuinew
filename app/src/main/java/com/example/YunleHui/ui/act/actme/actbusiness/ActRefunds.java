package com.example.YunleHui.ui.act.actme.actbusiness;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.BeanHomeList;
import com.example.YunleHui.Bean.BeanImgs;
import com.example.YunleHui.Bean.Bean_shopList;
import com.example.YunleHui.MainActivity;
import com.example.YunleHui.R;
import com.example.YunleHui.adpter.FullyGridLayoutManager;
import com.example.YunleHui.adpter.GridImageAdapter;
import com.example.YunleHui.adpter.GridPublishGoods;
import com.example.YunleHui.adpter.GridPublishGoodsTao;
import com.example.YunleHui.adpter.MyRecycleViewAdapter;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.act.acthome.ActComdetails;
import com.example.YunleHui.ui.act.actme.ActBusApp;
import com.example.YunleHui.ui.act.refund.ActRefund;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.ClearEditText;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.permissions.RxPermissions;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * 社区购发布商品
 */


public class ActRefunds extends BaseAct {

    ArrayList<BeanImgs> datassss = new ArrayList<>();


    // 0 头部的数据，1套餐的数据
    private int Moder = 0;


//    头部

    @BindView(R.id.recycler_head)
    RecyclerView recycler_head;


    private int themeId;
    private int chooseMode = PictureMimeType.ofImage();

    private int maxSelectNum = 6;

    private List<LocalMedia> selectList = new ArrayList<>();
    private GridPublishGoods adapter;


    private GridPublishGoodsTao adapterTao;


    private final static String TAG = MainActivity.class.getSimpleName();


    private List<LocalMedia> selectListTao = new ArrayList<>();


//    套餐的列表

    @BindView(R.id.recycler_tao)
    RecyclerView recycler_tao;

    //
    private MyRecycleViewAdapter myRecycleViewAdapter;


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_refunds;
    }

    @Override
    protected void findViews() {

        if (toolbar_all != null) {
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("商品发布");
        }

    }

    @Override
    public void initData() {
        themeId = R.style.picture_default_style;
        FullyGridLayoutManager manager = new FullyGridLayoutManager(ActRefunds.this, 4, GridLayoutManager.VERTICAL, false);
        recycler_head.setLayoutManager(manager);
        adapter = new GridPublishGoods(ActRefunds.this, onAddPicClickListener);
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
                            PictureSelector.create(ActRefunds.this).themeStyle(themeId).openExternalPreview(position, selectList);
                            break;
                        case 2:
                            // 预览视频
                            PictureSelector.create(ActRefunds.this).externalPictureVideo(media.getPath());
                            break;
                        case 3:
                            // 预览音频
                            PictureSelector.create(ActRefunds.this).externalPictureAudio(media.getPath());
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
                    PictureFileUtils.deleteCacheDirFile(ActRefunds.this);
                } else {
                    Toast.makeText(ActRefunds.this,
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


//        添加套餐的 列表  recycler_tao


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
            datassss.add(new BeanImgs("", imgs, "", "", "", "", ""));
        }

        myRecycleViewAdapter = new MyRecycleViewAdapter(datassss, this);

        recycler_tao.setAdapter(myRecycleViewAdapter);

        //传true 可以滑动 false不可以滑动
        recycler_tao.setNestedScrollingEnabled(false);

    }

    //头部的数据
    private GridPublishGoods.onAddPicClickListener onAddPicClickListener = new GridPublishGoods.onAddPicClickListener() {
        @Override
        public void onAddPicClick() {

            Toast.makeText(ActRefunds.this, "===111===", Toast.LENGTH_SHORT).show();


            Moder = 0;


//          相册or单独拍照

            boolean mode = true;
            if (mode) {
                // 进入相册 以下是例子：不需要的api可以不写
                PictureSelector.create(ActRefunds.this)
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
                PictureSelector.create(ActRefunds.this)
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


    //套餐的数据
    GridPublishGoodsTao.onAddPicClickListener onAddPicClickListeners = new GridPublishGoodsTao.onAddPicClickListener() {
        @Override
        public void onAddPicClick(int position) {

            Toast.makeText(ActRefunds.this, "===222===" + "---" + position, Toast.LENGTH_SHORT).show();


            Moder = 1;


            postionTao = position;


//          相册or单独拍照

            boolean mode = true;
            if (mode) {
                // 进入相册 以下是例子：不需要的api可以不写
                PictureSelector.create(ActRefunds.this)
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
                PictureSelector.create(ActRefunds.this)
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

                        datassss.set(postionTao, new BeanImgs("", selectListTao, "", "", "", "", ""));

                        myRecycleViewAdapter = new MyRecycleViewAdapter(datassss, this);

                        recycler_tao.setAdapter(myRecycleViewAdapter);

                    }
                    break;
            }
        }
    }

    private String path_img;

    //    套餐里面选中的postion；
    private int postionTao = 0;

    //套餐一个的时候显示
    FullyGridLayoutManager managerOne;

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
//            List<LocalMedia> selectList = new ArrayList<>();
//            selectList.clear();
//            selectList.addAll(datas.get(positionss).getImgs());
//            套餐里面图片的列表
            managerOne = new FullyGridLayoutManager(ActRefunds.this, 4, GridLayoutManager.VERTICAL, false);
            holder.xr_refund.setLayoutManager(managerOne);
            adapterTao = new GridPublishGoodsTao(ActRefunds.this, onAddPicClickListeners, positionss);
            Log.i("GridPublishGoodsTao", datas.get(positionss).getImgs().size() + "----" + "----");
            adapterTao.setList(datas.get(positionss).getImgs());
//            datas.get(positionss).setImgs(datas.get(positionss).getImgs());
//            datas.set(postionTao,new BeanImgs("",selectListTao,"","","","",""));
//            将数据存储起来
//            datasasd.add(new BeanImgs("",datas.get(positionss).getImgs(),"","","","",""));
            adapterTao.setSelectMax(maxSelectNum);
            holder.xr_refund.setAdapter(adapterTao);
            holder.xr_refund.setNestedScrollingEnabled(false);
            adapterTao.setOnItemClickListener(new GridPublishGoodsTao.OnItemClickListener() {
                @Override
                public void onItemClick(int position, View v) {
                    Toast.makeText(ActRefunds.this, postionTao + "----" + positionss, Toast.LENGTH_SHORT).show();
                    Log.i("adapterTao", postionTao + "---" + positionss);
//                  postionTao = positionss;
//                  myRecycleViewAdapter.getData();
                    if (datas.get(positionss).getImgs().size() > 0) {
                        LocalMedia media = datas.get(positionss).getImgs().get(position);
                        String pictureType = media.getPictureType();
                        int mediaType = PictureMimeType.pictureToVideo(pictureType);
                        switch (mediaType) {
                            case 1:
                                // 预览图片 可自定长按保存路径
                                //PictureSelector.create(MainActivity.this).themeStyle(themeId).externalPicturePreview(position, "/custom_file", selectList);
                                PictureSelector.create(ActRefunds.this).themeStyle(themeId).openExternalPreview(position, datas.get(positionss).getImgs());
                                break;
                            case 2:
                                // 预览视频
                                PictureSelector.create(ActRefunds.this).externalPictureVideo(media.getPath());
                                break;
                            case 3:
                                // 预览音频
                                PictureSelector.create(ActRefunds.this).externalPictureAudio(media.getPath());
                                break;
                        }
                    }
                }
            });

            holder.lin_addItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    List<LocalMedia> selectListTao = new ArrayList<>();
                    selectListTao.clear();
                    datas.add(new BeanImgs("", selectListTao, "", "", "", "", ""));
                    datassss.add(new BeanImgs("", selectListTao, "", "", "", "", ""));
                    myRecycleViewAdapter.notifyDataSetChanged();
                }
            });

            holder.lin_RemoveItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    datas.remove(positionss);
                    datassss.remove(positionss);
                    myRecycleViewAdapter.notifyItemRemoved(positionss);
                    myRecycleViewAdapter.notifyDataSetChanged();
                }
            });

            holder.lin_Price.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    postionTao = positionss;


                    View view_ = Tools.setRebuildPop(context, R.layout.item_fabu, R.layout.frag_explosive);


                    ClearEditText edit_yuan, edit_now, edit_yong, edit_jie, edit_Stock;

                    edit_yuan = view_.findViewById(R.id.edit_yuan);
                    edit_now = view_.findViewById(R.id.edit_now);
                    edit_yong = view_.findViewById(R.id.edit_yong);
                    edit_jie = view_.findViewById(R.id.edit_jie);
                    edit_Stock = view_.findViewById(R.id.edit_Stock);

                    TextView text_click, text_cancel;
                    text_click = (TextView) view_.findViewById(R.id.text_click);
                    text_cancel = (TextView) view_.findViewById(R.id.text_cancel);

                    text_click.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            datassss.set(postionTao, new BeanImgs("", selectListTao, "", "", "", "", ""));

                            datassss.get(postionTao).setOriginalprice(edit_yuan.getText().toString().trim());

                            datassss.get(postionTao).setPresentprice(edit_now.getText().toString().trim());

                            datassss.get(postionTao).setCommission(edit_yong.getText().toString().trim());

                            datassss.get(postionTao).setStock(edit_Stock.getText().toString().trim());

                            myRecycleViewAdapter = new MyRecycleViewAdapter(datassss, ActRefunds.this);

                            recycler_tao.setAdapter(myRecycleViewAdapter);

                            Tools.mBottomSheetPop.dismiss();

                        }
                    });



                    text_cancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Tools.mBottomSheetPop.dismiss();
                        }
                    });





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


            public ViewHolder(View itemView) {
                super(itemView);
                xr_refund = (RecyclerView) itemView.findViewById(R.id.xr_refund);
                lin_addItem = itemView.findViewById(R.id.lin_addItem);
                lin_RemoveItem = itemView.findViewById(R.id.lin_RemoveItem);

                lin_Price = itemView.findViewById(R.id.lin_Price);

            }
        }
    }


}
