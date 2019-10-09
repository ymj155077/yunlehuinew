package com.example.YunleHui.Bean;

import java.util.List;

public class Bean_sel {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : [{"id":372,"shopName":"星月","shopTel":"18996168632","shopAddress":"范文芳威威","cityId":0,"districtId":0,"shopLogoUrl":"http://pxjovmx1d.bkt.clouddn.com/1174308106847522816","longitude":0,"latitude":0,"userId":0,"typeId":0,"classId":0,"remark":null,"crateTime":null,"openTime":null,"state":0,"pressOrder":0,"shopNature":0},{"id":1,"shopName":"两路口核销店","shopTel":"18122222222","shopAddress":"两路口地铁站附近","cityId":0,"districtId":0,"shopLogoUrl":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563536200243&di=e02853590a5836a27ac7df4f95521913&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg","longitude":0,"latitude":0,"userId":0,"typeId":0,"classId":0,"remark":null,"crateTime":null,"openTime":null,"state":0,"pressOrder":0,"shopNature":0}]
     */

    private boolean success;
    private int code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 372
         * shopName : 星月
         * shopTel : 18996168632
         * shopAddress : 范文芳威威
         * cityId : 0
         * districtId : 0
         * shopLogoUrl : http://pxjovmx1d.bkt.clouddn.com/1174308106847522816
         * longitude : 0.0
         * latitude : 0.0
         * userId : 0
         * typeId : 0
         * classId : 0
         * remark : null
         * crateTime : null
         * openTime : null
         * state : 0
         * pressOrder : 0
         * shopNature : 0
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
        private Object remark;
        private Object crateTime;
        private Object openTime;
        private int state;
        private int pressOrder;
        private int shopNature;

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

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public Object getCrateTime() {
            return crateTime;
        }

        public void setCrateTime(Object crateTime) {
            this.crateTime = crateTime;
        }

        public Object getOpenTime() {
            return openTime;
        }

        public void setOpenTime(Object openTime) {
            this.openTime = openTime;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getPressOrder() {
            return pressOrder;
        }

        public void setPressOrder(int pressOrder) {
            this.pressOrder = pressOrder;
        }

        public int getShopNature() {
            return shopNature;
        }

        public void setShopNature(int shopNature) {
            this.shopNature = shopNature;
        }
    }
}
