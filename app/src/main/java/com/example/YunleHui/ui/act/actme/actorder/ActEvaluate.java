package com.example.YunleHui.ui.act.actme.actorder;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.YunleHui.Bean.Bean_shopUrl;
import com.example.YunleHui.MainActivity;
import com.example.YunleHui.R;
import com.example.YunleHui.adpter.FullyGridLayoutManager;
import com.example.YunleHui.adpter.GridImageAdapter;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.act.actme.ActBusApp;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.view.ClearEditText;
import com.example.xlhratingbar_lib.XLHRatingBar;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.permissions.RxPermissions;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.StringUtils;

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

/**
 * 评价
 */

public class ActEvaluate extends BaseAct {



    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    @BindView(R.id.edit_Remarks)
    ClearEditText edit_Remarks;


    private int foodId = 0 ;

    private String orderNum = "";


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.act_evaluate;
    }

    @Override
    protected void findViews() {

        if (toolbar_all!=null){
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("评价");
        }

    }

    private int themeId;

    private int chooseMode = PictureMimeType.ofImage();

    private int maxSelectNum = 6;


    private int IsSelection = 0;


    @Override
    public void initData() {
        Intent intent = getIntent();
        foodId = intent.getIntExtra("foodId",0);


        orderNum = intent.getStringExtra("orderNum");


        imgs.clear();
        themeId = R.style.picture_default_style;
        FullyGridLayoutManager manager = new FullyGridLayoutManager(ActEvaluate.this, 4, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        adapter = new GridImageAdapter(ActEvaluate.this, onAddPicClickListener);
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
                            PictureSelector.create(ActEvaluate.this).themeStyle(themeId).openExternalPreview(position, selectList);
                            break;
                        case 2:
                            // 预览视频
                            PictureSelector.create(ActEvaluate.this).externalPictureVideo(media.getPath());
                            break;
                        case 3:
                            // 预览音频
                            PictureSelector.create(ActEvaluate.this).externalPictureAudio(media.getPath());
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
                    PictureFileUtils.deleteCacheDirFile(ActEvaluate.this);
                } else {
                    Toast.makeText(ActEvaluate.this,
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


        select_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(ActEvaluate.this, "1", Toast.LENGTH_SHORT)
                            .show();
                    IsSelection = 1 ;
                }else {
                    Toast.makeText(ActEvaluate.this, "0", Toast.LENGTH_SHORT)
                            .show();
                    IsSelection = 0 ;
                }
            }
        });


        ratingBar.setOnRatingChangeListener(new XLHRatingBar.OnRatingChangeListener() {
            @Override
            public void onChange(int countSelected) {
                rating = countSelected;
                if (countSelected == 1) {
                    text_pin.setText("很差");
                } else if (countSelected == 2) {
                    text_pin.setText("一般");
                } else if (countSelected == 3) {
                    text_pin.setText("满意");
                } else if (countSelected == 4) {
                    text_pin.setText("非常满意");
                } else if (countSelected == 5) {
                    text_pin.setText("毫无挑剔");
                }
//                Toast.makeText(getApplicationContext(), countSelected + "---" + "rating:", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private int rating = 5;


    @BindView(R.id.select_all)
    CheckBox select_all;

    @BindView(R.id.ratingBar)
    XLHRatingBar ratingBar;

    @BindView(R.id.text_pin)
    TextView text_pin;

    private GridImageAdapter adapter;

    private List<LocalMedia> selectList = new ArrayList<>();


    private GridImageAdapter.onAddPicClickListener onAddPicClickListener = new GridImageAdapter.onAddPicClickListener() {
        @Override
        public void onAddPicClick() {
//            相册or单独拍照
            boolean mode = true;
            if (mode) {
                // 进入相册 以下是例子：不需要的api可以不写
                PictureSelector.create(ActEvaluate.this)
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
                PictureSelector.create(ActEvaluate.this)
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


    public static class GridImageAdapter extends
            RecyclerView.Adapter<GridImageAdapter.ViewHolder> {
        public static final int TYPE_CAMERA = 1;
        public static final int TYPE_PICTURE = 2;
        private LayoutInflater mInflater;
        private List<LocalMedia> list = new ArrayList<>();
        private int selectMax = 9;
        private Context context;
        /**
         * 点击添加图片跳转
         */
        private onAddPicClickListener mOnAddPicClickListener;

        public interface onAddPicClickListener {
            void onAddPicClick();
        }


        public List<LocalMedia> getDta() {

            return list;

        }


        public GridImageAdapter(Context context, onAddPicClickListener mOnAddPicClickListener) {
            this.context = context;
            mInflater = LayoutInflater.from(context);
            this.mOnAddPicClickListener = mOnAddPicClickListener;
        }

        public void setSelectMax(int selectMax) {
            this.selectMax = selectMax;
        }

        public void setList(List<LocalMedia> list) {
            this.list = list;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            ImageView mImg;
            LinearLayout ll_del;
            TextView tv_duration;

            public ViewHolder(View view) {
                super(view);
                mImg = (ImageView) view.findViewById(R.id.fiv);
                ll_del = (LinearLayout) view.findViewById(R.id.ll_del);
                tv_duration = (TextView) view.findViewById(R.id.tv_duration);
            }
        }

        @Override
        public int getItemCount() {
            if (list.size() < selectMax) {
                return list.size() + 1;
            } else {
                return list.size();
            }
        }

        @Override
        public int getItemViewType(int position) {
            if (isShowAddItem(position)) {
                return TYPE_CAMERA;
            } else {
                return TYPE_PICTURE;
            }
        }

        /**
         * 创建ViewHolder
         */
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = mInflater.inflate(R.layout.gv_filter,
                    viewGroup, false);
            final ViewHolder viewHolder = new GridImageAdapter.ViewHolder(view);
            return viewHolder;
        }

        private boolean isShowAddItem(int position) {
            int size = list.size() == 0 ? 0 : list.size();
            return position == size;
        }

        /**
         * 设置值
         */
        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {
            //少于8张，显示继续添加的图标
            if (getItemViewType(position) == TYPE_CAMERA) {
                viewHolder.mImg.setImageResource(R.drawable.addimg_1x);
                viewHolder.mImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mOnAddPicClickListener.onAddPicClick();
                    }
                });
                viewHolder.ll_del.setVisibility(View.INVISIBLE);
            } else {
                viewHolder.ll_del.setVisibility(View.VISIBLE);
                viewHolder.ll_del.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int index = viewHolder.getAdapterPosition();
                        // 这里有时会返回-1造成数据下标越界,具体可参考getAdapterPosition()源码，
                        // 通过源码分析应该是bindViewHolder()暂未绘制完成导致，知道原因的也可联系我~感谢
                        if (index != RecyclerView.NO_POSITION) {
                            list.remove(index);
                            notifyItemRemoved(index);
                            notifyItemRangeChanged(index, list.size());
                        }
                    }
                });
                LocalMedia media = list.get(position);
                int mimeType = media.getMimeType();
                String path = "";
                if (media.isCut() && !media.isCompressed()) {
                    // 裁剪过
                    path = media.getCutPath();
                } else if (media.isCompressed() || (media.isCut() && media.isCompressed())) {
                    // 压缩过,或者裁剪同时压缩过,以最终压缩过图片为准
                    path = media.getCompressPath();
                } else {
                    // 原图
                    path = media.getPath();
                }
                // 图片
                if (media.isCompressed()) {
                    Log.i("compress image result:", new File(media.getCompressPath()).length() / 1024 + "k");
                    Log.i("压缩地址::", media.getCompressPath());
                }

                Log.i("原图地址::", media.getPath());
                int pictureType = PictureMimeType.isPictureType(media.getPictureType());
                if (media.isCut()) {
                    Log.i("裁剪地址::", media.getCutPath());
                }
                long duration = media.getDuration();
                viewHolder.tv_duration.setVisibility(pictureType == PictureConfig.TYPE_VIDEO
                        ? View.VISIBLE : View.GONE);
                if (mimeType == PictureMimeType.ofAudio()) {
                    viewHolder.tv_duration.setVisibility(View.VISIBLE);
                    Drawable drawable = ContextCompat.getDrawable(context, R.drawable.picture_audio);
                    StringUtils.modifyTextViewDrawable(viewHolder.tv_duration, drawable, 0);
                } else {
                    Drawable drawable = ContextCompat.getDrawable(context, R.drawable.video_icon);
                    StringUtils.modifyTextViewDrawable(viewHolder.tv_duration, drawable, 0);
                }
                viewHolder.tv_duration.setText(DateUtils.timeParse(duration));
                if (mimeType == PictureMimeType.ofAudio()) {
                    viewHolder.mImg.setImageResource(R.drawable.audio_placeholder);
                } else {
                    RequestOptions options = new RequestOptions()
                            .centerCrop()
                            .placeholder(R.color.color_f6)
                            .diskCacheStrategy(DiskCacheStrategy.ALL);
                    Glide.with(viewHolder.itemView.getContext())
                            .load(path)
                            .apply(options)
                            .into(viewHolder.mImg);
                }
                //itemView 的点击事件
                if (mItemClickListener != null) {
                    viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int adapterPosition = viewHolder.getAdapterPosition();
                            mItemClickListener.onItemClick(adapterPosition, v);
                        }
                    });
                }
            }
        }

        protected OnItemClickListener mItemClickListener;

        public interface OnItemClickListener {
            void onItemClick(int position, View v);
        }

        public void setOnItemClickListener(OnItemClickListener listener) {
            this.mItemClickListener = listener;
        }
    }


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
    private String path_img;


    @OnClick({R.id.text_Submission})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.text_Submission:
                selectListUp.clear();
                selectListUp = adapter.getDta();
                if (selectListUp.size() > 0) {
                    try {
                        uploadImage();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }


    private Bean_shopUrl bean_shopUrl;
    private boolean success_shopUrl;
    private int code_shopUrl;
    private String msg_shopUrl;
    private Bean_shopUrl.DataBean data_shopUrl;


    //上传的list
    private List<LocalMedia> selectListUp = new ArrayList<>();


    /**
     * 上传图片
     * //     * @param url
     * //     * @param imagePath 图片路径
     *
     * @return 新图片的路径
     * @throws IOException
     * @throws JSONException
     */

    int size = 0;

    public void uploadImage() throws IOException, JSONException {
        String imagePath = selectListUp.get(size).getCompressPath();
        ++size;
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
                        Log.i("response", size + "----" + img);
                        bean_shopUrl = MyApp.gson.fromJson(img, Bean_shopUrl.class);
                        data_shopUrl = bean_shopUrl.getData();
                        String img_url = data_shopUrl.getMediaUrl();
//添加图片
                        imgs.add(img_url);
                        if (selectListUp.size() == size) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //提交申请数据
                                    HttpUtil.addMapparams();
                                    Map<Object, Object> params_order = new HashMap<>();
                                    params_order.clear();
                                    params_order.put("orderNum", orderNum);
                                    params_order.put("content", edit_Remarks.getText().toString());
                                    params_order.put("createTime", "");
                                    params_order.put("goodsDes", "");
                                    params_order.put("parentId", 0);
                                    params_order.put("replyId", 0);
                                    params_order.put("replyUserId", 0);
                                    params_order.put("replyUserUser", "");
                                    params_order.put("score", 0);
                                    params_order.put("star", 0);
                                    params_order.put("typeId", 0);
                                    params_order.put("userId", MyApp.user);
                                    params_order.put("userLogo", "");
                                    params_order.put("userName", "");
                                    params_order.put("varId", foodId);
//                        HttpUtil.params.put("shopApplyDto", params_order);
//                        HttpUtil.params.put("userId", MyApp.user);
                                    params_order.put("picUrl", MyApp.gson.toJson(imgs) + "");
                                    HttpUtil.postRaw("frontShop/shop/addComment", params_order);
                                    getdata("frontShop/shop/addComment");

                                    Log.i("addComment", MyApp.gson.toJson(imgs));

                                }
                            });
                        } else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        uploadImage();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                    }
                });
            }
        });
    }


    List<String> imgs = new ArrayList<>();


    @Override
    public void StringResulit(String key, String value) {


        if (key.equals("frontShop/shop/addComment")) {

            finish();

        }


    }


}
