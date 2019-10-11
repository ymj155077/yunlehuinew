package com.example.YunleHui.Bean;

public class Bean_xiang {


    private String img;
    private String shopName;
    private String context;

    public Bean_xiang(String img, String shopName, String context, String price) {
        this.img = img;
        this.shopName = shopName;
        this.context = context;
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String price;


}
