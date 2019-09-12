package com.example.YunleHui.Bean;

import java.util.List;

/**
 * Created by admin on 2019/8/27 0027.
 */

public class Bean_list {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : [{"id":500113,"areaName":"巴南区","remark":"重庆市"},{"id":500109,"areaName":"北碚区","remark":"重庆市"},{"id":500120,"areaName":"璧山区","remark":"重庆市"},{"id":500115,"areaName":"长寿区","remark":"重庆市"},{"id":500229,"areaName":"城口县","remark":"重庆市"},{"id":500104,"areaName":"大渡口区","remark":"重庆市"},{"id":500111,"areaName":"大足区","remark":"重庆市"},{"id":500231,"areaName":"垫江县","remark":"重庆市"},{"id":500230,"areaName":"丰都县","remark":"重庆市"},{"id":500236,"areaName":"奉节县","remark":"重庆市"},{"id":500102,"areaName":"涪陵区","remark":"重庆市"},{"id":500117,"areaName":"合川区","remark":"重庆市"},{"id":500105,"areaName":"江北区","remark":"重庆市"},{"id":500116,"areaName":"江津区","remark":"重庆市"},{"id":500107,"areaName":"九龙坡区","remark":"重庆市"},{"id":500154,"areaName":"开州区","remark":"重庆市"},{"id":500228,"areaName":"梁平县","remark":"重庆市"},{"id":500108,"areaName":"南岸区","remark":"重庆市"},{"id":500119,"areaName":"南川区","remark":"重庆市"},{"id":500243,"areaName":"彭水苗族土家族自治县","remark":"重庆市"},{"id":500110,"areaName":"綦江区","remark":"重庆市"},{"id":500114,"areaName":"黔江区","remark":"重庆市"},{"id":500153,"areaName":"荣昌区","remark":"重庆市"},{"id":500106,"areaName":"沙坪坝区","remark":"重庆市"},{"id":500240,"areaName":"石柱土家族自治县","remark":"重庆市"},{"id":500151,"areaName":"铜梁区","remark":"重庆市"},{"id":500152,"areaName":"潼南区","remark":"重庆市"},{"id":500101,"areaName":"万州区","remark":"重庆市"},{"id":500237,"areaName":"巫山县","remark":"重庆市"},{"id":500238,"areaName":"巫溪县","remark":"重庆市"},{"id":500232,"areaName":"武隆县","remark":"重庆市"},{"id":500241,"areaName":"秀山土家族苗族自治县","remark":"重庆市"},{"id":500118,"areaName":"永川区","remark":"重庆市"},{"id":500242,"areaName":"酉阳土家族苗族自治县","remark":"重庆市"},{"id":500112,"areaName":"渝北区","remark":"重庆市"},{"id":500103,"areaName":"渝中区","remark":"重庆市"},{"id":500235,"areaName":"云阳县","remark":"重庆市"},{"id":500233,"areaName":"忠县","remark":"重庆市"}]
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
         * id : 500113
         * areaName : 巴南区
         * remark : 重庆市
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
