package com.example.YunleHui.ui.act.ActComPur;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseAct;

import butterknife.BindView;
import butterknife.OnClick;

public class ActNearMer extends BaseAct {


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    @BindView(R.id.lin_shop_center)
    LinearLayout lin_shop_center;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_near_mer;
    }

    @Override
    protected void findViews() {

        TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
        text_center.setText("附近商铺");

    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.lin_shop_center})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.lin_shop_center:

                startActivity(ActShopCenter.class);

                break;
        }
    }


}
