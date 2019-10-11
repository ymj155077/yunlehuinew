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
import android.widget.TextView;

import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.base.MyPagerAdapter;
import com.example.YunleHui.ui.act.actme.ActMyOrder;
import com.example.YunleHui.ui.frag.fragorder.fragToevaluated;
import com.example.YunleHui.ui.frag.fragorder.fragToused;
import com.example.YunleHui.ui.frag.fragorder.fragUsed;
import com.example.YunleHui.ui.frag.fragorder.fragnoTused;
import com.example.YunleHui.ui.frag.fragorder.fragrefund;
import com.example.YunleHui.ui.frag.fragshop.fragCompleted;
import com.example.YunleHui.ui.frag.fragshop.fragConsumed;
import com.example.YunleHui.ui.frag.fragshop.fragHavede;
import com.example.YunleHui.ui.frag.fragshop.fragRem;
import com.example.YunleHui.ui.frag.fragshop.fragUnorders;
import com.example.YunleHui.utils.CommonUtils;
import com.example.YunleHui.utils.FragmentFactory;
import com.example.YunleHui.view.MTabLayout.SlidingTabLayout;
import com.example.YunleHui.view.MTabLayout.ViewFindUtils;
import com.example.YunleHui.view.tabpagerindictor.TabPageIndicator;

import java.util.ArrayList;

import butterknife.BindView;

public class ActOrManaGe extends BaseAct {

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
        return R.layout.activity_act_or_mana_ge;
    }

    @Override
    protected void findViews() {

        if (toolbar_all!=null){
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("订单管理");
        }

        View decorView = getWindow().getDecorView();
        vp = ViewFindUtils.find(decorView, R.id.vp);

        /** indicator矩形圆角 */
        tabLayout = ViewFindUtils.find(decorView, R.id.tl_7);

    }


    private ArrayList<Fragment> mFragments = new ArrayList<>();

    private final String[] mTitles = {"已支付", "代配送", "已配送", "已完成", "退款管理"};



    @Override
    public void initData() {

        Intent intent = getIntent();
        type = intent.getIntExtra("type",0);
        mFragments.add(new fragConsumed());
        mFragments.add(new fragUnorders());
        mFragments.add(new fragHavede());
        mFragments.add(new fragCompleted());
        mFragments.add(new fragRem());

        mAdapter = new MyPagerAdapter(getSupportFragmentManager(),mFragments,mTitles);
        vp.setAdapter(mAdapter);
        vp.setOffscreenPageLimit(4);
        tabLayout.setViewPager(vp, mTitles);
        tabLayout.setCurrentTab(type);
        vp.setCurrentItem(type);

    }











































}
