package com.example.YunleHui.base;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.YunleHui.Bean.BeanVerification;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.ui.act.actme.ActLogin;
import com.example.YunleHui.utils.ActivityCollector;
import com.example.YunleHui.utils.ScreenAdapterUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.utils.statusBar.StatusBarCompat;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Callback;
import okhttp3.Response;


public abstract class BaseAct extends AppCompatActivity {


    private BeanVerification beanVerification;
    private boolean success;
    private int code;
    private String msg;
    private Object data;
    private Toolbar toolbar_all;
    private int two;
    private int three;
    protected Unbinder mBinder;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注意：这里的setContentView必须有super才可以，需要走父类方法
//        super.setContentView(R.layout.activity_base);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(getContentViewId());
        StatusBarCompat.translucentStatusBar(this, true);
        StatusBarCompat.changeToLightStatusBar(this);
        Log.d("BaseActivity", getClass().getSimpleName());
//        Knife
        ActivityCollector.addActivity(this);
        findViews();
        if (ScreenAdapterUtil.hasNotchScreen(this)) {
//            Log.d("ScreenAdapterUtil", "你是刘海屏");
            if (toolbar_all != null) {
//                setToolbarHeight(85, toolbar_all);
                setToolbarHeight(73, toolbar_all);

            }
        } else {
//            Log.d("ScreenAdapterUtil", "你是常规屏");
            if (toolbar_all != null) {
//                setToolbarHeight(82, toolbar_all);

                setToolbarHeight(70, toolbar_all);
            }
        }
        initData();
    }
    /**
     * 使用频率高 一般用于Activity初始化界面
     * 例如 onCreate()里。初始化布局就用到setContentView(R.layout.xxxx) 就是初始化页面布局
     */
    @Override
    public void setContentView(int layoutResId) {
        super.setContentView(layoutResId);
        //Butter Knife初始化
        mBinder = ButterKnife.bind(this);
    }

    /**
     * 这个一般用于加载自定义控件，或者系统空间的布局
     */
    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        //Butter Knife初始化
        mBinder = ButterKnife.bind(this);
    }

    /**
     *
     */
    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        //Butter Knife初始化
        mBinder = ButterKnife.bind(this);
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
//                                           @NonNull int[] grantResults) {
//        XPermissionUtils.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }

    public abstract void startActivity(Class<?> clz);

    @Override
    protected void onStart() {
        super.onStart();
//        showLoadingDialog();
        toolbar_all = (Toolbar) findViewById(R.id.toolbar_all);

        if (toolbar_all != null) {

            LinearLayout lin_lin_lin = (LinearLayout) toolbar_all.findViewById(R.id.lin_lin_lin);

            lin_lin_lin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }


        /**
         * 判断是否有Toolbar,并默认显示返回按钮
         */
        if (null != getToolbar() && isShowBacking()) {
            showBack();
        }
    }


    /**
     * 重置Toolbar高度
     *
     * @param height
     */
    protected void setToolbarHeight(int height, Toolbar toolbar) {
        Toolbar.LayoutParams params = new Toolbar.LayoutParams(Toolbar.LayoutParams.MATCH_PARENT, height);
        toolbar.setLayoutParams(params);
    }


    /**
     * this Activity of tool bar.
     * 获取头部.
     *
     * @return support.v7.widget.Toolbar.
     */
    public Toolbar getToolbar() {
        return (Toolbar) findViewById(R.id.toolbar);
    }

    /**
     * 版本号小于21的后退按钮图片
     */
    private void showBack() {
        getToolbar().setNavigationIcon(R.drawable.toolbar_back);
        getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    protected boolean isShowBacking() {
        return true;
    }

    public static AlertDialog alertDialog;

    public static LinearLayout lin_diassd;

    public void showLoadingDialog() {
        alertDialog = new AlertDialog.Builder(this, R.style.CustomDialog).create();
        alertDialog.setCancelable(false);
        alertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_SEARCH || keyCode == KeyEvent.KEYCODE_BACK)
                    return true;
                return false;
            }
        });
        alertDialog.show();
        alertDialog.setContentView(R.layout.loading_alert);
        alertDialog.setCanceledOnTouchOutside(false);
        lin_diassd = (LinearLayout) alertDialog.findViewById(R.id.lin_diassd);
        lin_diassd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissLoadingDialog();
                finish();
            }
        });
    }












    public void dismissLoadingDialog() {
        if (null != alertDialog && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }
    public abstract int getContentViewId();

    protected abstract void findViews();

    public abstract void initData();


    @Override
    protected void onDestroy() {
        mBinder.unbind();
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    public void stringResulit(String key, String value) {

    }


    public void getdata(final String key) {
        MyApp.call.enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                Log.i(key, e.toString() + "");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Network_state(0);
                        dismissLoadingDialog();
                    }
                });
            }
            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                final String resp = response.body().string();
                Tools.i(key,resp);
                try {
                    beanVerification = MyApp.gson.fromJson(resp, BeanVerification.class);
                    code = beanVerification.getCode();

//                    if (code ==200) {
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                Network_state(1);
//                                stringResulit(key, resp);
//                            }
//                        });
//                    } else

                        if (code==800103){

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                stringResulit(key, resp);
                            }
                        });

                    } else if (code == 105100) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                MyApp.user = 0;
                                MyApp.putSharedPreference(BaseAct.this, "user", 0);
                                MyApp.putSharedPreference(BaseAct.this,"access_token", "");
                                Toast.makeText(BaseAct.this, "登录失效！请重新登录！", Toast.LENGTH_SHORT).show();
                                startActivity(ActLogin.class);
                            }
                        });
                    }else if (code == 105101) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(BaseAct.this, beanVerification.getMsg(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }else if (code == 105102) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(BaseAct.this, beanVerification.getMsg(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }else if (code == 105103) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(BaseAct.this, beanVerification.getMsg(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }else if (code == 105104) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(BaseAct.this, beanVerification.getMsg(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                        else {

                       runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
//                                if (key.equals("account/checkPasswordSetting")){
                                    stringResulit(key, resp);
//                                }else {
//                                    Toast.makeText(BaseAct.this, beanVerification.getMsg(), Toast.LENGTH_SHORT).show();
//                                }
                            }
                        });
                    }
//                    else if (code.equals("401")) {
////                        Network_state(2);
////                        dismissLoadingDialog();
////                        MyApp.user = "";
////                        MyApp.putSharedPreference(BaseActivity.this, "user", "");
////                        MyApp.putSharedPreference(BaseActivity.this, "access_token", "");
////                        Toast.makeText(BaseActivity.this, "登录失效！请重新登录！", Toast.LENGTH_SHORT).show();
////                        startActivity(ActLogin.class);
//                    } else {
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
////                                Network_state(3);
////                                dismissLoadingDialog();
////                                String message = bean_error.getMessage();
////                                Toast.makeText(BaseActivity.this, message + "", Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                    }
                } catch (Exception e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
//                            解析数据错误
//                            Network_state(4);
//                            dismissLoadingDialog();

                            try {
                                Toast.makeText(BaseAct.this, beanVerification.getMsg(), Toast.LENGTH_SHORT).show();
                            }catch (Exception e){

                            }

                        }
                    });
                }
            }
        });
    }
    public void Network_state(int a){

    }
}
