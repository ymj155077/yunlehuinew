package com.example.YunleHui.Bean;

import java.util.List;

/**
 * Created by admin on 2019/8/24 0024.
 */

public class Bean_jin {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : {"totalCount":4,"voList":[{"id":116,"customer":1,"customerLogo":"http://thirdwx.qlogo.cn/mmopen/vi_32/UniaxFelbP12vx30vuwgGicYRp9pCdliaPYVT6Kgb21MNk9pH7MXnbicsOjMJ3rgbP9zRjaEqk9cD8BWTsswNC7meg/132","customerName":"test","channel":2,"beneficiary":20,"beneficiaryName":"张三","commission":250,"type":1,"state":1,"exception":0,"exceptionDes":null,"createTime":"2019-08-03","settlementTime":null,"exceptionTime":null,"goodsId":122,"goodsName":"火锅12-2","goodsSetId":24,"goodsSetLogo":"http://n.sinaimg.cn/sinacn/w640h640/20180304/6b58-fxipenm7791113.jpg","goodsSetName":"套餐一","goodsCommission":1000,"goodsTotalCommission":1000,"orderId":22,"orderNumber":"142848853354217472","count":1},{"id":117,"customer":3,"customerLogo":"http://thirdwx.qlogo.cn/mmopen/vi_32/UniaxFelbP12vx30vuwgGicYRp9pCdliaPYVT6Kgb21MNk9pH7MXnbicsOjMJ3rgbP9zRjaEqk9cD8BWTsswNC7meg/132","customerName":"test","channel":2,"beneficiary":20,"beneficiaryName":"张三","commission":750,"type":0,"state":1,"exception":0,"exceptionDes":null,"createTime":"2019-08-03","settlementTime":null,"exceptionTime":null,"goodsId":122,"goodsName":"火锅12-2","goodsSetId":24,"goodsSetLogo":"http://n.sinaimg.cn/sinacn/w640h640/20180304/6b58-fxipenm7791113.jpg","goodsSetName":"套餐一","goodsCommission":1000,"goodsTotalCommission":1000,"orderId":33,"orderNumber":"142848853354217472","count":1},{"id":118,"customer":3,"customerLogo":"http://thirdwx.qlogo.cn/mmopen/vi_32/UniaxFelbP12vx30vuwgGicYRp9pCdliaPYVT6Kgb21MNk9pH7MXnbicsOjMJ3rgbP9zRjaEqk9cD8BWTsswNC7meg/132","customerName":"test","channel":2,"beneficiary":20,"beneficiaryName":"张三","commission":750,"type":0,"state":1,"exception":0,"exceptionDes":null,"createTime":"2019-08-03","settlementTime":null,"exceptionTime":null,"goodsId":116,"goodsName":"火锅12-2","goodsSetId":24,"goodsSetLogo":"http://n.sinaimg.cn/sinacn/w640h640/20180304/6b58-fxipenm7791113.jpg","goodsSetName":"套餐一","goodsCommission":1000,"goodsTotalCommission":1000,"orderId":33,"orderNumber":"142848853354217472","count":1},{"id":119,"customer":3,"customerLogo":"http://thirdwx.qlogo.cn/mmopen/vi_32/UniaxFelbP12vx30vuwgGicYRp9pCdliaPYVT6Kgb21MNk9pH7MXnbicsOjMJ3rgbP9zRjaEqk9cD8BWTsswNC7meg/132","customerName":"test","channel":2,"beneficiary":20,"beneficiaryName":"张三","commission":750,"type":0,"state":1,"exception":0,"exceptionDes":null,"createTime":"2019-08-03","settlementTime":null,"exceptionTime":null,"goodsId":117,"goodsName":"火锅12-2","goodsSetId":24,"goodsSetLogo":"http://n.sinaimg.cn/sinacn/w640h640/20180304/6b58-fxipenm7791113.jpg","goodsSetName":"套餐一","goodsCommission":1000,"goodsTotalCommission":1000,"orderId":33,"orderNumber":"142848853354217472","count":1}],"totalCommission":2500,"notSettleCommission":0,"settledCommission":2500,"exceptionCommission":0}
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
         * totalCount : 4
         * voList : [{"id":116,"customer":1,"customerLogo":"http://thirdwx.qlogo.cn/mmopen/vi_32/UniaxFelbP12vx30vuwgGicYRp9pCdliaPYVT6Kgb21MNk9pH7MXnbicsOjMJ3rgbP9zRjaEqk9cD8BWTsswNC7meg/132","customerName":"test","channel":2,"beneficiary":20,"beneficiaryName":"张三","commission":250,"type":1,"state":1,"exception":0,"exceptionDes":null,"createTime":"2019-08-03","settlementTime":null,"exceptionTime":null,"goodsId":122,"goodsName":"火锅12-2","goodsSetId":24,"goodsSetLogo":"http://n.sinaimg.cn/sinacn/w640h640/20180304/6b58-fxipenm7791113.jpg","goodsSetName":"套餐一","goodsCommission":1000,"goodsTotalCommission":1000,"orderId":22,"orderNumber":"142848853354217472","count":1},{"id":117,"customer":3,"customerLogo":"http://thirdwx.qlogo.cn/mmopen/vi_32/UniaxFelbP12vx30vuwgGicYRp9pCdliaPYVT6Kgb21MNk9pH7MXnbicsOjMJ3rgbP9zRjaEqk9cD8BWTsswNC7meg/132","customerName":"test","channel":2,"beneficiary":20,"beneficiaryName":"张三","commission":750,"type":0,"state":1,"exception":0,"exceptionDes":null,"createTime":"2019-08-03","settlementTime":null,"exceptionTime":null,"goodsId":122,"goodsName":"火锅12-2","goodsSetId":24,"goodsSetLogo":"http://n.sinaimg.cn/sinacn/w640h640/20180304/6b58-fxipenm7791113.jpg","goodsSetName":"套餐一","goodsCommission":1000,"goodsTotalCommission":1000,"orderId":33,"orderNumber":"142848853354217472","count":1},{"id":118,"customer":3,"customerLogo":"http://thirdwx.qlogo.cn/mmopen/vi_32/UniaxFelbP12vx30vuwgGicYRp9pCdliaPYVT6Kgb21MNk9pH7MXnbicsOjMJ3rgbP9zRjaEqk9cD8BWTsswNC7meg/132","customerName":"test","channel":2,"beneficiary":20,"beneficiaryName":"张三","commission":750,"type":0,"state":1,"exception":0,"exceptionDes":null,"createTime":"2019-08-03","settlementTime":null,"exceptionTime":null,"goodsId":116,"goodsName":"火锅12-2","goodsSetId":24,"goodsSetLogo":"http://n.sinaimg.cn/sinacn/w640h640/20180304/6b58-fxipenm7791113.jpg","goodsSetName":"套餐一","goodsCommission":1000,"goodsTotalCommission":1000,"orderId":33,"orderNumber":"142848853354217472","count":1},{"id":119,"customer":3,"customerLogo":"http://thirdwx.qlogo.cn/mmopen/vi_32/UniaxFelbP12vx30vuwgGicYRp9pCdliaPYVT6Kgb21MNk9pH7MXnbicsOjMJ3rgbP9zRjaEqk9cD8BWTsswNC7meg/132","customerName":"test","channel":2,"beneficiary":20,"beneficiaryName":"张三","commission":750,"type":0,"state":1,"exception":0,"exceptionDes":null,"createTime":"2019-08-03","settlementTime":null,"exceptionTime":null,"goodsId":117,"goodsName":"火锅12-2","goodsSetId":24,"goodsSetLogo":"http://n.sinaimg.cn/sinacn/w640h640/20180304/6b58-fxipenm7791113.jpg","goodsSetName":"套餐一","goodsCommission":1000,"goodsTotalCommission":1000,"orderId":33,"orderNumber":"142848853354217472","count":1}]
         * totalCommission : 2500
         * notSettleCommission : 0
         * settledCommission : 2500
         * exceptionCommission : 0
         */

