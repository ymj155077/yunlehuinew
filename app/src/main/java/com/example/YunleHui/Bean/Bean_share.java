package com.example.YunleHui.Bean;

import java.util.List;

/**
 * Created by admin on 2019/8/23 0023.
 */

public class Bean_share {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : {"totalCount":2,"voList":[{"id":0,"userId":20,"goodsId":117,"logoUrl":"http://img.daimg.com/uploads/allimg/181010/1-1Q010161035.jpg","posterUrl":"http://img.daimg.com/uploads/allimg/181010/1-1Q010161035.jpg","name":"火锅12-2","intro":"重庆火锅，又称为毛肚火锅或麻辣火锅，是中国传统饮食方式，起源于明末清初的重庆嘉陵江畔、朝天门等码头船工纤夫的粗放餐饮方式，原料主要是牛毛肚、猪黄喉、鸭肠、牛血旺等。","price":4900,"originalPrice":19900,"pv":0,"commission":750}]}
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
         * totalCount : 2
         * voList : [{"id":0,"userId":20,"goodsId":117,"logoUrl":"http://img.daimg.com/uploads/allimg/181010/1-1Q010161035.jpg","posterUrl":"http://img.daimg.com/uploads/allimg/181010/1-1Q010161035.jpg","name":"火锅12-2","intro":"重庆火锅，又称为毛肚火锅或麻辣火锅，是中国传统饮食方式，起源于明末清初的重庆嘉陵江畔、朝天门等码头船工纤夫的粗放餐饮方式，原料主要是牛毛肚、猪黄喉、鸭肠、牛血旺等。","price":4900,"originalPrice":19900,"pv":0,"commission":750}]
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
             * id : 0
             * userId : 20
             * goodsId : 117
             * logoUrl : http://img.daimg.com/uploads/allimg/181010/1-1Q010161035.jpg
             * posterUrl : http://img.daimg.com/uploads/allimg/181010/1-1Q010161035.jpg
             * name : 火锅12-2
             * intro : 重庆火锅，又称为毛肚火锅或麻辣火锅，是中国传统饮食方式，起源于明末清初的重庆嘉陵江畔、朝天门等码头船工纤夫的粗放餐饮方式，原料主要是牛毛肚、猪黄喉、鸭肠、牛血旺等。
             * price : 4900
             * originalPrice : 19900
             * pv : 0
             * commission : 750
             */

            private int id;
            private int userId;
            private int goodsId;
            private String logoUrl;
            private String posterUrl;
            private String name;
            private String intro;
            private int price;
            private int originalPrice;
            private int pv;
            private int commission;

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

            public int getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(int goodsId) {
                this.goodsId = goodsId;
            }

            public String getLogoUrl() {
                return logoUrl;
            }

            public void setLogoUrl(String logoUrl) {
                this.logoUrl = logoUrl;
            }

            public String getPosterUrl() {
                return posterUrl;
            }

            public void setPosterUrl(String posterUrl) {
                this.posterUrl = posterUrl;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getOriginalPrice() {
                return originalPrice;
            }

            public void setOriginalPrice(int originalPrice) {
                this.originalPrice = originalPrice;
            }

            public int getPv() {
                return pv;
            }

            public void setPv(int pv) {
                this.pv = pv;
            }

            public int getCommission() {
                return commission;
            }

            public void setCommission(int commission) {
                this.commission = commission;
            }
        }
    }
}
