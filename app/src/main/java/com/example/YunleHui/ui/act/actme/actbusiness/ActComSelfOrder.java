package com.example.YunleHui.ui.act.actme.actbusiness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseAct;

/**
 *
 * 社区购自提未支付订单
 *
 * */

public class ActComSelfOrder extends BaseAct {


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this,clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_com_self_order;
    }

    @Override
    protected void findViews() {

    }

    @Override
    public void initData() {

    }
}
