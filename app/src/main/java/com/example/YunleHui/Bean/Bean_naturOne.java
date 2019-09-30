package com.example.YunleHui.Bean;

public class Bean_naturOne {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : {"id":232,"state":2,"applyRemark":null,"resultRemark":null,"orderDetailVo":null}
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
         * id : 232
         * state : 2
         * applyRemark : null
         * resultRemark : null
         * orderDetailVo : null
         */

        private int id;
        private int state;
        private Object applyRemark;
        private Object resultRemark;
        private Object orderDetailVo;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public Object getApplyRemark() {
            return applyRemark;
        }

        public void setApplyRemark(Object applyRemark) {
            this.applyRemark = applyRemark;
        }

        public Object getResultRemark() {
            return resultRemark;
        }

        public void setResultRemark(Object resultRemark) {
            this.resultRemark = resultRemark;
        }

        public Object getOrderDetailVo() {
            return orderDetailVo;
        }

        public void setOrderDetailVo(Object orderDetailVo) {
            this.orderDetailVo = orderDetailVo;
        }
    }
}
