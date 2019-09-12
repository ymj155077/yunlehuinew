package com.example.YunleHui.ui.frag.fragmessage;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseFrag;

/**
 *
 *
 * 聊天
 *
 * */


public class fragchat extends BaseFrag {


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(getActivity(),clz));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_chat;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }
}