        private int totalCount;
        private int totalCommission;
        private int notSettleCommission;
        private int settledCommission;
        private int exceptionCommission;
        private List<VoListBean> voList;

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

        public List<VoListBean> getVoList() {
            return voList;
        }

        public void setVoList(List<VoListBean> voList) {
            this.voList = voList;
        }

        public static class VoListBean {
            /**
             * id : 116
             * customer : 1
             * customerLogo : http://thirdwx.qlogo.cn/mmopen/vi_32/UniaxFelbP12vx30vuwgGicYRp9pCdliaPYVT6Kgb21MNk9pH7MXnbicsOjMJ3rgbP9zRjaEqk9cD8BWTsswNC7meg/132
             * customerName : test
             * channel : 2
             * beneficiary : 20
             * beneficiaryName : 张三
             * commission : 250
             * type : 1
             * state : 1
             * exception : 0
             * exceptionDes : null
             * createTime : 2019-08-03
             * settlementTime : null
             * exceptionTime : null
             * goodsId : 122
             * goodsName : 火锅12-2
             * goodsSetId : 24
             * goodsSetLogo : http://n.sinaimg.cn/sinacn/w640h640/20180304/6b58-fxipenm7791113.jpg
             * goodsSetName : 套餐一
             * goodsCommission : 1000
             * goodsTotalCommission : 1000
             * orderId : 22
             * orderNumber : 142848853354217472
             * count : 1
             */

