package com.example.YunleHui.Bean;

import java.util.List;

public class Bean_spgl {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : [{"id":601,"shopClassId":0,"operateShopId":0,"goodsName":"u分就分不方便","inventory":132,"price":36000,"discountPrice":30000,"commission":1000,"postersUrl":"http://pz4yvu336.bkt.clouddn.com/1182116315096289280","saleNum":0,"specifications":null,"state":1,"logoUrl":"http://pz4yvu336.bkt.clouddn.com/1182116308511232000","preTime":9,"goodsEffeDate":"2002-01-01","orderEffeDate":"1997-01-01","sortNum":0,"limited":0,"created":"2019-10-10T02:36:26.000+0000","isAllowId":0,"setMealList":[{"id":87,"goodsId":601,"operateShopId":385,"setMealName":null,"logoUrl":"http://pz4yvu336.bkt.clouddn.com/1182122682074927104","stock":66,"price":30000,"originalPrice":36000,"settlementPrice":23000,"commission":1000,"remark":"就差你拉拉队"},{"id":88,"goodsId":601,"operateShopId":385,"setMealName":null,"logoUrl":"http://pz4yvu336.bkt.clouddn.com/1182122682163007488","stock":66,"price":89000,"originalPrice":99000,"settlementPrice":66000,"commission":1000,"remark":""}]},{"id":600,"shopClassId":0,"operateShopId":0,"goodsName":"发扣扣放长假减肥","inventory":79,"price":84000,"discountPrice":84000,"commission":1000,"postersUrl":"http://pz4yvu336.bkt.clouddn.com/1182116315293421568","saleNum":0,"specifications":null,"state":1,"logoUrl":"http://pz4yvu336.bkt.clouddn.com/1182116308511232000","preTime":9,"goodsEffeDate":"2005-01-01","orderEffeDate":"1993-01-01","sortNum":0,"limited":0,"created":"2019-10-10T02:11:09.000+0000","isAllowId":0,"setMealList":[{"id":85,"goodsId":600,"operateShopId":385,"setMealName":null,"logoUrl":"http://pz4yvu336.bkt.clouddn.com/1182113906835984384","stock":10,"price":96000,"originalPrice":99000,"settlementPrice":69000,"commission":1000,"remark":"好的好的好的好的好"},{"id":86,"goodsId":600,"operateShopId":385,"setMealName":null,"logoUrl":"http://pz4yvu336.bkt.clouddn.com/1182116318078439424","stock":69,"price":84000,"originalPrice":89000,"settlementPrice":78000,"commission":1000,"remark":"大家都你懂不懂"}]}]
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
         * id : 601
         * shopClassId : 0
         * operateShopId : 0
         * goodsName : u分就分不方便
         * inventory : 132
         * price : 36000
         * discountPrice : 30000
         * commission : 1000
         * postersUrl : http://pz4yvu336.bkt.clouddn.com/1182116315096289280
         * saleNum : 0
         * specifications : null
         * state : 1
         * logoUrl : http://pz4yvu336.bkt.clouddn.com/1182116308511232000
         * preTime : 9
         * goodsEffeDate : 2002-01-01
         * orderEffeDate : 1997-01-01
         * sortNum : 0
         * limited : 0
         * created : 2019-10-10T02:36:26.000+0000
         * isAllowId : 0
         * setMealList : [{"id":87,"goodsId":601,"operateShopId":385,"setMealName":null,"logoUrl":"http://pz4yvu336.bkt.clouddn.com/1182122682074927104","stock":66,"price":30000,"originalPrice":36000,"settlementPrice":23000,"commission":1000,"remark":"就差你拉拉队"},{"id":88,"goodsId":601,"operateShopId":385,"setMealName":null,"logoUrl":"http://pz4yvu336.bkt.clouddn.com/1182122682163007488","stock":66,"price":89000,"originalPrice":99000,"settlementPrice":66000,"commission":1000,"remark":""}]
         */

        private int id;
        private int shopClassId;
        private int operateShopId;
        private String goodsName;
        private int inventory;
        private int price;
        private int discountPrice;
        private int commission;
        private String postersUrl;
        private int saleNum;
        private Object specifications;
        private int state;
        private String logoUrl;
        private int preTime;
        private String goodsEffeDate;
        private String orderEffeDate;
        private int sortNum;
        private int limited;
        private String created;
        private int isAllowId;
        private List<SetMealListBean> setMealList;


