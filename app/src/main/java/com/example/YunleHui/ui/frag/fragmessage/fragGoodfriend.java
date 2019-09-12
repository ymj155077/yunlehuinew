package com.example.YunleHui.ui.frag.fragmessage;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseFrag;

/**
 *
 *
 * 好友
 *
 *
 * */


public class fragGoodfriend extends BaseFrag {
    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(getActivity(),clz));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_goodfriend;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }


}
