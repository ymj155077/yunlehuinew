package com.example.YunleHui.ui.frag.fragshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseFrag;

/**
 * Created by admin on 2019/8/29 0029.
 * <p>
 * 代配送
 */

public class fragUnorders extends BaseFrag {

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(getActivity(), clz));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragunorders;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    public void initData() {

    }
}
