package com.example.YunleHui.ui.act.actme.actorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseAct;

import butterknife.BindView;


/**
 *
 * 商家已拒绝
 *
 * */

public class Actfail extends BaseAct {



    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    private String mark;



    @BindView(R.id.text_Reason)
    TextView text_Reason;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this,clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_actfail;
    }

    @Override
    protected void findViews() {

        if (toolbar_all!=null){
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("退款详情");
        }

    }

    @Override
    public void initData() {

        Intent intent  = getIntent();

        mark = intent.getStringExtra("mark");

        text_Reason.setText(mark);

    }
}
