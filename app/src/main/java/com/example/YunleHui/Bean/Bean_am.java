package com.example.YunleHui.Bean;

public class Bean_am {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : {"id":1776,"customerId":2,"shopId":1,"goodsId":956,"buyNum":0,"goodsName":"四川腊肉500g±20g","price":1880,"addTime":"2019-09-19T13:14:31.000+0000","updateTime":"2019-09-19T13:15:26.000+0000","totalPrice":1880,"resultPrice":0,"specifications":"件"}
     */

    private boolean success;
    private int code;
    private String msg;
    private DataBean data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1776
         * customerId : 2
         * shopId : 1
         * goodsId : 956
         * buyNum : 0
         * goodsName : 四川腊肉500g±20g
         * price : 1880
         * addTime : 2019-09-19T13:14:31.000+0000
         * updateTime : 2019-09-19T13:15:26.000+0000
         * totalPrice : 1880
         * resultPrice : 0
         * specifications : 件
         */

        private int id;
        private int customerId;
        private int shopId;
        private int goodsId;
        private int buyNum;
        private String goodsName;
        private int price;
        private String addTime;
        private String updateTime;
        private int totalPrice;
        private int resultPrice;
        private String specifications;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCustomerId() {
            return customerId;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }

        public int getBuyNum() {
            return buyNum;
        }

        public void setBuyNum(int buyNum) {
            this.buyNum = buyNum;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getAddTime() {
            return addTime;
        }

        public void setAddTime(String addTime) {
            this.addTime = addTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public int getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(int totalPrice) {
            this.totalPrice = totalPrice;
        }

        public int getResultPrice() {
            return resultPrice;
        }

        public void setResultPrice(int resultPrice) {
            this.resultPrice = resultPrice;
        }

        public String getSpecifications() {
            return specifications;
        }

        public void setSpecifications(String specifications) {
            this.specifications = specifications;
        }
    }
}
