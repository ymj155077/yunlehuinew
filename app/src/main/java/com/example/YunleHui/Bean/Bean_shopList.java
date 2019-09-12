package com.example.YunleHui.Bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by admin on 2019/8/27 0027.
 */

public class Bean_shopList {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : [{"id":1,"className":"美食","serviceCharge":0.511231,"classLogoUrl":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg","classNature":0},{"id":2,"className":"娱乐","serviceCharge":0,"classLogoUrl":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg","classNature":0},{"id":3,"className":"丽人","serviceCharge":0,"classLogoUrl":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg","classNature":0},{"id":4,"className":"旅游","serviceCharge":0,"classLogoUrl":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg","classNature":0},{"id":5,"className":"教育","serviceCharge":0,"classLogoUrl":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg","classNature":0},{"id":6,"className":"水果","serviceCharge":0,"classLogoUrl":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg","classNature":0},{"id":7,"className":"生鲜","serviceCharge":0,"classLogoUrl":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg","classNature":0},{"id":8,"className":"xxx","serviceCharge":0,"classLogoUrl":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg","classNature":0},{"id":9,"className":"kakak","serviceCharge":0,"classLogoUrl":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg","classNature":0},{"id":10,"className":"夜宵","serviceCharge":0,"classLogoUrl":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg","classNature":0},{"id":11,"className":"asda","serviceCharge":0,"classLogoUrl":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg","classNature":0},{"id":12,"classN 08-27 13:40:15.220 26804-26868/com.example.YunleHui I/shopApply/shopClassList: ame":"周边","serviceCharge":0,"classLogoUrl":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg","classNature":0}]
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
         * id : 1
         * className : 美食
         * serviceCharge : 0.511231
         * classLogoUrl : https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg
         * classNature : 0
         * classN 08-27 13:40:15.220 26804-26868/com.example.YunleHui I/shopApply/shopClassList: ame : 周边
         */

        private int id;
        private String className;
        private double serviceCharge;
        private String classLogoUrl;
        private int classNature;
        @SerializedName("classN 08-27 13:40:15.220 26804-26868/com.example.YunleHui I/shopApply/shopClassList: ame")
        private String _$ClassN08271340152202680426868ComExampleYunleHuiIShopApplyShopClassListAme167; // FIXME check this code

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public int getClassNature() {
            return classNature;
        }

        public void setClassNature(int classNature) {
            this.classNature = classNature;
        }

        public String get_$ClassN08271340152202680426868ComExampleYunleHuiIShopApplyShopClassListAme167() {
            return _$ClassN08271340152202680426868ComExampleYunleHuiIShopApplyShopClassListAme167;
        }

        public void set_$ClassN08271340152202680426868ComExampleYunleHuiIShopApplyShopClassListAme167(String _$ClassN08271340152202680426868ComExampleYunleHuiIShopApplyShopClassListAme167) {
            this._$ClassN08271340152202680426868ComExampleYunleHuiIShopApplyShopClassListAme167 = _$ClassN08271340152202680426868ComExampleYunleHuiIShopApplyShopClassListAme167;
        }
    }
}
