package com.example.YunleHui.ui.act.actme.actbusiness;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.act.actme.ActMyOrder;
import com.example.YunleHui.utils.CommonUtils;
import com.example.YunleHui.utils.FragmentFactory;
import com.example.YunleHui.view.tabpagerindictor.TabPageIndicator;

import butterknife.BindView;


//核销商户

public class ActWriteMerchants extends BaseAct {

    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_write_merchants;
    }

    @Override
    protected void findViews() {
        if (toolbar_all != null) {
            TextView text_center = toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("核销商户");


            ImageView toolbar_right_img = (ImageView) toolbar_all.findViewById(R.id.toolbar_right_img);
            toolbar_right_img.setImageResource(R.drawable.jiahao);
            toolbar_right_img.setVisibility(View.VISIBLE);

            toolbar_right_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(ActBusSearch.class);
                }
            });
        }
    }

    @BindView(R.id.indicator)
    TabPageIndicator indicator;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @Override
    public void initData() {
        BasePagerAdapter adapter = new BasePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);
        indicator.setViewPager(viewPager);
        setTabPagerIndicator();
    }


    static class BasePagerAdapter extends FragmentPagerAdapter {
        String[] titles = new String[]{"已添加", "待验证"};


        public BasePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return FragmentFactory.createWriteoff(position);
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
        indicator.setIndicatorMode(TabPageIndicator.IndicatorMode.MODE_NOWEIGHT_EXPAND_SAME);
//设置分割线高度
        indicator.setIndicatorHeight(6);
//  设置右侧 颜色
//        indicator.setDividerColor(Color.parseColor("#f2f2f2"));// 设置分割线的颜色
        indicator.setDividerPadding(CommonUtils.dip2px(MyApp.getContextObject(), 10));
        indicator.setIndicatorColor(Color.parseColor("#FF6C4B"));// 设置底部导航线的颜色 f2f2f2

        indicator.setTextColorSelected(Color.parseColor("#FF6C4B"));// 设置tab标题选中的颜色
//        indicator.setTextColorSelected(Color.parseColor("#606368"));// 设置tab标题选中的颜色
        indicator.setTextColor(Color.parseColor("#333333"));// 设置tab标题未被选中的颜色
        indicator.setTextSize(CommonUtils.sp2px(MyApp.getContextObject(), 17));// 设置字体大小
//设置最下面一条的横线的颜色
        indicator.setUnderlineColor(Color.parseColor("#f2f2f2"));


    }


}
