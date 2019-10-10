package com.example.YunleHui.ui.act.actme;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.Bean_sd;
import com.example.YunleHui.Bean.Bean_shopUrl;
import com.example.YunleHui.MainActivity;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.utils.BuildConfig;
import com.example.YunleHui.utils.FileUtil;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.birthdaypick.CustomListener;
import com.example.YunleHui.view.birthdaypick.OnTimeSelectListener;
import com.example.YunleHui.view.birthdaypick.TimePickerBuilder;
import com.example.YunleHui.view.birthdaypick.TimePickerView;
import com.tbruyelle.rxpermissions.Permission;
import com.tbruyelle.rxpermissions.RxPermissions;

import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import rx.Observer;
import rx.Subscription;
import rx.functions.Action1;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static com.example.YunleHui.utils.FileUtil.getRealFilePathFromUri;
import static com.example.YunleHui.utils.Tools.mBottomSheetPop;

/**
 * 个人信息信息
 */

public class ActPerinform extends BaseAct {

    @BindView(R.id.mFrameLayout)
    LinearLayout mFrameLayout;


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;

    private TextView text_center;

    @BindView(R.id.img_head)
    ImageView img_head;

    @BindView(R.id.text_name)
    TextView text_name;

    @BindView(R.id.text_sex)
    TextView text_sex;

    @BindView(R.id.text_Birthday)
    TextView text_Birthday;

    @BindView(R.id.text_phone)
    TextView text_phone;

    @BindView(R.id.lin_ni)
    LinearLayout lin_ni;

    @BindView(R.id.lin_Gender)
    LinearLayout lin_Gender;


    @BindView(R.id.lin_Birthday)
    LinearLayout lin_Birthday;


    @BindView(R.id.lin_head)
    LinearLayout lin_head;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_set_up;
    }


    @Override
    protected void onResume() {
        super.onResume();

        String name = (String) MyApp.getSharedPreference(this, "nickName", "");

        String xinBie = (String) MyApp.getSharedPreference(this, "gender", "");
        String avatarUrl = (String) MyApp.getSharedPreference(this, "avatarUrl", "");
        Glide.with(this).load(avatarUrl).into(img_head);
        text_name.setText(name);
        text_sex.setText(xinBie);


    }

    @Override
    protected void findViews() {

        if (toolbar_all != null) {
            text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("个人信息");
        }

    }

    @Override
    public void initData() {
        String phone = (String) MyApp.getSharedPreference(this, "phone", "");
        text_phone.setText(Tools.getStarPhone(phone));
    }

    private int type = 0;

    @OnClick({R.id.lin_head, R.id.lin_ni, R.id.lin_Gender})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.lin_head:
                type = 2;
                choosehead();

                break;
//                昵称
            case R.id.lin_ni:
                Intent intent = new Intent(this, ActMoinfor.class);
                intent.putExtra("name", "设置名字");

                intent.putExtra("text_name", text_name.getText().toString());

                intent.putExtra("type", 0);
                startActivity(intent);
                break;

            case R.id.lin_Gender:
                Intent intentGender = new Intent(this, ActMoinfor.class);
                intentGender.putExtra("name", "设置性别");
                intentGender.putExtra("type", 1);
                startActivity(intentGender);
                break;

        }
    }

    private void choosehead() {
        //                弹窗
        View view_headimg = Tools.setPop(this, R.layout.pop_shot, R.layout.frag_me);
//相册
        TextView text_Album = (TextView) view_headimg.findViewById(R.id.text_Album);
        text_Album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //权限判断
                if (ContextCompat.checkSelfPermission(ActPerinform.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    //申请READ_EXTERNAL_STORAGE权限
                    ActivityCompat.requestPermissions(ActPerinform.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            READ_EXTERNAL_STORAGE_REQUEST_CODE);
                } else {
                    //跳转到相册
                    gotoPhoto();
                }
                Tools.mBottomSheetPop.dismiss();
            }
        });
//                拍照
        TextView text_Photograph = (TextView) view_headimg.findViewById(R.id.text_Photograph);
        text_Photograph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //权限判断
//                if (ContextCompat.checkSelfPermission(ActPerinform.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                        != PackageManager.PERMISSION_GRANTED) {
//                    //申请WRITE_EXTERNAL_STORAGE权限
//                    ActivityCompat.requestPermissions(ActPerinform.this, new String[]{
//                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                                    Manifest.permission.CAMERA
//                            },
//                            WRITE_EXTERNAL_STORAGE_REQUEST_CODE);
//
//                    Toast.makeText(ActPerinform.this,"你妈的",Toast.LENGTH_SHORT).show();


//                RxPermissions.getInstance(ActPerinform.this)
//                        .requestEach(WRITE_EXTERNAL_STORAGE,
//                                Manifest.permission.CAMERA
//                        ).subscribe(new Action1<Boolean>() {
//                    @Override
//                    public void call(Boolean aBoolean) {
//                        if (aBoolean) {//true表示获取权限成功（注意这里在android6.0以下默认为true）
//                            Log.i("permissions", Manifest.permission.READ_CALENDAR + "：" + 获取成功);
//                        } else {
//                            Log.i("permissions", Manifest.permission.READ_CALENDAR + "：" + 获取失败);
//                        }
//                    }
//                });




                //这个请求事件我写在点击事件里面，
                //点击button之后RxPermissions会为我们申请运行时权限
                RxPermissions.getInstance(ActPerinform.this)
                        .request(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.CAMERA)//这里填写所需要的权限
                        .subscribe(new Action1<Boolean>() {
                            @Override
                            public void call(Boolean aBoolean) {
                                if (aBoolean) {//true表示获取权限成功（注意这里在android6.0以下默认为true）

                                    //跳转到调用系统相机
                                    gotoCamera();

                                    Log.i("READ_CALENDAR", Manifest.permission.CAMERA + "：" + "获取成功");
                                } else {
                                    Log.i("READ_CALENDAR", Manifest.permission.READ_CALENDAR + "：" + "获取失败");
                                }
                            }
                        });










