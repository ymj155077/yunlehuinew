package com.example.YunleHui.Bean;

import java.io.Serializable;

/**
 * Created by admin on 2019/8/28 0028.
 */

public class Bean_shop_center implements Serializable {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : {"id":371,"shopName":"六公里营销核销","shopTel":"14614641","shopAddress":"两路口地铁站附近","shopLogoUrl":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563536200243&di=e02853590a5836a27ac7df4f95521913&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg","longitude":106.573358,"latitude":29.497804,"userId":20,"typeId":3,"remark":"店铺介绍","state":1,"crateTime":"2019-07-19","shopNature":1,"cityId":500000,"classId":4,"className":"旅游","serviceCharge":0,"classLogoUrl":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg"}
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
         * id : 371
         * shopName : 六公里营销核销
         * shopTel : 14614641
         * shopAddress : 两路口地铁站附近
         * shopLogoUrl : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563536200243&di=e02853590a5836a27ac7df4f95521913&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg
         * longitude : 106.573358
         * latitude : 29.497804
         * userId : 20
         * typeId : 3
         * remark : 店铺介绍
         * state : 1
         * crateTime : 2019-07-19
         * shopNature : 1
         * cityId : 500000
         * classId : 4
         * className : 旅游
         * serviceCharge : 0.0
         * classLogoUrl : https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg
         */

        private int id;
        private String shopName;
        private String shopTel;
        private String shopAddress;
        private String shopLogoUrl;
        private double longitude;
        private double latitude;
        private int userId;
        private int typeId;
        private String remark;
        private int state;
        private String crateTime;
        private int shopNature;
        private int cityId;
        private int classId;
        private String className;
        private double serviceCharge;
        private String classLogoUrl;

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

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getCrateTime() {
            return crateTime;
        }

        public void setCrateTime(String crateTime) {
            this.crateTime = crateTime;
        }

        public int getShopNature() {
            return shopNature;
        }

        public void setShopNature(int shopNature) {
            this.shopNature = shopNature;
        }

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public int getClassId() {
            return classId;
        }

        public void setClassId(int classId) {
            this.classId = classId;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public double getServiceCharge() {
            return serviceCharge;
        }

        public void setServiceCharge(double serviceCharge) {
            this.serviceCharge = serviceCharge;
        }

        public String getClassLogoUrl() {
            return classLogoUrl;
        }

        public void setClassLogoUrl(String classLogoUrl) {
            this.classLogoUrl = classLogoUrl;
        }
    }
}
