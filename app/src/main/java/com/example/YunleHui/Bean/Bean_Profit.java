package com.example.YunleHui.Bean;

import java.util.List;

/**
 * Created by admin on 2019/8/23 0023.
 *
 * 收益
 *
 */

public class Bean_Profit {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : {"totalCount":0,"voList":[],"totalCommission":0,"notSettleCommission":0,"settledCommission":0,"exceptionCommission":0}
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
         * totalCount : 0
         * voList : []
         * totalCommission : 0
         * notSettleCommission : 0
         * settledCommission : 0
         * exceptionCommission : 0
         */

        private int totalCount;
        private int totalCommission;
        private int notSettleCommission;
        private int settledCommission;
        private int exceptionCommission;
        private List<?> voList;

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getTotalCommission() {
            return totalCommission;
        }

        public void setTotalCommission(int totalCommission) {
            this.totalCommission = totalCommission;
        }

        public int getNotSettleCommission() {
            return notSettleCommission;
        }

        public void setNotSettleCommission(int notSettleCommission) {
            this.notSettleCommission = notSettleCommission;
        }

        public int getSettledCommission() {
            return settledCommission;
        }

        public void setSettledCommission(int settledCommission) {
            this.settledCommission = settledCommission;
        }

        public int getExceptionCommission() {
            return exceptionCommission;
        }

        public void setExceptionCommission(int exceptionCommission) {
            this.exceptionCommission = exceptionCommission;
        }

        public List<?> getVoList() {
            return voList;
        }

        public void setVoList(List<?> voList) {
            this.voList = voList;
        }
    }
}
