package com.example.YunleHui.ui.act.actme.actbusiness;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.YunleHui.MainActivity;
import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseAct;
import com.tbruyelle.rxpermissions.Permission;
import com.tbruyelle.rxpermissions.RxPermissions;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.OnClick;
import rx.functions.Action1;

public class ActWriteOffManage extends BaseAct {


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    @BindView(R.id.text_ma_search)
    TextView text_ma_search;


    @BindView(R.id.lin_saomiao)
    LinearLayout lin_saomiao;

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_write_off_manage;
    }

    @Override
    protected void findViews() {

        if (toolbar_all != null) {

            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("核销");

            TextView toolbar_right = toolbar_all.findViewById(R.id.toolbar_right);
            toolbar_right.setText("核销历史");
            toolbar_right.setVisibility(View.VISIBLE);

            toolbar_right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(ActWriteHistory.class);
                }
            });
        }
    }

    @Override
    public void initData() {

    }

    /**
     * 扫描跳转Activity RequestCode
     */
    public static final int REQUEST_CODE = 111;

    @OnClick({R.id.text_ma_search, R.id.lin_saomiao})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.text_ma_search:
                startActivity(ActDetailsWriteOff.class);
                break;

            case R.id.lin_saomiao:



                RxPermissions.getInstance(ActWriteOffManage.this)

                        .requestEach( Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.CAMERA
                        )
                        .subscribe(new Action1<Permission>() {
                            @Override
                            public void call(Permission permission) {
                                if (permission.name.equals(Manifest.permission.CAMERA)) {

                                    Log.i("permissions", Manifest.permission.CAMERA + "：" + permission.granted);

                                    Intent intent = new Intent(getApplication(), CaptureActivity.class);
                                    startActivityForResult(intent, REQUEST_CODE);

                                }
                            }
                        });



                break;
        }
    }







    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /**
         * 处理二维码扫描结果
         */
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(ActWriteOffManage.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }

//        /**
//         * 选择系统图片并解析
//         */
//        else if (requestCode == REQUEST_IMAGE) {
//            if (data != null) {
//                Uri uri = data.getData();
//                try {
//                    CodeUtils.analyzeBitmap(ImageUtil.getImageAbsolutePath(this, uri), new CodeUtils.AnalyzeCallback() {
//                        @Override
//                        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
//                            Toast.makeText(MainActivity.this, "解析结果:" + result, Toast.LENGTH_LONG).show();
//                        }
//
//                        @Override
//                        public void onAnalyzeFailed() {
//                            Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
//                        }
//                    });
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        else if (requestCode == REQUEST_CAMERA_PERM) {
//            Toast.makeText(this, "从设置页面返回...", Toast.LENGTH_SHORT)
//                    .show();
//        }
    }








}
