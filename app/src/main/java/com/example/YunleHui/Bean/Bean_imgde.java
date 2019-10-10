package com.example.YunleHui.Bean;

public class Bean_imgde {



    private String img;
    private int number;
    private int pai;

    public int getPai() {
        return pai;
    }

    public Bean_imgde(String img, int number, int pai) {
        this.img = img;
        this.number = number;
        this.pai = pai;
    }

    public void setPai(int pai) {
        this.pai = pai;
    }



    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
