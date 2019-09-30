package com.example.YunleHui.ui.act.actme;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.base.MyPagerAdapter;
import com.example.YunleHui.ui.frag.fragShopMall;
import com.example.YunleHui.ui.frag.fragorder.fragToevaluated;
import com.example.YunleHui.ui.frag.fragorder.fragToused;
import com.example.YunleHui.ui.frag.fragorder.fragUsed;
import com.example.YunleHui.ui.frag.fragorder.fragnoTused;
import com.example.YunleHui.ui.frag.fragorder.fragrefund;
import com.example.YunleHui.utils.CommonUtils;
import com.example.YunleHui.utils.FragmentFactory;
import com.example.YunleHui.view.MTabLayout.SlidingTabLayout;
import com.example.YunleHui.view.MTabLayout.ViewFindUtils;
import com.example.YunleHui.view.tabpagerindictor.TabPageIndicator;

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.BindView;

public class ActMyOrder extends BaseAct {

//    private TabPageIndicator indicator;
//    private ViewPager viewPager;
    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;




    private MyPagerAdapter mAdapter;

    private ViewPager vp;

    private int type = 0;

    private SlidingTabLayout tabLayout;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this,clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_my_order;
    }

    @Override
    protected void findViews() {
//        indicator = (TabPageIndicator)findViewById(R.id.indicator);
//        viewPager = (ViewPager)findViewById(R.id.viewPager);

        if (toolbar_all!=null){
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("我的订单");
        }

        View decorView = getWindow().getDecorView();
        vp = ViewFindUtils.find(decorView, R.id.vp);

        /** indicator矩形圆角 */
        tabLayout = ViewFindUtils.find(decorView, R.id.tl_7);

    }

    private ArrayList<Fragment> mFragments = new ArrayList<>();

    private final String[] mTitles = {"代付款", "未使用", "已使用", "待评价", "退款"};

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void initData() {
        Intent intent = getIntent();
        type = intent.getIntExtra("type",0);
        mFragments.add(new fragToused());
        mFragments.add(new fragnoTused());
        mFragments.add(new fragUsed());
        mFragments.add(new fragToevaluated());
        mFragments.add(new fragrefund());
        mAdapter = new MyPagerAdapter(getSupportFragmentManager(),mFragments,mTitles);
        vp.setAdapter(mAdapter);
        vp.setOffscreenPageLimit(4);
        tabLayout.setViewPager(vp, mTitles);
        tabLayout.setCurrentTab(type);
        vp.setCurrentItem(type);
    }
}
