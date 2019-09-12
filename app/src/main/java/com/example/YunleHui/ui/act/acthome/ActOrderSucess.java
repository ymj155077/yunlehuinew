package com.example.YunleHui.ui.act.acthome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseAct;

import butterknife.BindView;


//订单支付完成

public class ActOrderSucess extends BaseAct {





    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this,clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_order_sucess;
    }

    @Override
    protected void findViews() {

    }

    @Override
    public void initData() {

    }
}
