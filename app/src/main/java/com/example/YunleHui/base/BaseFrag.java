package com.example.YunleHui.base;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.YunleHui.Bean.BeanVerification;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.ui.act.actme.ActLogin;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.utils.statusBar.StatusBarCompat;
import java.io.IOException;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Callback;
import okhttp3.Response;

public abstract class BaseFrag extends Fragment {

    private BeanVerification beanVerification;
    private boolean success;
    private int code;
    private String msg;
    private Object data;


    private AlertDialog alertDialog;


    public void showLoadingDialog() {


        alertDialog = new AlertDialog.Builder(getActivity(), R.style.CustomDialog).create();
//        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
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


    }

    public void dismissLoadingDialog() {
        Log.i("dismissLoadingDialog", "----------------");
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }

    }

    private Unbinder unbinder;

    protected Activity mActivity;
    protected View view;

    AppCompatActivity mAppCompatActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity) context;
    }

    @Override
    public void onDestroyView() {

        if (unbinder != null) {
            unbinder.unbind();
        }

        super.onDestroyView();
        view = null;
    }


    @SuppressLint("ResourceAsColor")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(mActivity)
                .inflate(getLayoutId(), container, false);

        unbinder = ButterKnife.bind(this, view);

        initView(view, savedInstanceState);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_all);
        if (toolbar != null) {
            LinearLayout lin_lin_lin = (LinearLayout) toolbar.findViewById(R.id.lin_lin_lin);
            lin_lin_lin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().finish();
                }
            });
        }
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        StatusBarCompat.translucentStatusBar(getActivity(), true);

        StatusBarCompat.changeToLightStatusBar(getActivity());

        initData();
    }

    public abstract void startActivity(Class<?> clz);

    protected abstract int getLayoutId();

    protected abstract void initView(View view, Bundle savedInstanceState);

    protected abstract void initData();




    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void StringResulit(String key, String value) {

    }

    public void getdata(final String key) {
        MyApp.call.enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                Log.i(key, e.toString() + "");
//                getActivity().runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Network_state(0);
//                        dismissLoadingDialog();
//                    }
//                });
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                final String resp = response.body().string();
                Tools.i(key, resp);
                try {
                    beanVerification = MyApp.gson.fromJson(resp, BeanVerification.class);
                    code = beanVerification.getCode();
//                    if (code == 200) {
//                        getActivity().runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                Network_state(1);
//                                StringResulit(key, resp);
//                            }
//                        });
//                    } else
                        if (code == 105100) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                MyApp.user = 0;
                                MyApp.putSharedPreference(getActivity(), "user", 0);
                                MyApp.putSharedPreference(getActivity(), "access_token", "");
                                Toast.makeText(getActivity(), "登录失效！请重新登录！", Toast.LENGTH_SHORT).show();
                                startActivity(ActLogin.class);
                            }
                        });
                    } else if (code == 105101) {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getActivity(), beanVerification.getMsg(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }else if (code == 105102) {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getActivity(), beanVerification.getMsg(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }else if (code == 105103) {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getActivity(), beanVerification.getMsg(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }else if (code == 105104) {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getActivity(), beanVerification.getMsg(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    else {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                StringResulit(key, resp);
//                                Toast.makeText(getActivity(), beanVerification.getMsg(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
// else if (code.equals("401")) {
//                        Network_state(2);
//                        dismissLoadingDialog();
//                        MyApp.user = "";
//                        MyApp.putSharedPreference(getActivity(), "user", "");
//                        MyApp.putSharedPreference(getActivity(), "access_token", "");
//                        Toast.makeText(getActivity(), "登录失效！请重新登录！", Toast.LENGTH_SHORT).show();
//                        startActivity(ActLogin.class);
//                    } else {
//                        getActivity().runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                Network_state(3);
//                                dismissLoadingDialog();
//                                String message = bean_error.getMessage();
//                                Toast.makeText(getActivity(), message + "", Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                    }
                } catch (Exception e) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            try {
                                Toast.makeText(getActivity(), beanVerification.getMsg(), Toast.LENGTH_SHORT).show();
                                Network_state(4);
                                dismissLoadingDialog();
                            }catch (Exception e1){

                            }
                        }
                    });
                }
            }
        });
    }

    public void Network_state(int a) {

    }


}
