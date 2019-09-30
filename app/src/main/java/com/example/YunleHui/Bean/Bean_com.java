package com.example.YunleHui.Bean;

public class Bean_com {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : {"orderInfo":{"id":246,"orderNum":"905240901210246","getCode":null,"receiveCode":null,"customerId":2,"customerName":"记得记得就","customerTel":"18725621750","receiveAddress":"呵呵呵","shopId":3,"shopName":"达瓦大","communityId":3,"communityName":"中亿阳明山水","receiveWay":4,"deliveryTime":"01:00-06:30","deliveryRecord":0,"state":0,"totalMoney":2200,"payMoney":2200,"resultMoney":0,"realMoney":2200,"remark":"共商大计看","settlementId":-1,"payTime":null,"createTime":1569330065815,"cgetTime":null,"receiveTime":null,"payNum":null,"payRecode":null,"commission":0,"payWay":0,"channel":0}}
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
         * orderInfo : {"id":246,"orderNum":"905240901210246","getCode":null,"receiveCode":null,"customerId":2,"customerName":"记得记得就","customerTel":"18725621750","receiveAddress":"呵呵呵","shopId":3,"shopName":"达瓦大","communityId":3,"communityName":"中亿阳明山水","receiveWay":4,"deliveryTime":"01:00-06:30","deliveryRecord":0,"state":0,"totalMoney":2200,"payMoney":2200,"resultMoney":0,"realMoney":2200,"remark":"共商大计看","settlementId":-1,"payTime":null,"createTime":1569330065815,"cgetTime":null,"receiveTime":null,"payNum":null,"payRecode":null,"commission":0,"payWay":0,"channel":0}
         */

        private OrderInfoBean orderInfo;

        public OrderInfoBean getOrderInfo() {
            return orderInfo;
        }

        public void setOrderInfo(OrderInfoBean orderInfo) {
            this.orderInfo = orderInfo;
        }

        public static class OrderInfoBean {
            /**
             * id : 246
             * orderNum : 905240901210246
             * getCode : null
             * receiveCode : null
             * customerId : 2
             * customerName : 记得记得就
             * customerTel : 18725621750
             * receiveAddress : 呵呵呵
             * shopId : 3
             * shopName : 达瓦大
             * communityId : 3
             * communityName : 中亿阳明山水
             * receiveWay : 4
             * deliveryTime : 01:00-06:30
             * deliveryRecord : 0
             * state : 0
             * totalMoney : 2200
             * payMoney : 2200
             * resultMoney : 0
             * realMoney : 2200
             * remark : 共商大计看
             * settlementId : -1
             * payTime : null
             * createTime : 1569330065815
             * cgetTime : null
             * receiveTime : null
             * payNum : null
             * payRecode : null
             * commission : 0
             * payWay : 0
             * channel : 0
             */

            private int id;
            private String orderNum;
            private Object getCode;
            private Object receiveCode;
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
            private int deliveryRecord;
            private int state;
            private int totalMoney;
            private int payMoney;
            private int resultMoney;
            private int realMoney;
            private String remark;
            private int settlementId;
            private Object payTime;
            private long createTime;
            private Object cgetTime;
            private Object receiveTime;
            private Object payNum;
            private Object payRecode;
            private int commission;
            private int payWay;
            private int channel;

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

            public Object getGetCode() {
                return getCode;
            }

            public void setGetCode(Object getCode) {
                this.getCode = getCode;
            }

            public Object getReceiveCode() {
                return receiveCode;
            }

            public void setReceiveCode(Object receiveCode) {
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

            public int getDeliveryRecord() {
                return deliveryRecord;
            }

            public void setDeliveryRecord(int deliveryRecord) {
                this.deliveryRecord = deliveryRecord;
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

            public Object getPayTime() {
                return payTime;
            }

            public void setPayTime(Object payTime) {
                this.payTime = payTime;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
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

            public Object getPayNum() {
                return payNum;
            }

            public void setPayNum(Object payNum) {
                this.payNum = payNum;
            }

            public Object getPayRecode() {
                return payRecode;
            }

            public void setPayRecode(Object payRecode) {
                this.payRecode = payRecode;
            }

            public int getCommission() {
                return commission;
            }

            public void setCommission(int commission) {
                this.commission = commission;
            }

            public int getPayWay() {
                return payWay;
            }

            public void setPayWay(int payWay) {
                this.payWay = payWay;
            }

            public int getChannel() {
                return channel;
            }

            public void setChannel(int channel) {
                this.channel = channel;
            }
        }
    }
}
