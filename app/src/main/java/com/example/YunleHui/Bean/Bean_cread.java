package com.example.YunleHui.Bean;

import java.util.List;

/**
 * Created by admin on 2019/8/16 0016.
 */

public class Bean_cread {


    /**
     * channel : 0
     * count : 0
     * discountResultIdList : [0]
     * goodsId : 0
     * goodsSetId : 0
     * remark : string
     * tel : string
     * userId : 0
     */

    private int channel;
    private int count;
    private int goodsId;
    private int goodsSetId;
    private String remark;
    private String tel;
    private int userId;
    private List<Integer> discountResultIdList;

    public Bean_cread(int channel, int count, int goodsId, int goodsSetId, String remark, String tel, int userId, List<Integer> discountResultIdList) {
        this.channel = channel;
        this.count = count;
        this.goodsId = goodsId;
        this.goodsSetId = goodsSetId;
        this.remark = remark;
        this.tel = tel;
        this.userId = userId;
        this.discountResultIdList = discountResultIdList;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getGoodsSetId() {
        return goodsSetId;
    }

    public void setGoodsSetId(int goodsSetId) {
        this.goodsSetId = goodsSetId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Integer> getDiscountResultIdList() {
        return discountResultIdList;
    }

    public void setDiscountResultIdList(List<Integer> discountResultIdList) {
        this.discountResultIdList = discountResultIdList;
    }
}
