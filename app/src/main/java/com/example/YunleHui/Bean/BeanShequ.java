package com.example.YunleHui.Bean;

import java.io.Serializable;
import java.util.List;

public class BeanShequ implements Serializable {


    /**
     * orderDetailList : [{"id":7,"orderId":4,"goodsId":1,"goodsName":"【进口】熟冻波士顿龙虾","price":9900,"num":1,"specifications":"件","totalMoney":9900,"goodsDetail":null,"logoUrl":"https://file.aicenyi.com/icon38e49cac-f5c2-4642-9335-a63ca222e4461549164317511.jpg"},{"id":8,"orderId":4,"goodsId":2,"goodsName":"泸州老窖52度品藏酒","price":13000,"num":2,"specifications":"件","totalMoney":26000,"goodsDetail":null,"logoUrl":"https://file.aicenyi.com/icon38e49cac-f5c2-4642-9335-a63ca222e4461549164317511.jpg"}]
     * orderNature : 1
     * shopId : 1
     * shopName : 重庆艾成艺自营店
     * totalMoney : 35900
     * orderNum : 908310113180004
     * createTime : 2019-08-30T01:13:00.000+0000
     * totalNum : 3
     * deliveryRecord : 0
     * receiveWay : 3
     * refundState : -1
     */

    private int orderNature;
    private int shopId;
    private String shopName;
    private int totalMoney;
    private String orderNum;
    private String createTime;
    private int totalNum;
    private int deliveryRecord;
    private int receiveWay;
    private int refundState;
    private List<OrderDetailListBean> orderDetailList;

    public int getOrderNature() {
        return orderNature;
    }

    public void setOrderNature(int orderNature) {
        this.orderNature = orderNature;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getDeliveryRecord() {
        return deliveryRecord;
    }

    public void setDeliveryRecord(int deliveryRecord) {
        this.deliveryRecord = deliveryRecord;
    }

    public int getReceiveWay() {
        return receiveWay;
    }

    public void setReceiveWay(int receiveWay) {
        this.receiveWay = receiveWay;
    }

    public int getRefundState() {
        return refundState;
    }

    public void setRefundState(int refundState) {
        this.refundState = refundState;
    }

    public List<OrderDetailListBean> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetailListBean> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public static class OrderDetailListBean implements Serializable{
        /**
         * id : 7
         * orderId : 4
         * goodsId : 1
         * goodsName : 【进口】熟冻波士顿龙虾
         * price : 9900
         * num : 1
         * specifications : 件
         * totalMoney : 9900
         * goodsDetail : null
         * logoUrl : https://file.aicenyi.com/icon38e49cac-f5c2-4642-9335-a63ca222e4461549164317511.jpg
         */

        private int id;
        private int orderId;
        private int goodsId;
        private String goodsName;
        private int price;
        private int num;
        private String specifications;
        private int totalMoney;
        private Object goodsDetail;
        private String logoUrl;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
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

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getSpecifications() {
            return specifications;
        }

        public void setSpecifications(String specifications) {
            this.specifications = specifications;
        }

        public int getTotalMoney() {
            return totalMoney;
        }

        public void setTotalMoney(int totalMoney) {
            this.totalMoney = totalMoney;
        }

        public Object getGoodsDetail() {
            return goodsDetail;
        }

        public void setGoodsDetail(Object goodsDetail) {
            this.goodsDetail = goodsDetail;
        }

        public String getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
        }
    }
}
