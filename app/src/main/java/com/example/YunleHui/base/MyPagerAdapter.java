package com.example.YunleHui.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MyPagerAdapter extends FragmentPagerAdapter {


    private List<Fragment> mFragments;
    private String[] mTitles;


    public MyPagerAdapter(FragmentManager fm,List<Fragment> mFragments,String[] mTitles) {
        super(fm);

        this.mTitles = mTitles;

        this.mFragments = mFragments;


    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }
}

