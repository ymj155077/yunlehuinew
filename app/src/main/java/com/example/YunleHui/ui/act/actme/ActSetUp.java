package com.example.YunleHui.ui.act.actme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 设置
 */

public class ActSetUp extends BaseAct {


    @BindView(R.id.lin_about)
    LinearLayout lin_about;

    @BindView(R.id.lin_Safety_Center)
    LinearLayout lin_Safety_Center;


    @BindView(R.id.lin_out)
    LinearLayout lin_out;


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    @BindView(R.id.lin_call)
    LinearLayout lin_call;



    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_set_up2;
    }

    @Override
    protected void findViews() {

        if (toolbar_all!=null){
            TextView textView = toolbar_all.findViewById(R.id.toolbar_center);
            textView.setText("设置");
        }

    }

    @Override
    public void initData() {

    }

    @OnClick({
            R.id.lin_about, R.id.lin_Safety_Center,
            R.id.lin_out,R.id.lin_call
    })
    public void OnClick(View view) {
        switch (view.getId()) {
//          关于云享优汇
            case R.id.lin_about:

                startActivity(ActEdition.class);

                break;

//                安全中心
            case R.id.lin_Safety_Center:

                startActivity(ActSafetyCenter.class);

                break;

            case R.id.lin_call:

                startActivity(ActCusService.class);

                break;

            case R.id.lin_out:

                MyApp.user = 0;

                MyApp.putSharedPreference(this, "user", 0);
                MyApp.putSharedPreference(this, "access_token", "");
                MyApp.putSharedPreference(this, "nickName", "");
                MyApp.putSharedPreference(this, "userType", 0);

                startActivity(ActLogin.class);
                finish();
                break;

        }
    }


}
