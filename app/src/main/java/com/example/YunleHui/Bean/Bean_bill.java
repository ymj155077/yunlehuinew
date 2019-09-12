package com.example.YunleHui.Bean;

import java.util.List;

/**
 * Created by admin on 2019/8/23 0023.
 */

public class Bean_bill {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : {"totalCount":5,"voList":[{"id":62,"userId":20,"tradeAmount":984,"poundage":0,"inOut":0,"tradeType":4,"extraNo":"8","tradeTime":"2019-08-20T09:03:00.000+0000","tradeDesc":"退款至余额【火锅12-1(大事发生)金额:984】"},{"id":61,"userId":20,"tradeAmount":984,"poundage":0,"inOut":1,"tradeType":1,"extraNo":"132","tradeTime":"2019-08-20T08:20:21.000+0000","tradeDesc":"支付【火锅12-1(大事发生)金额:984】"},{"id":59,"userId":20,"tradeAmount":9541,"poundage":0,"inOut":1,"tradeType":1,"extraNo":"131","tradeTime":"2019-08-20T02:31:20.000+0000","tradeDesc":"支付【火锅12-1(打算)金额:9541】"},{"id":57,"userId":20,"tradeAmount":984,"poundage":0,"inOut":1,"tradeType":1,"extraNo":"129","tradeTime":"2019-08-20T02:27:18.000+0000","tradeDesc":"支付【火锅12-1(大事发生)金额:984】"},{"id":55,"userId":20,"tradeAmount":9541,"poundage":0,"inOut":1,"tradeType":1,"extraNo":"128","tradeTime":"2019-08-20T02:23:24.000+0000","tradeDesc":"支付【火锅12-1(打算)金额:9541】"}],"totalIncome":21050,"totalExpenditure":0}
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
         * totalCount : 5
         * voList : [{"id":62,"userId":20,"tradeAmount":984,"poundage":0,"inOut":0,"tradeType":4,"extraNo":"8","tradeTime":"2019-08-20T09:03:00.000+0000","tradeDesc":"退款至余额【火锅12-1(大事发生)金额:984】"},{"id":61,"userId":20,"tradeAmount":984,"poundage":0,"inOut":1,"tradeType":1,"extraNo":"132","tradeTime":"2019-08-20T08:20:21.000+0000","tradeDesc":"支付【火锅12-1(大事发生)金额:984】"},{"id":59,"userId":20,"tradeAmount":9541,"poundage":0,"inOut":1,"tradeType":1,"extraNo":"131","tradeTime":"2019-08-20T02:31:20.000+0000","tradeDesc":"支付【火锅12-1(打算)金额:9541】"},{"id":57,"userId":20,"tradeAmount":984,"poundage":0,"inOut":1,"tradeType":1,"extraNo":"129","tradeTime":"2019-08-20T02:27:18.000+0000","tradeDesc":"支付【火锅12-1(大事发生)金额:984】"},{"id":55,"userId":20,"tradeAmount":9541,"poundage":0,"inOut":1,"tradeType":1,"extraNo":"128","tradeTime":"2019-08-20T02:23:24.000+0000","tradeDesc":"支付【火锅12-1(打算)金额:9541】"}]
         * totalIncome : 21050
         * totalExpenditure : 0
         */

        private int totalCount;
        private int totalIncome;
        private int totalExpenditure;
        private List<VoListBean> voList;

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getTotalIncome() {
            return totalIncome;
        }

        public void setTotalIncome(int totalIncome) {
            this.totalIncome = totalIncome;
        }

        public int getTotalExpenditure() {
            return totalExpenditure;
        }

        public void setTotalExpenditure(int totalExpenditure) {
            this.totalExpenditure = totalExpenditure;
        }

        public List<VoListBean> getVoList() {
            return voList;
        }

        public void setVoList(List<VoListBean> voList) {
            this.voList = voList;
        }

        public static class VoListBean {
            /**
             * id : 62
             * userId : 20
             * tradeAmount : 984
             * poundage : 0
             * inOut : 0
             * tradeType : 4
             * extraNo : 8
             * tradeTime : 2019-08-20T09:03:00.000+0000
             * tradeDesc : 退款至余额【火锅12-1(大事发生)金额:984】
             */

            private int id;
            private int userId;
            private int tradeAmount;
            private int poundage;
            private int inOut;
            private int tradeType;
            private String extraNo;
            private String tradeTime;
            private String tradeDesc;

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

            public String getExtraNo() {
                return extraNo;
            }

            public void setExtraNo(String extraNo) {
                this.extraNo = extraNo;
            }

            public String getTradeTime() {
                return tradeTime;
            }

            public void setTradeTime(String tradeTime) {
                this.tradeTime = tradeTime;
            }

            public String getTradeDesc() {
                return tradeDesc;
            }

            public void setTradeDesc(String tradeDesc) {
                this.tradeDesc = tradeDesc;
            }
        }
    }
}
