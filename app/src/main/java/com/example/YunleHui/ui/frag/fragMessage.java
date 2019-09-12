package com.example.YunleHui.ui.frag;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.YunleHui.MainActivity;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseFrag;
import com.example.YunleHui.ui.act.actme.ActMyOrder;
import com.example.YunleHui.utils.CommonUtils;
import com.example.YunleHui.utils.FragmentFactory;
import com.example.YunleHui.view.tabpagerindictor.TabPageIndicator;
import com.hyphenate.EMCallBack;
import com.hyphenate.EMConnectionListener;
import com.hyphenate.EMError;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.hyphenate.util.NetUtils;

import butterknife.BindView;

public class fragMessage extends BaseFrag {





    private TabPageIndicator indicator;
    private ViewPager viewPager;






    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(getActivity(),clz));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_message;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        indicator = (TabPageIndicator)view.findViewById(R.id.indicator);
        viewPager = (ViewPager)view.findViewById(R.id.viewPager);
    }

    @Override
    protected void initData() {





        BasePagerAdapter adapter = new BasePagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(4);
//        viewPager.setCurrentItem(type);
        indicator.setViewPager(viewPager);
        setTabPagerIndicator();
    }


    static class BasePagerAdapter extends FragmentPagerAdapter {
        String[] titles = new String[]{"通知", "聊天", "好友"};


        public BasePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return FragmentFactory.createChat(position);
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }



    private void setTabPagerIndicator() {
        // 设置模式，一定要先设置模式
//        indicator.setIndicatorMode(TabPageIndicator.IndicatorMode.MODE_NOWEIGHT_EXPAND_SAME);
        indicator.setIndicatorMode(TabPageIndicator.IndicatorMode.MODE_WEIGHT_NOEXPAND_SAME);
//设置分割线高度
        indicator.setIndicatorHeight(8);
//  设置右侧 颜色
//        indicator.setDividerColor(Color.parseColor("#f2f2f2"));// 设置分割线的颜色
        indicator.setDividerPadding(CommonUtils.dip2px(MyApp.getContextObject(), 10));
        indicator.setIndicatorColor(Color.parseColor("#FFFFFF"));// 设置底部导航线的颜色 f2f2f2

        indicator.setTextColorSelected(Color.parseColor("#FFFFFF"));// 设置tab标题选中的颜色
//        indicator.setTextColorSelected(Color.parseColor("#606368"));// 设置tab标题选中的颜色
        indicator.setTextColor(Color.parseColor("#FFFFFF"));// 设置tab标题未被选中的颜色
        indicator.setTextSize(CommonUtils.sp2px(MyApp.getContextObject(), 17));// 设置字体大小
//设置最下面一条的横线的颜色
        indicator.setUnderlineColor(Color.parseColor("#FF6551"));



    }

}
