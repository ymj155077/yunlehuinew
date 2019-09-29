package com.example.YunleHui.Bean;

public class BeanWechat {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : {"id":49,"payType":0,"userId":2,"userOpenId":"","orderId":0,"payDes":"微信支付【火锅12-1金额：0.01元】","payNum":"1177415777901481984","totalAmount":1,"tradeType":"APP","sign":"FB776EA857B77E8F245C7E001219E931","prepayJson":"{\"timeStamp\":\"1569552771\",\"packageValue\":\"Sign=WXPay\",\"appId\":\"wx4cf62a0fc2261a00\",\"sign\":\"FB776EA857B77E8F245C7E001219E931\",\"prepayId\":\"wx27105250584591493a8fd3de1201103300\",\"partnerId\":\"1513615711\",\"nonceStr\":\"1569552771905\"}"}
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
         * id : 49
         * payType : 0
         * userId : 2
         * userOpenId :
         * orderId : 0
         * payDes : 微信支付【火锅12-1金额：0.01元】
         * payNum : 1177415777901481984
         * totalAmount : 1
         * tradeType : APP
         * sign : FB776EA857B77E8F245C7E001219E931
         * prepayJson : {"timeStamp":"1569552771","packageValue":"Sign=WXPay","appId":"wx4cf62a0fc2261a00","sign":"FB776EA857B77E8F245C7E001219E931","prepayId":"wx27105250584591493a8fd3de1201103300","partnerId":"1513615711","nonceStr":"1569552771905"}
         */

        private int id;
        private int payType;
        private int userId;
        private String userOpenId;
        private int orderId;
        private String payDes;
        private String payNum;
        private int totalAmount;
        private String tradeType;
        private String sign;
        private String prepayJson;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPayType() {
            return payType;
        }

        public void setPayType(int payType) {
            this.payType = payType;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserOpenId() {
            return userOpenId;
        }

        public void setUserOpenId(String userOpenId) {
            this.userOpenId = userOpenId;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public String getPayDes() {
            return payDes;
        }

        public void setPayDes(String payDes) {
            this.payDes = payDes;
        }

        public String getPayNum() {
            return payNum;
        }

        public void setPayNum(String payNum) {
            this.payNum = payNum;
        }

        public int getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(int totalAmount) {
            this.totalAmount = totalAmount;
        }

        public String getTradeType() {
            return tradeType;
        }

        public void setTradeType(String tradeType) {
            this.tradeType = tradeType;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getPrepayJson() {
            return prepayJson;
        }

        public void setPrepayJson(String prepayJson) {
            this.prepayJson = prepayJson;
        }
    }
}
