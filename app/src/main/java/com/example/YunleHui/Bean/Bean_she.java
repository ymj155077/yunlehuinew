package com.example.YunleHui.Bean;

import java.util.List;

public class Bean_she {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : {"id":238,"orderNum":"917200957200238","getCode":"920172009570238g","receiveCode":"917092057200238r","customerId":2,"customerName":"杨幂家","customerTel":"18725621750","receiveAddress":"呵呵呵呵呵","shopId":1,"shopName":"两路口核销店","communityId":5,"communityName":"新欧鹏教育城","receiveWay":4,"deliveryTime":"9:00-22:00","state":3,"totalMoney":22760,"payMoney":22760,"resultMoney":0,"realMoney":22760,"remark":"会打电话多久发货","settlementId":-1,"orderTime":null,"payTime":1568960762000,"cgetTime":null,"receiveTime":null,"payNum":null,"payRecode":null,"orderDetailList":[{"id":485,"orderId":238,"goodsId":2,"goodsName":"泸州老窖52度品藏酒2瓶装","price":8800,"num":2,"specifications":"件","totalMoney":17600,"goodsDetail":null,"commission":0,"logoUrl":"https://file.aicenyi.com/iconb296fd82-4e3f-4835-8335-7406b877df3a1548913325138.jpg"},{"id":486,"orderId":238,"goodsId":13,"goodsName":"百菲酪高钙水牛奶24盒","price":2580,"num":2,"specifications":"件","totalMoney":5160,"goodsDetail":null,"commission":0,"logoUrl":"https://file.aicenyi.com/icon057edb1e-10d7-4f27-ad7a-1c9b36a18cfa1548913533016.jpg"}],"shopInfo":{"id":1,"shopName":"两路口核销店","shopTel":"18122222222","shopAddress":"两路口地铁站附近","cityId":500000,"districtId":0,"shopLogoUrl":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563536200243&di=e02853590a5836a27ac7df4f95521913&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg","longitude":106.54863,"latitude":29.552567,"userId":4,"typeId":2,"classId":0,"remark":"店铺介绍","crateTime":1563527315000,"state":1,"salesVolume":0,"shopNature":1,"selfShop":0,"openTime":"8:00-22:00"},"communityInfo":{"id":5,"communityName":"新欧鹏教育城","communityAddress":"江北区江北嘴鲁溉路(中央公园旁)","sortNum":0,"description":"社区代理:尹国红","logoUrl":"https://file.aicenyi.com/iconbb2ee733-51d1-480e-b94a-9621c00f86c31548925475954.jpg","tel":"17726638949","state":1,"longitude":106.5732,"latitude":29.59,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0},"payWay":0,"createTime":1568984238000}
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
         * id : 238
         * orderNum : 917200957200238
         * getCode : 920172009570238g
         * receiveCode : 917092057200238r
         * customerId : 2
         * customerName : 杨幂家
         * customerTel : 18725621750
         * receiveAddress : 呵呵呵呵呵
         * shopId : 1
         * shopName : 两路口核销店
         * communityId : 5
         * communityName : 新欧鹏教育城
         * receiveWay : 4
         * deliveryTime : 9:00-22:00
         * state : 3
         * totalMoney : 22760
         * payMoney : 22760
         * resultMoney : 0
         * realMoney : 22760
         * remark : 会打电话多久发货
         * settlementId : -1
         * orderTime : null
         * payTime : 1568960762000
         * cgetTime : null
         * receiveTime : null
         * payNum : null
         * payRecode : null
         * orderDetailList : [{"id":485,"orderId":238,"goodsId":2,"goodsName":"泸州老窖52度品藏酒2瓶装","price":8800,"num":2,"specifications":"件","totalMoney":17600,"goodsDetail":null,"commission":0,"logoUrl":"https://file.aicenyi.com/iconb296fd82-4e3f-4835-8335-7406b877df3a1548913325138.jpg"},{"id":486,"orderId":238,"goodsId":13,"goodsName":"百菲酪高钙水牛奶24盒","price":2580,"num":2,"specifications":"件","totalMoney":5160,"goodsDetail":null,"commission":0,"logoUrl":"https://file.aicenyi.com/icon057edb1e-10d7-4f27-ad7a-1c9b36a18cfa1548913533016.jpg"}]
         * shopInfo : {"id":1,"shopName":"两路口核销店","shopTel":"18122222222","shopAddress":"两路口地铁站附近","cityId":500000,"districtId":0,"shopLogoUrl":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563536200243&di=e02853590a5836a27ac7df4f95521913&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg","longitude":106.54863,"latitude":29.552567,"userId":4,"typeId":2,"classId":0,"remark":"店铺介绍","crateTime":1563527315000,"state":1,"salesVolume":0,"shopNature":1,"selfShop":0,"openTime":"8:00-22:00"}
         * communityInfo : {"id":5,"communityName":"新欧鹏教育城","communityAddress":"江北区江北嘴鲁溉路(中央公园旁)","sortNum":0,"description":"社区代理:尹国红","logoUrl":"https://file.aicenyi.com/iconbb2ee733-51d1-480e-b94a-9621c00f86c31548925475954.jpg","tel":"17726638949","state":1,"longitude":106.5732,"latitude":29.59,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0}
         * payWay : 0
         * createTime : 1568984238000
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
        private Object payNum;
        private Object payRecode;
        private ShopInfoBean shopInfo;
        private CommunityInfoBean communityInfo;
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

        public ShopInfoBean getShopInfo() {
            return shopInfo;
        }

        public void setShopInfo(ShopInfoBean shopInfo) {
            this.shopInfo = shopInfo;
        }

        public CommunityInfoBean getCommunityInfo() {
            return communityInfo;
        }

        public void setCommunityInfo(CommunityInfoBean communityInfo) {
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
             * userId : 4
             * typeId : 2
             * classId : 0
             * remark : 店铺介绍
             * crateTime : 1563527315000
             * state : 1
             * salesVolume : 0
             * shopNature : 1
             * selfShop : 0
             * openTime : 8:00-22:00
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
            private int salesVolume;
            private int shopNature;
            private int selfShop;
            private String openTime;

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

            public int getSalesVolume() {
                return salesVolume;
            }

            public void setSalesVolume(int salesVolume) {
                this.salesVolume = salesVolume;
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

            public String getOpenTime() {
                return openTime;
            }

            public void setOpenTime(String openTime) {
                this.openTime = openTime;
            }
        }

        public static class CommunityInfoBean {
            /**
             * id : 5
             * communityName : 新欧鹏教育城
             * communityAddress : 江北区江北嘴鲁溉路(中央公园旁)
             * sortNum : 0
             * description : 社区代理:尹国红
             * logoUrl : https://file.aicenyi.com/iconbb2ee733-51d1-480e-b94a-9621c00f86c31548925475954.jpg
             * tel : 17726638949
             * state : 1
             * longitude : 106.5732
             * latitude : 29.59
             * del : 0
             * returnPercentage : 1000
             * openId : null
             * wechatLogin : -1
             * areaCode : 500000
             * distance : 0
             */

            private int id;
            private String communityName;
            private String communityAddress;
            private int sortNum;
            private String description;
            private String logoUrl;
            private String tel;
            private int state;
            private double longitude;
            private double latitude;
            private int del;
            private int returnPercentage;
            private Object openId;
            private int wechatLogin;
            private String areaCode;
            private int distance;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCommunityName() {
                return communityName;
            }

            public void setCommunityName(String communityName) {
                this.communityName = communityName;
            }

            public String getCommunityAddress() {
                return communityAddress;
            }

            public void setCommunityAddress(String communityAddress) {
                this.communityAddress = communityAddress;
            }

            public int getSortNum() {
                return sortNum;
            }

            public void setSortNum(int sortNum) {
                this.sortNum = sortNum;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getLogoUrl() {
                return logoUrl;
            }

            public void setLogoUrl(String logoUrl) {
                this.logoUrl = logoUrl;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
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

            public int getDel() {
                return del;
            }

            public void setDel(int del) {
                this.del = del;
            }

            public int getReturnPercentage() {
                return returnPercentage;
            }

            public void setReturnPercentage(int returnPercentage) {
                this.returnPercentage = returnPercentage;
            }

            public Object getOpenId() {
                return openId;
            }

            public void setOpenId(Object openId) {
                this.openId = openId;
            }

            public int getWechatLogin() {
                return wechatLogin;
            }

            public void setWechatLogin(int wechatLogin) {
                this.wechatLogin = wechatLogin;
            }

            public String getAreaCode() {
                return areaCode;
            }

            public void setAreaCode(String areaCode) {
                this.areaCode = areaCode;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }
        }

        public static class OrderDetailListBean {
            /**
             * id : 485
             * orderId : 238
             * goodsId : 2
             * goodsName : 泸州老窖52度品藏酒2瓶装
             * price : 8800
             * num : 2
             * specifications : 件
             * totalMoney : 17600
             * goodsDetail : null
             * commission : 0
             * logoUrl : https://file.aicenyi.com/iconb296fd82-4e3f-4835-8335-7406b877df3a1548913325138.jpg
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
            private int commission;
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

            public int getCommission() {
                return commission;
            }

            public void setCommission(int commission) {
                this.commission = commission;
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
