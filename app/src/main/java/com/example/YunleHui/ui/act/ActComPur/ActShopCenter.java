package com.example.YunleHui.ui.act.ActComPur;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.act.actme.ActMyOrder;
import com.example.YunleHui.ui.frag.fragExplosive;
import com.example.YunleHui.utils.CommonUtils;
import com.example.YunleHui.utils.FragmentFactory;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.view.tabpagerindictor.TabPageIndicator;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;

import java.util.ArrayList;

import butterknife.BindView;


/**
 * 商铺中心
 */
public class ActShopCenter extends BaseAct {


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;

    @BindView(R.id.banner)
    MZBannerView banner;


    @BindView(R.id.indicator)
    TabPageIndicator indicator;


    @BindView(R.id.viewPager)
    ViewPager viewPager;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_shop_center;
    }

    @Override
    protected void findViews() {

        if (toolbar_all != null) {
            TextView textView = toolbar_all.findViewById(R.id.toolbar_center);
            textView.setText("商家详情");
        }

    }


    @Override
    public void initData() {
        Intent intent = getIntent();


        String shopId = intent.getStringExtra("shopId");

        HttpUtil.getAsynHttp("shopping/toShop?shopId=" + shopId);
        getdata("shopping/toShop");


        ArrayList<String> dada = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            dada.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1567438039958&di=cefcb9c8acd4e1a1269b53dd6a4ba467&imgtype=0&src=http%3A%2F%2Finews.gtimg.com%2Fnewsapp_bt%2F0%2F9640793844%2F1000.jpg");

            dada.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1567438039957&di=13f9f755c0794d4526ea08b6fb10a1e0&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201609%2F16%2F20160916083009_tky83.thumb.700_0.jpeg");
        }


        // 设置数据
        banner.setPages(dada, new MZHolderCreator<fragExplosive.BannerViewHolder>() {
            @Override
            public fragExplosive.BannerViewHolder createViewHolder() {
                return new fragExplosive.BannerViewHolder();
            }
        });

        banner.start();//开始轮播


        BasePagerAdapter adapter = new BasePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(4);

        indicator.setViewPager(viewPager);

        setTabPagerIndicator();


    }


    static class BasePagerAdapter extends FragmentPagerAdapter {
        String[] titles = new String[]{"商品", "商家"};


        public BasePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return FragmentFactory.ShopCenter(position);
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
        indicator.setIndicatorMode(TabPageIndicator.IndicatorMode.MODE_NOWEIGHT_NOEXPAND_NOSAME);
//设置分割线高度
        indicator.setIndicatorHeight(8);
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


    @Override
    public void stringResulit(String key, String value) {


        if (key.equals("shopping/toShop")) {

        }


    }


}


















