package com.example.YunleHui.Bean;

import java.util.List;

/**
 * Created by admin on 2019/8/23 0023.
 */

public class Bean_tuan {


    /**
     * code : 0
     * data : {"totalCount":0,"voList":[{"subUserId":0,"subUserName":"string","totalCommission":0,"totalCount":0}]}
     * msg : string
     * success : true
     */

    private int code;
    private DataBean data;
    private String msg;
    private boolean success;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataBean {
        /**
         * totalCount : 0
         * voList : [{"subUserId":0,"subUserName":"string","totalCommission":0,"totalCount":0}]
         */

        private int totalCount;
        private List<VoListBean> voList;

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public List<VoListBean> getVoList() {
            return voList;
        }

        public void setVoList(List<VoListBean> voList) {
            this.voList = voList;
        }

        public static class VoListBean {
            /**
             * subUserId : 0
             * subUserName : string
             * totalCommission : 0
             * totalCount : 0
             */

            private int subUserId;
            private String subUserName;
            private int totalCommission;
            private int totalCount;

            private String subLogo;

            public String getSubLogo() {
                return subLogo;
            }

            public void setSubLogo(String subLogo) {
                this.subLogo = subLogo;
            }

            public int getSubUserId() {
                return subUserId;
            }

            public void setSubUserId(int subUserId) {
                this.subUserId = subUserId;
            }

            public String getSubUserName() {
                return subUserName;
            }

            public void setSubUserName(String subUserName) {
                this.subUserName = subUserName;
            }

            public int getTotalCommission() {
                return totalCommission;
            }

            public void setTotalCommission(int totalCommission) {
                this.totalCommission = totalCommission;
            }

            public int getTotalCount() {
                return totalCount;
            }

            public void setTotalCount(int totalCount) {
                this.totalCount = totalCount;
            }
        }
    }
}
