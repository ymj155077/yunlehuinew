package com.example.YunleHui.ui.act.ActComPur;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseAct;

import butterknife.BindView;

public class ActHregistra extends BaseAct {


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_hregistra;
    }

    @Override
    protected void findViews() {
        if (toolbar_all != null) {
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("团长注册");
        }
    }

    @Override
    public void initData() {

    }
}
