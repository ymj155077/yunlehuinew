package com.example.YunleHui.Bean;

import java.util.List;

/**
 * Created by admin on 2019/8/12 0012.
 */

public class Bean_cai {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : [{"id":1,"className":"美食","classLogoUrl":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg","remark":"","logoUrl":null},{"id":2,"className":"娱乐","classLogoUrl":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg","remark":"","logoUrl":null},{"id":3,"className":"丽人","classLogoUrl":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg","remark":"","logoUrl":null},{"id":4,"className":"旅游","classLogoUrl":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg","remark":"","logoUrl":null},{"id":5,"className":"教育","classLogoUrl":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg","remark":"","logoUrl":null},{"id":6,"className":"水果","classLogoUrl":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg","remark":"","logoUrl":null},{"id":7,"className":"生鲜","classLogoUrl":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg","remark":"","logoUrl":null},{"id":8,"className":"xxx","classLogoUrl":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg","remark":"","logoUrl":null},{"id":9,"className":"kakak","classLogoUrl":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg","remark":"","logoUrl":null},{"id":10,"className":"夜宵","classLogoUrl":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg","remark":"","logoUrl":null},{"id":11,"className":"asda","classLogoUrl":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg","remark":"","logoUrl":null},{"id":12,"className":"周边","classLogoUrl":"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg","remark":"","logoUrl":null}]
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
         * classLogoUrl : https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2460975758,130576517&fm=26&gp=0.jpg
         * remark :
         * logoUrl : null
         */

        private int id;
        private String className;
        private String classLogoUrl;
        private String remark;
        private Object logoUrl;

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

        public String getClassLogoUrl() {
            return classLogoUrl;
        }

        public void setClassLogoUrl(String classLogoUrl) {
            this.classLogoUrl = classLogoUrl;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public Object getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(Object logoUrl) {
            this.logoUrl = logoUrl;
        }
    }
}
