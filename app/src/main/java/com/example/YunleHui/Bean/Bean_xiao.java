package com.example.YunleHui.Bean;

import java.io.Serializable;

public class Bean_xiao implements Serializable {


    /**
     * shopName : 麒麟店铺
     * id : 381
     * startTime : 00:00
     * endTime : 24:00
     */

    private String shopName;
    private String id;
    private String startTime;
    private String endTime;

    public Bean_xiao(String shopName, String id, String startTime, String endTime) {
        this.shopName = shopName;
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
