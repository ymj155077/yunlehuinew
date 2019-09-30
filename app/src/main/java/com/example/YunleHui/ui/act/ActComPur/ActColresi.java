package com.example.YunleHui.ui.act.ActComPur;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseAct;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 代理入住
 */

public class ActColresi extends BaseAct {

    @BindView(R.id.text_colresi)
    TextView text_colresi;


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_colresi;
    }

    @Override
    protected void findViews() {

        if (toolbar_all != null) {
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("代理入住");
        }

    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.text_colresi})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.text_colresi:
//团长注册
                startActivity(ActHregistra.class);
                break;
        }
    }
}
