package com.example.YunleHui.ui.act.actme;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseAct;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *
 * 达人的界面
 *
 * */

public class ActDaren extends BaseAct{

    @BindView(R.id.lin_finsh)
    LinearLayout lin_finsh;

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this,clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_daren2;
    }

    @Override
    protected void findViews() {

    }

    @Override
    public void initData() {

    }






    @OnClick({R.id.lin_finsh})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.lin_finsh:
                finish();
                break;
        }
    }







}
