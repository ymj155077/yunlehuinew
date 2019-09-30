package com.example.YunleHui.Bean;


/**
 * 两个list
 */
public class BeanTwo_list {


    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BeanTwo_list(int orderNature, String orderDetail, String shopName, int receiveWay, String orderNum, int totalMoney, int totalNum, String value,int isComment) {

        this.orderDetail = orderDetail;
        this.orderNature = orderNature;
        this.shopName = shopName;
        this.receiveWay = receiveWay;
        this.orderNum = orderNum;
        this.totalMoney = totalMoney;
this.totalNum = totalNum;
this.value = value;
this.isComment = isComment;

    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    private String orderNum;

    private int totalMoney;

    private String shopName;

    private int orderNature;

    private int totalNum;

    private String value;

    public int getIsComment() {
        return isComment;
    }

    public void setIsComment(int isComment) {
        this.isComment = isComment;
    }

    private int isComment;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    private String orderDetail;

    private int receiveWay;

    public int getReceiveWay() {
        return receiveWay;
    }

    public void setReceiveWay(int receiveWay) {
        this.receiveWay = receiveWay;
    }

    public int getOrderNature() {
        return orderNature;
    }

    public void setOrderNature(int orderNature) {
        this.orderNature = orderNature;
    }

    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }
}