        private int goodsNature;

        private String remark;

        public int getGoodsNature() {
            return goodsNature;
        }

        public void setGoodsNature(int goodsNature) {
            this.goodsNature = goodsNature;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getShopClassId() {
            return shopClassId;
        }

        public void setShopClassId(int shopClassId) {
            this.shopClassId = shopClassId;
        }

        public int getOperateShopId() {
            return operateShopId;
        }

        public void setOperateShopId(int operateShopId) {
            this.operateShopId = operateShopId;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public int getInventory() {
            return inventory;
        }

        public void setInventory(int inventory) {
            this.inventory = inventory;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getDiscountPrice() {
            return discountPrice;
        }

        public void setDiscountPrice(int discountPrice) {
            this.discountPrice = discountPrice;
        }

        public int getCommission() {
            return commission;
        }

        public void setCommission(int commission) {
            this.commission = commission;
        }

        public String getPostersUrl() {
            return postersUrl;
        }

        public void setPostersUrl(String postersUrl) {
            this.postersUrl = postersUrl;
        }

        public int getSaleNum() {
            return saleNum;
        }

        public void setSaleNum(int saleNum) {
            this.saleNum = saleNum;
        }

        public Object getSpecifications() {
            return specifications;
        }

        public void setSpecifications(Object specifications) {
            this.specifications = specifications;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
        }

        public int getPreTime() {
            return preTime;
        }

        public void setPreTime(int preTime) {
            this.preTime = preTime;
        }

        public String getGoodsEffeDate() {
            return goodsEffeDate;
        }

        public void setGoodsEffeDate(String goodsEffeDate) {
            this.goodsEffeDate = goodsEffeDate;
        }

        public String getOrderEffeDate() {
            return orderEffeDate;
        }

        public void setOrderEffeDate(String orderEffeDate) {
            this.orderEffeDate = orderEffeDate;
        }

        public int getSortNum() {
            return sortNum;
        }

        public void setSortNum(int sortNum) {
            this.sortNum = sortNum;
        }

        public int getLimited() {
            return limited;
        }

        public void setLimited(int limited) {
            this.limited = limited;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public int getIsAllowId() {
            return isAllowId;
        }

        public void setIsAllowId(int isAllowId) {
            this.isAllowId = isAllowId;
        }

        public List<SetMealListBean> getSetMealList() {
            return setMealList;
        }

        public void setSetMealList(List<SetMealListBean> setMealList) {
            this.setMealList = setMealList;
        }

        public static class SetMealListBean {
            /**
             * id : 87
             * goodsId : 601
             * operateShopId : 385
             * setMealName : null
             * logoUrl : http://pz4yvu336.bkt.clouddn.com/1182122682074927104
             * stock : 66
             * price : 30000
             * originalPrice : 36000
             * settlementPrice : 23000
             * commission : 1000
             * remark : 就差你拉拉队
             */

            private int id;
            private int goodsId;
            private int operateShopId;
            private String setMealName;
            private String logoUrl;
            private int stock;
            private int price;
            private int originalPrice;
            private int settlementPrice;
            private int commission;
            private String remark;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(int goodsId) {
                this.goodsId = goodsId;
            }

            public int getOperateShopId() {
                return operateShopId;
            }

            public void setOperateShopId(int operateShopId) {
                this.operateShopId = operateShopId;
            }

            public String getSetMealName() {
                return setMealName;
            }

            public void setSetMealName(String setMealName) {
                this.setMealName = setMealName;
            }

            public String getLogoUrl() {
                return logoUrl;
            }

            public void setLogoUrl(String logoUrl) {
                this.logoUrl = logoUrl;
            }

            public int getStock() {
                return stock;
            }

            public void setStock(int stock) {
                this.stock = stock;
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

            public int getSettlementPrice() {
                return settlementPrice;
            }

            public void setSettlementPrice(int settlementPrice) {
                this.settlementPrice = settlementPrice;
            }

            public int getCommission() {
                return commission;
            }

            public void setCommission(int commission) {
                this.commission = commission;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }
        }
    }
}
