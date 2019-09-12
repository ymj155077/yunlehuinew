package com.example.YunleHui.Bean;

/**
 * Created by admin on 2019/8/17 0017.
 */

public class Bean_account {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : {"id":40,"userId":20,"tradeAmount":-1,"poundage":-1,"inOut":-1,"tradeType":-1,"extraNo":null,"tradeTime":null,"tradeDesc":null}
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
         * id : 40
         * userId : 20
         * tradeAmount : -1
         * poundage : -1
         * inOut : -1
         * tradeType : -1
         * extraNo : null
         * tradeTime : null
         * tradeDesc : null
         */

        private int id;
        private int userId;
        private int tradeAmount;
        private int poundage;
        private int inOut;
        private int tradeType;
        private Object extraNo;
        private Object tradeTime;
        private Object tradeDesc;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getTradeAmount() {
            return tradeAmount;
        }

        public void setTradeAmount(int tradeAmount) {
            this.tradeAmount = tradeAmount;
        }

        public int getPoundage() {
            return poundage;
        }

        public void setPoundage(int poundage) {
            this.poundage = poundage;
        }

        public int getInOut() {
            return inOut;
        }

        public void setInOut(int inOut) {
            this.inOut = inOut;
        }

        public int getTradeType() {
            return tradeType;
        }

        public void setTradeType(int tradeType) {
            this.tradeType = tradeType;
        }

        public Object getExtraNo() {
            return extraNo;
        }

        public void setExtraNo(Object extraNo) {
            this.extraNo = extraNo;
        }

        public Object getTradeTime() {
            return tradeTime;
        }

        public void setTradeTime(Object tradeTime) {
            this.tradeTime = tradeTime;
        }

        public Object getTradeDesc() {
            return tradeDesc;
        }

        public void setTradeDesc(Object tradeDesc) {
            this.tradeDesc = tradeDesc;
        }
    }
}
