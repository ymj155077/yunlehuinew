package com.example.YunleHui.Bean;

import java.util.List;

public class Bean_day {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : {"id":20,"orderNum":"901010232140020","getCode":"914010102320020g","receiveCode":"901020132140020r","customerId":3,"customerName":"郑先生","customerTel":"17318213273","receiveAddress":"红心小区22栋3-3","shopId":4,"shopName":"1+2便利店","communityId":2,"communityName":"紫御江山","receiveWay":3,"deliveryTime":"07:00-08:00","state":2,"totalMoney":350,"payMoney":350,"resultMoney":0,"realMoney":350,"remark":null,"settlementId":1,"orderTime":null,"payTime":1549002738000,"cgetTime":null,"receiveTime":null,"payNum":"901010232140020-0","payRecode":"prepay_id=wx01143202915854a1142248052473688712","orderDetailList":[{"id":34,"orderId":20,"goodsId":283,"goodsName":"康师傅香菇炖鸡面桶装","price":350,"num":1,"specifications":"件","totalMoney":350,"goodsDetail":null,"logoUrl":"https://file.aicenyi.com/icon38e49cac-f5c2-4642-9335-a63ca222e4461549164317511.jpg"}],"shopInfo":null,"communityInfo":null,"payWay":0}
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
         * id : 20
         * orderNum : 901010232140020
         * getCode : 914010102320020g
         * receiveCode : 901020132140020r
         * customerId : 3
         * customerName : 郑先生
         * customerTel : 17318213273
         * receiveAddress : 红心小区22栋3-3
         * shopId : 4
         * shopName : 1+2便利店
         * communityId : 2
         * communityName : 紫御江山
         * receiveWay : 3
         * deliveryTime : 07:00-08:00
         * state : 2
         * totalMoney : 350
         * payMoney : 350
         * resultMoney : 0
         * realMoney : 350
         * remark : null
         * settlementId : 1
         * orderTime : null
         * payTime : 1549002738000
         * cgetTime : null
         * receiveTime : null
         * payNum : 901010232140020-0
         * payRecode : prepay_id=wx01143202915854a1142248052473688712
         * orderDetailList : [{"id":34,"orderId":20,"goodsId":283,"goodsName":"康师傅香菇炖鸡面桶装","price":350,"num":1,"specifications":"件","totalMoney":350,"goodsDetail":null,"logoUrl":"https://file.aicenyi.com/icon38e49cac-f5c2-4642-9335-a63ca222e4461549164317511.jpg"}]
         * shopInfo : null
         * communityInfo : null
         * payWay : 0
         */

        private int id;
        private String orderNum;
        private String getCode;
        private String receiveCode;
        private int customerId;
        private String customerName;
        private String customerTel;
        private String receiveAddress;
        private int shopId;
        private String shopName;
        private int communityId;
        private String communityName;
        private int receiveWay;
        private String deliveryTime;
        private int state;
        private int totalMoney;
        private int payMoney;
        private int resultMoney;
        private int realMoney;
        private String remark;
        private int settlementId;
        private Object orderTime;
        private long payTime;
        private Object cgetTime;
        private Object receiveTime;
        private String payNum;
        private String payRecode;
        private Object shopInfo;
        private Object communityInfo;
        private int payWay;
        private List<OrderDetailListBean> orderDetailList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOrderNum() {
            return orderNum;
        }

        public void setOrderNum(String orderNum) {
            this.orderNum = orderNum;
        }

        public String getGetCode() {
            return getCode;
        }

        public void setGetCode(String getCode) {
            this.getCode = getCode;
        }

        public String getReceiveCode() {
            return receiveCode;
        }

        public void setReceiveCode(String receiveCode) {
            this.receiveCode = receiveCode;
        }

        public int getCustomerId() {
            return customerId;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getCustomerTel() {
            return customerTel;
        }

        public void setCustomerTel(String customerTel) {
            this.customerTel = customerTel;
        }

        public String getReceiveAddress() {
            return receiveAddress;
        }

        public void setReceiveAddress(String receiveAddress) {
            this.receiveAddress = receiveAddress;
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

        public int getCommunityId() {
            return communityId;
        }

        public void setCommunityId(int communityId) {
            this.communityId = communityId;
        }

        public String getCommunityName() {
            return communityName;
        }

        public void setCommunityName(String communityName) {
            this.communityName = communityName;
        }

        public int getReceiveWay() {
            return receiveWay;
        }

        public void setReceiveWay(int receiveWay) {
            this.receiveWay = receiveWay;
        }

        public String getDeliveryTime() {
            return deliveryTime;
        }

        public void setDeliveryTime(String deliveryTime) {
            this.deliveryTime = deliveryTime;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getTotalMoney() {
            return totalMoney;
        }

        public void setTotalMoney(int totalMoney) {
            this.totalMoney = totalMoney;
        }

        public int getPayMoney() {
            return payMoney;
        }

        public void setPayMoney(int payMoney) {
            this.payMoney = payMoney;
        }

        public int getResultMoney() {
            return resultMoney;
        }

        public void setResultMoney(int resultMoney) {
            this.resultMoney = resultMoney;
        }

        public int getRealMoney() {
            return realMoney;
        }

        public void setRealMoney(int realMoney) {
            this.realMoney = realMoney;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getSettlementId() {
            return settlementId;
        }

        public void setSettlementId(int settlementId) {
            this.settlementId = settlementId;
        }

        public Object getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(Object orderTime) {
            this.orderTime = orderTime;
        }

        public long getPayTime() {
            return payTime;
        }

        public void setPayTime(long payTime) {
            this.payTime = payTime;
        }

        public Object getCgetTime() {
            return cgetTime;
        }

        public void setCgetTime(Object cgetTime) {
            this.cgetTime = cgetTime;
        }

        public Object getReceiveTime() {
            return receiveTime;
        }

        public void setReceiveTime(Object receiveTime) {
            this.receiveTime = receiveTime;
        }

        public String getPayNum() {
            return payNum;
        }

        public void setPayNum(String payNum) {
            this.payNum = payNum;
        }

        public String getPayRecode() {
            return payRecode;
        }

        public void setPayRecode(String payRecode) {
            this.payRecode = payRecode;
        }

        public Object getShopInfo() {
            return shopInfo;
        }

        public void setShopInfo(Object shopInfo) {
            this.shopInfo = shopInfo;
        }

        public Object getCommunityInfo() {
            return communityInfo;
        }

        public void setCommunityInfo(Object communityInfo) {
            this.communityInfo = communityInfo;
        }

        public int getPayWay() {
            return payWay;
        }

        public void setPayWay(int payWay) {
            this.payWay = payWay;
        }

        public List<OrderDetailListBean> getOrderDetailList() {
            return orderDetailList;
        }

        public void setOrderDetailList(List<OrderDetailListBean> orderDetailList) {
            this.orderDetailList = orderDetailList;
        }

        public static class OrderDetailListBean {
            /**
             * id : 34
             * orderId : 20
             * goodsId : 283
             * goodsName : 康师傅香菇炖鸡面桶装
             * price : 350
             * num : 1
             * specifications : 件
             * totalMoney : 350
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
}
