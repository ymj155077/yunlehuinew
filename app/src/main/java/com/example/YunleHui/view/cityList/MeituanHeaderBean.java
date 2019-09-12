package com.example.YunleHui.view.cityList;

import com.example.YunleHui.Bean.Bean_cityList;

import java.util.ArrayList;
import java.util.List;

/**
 * 介绍：美团城市列表 HeaderView Bean
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 2016/11/28.
 */

public class MeituanHeaderBean extends BaseIndexPinyinBean {
    private ArrayList<Bean_cityList.DataBean> cityList;
    //悬停ItemDecoration显示的Tag
    private String suspensionTag;

    public MeituanHeaderBean() {
    }

    public MeituanHeaderBean(ArrayList<Bean_cityList.DataBean> cityList, String suspensionTag, String indexBarTag) {
        this.cityList = cityList;
        this.suspensionTag = suspensionTag;
        this.setBaseIndexTag(indexBarTag);
    }

    public ArrayList<Bean_cityList.DataBean> getCityList() {
        return cityList;
    }

    public MeituanHeaderBean setCityList(ArrayList<Bean_cityList.DataBean> cityList) {
        this.cityList = cityList;
        return this;
    }

    public MeituanHeaderBean setSuspensionTag(String suspensionTag) {
        this.suspensionTag = suspensionTag;
        return this;
    }

    @Override
    public String getTarget() {
        return null;
    }

    @Override
    public boolean isNeedToPinyin() {
        return false;
    }

    @Override
    public String getSuspensionTag() {
        return suspensionTag;
    }


}
