package com.example.YunleHui.ui.act.actme;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.YunleHui.Bean.BeanLogin;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.view.ClearEditText;

import butterknife.BindView;
import butterknife.OnClick;


public class ActLogin extends BaseAct {

    private BeanLogin beanLogin;
    private boolean success;
    private int code;
    private String msg;
    private BeanLogin.DataBean data;
    private BeanLogin.DataBean.UserInfoBean userInfo;
    Toolbar toolbar_all;
    private TimeCount time;
    @BindView(R.id.text_send)
    TextView text_send;
    @BindView(R.id.edit_phone)
    ClearEditText edit_phone;
    @BindView(R.id.et_account)
    ClearEditText et_account;
    @BindView(R.id.text_login)
    TextView text_login;

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_login;
    }

    @Override
    protected void findViews() {
        toolbar_all = findViewById(R.id.toolbar_all);
        if (toolbar_all != null) {
            ImageView back_tool = toolbar_all.findViewById(R.id.back_tool);
            back_tool.setImageResource(R.drawable.finsh);
            TextView text = toolbar_all.findViewById(R.id.toolbar_center);
            text.setText("");
        }
        text_send = (TextView) findViewById(R.id.text_send);
        edit_phone = (ClearEditText) findViewById(R.id.edit_phone);
    }

    @Override
    public void initData() {
        time = new TimeCount(60000, 1000);
    }

    @OnClick({R.id.text_send, R.id.et_account, R.id.text_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text_send:
                if (null != edit_phone.getText().toString().trim() && edit_phone.getText().toString().trim().length() > 9) {
                    text_send.setClickable(false);
                    time.start();
                    HttpUtil.addMapparams();
                    HttpUtil.params.put("phone", edit_phone.getText().toString().trim());
                    HttpUtil.Post_request("user/login/smsCode", HttpUtil.params);
                    getdata("user/login/smsCode");
                } else {
                    Toast.makeText(this, "请检查号码是否有误！", Toast.LENGTH_SHORT).show();
                }
                break;
//                登录
            case R.id.text_login:
                HttpUtil.addMapparams();
                HttpUtil.params.put("phone", edit_phone.getText().toString().trim());
                HttpUtil.params.put("SmsCode", et_account.getText().toString().trim());
                HttpUtil.Post_request("user/login", HttpUtil.params);
                getdata("user/login");
                break;
        }
    }


    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            text_send.setClickable(false);
            text_send.setText("(" + millisUntilFinished / 1000 + ") 秒");
        }

        @Override
        public void onFinish() {
            text_send.setText("重新获取");
            text_send.setClickable(true);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (time != null) {
            time.cancel();
        }
    }


    @Override
    public void StringResulit(String key, String value) {

        try {
            if (key.equals("user/login/smsCode")){
                Toast.makeText(this, "发送成功", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {

        }
        if (key.equals("user/login")) {

                beanLogin = MyApp.gson.fromJson(value, BeanLogin.class);
                data = beanLogin.getData();
                userInfo = data.getUserInfo();
                MyApp.user = userInfo.getId();
                MyApp.access_token = data.getToken();
                MyApp.userType = data.getUserType();
                MyApp.putSharedPreference(this, "phone", edit_phone.getText().toString().trim());
                MyApp.putSharedPreference(this, "user", userInfo.getId());
                MyApp.putSharedPreference(this, "access_token", data.getToken() + "");
                MyApp.putSharedPreference(this, "nickName", userInfo.getNickName() + "");
                MyApp.putSharedPreference(this, "userType", data.getUserType());

                if (userInfo.getAvatarUrl()==null){
                    String getAvatarUrl = "";
                }

                MyApp.putSharedPreference(this, "avatarUrl", "");
                if (userInfo.getGender()==-1) {
                    MyApp.putSharedPreference(this, "gender", "男");
                }else {
                    MyApp.putSharedPreference(this, "gender", "女");
                }
                finish();

        }
    }
}
