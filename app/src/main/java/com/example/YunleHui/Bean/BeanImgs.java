package com.example.YunleHui.Bean;

import com.luck.picture.lib.entity.LocalMedia;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class BeanImgs {

    private String details;

    private List<LocalMedia> imgs;


    private String Originalprice ;

    private String Presentprice;

    private String Commission;

    private String Settlementprice;

    private String Stock;

    public BeanImgs(String details, List<LocalMedia> imgs, String originalprice, String presentprice, String commission, String settlementprice, String stock) {
        this.details = details;
        this.imgs = imgs;
        this.Originalprice = originalprice;
        this.Presentprice = presentprice;
        this.Commission = commission;
        this.Settlementprice = settlementprice;
        this.Stock = stock;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getOriginalprice() {
        return Originalprice;
    }

    public void setOriginalprice(String originalprice) {
        Originalprice = originalprice;
    }

    public String getPresentprice() {
        return Presentprice;
    }

    public void setPresentprice(String presentprice) {
        Presentprice = presentprice;
    }

    public String getCommission() {
        return Commission;
    }

    public void setCommission(String commission) {
        Commission = commission;
    }

    public String getSettlementprice() {
        return Settlementprice;
    }

    public void setSettlementprice(String settlementprice) {
        Settlementprice = settlementprice;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String stock) {
        Stock = stock;
    }

    public List<LocalMedia> getImgs() {
        return imgs;
    }

    public void setImgs(List<LocalMedia> imgs) {
        this.imgs = imgs;
    }

    public BeanImgs(List<LocalMedia> imgs){
        this.imgs = imgs;
    }



}