//                        .subscribe(new Action1<Boolean>() {
//                            @Override
//                            public void call(Boolean permission) {
//                                    Log.i("permissions", Manifest.permission.CAMERA + "：" + WRITE_EXTERNAL_STORAGE);
//                                    //跳转到调用系统相机
//                                    gotoCamera();
//                            }
//                        });


//                } else {
//                    //跳转到调用系统相机
//                    gotoCamera();
//                }





                Tools.mBottomSheetPop.dismiss();
            }
        });
//取消
        TextView text_cancel_ = (TextView) view_headimg.findViewById(R.id.text_cancel);
        text_cancel_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomSheetPop.dismiss();
            }
        });
    }


    //请求相机
    private static final int REQUEST_CAPTURE = 100;
    //请求相册
    private static final int REQUEST_PICK = 101;
    //请求截图
    private static final int REQUEST_CROP_PHOTO = 102;
    //请求访问外部存储
    private static final int READ_EXTERNAL_STORAGE_REQUEST_CODE = 103;
    //请求写入外部存储
    private static final int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 104;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch (requestCode) {
            case REQUEST_CAPTURE: //调用系统相机返回
                if (resultCode == RESULT_OK) {
                    gotoClipActivity(Uri.fromFile(tempFile));
                }
                break;
            case REQUEST_PICK:  //调用系统相册返回
                if (resultCode == RESULT_OK) {
                    Uri uri = intent.getData();
                    gotoClipActivity(uri);
                }
                break;
            case REQUEST_CROP_PHOTO:  //剪切图片返回
                if (resultCode == RESULT_OK) {
                    final Uri uri = intent.getData();
                    if (uri == null) {
                        return;
                    }
                    String cropImagePath = getRealFilePathFromUri(getApplicationContext(), uri);
                    Bitmap bitMap = BitmapFactory.decodeFile(cropImagePath);

                    img_head.setImageBitmap(bitMap);

                    //此处后面可以将bitMap转为二进制上传后台网络
                    //......

                    uploadImage(cropImagePath);

                }
                break;
        }
    }


    /**
     * 打开截图界面
     */
    public void gotoClipActivity(Uri uri) {
        if (uri == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this, ClipImageActivity.class);
        intent.putExtra("type", type);
        intent.setData(uri);
        startActivityForResult(intent, REQUEST_CROP_PHOTO);
    }


    /**
     * 外部存储权限申请返回
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == WRITE_EXTERNAL_STORAGE_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission Granted
                gotoCamera();
            }
        } else if (requestCode == READ_EXTERNAL_STORAGE_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission Granted
                gotoPhoto();
            }
        }
    }


    /**
     * 跳转到相册
     */
    private void gotoPhoto() {
        Log.d("evan", "*****************打开图库********************");
        //跳转到调用系统图库
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(intent, "请选择图片"), REQUEST_PICK);
    }


    /**
     * 跳转到照相机
     */
    private void gotoCamera() {
        Log.d("evan", "*****************打开相机********************");
        Log.d("evan", "*****************打开相机********************");
        //创建拍照存储的图片文件
        tempFile = new File(FileUtil.checkDirPath(Environment.getExternalStorageDirectory().getPath() + "/image/"), System.currentTimeMillis() + ".jpg");

        //跳转到调用系统相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //设置7.0中共享文件，分享路径定义在xml/file_paths.xml
            intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(ActPerinform.this, BuildConfig.APPLICATION_ID + ".fileProvider", tempFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, contentUri);
        } else {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
        }
        startActivityForResult(intent, REQUEST_CAPTURE);


    }


    //调用照相机返回图片文件
    private File tempFile;


    private Bean_shopUrl bean_shopUrl;
    private boolean success_shopUrl;
    private int code_shopUrl;
    private String msg_shopUrl;
    private Bean_shopUrl.DataBean data_shopUrl;

    public void uploadImage(String imagePath) {
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
                        Log.i("response", "----" + img);
                        bean_shopUrl = MyApp.gson.fromJson(img, Bean_shopUrl.class);
                        data_shopUrl = bean_shopUrl.getData();
                        String img_url = data_shopUrl.getMediaUrl();
//添加图片
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                HttpUtil.addMapparams();
                                HttpUtil.params.put("avatarUrl", img_url);

                                HttpUtil.Post_request("user/updateUserInfo", HttpUtil.params);
                                getdata("user/updateUserInfo");


                            }
                        });

                    }
                });
            }
        });
    }


    private Bean_sd bean_sd;
    private boolean success_sd;
    private int code_sd;
    private String msg_sd;
    private Bean_sd.DataBean data_sd;

    @Override
    public void stringResulit(String key, String value) {
        if (key.equals("user/updateUserInfo")) {

            bean_sd = MyApp.gson.fromJson(value, Bean_sd.class);
            data_sd = bean_sd.getData();

            MyApp.putSharedPreference(this, "avatarUrl", data_sd.getAvatarUrl());

            Glide.with(this).load(data_sd.getAvatarUrl()).into(img_head);

        }
    }


}
