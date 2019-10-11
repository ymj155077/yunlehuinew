package com.example.YunleHui.ui.frag.fragshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseFrag;
import com.example.YunleHui.view.MyXrecycleview;

import butterknife.BindView;



/**
 *
 *
 * 已配送
 *
 *
 * */

public class fragHavede extends BaseFrag {



    @BindView(R.id.have_xrecyc)
    MyXrecycleview have_xrecyc;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(getActivity(),clz));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_havede;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }





}
