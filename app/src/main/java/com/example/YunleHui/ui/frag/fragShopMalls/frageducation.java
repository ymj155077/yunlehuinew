package com.example.YunleHui.ui.frag.fragShopMalls;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseFrag;

/**
 * Created by admin on 2019/8/13 0013.
 *
 * 教育
 *
 */

public class frageducation extends BaseFrag {
    @Override
    protected int getLayoutId() {
       return R.layout.frageducation;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void startActivity(Class<?> clz) {
startActivity(new Intent(getActivity(),clz));
    }
}
