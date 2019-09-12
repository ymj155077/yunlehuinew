package com.example.YunleHui.view.cityList;



/**
 * 介绍：美团里的城市bean
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 2016/11/28.
 */

public class MeiTuanBean extends BaseIndexPinyinBean {
    private String city;//城市名字

    private int id;

    private String remark;


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MeiTuanBean() {
    }

    public MeiTuanBean(int id,String city,String remark) {
     this.id = id;
        this.city = city;

        this.remark = remark;

    }

    public String getCity() {
        return city;
    }

    public MeiTuanBean setCity(String city) {
        this.city = city;
        return this;
    }

    @Override
    public String getTarget() {
        return city;
    }
}
