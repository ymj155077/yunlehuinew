package com.example.YunleHui.Bean;

import java.io.Serializable;
import java.util.List;

public class Bean_pur implements Serializable {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : {"id":5,"orderNum":"904310114180005","getCode":"918043101140005g","receiveCode":"904013114180005r","customerId":3,"customerName":"新年","customerTel":"346546343664","receiveAddress":"哦很厚狐狸精","shopId":1,"shopName":"重庆艾成艺自营店","communityId":2,"communityName":"紫御江山","receiveWay":3,"deliveryTime":"11:00-11:00","state":2,"totalMoney":22900,"payMoney":22900,"resultMoney":0,"realMoney":22900,"remark":null,"settlementId":-1,"orderTime":null,"payTime":null,"cgetTime":null,"receiveTime":null,"payNum":"904310114180005-0","payRecode":"prepay_id=wx31181415363009421f3fa5c22693655572","orderDetailList":[{"id":9,"orderId":5,"goodsId":1,"goodsName":"【进口】熟冻波士顿龙虾","price":9900,"num":1,"specifications":"件","totalMoney":9900,"goodsDetail":null,"logoUrl":"https://file.aicenyi.com/icon38e49cac-f5c2-4642-9335-a63ca222e4461549164317511.jpg"},{"id":10,"orderId":5,"goodsId":2,"goodsName":"泸州老窖52度品藏酒","price":13000,"num":1,"specifications":"件","totalMoney":13000,"goodsDetail":null,"logoUrl":"https://file.aicenyi.com/icon38e49cac-f5c2-4642-9335-a63ca222e4461549164317511.jpg"}],"shopInfo":{"id":1,"shopName":"两路口核销店","shopTel":"18122222222","shopAddress":"两路口地铁站附近","cityId":500000,"districtId":0,"shopLogoUrl":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563536200243&di=e02853590a5836a27ac7df4f95521913&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg","longitude":106.54863,"latitude":29.552567,"userId":3,"typeId":2,"classId":0,"remark":"店铺介绍","crateTime":1563527315000,"state":1,"shopNature":1,"selfShop":0},"communityInfo":null,"payWay":0,"createTime":1567127580000}
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

    public static class DataBean implements Serializable{
        /**
         * id : 5
         * orderNum : 904310114180005
         * getCode : 918043101140005g
         * receiveCode : 904013114180005r
         * customerId : 3
         * customerName : 新年
         * customerTel : 346546343664
         * receiveAddress : 哦很厚狐狸精
         * shopId : 1
         * shopName : 重庆艾成艺自营店
         * communityId : 2
         * communityName : 紫御江山
         * receiveWay : 3
         * deliveryTime : 11:00-11:00
         * state : 2
         * totalMoney : 22900
         * payMoney : 22900
         * resultMoney : 0
         * realMoney : 22900
         * remark : null
         * settlementId : -1
         * orderTime : null
         * payTime : null
         * cgetTime : null
         * receiveTime : null
         * payNum : 904310114180005-0
         * payRecode : prepay_id=wx31181415363009421f3fa5c22693655572
         * orderDetailList : [{"id":9,"orderId":5,"goodsId":1,"goodsName":"【进口】熟冻波士顿龙虾","price":9900,"num":1,"specifications":"件","totalMoney":9900,"goodsDetail":null,"logoUrl":"https://file.aicenyi.com/icon38e49cac-f5c2-4642-9335-a63ca222e4461549164317511.jpg"},{"id":10,"orderId":5,"goodsId":2,"goodsName":"泸州老窖52度品藏酒","price":13000,"num":1,"specifications":"件","totalMoney":13000,"goodsDetail":null,"logoUrl":"https://file.aicenyi.com/icon38e49cac-f5c2-4642-9335-a63ca222e4461549164317511.jpg"}]
         * shopInfo : {"id":1,"shopName":"两路口核销店","shopTel":"18122222222","shopAddress":"两路口地铁站附近","cityId":500000,"districtId":0,"shopLogoUrl":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563536200243&di=e02853590a5836a27ac7df4f95521913&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg","longitude":106.54863,"latitude":29.552567,"userId":3,"typeId":2,"classId":0,"remark":"店铺介绍","crateTime":1563527315000,"state":1,"shopNature":1,"selfShop":0}
         * communityInfo : null
         * payWay : 0
         * createTime : 1567127580000
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
        private String payTime;
        private Object cgetTime;
        private Object receiveTime;
        private String payNum;
        private String payRecode;
        private ShopInfoBean shopInfo;
        private Object communityInfo;
        private int payWay;
        private long createTime;
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

        public String getPayTime() {
            return payTime;
        }

        public void setPayTime(String payTime) {
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

        public ShopInfoBean getShopInfo() {
            return shopInfo;
        }

        public void setShopInfo(ShopInfoBean shopInfo) {
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

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public List<OrderDetailListBean> getOrderDetailList() {
            return orderDetailList;
        }

        public void setOrderDetailList(List<OrderDetailListBean> orderDetailList) {
            this.orderDetailList = orderDetailList;
        }

        public static class ShopInfoBean {
            /**
             * id : 1
             * shopName : 两路口核销店
             * shopTel : 18122222222
             * shopAddress : 两路口地铁站附近
             * cityId : 500000
             * districtId : 0
             * shopLogoUrl : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563536200243&di=e02853590a5836a27ac7df4f95521913&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg
             * longitude : 106.54863
             * latitude : 29.552567
             * userId : 3
             * typeId : 2
             * classId : 0
             * remark : 店铺介绍
             * crateTime : 1563527315000
             * state : 1
             * shopNature : 1
             * selfShop : 0
             */

            private int id;
            private String shopName;
            private String shopTel;
            private String shopAddress;
            private int cityId;
            private int districtId;
            private String shopLogoUrl;
            private double longitude;
            private double latitude;
            private int userId;
            private int typeId;
            private int classId;
            private String remark;
            private long crateTime;
            private int state;
            private int shopNature;
            private int selfShop;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }

            public String getShopTel() {
                return shopTel;
            }

            public void setShopTel(String shopTel) {
                this.shopTel = shopTel;
            }

            public String getShopAddress() {
                return shopAddress;
            }

            public void setShopAddress(String shopAddress) {
                this.shopAddress = shopAddress;
            }

            public int getCityId() {
                return cityId;
            }

            public void setCityId(int cityId) {
                this.cityId = cityId;
            }

            public int getDistrictId() {
                return districtId;
            }

            public void setDistrictId(int districtId) {
                this.districtId = districtId;
            }

            public String getShopLogoUrl() {
                return shopLogoUrl;
            }

            public void setShopLogoUrl(String shopLogoUrl) {
                this.shopLogoUrl = shopLogoUrl;
            }

            public double getLongitude() {
                return longitude;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }

            public double getLatitude() {
                return latitude;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getTypeId() {
                return typeId;
            }

            public void setTypeId(int typeId) {
                this.typeId = typeId;
            }

            public int getClassId() {
                return classId;
            }

            public void setClassId(int classId) {
                this.classId = classId;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public long getCrateTime() {
                return crateTime;
            }

            public void setCrateTime(long crateTime) {
                this.crateTime = crateTime;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public int getShopNature() {
                return shopNature;
            }

            public void setShopNature(int shopNature) {
                this.shopNature = shopNature;
            }

            public int getSelfShop() {
                return selfShop;
            }

            public void setSelfShop(int selfShop) {
                this.selfShop = selfShop;
            }
        }

        public static class OrderDetailListBean implements Serializable{
            /**
             * id : 9
             * orderId : 5
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
}
