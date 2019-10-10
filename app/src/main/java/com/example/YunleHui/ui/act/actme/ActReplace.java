package com.example.YunleHui.ui.act.actme;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.YunleHui.Bean.Bean_hj;
import com.example.YunleHui.Bean.Bean_re;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.view.ClearEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.YunleHui.ui.act.actme.ActBinding.actBinding;
import static com.example.YunleHui.ui.act.actme.ActRetrieve.actRetrieve;


/**
 * 更换手机
 */


public class ActReplace extends BaseAct {


    @BindView(R.id.edit_phone)
    ClearEditText editPhone;
    @BindView(R.id.edit_code)
    ClearEditText editCode;
    @BindView(R.id.text_yan)
    TextView textYan;
    @BindView(R.id.text_binding)
    TextView textBinding;
    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_replace;
    }

    @Override
    protected void findViews() {

        if (toolbar_all != null) {
            TextView textCenter = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            textCenter.setText("更换手机");
        }
    }


    private String phone = "";


    @Override
    public void initData() {

        time = new TimeCount(60000, 1000);
//        phone = (String) MyApp.getSharedPreference(this, "phone", "");

    }


    private TimeCount time;


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (time != null) {
            time.cancel();
        }
    }


    @OnClick({R.id.text_yan, R.id.text_binding})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.text_yan:
                textYan.setClickable(false);
                time.start();
                HttpUtil.addMapparams();
                HttpUtil.params.put("phone", editPhone.getText().toString().trim());
                HttpUtil.Post_request("user/login/smsCode", HttpUtil.params);
                getdata("user/login/smsCode");
                break;
            case R.id.text_binding:
                HttpUtil.addMapparams();
                HttpUtil.params.put("phone", editPhone.getText().toString().trim());
                HttpUtil.params.put("SmsCode", editCode.getText().toString().trim());
                HttpUtil.Post_request("user/updatePhoneNumber", HttpUtil.params);
                getdata("user/updatePhoneNumber");
                break;
        }
    }

    @Override
    public void stringResulit(String key, String value) {
        try {
            if (key.equals("user/login/smsCode")) {
                Toast.makeText(this, "发送成功", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {

        }
//修改手机号
        if (key.equals("user/updatePhoneNumber")) {
            bean_hj = MyApp.gson.fromJson(value, Bean_hj.class);
            code_hj = bean_hj.getCode();
            msg_hj = bean_hj.getMsg();
            if (code_hj == 200) {

                String phone = bean_hj.getData().getPhone();

                MyApp.putSharedPreference(this, "phone", phone);

                actBinding.finish();
                actRetrieve.finish();
                finish();
            }else {
                Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
            }
        }
    }




    private Bean_hj bean_hj;
    private int code_hj;
    private String msg_hj;
    private Bean_hj.DataBean data_hj;









    private Bean_re bean_re;
    private boolean success;
    private int code;
    private String msg;
    private Object data;

    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            textYan.setClickable(false);
            textYan.setText("(" + millisUntilFinished / 1000 + ") 秒");
        }

        @Override
        public void onFinish() {
            textYan.setText("重新获取");
            textYan.setClickable(true);
        }

    }


}
