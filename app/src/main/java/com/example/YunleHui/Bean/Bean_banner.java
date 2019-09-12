package com.example.YunleHui.Bean;

import java.util.List;

/**
 * Created by admin on 2019/8/24 0024.
 */

public class Bean_banner {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : {"totalCount":3,"voList":[{"name":"第一张图","des":"描述类容","url":"http://img.zcool.cn/community/01a6fd5c64161aa801203d22169868.jpg@1280w_1l_2o_100sh.jpg","jumpUrl":"baidu.com","pv":"2"},{"name":"第一张图","des":"描述类容","url":"http://img.zcool.cn/community/01a6fd5c64161aa801203d22169868.jpg@1280w_1l_2o_100sh.jpg","jumpUrl":"baidu.com","pv":"2"},{"name":"第二张图","des":"描述类容","url":"http://img.zcool.cn/community/0123cb5981a2350000002129bf3db6.jpg@1280w_1l_2o_100sh.jpg","jumpUrl":"baidu.com","pv":"2"}]}
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
         * totalCount : 3
         * voList : [{"name":"第一张图","des":"描述类容","url":"http://img.zcool.cn/community/01a6fd5c64161aa801203d22169868.jpg@1280w_1l_2o_100sh.jpg","jumpUrl":"baidu.com","pv":"2"},{"name":"第一张图","des":"描述类容","url":"http://img.zcool.cn/community/01a6fd5c64161aa801203d22169868.jpg@1280w_1l_2o_100sh.jpg","jumpUrl":"baidu.com","pv":"2"},{"name":"第二张图","des":"描述类容","url":"http://img.zcool.cn/community/0123cb5981a2350000002129bf3db6.jpg@1280w_1l_2o_100sh.jpg","jumpUrl":"baidu.com","pv":"2"}]
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
             * name : 第一张图
             * des : 描述类容
             * url : http://img.zcool.cn/community/01a6fd5c64161aa801203d22169868.jpg@1280w_1l_2o_100sh.jpg
             * jumpUrl : baidu.com
             * pv : 2
             */

            private String name;
            private String des;
            private String url;
            private String jumpUrl;
            private String pv;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDes() {
                return des;
            }

            public void setDes(String des) {
                this.des = des;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getJumpUrl() {
                return jumpUrl;
            }

            public void setJumpUrl(String jumpUrl) {
                this.jumpUrl = jumpUrl;
            }

            public String getPv() {
                return pv;
            }

            public void setPv(String pv) {
                this.pv = pv;
            }
        }
    }
}