            private int id;
            private int customer;
            private String customerLogo;
            private String customerName;
            private int channel;
            private int beneficiary;
            private String beneficiaryName;
            private int commission;
            private int type;
            private int state;
            private int exception;
            private Object exceptionDes;
            private String createTime;
            private Object settlementTime;
            private Object exceptionTime;
            private int goodsId;
            private String goodsName;
            private int goodsSetId;
            private String goodsSetLogo;
            private String goodsSetName;
            private int goodsCommission;
            private int goodsTotalCommission;
            private int orderId;
            private String orderNumber;
            private int count;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getCustomer() {
                return customer;
            }

            public void setCustomer(int customer) {
                this.customer = customer;
            }

            public String getCustomerLogo() {
                return customerLogo;
            }

            public void setCustomerLogo(String customerLogo) {
                this.customerLogo = customerLogo;
            }

            public String getCustomerName() {
                return customerName;
            }

            public void setCustomerName(String customerName) {
                this.customerName = customerName;
            }

            public int getChannel() {
                return channel;
            }

            public void setChannel(int channel) {
                this.channel = channel;
            }

            public int getBeneficiary() {
                return beneficiary;
            }

            public void setBeneficiary(int beneficiary) {
                this.beneficiary = beneficiary;
            }

            public String getBeneficiaryName() {
                return beneficiaryName;
            }

            public void setBeneficiaryName(String beneficiaryName) {
                this.beneficiaryName = beneficiaryName;
            }

            public int getCommission() {
                return commission;
            }

            public void setCommission(int commission) {
                this.commission = commission;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public int getException() {
                return exception;
            }

            public void setException(int exception) {
                this.exception = exception;
            }

            public Object getExceptionDes() {
                return exceptionDes;
            }

            public void setExceptionDes(Object exceptionDes) {
                this.exceptionDes = exceptionDes;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getSettlementTime() {
                return settlementTime;
            }

            public void setSettlementTime(Object settlementTime) {
                this.settlementTime = settlementTime;
            }

            public Object getExceptionTime() {
                return exceptionTime;
            }

            public void setExceptionTime(Object exceptionTime) {
                this.exceptionTime = exceptionTime;
            }

            public int getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(int goodsId) {
                this.goodsId = goodsId;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public int getGoodsSetId() {
                return goodsSetId;
            }

            public void setGoodsSetId(int goodsSetId) {
                this.goodsSetId = goodsSetId;
            }

            public String getGoodsSetLogo() {
                return goodsSetLogo;
            }

            public void setGoodsSetLogo(String goodsSetLogo) {
                this.goodsSetLogo = goodsSetLogo;
            }

            public String getGoodsSetName() {
                return goodsSetName;
            }

            public void setGoodsSetName(String goodsSetName) {
                this.goodsSetName = goodsSetName;
            }

            public int getGoodsCommission() {
                return goodsCommission;
            }

            public void setGoodsCommission(int goodsCommission) {
                this.goodsCommission = goodsCommission;
            }

            public int getGoodsTotalCommission() {
                return goodsTotalCommission;
            }

            public void setGoodsTotalCommission(int goodsTotalCommission) {
                this.goodsTotalCommission = goodsTotalCommission;
            }

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }

            public String getOrderNumber() {
                return orderNumber;
            }

            public void setOrderNumber(String orderNumber) {
                this.orderNumber = orderNumber;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }
        }
    }
}
