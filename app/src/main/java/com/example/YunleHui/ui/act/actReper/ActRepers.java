package com.example.YunleHui.ui.act.actReper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.utils.Tools;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 达人注册
 */

public class ActRepers extends BaseAct {

    @BindView(R.id.text_register)
    TextView text_register;


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_repers;
    }

    @Override
    protected void findViews() {
        if (toolbar_all != null) {
            TextView text_center = toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("达人注册");
        }
    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.text_register})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.text_register:
                View views = Tools.setRebuildPop(this, R.layout.pop_dare, R.layout.activity_act_repers);
                TextView text_as = (TextView) views.findViewById(R.id.text_as);
                text_as.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Tools.mBottomSheetPop.dismiss();
                        finish();

                    }
                });
                break;
        }
    }


}
