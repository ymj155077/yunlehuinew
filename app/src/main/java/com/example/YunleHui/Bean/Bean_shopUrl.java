package com.example.YunleHui.Bean;

/**
 * Created by admin on 2019/8/28 0028.
 */

public class Bean_shopUrl {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : {"id":469,"mediaType":0,"businessType":1,"mediaSize":37309,"mediaName":"1166535384595828736","mediaUrl":"http://pwa27iixx.bkt.clouddn.com/1166535384595828736"}
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
         * id : 469
         * mediaType : 0
         * businessType : 1
         * mediaSize : 37309
         * mediaName : 1166535384595828736
         * mediaUrl : http://pwa27iixx.bkt.clouddn.com/1166535384595828736
         */

        private int id;
        private int mediaType;
        private int businessType;
        private int mediaSize;
        private String mediaName;
        private String mediaUrl;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getMediaType() {
            return mediaType;
        }

        public void setMediaType(int mediaType) {
            this.mediaType = mediaType;
        }

        public int getBusinessType() {
            return businessType;
        }

        public void setBusinessType(int businessType) {
            this.businessType = businessType;
        }

        public int getMediaSize() {
            return mediaSize;
        }

        public void setMediaSize(int mediaSize) {
            this.mediaSize = mediaSize;
        }

        public String getMediaName() {
            return mediaName;
        }

        public void setMediaName(String mediaName) {
            this.mediaName = mediaName;
        }

        public String getMediaUrl() {
            return mediaUrl;
        }

        public void setMediaUrl(String mediaUrl) {
            this.mediaUrl = mediaUrl;
        }
    }
}
