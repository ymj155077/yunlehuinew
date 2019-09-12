package com.example.YunleHui.Bean;

import java.util.List;

/**
 * Created by admin on 2019/8/27 0027.
 */

public class Bean_you {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : [{"id":410522,"areaName":"安阳县","remark":"河南省"},{"id":410503,"areaName":"北关区","remark":"河南省"},{"id":410526,"areaName":"滑县","remark":"河南省"},{"id":410581,"areaName":"林州市","remark":"河南省"},{"id":410506,"areaName":"龙安区","remark":"河南省"},{"id":410527,"areaName":"内黄县","remark":"河南省"},{"id":410501,"areaName":"市辖区","remark":"河南省"},{"id":410523,"areaName":"汤阴县","remark":"河南省"},{"id":410502,"areaName":"文峰区","remark":"河南省"},{"id":410505,"areaName":"殷都区","remark":"河南省"}]
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
         * id : 410522
         * areaName : 安阳县
         * remark : 河南省
         */

        private int id;
        private String areaName;
        private String remark;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
