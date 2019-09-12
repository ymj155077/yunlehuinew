package com.example.YunleHui.ui.act.actme;

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

//银行卡添加成功

public class ActAddSucess extends BaseAct {


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    @BindView(R.id.text_click)
    TextView text_click;

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_add_sucess;
    }

    @Override
    protected void findViews() {

        if (toolbar_all != null) {
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("银行卡");
        }

    }

    @Override
    public void initData() {


    }

    @OnClick({R.id.text_click})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.text_click:

                finish();

                break;
        }
    }
}
