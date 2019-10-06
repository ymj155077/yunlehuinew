package com.example.YunleHui.Bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.luck.picture.lib.entity.LocalMedia;

import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class BeanImgs implements Parcelable {

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


    protected BeanImgs(Parcel in) {
        details = in.readString();
        imgs = in.createTypedArrayList(LocalMedia.CREATOR);
        Originalprice = in.readString();
        Presentprice = in.readString();
        Commission = in.readString();
        Settlementprice = in.readString();
        Stock = in.readString();
    }


    public static final Creator<BeanImgs> CREATOR = new Creator<BeanImgs>() {
        @Override
        public BeanImgs createFromParcel(Parcel in) {
            return new BeanImgs(in);
        }

        @Override
        public BeanImgs[] newArray(int size) {
            return new BeanImgs[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(details);
        parcel.writeTypedList(imgs);
        parcel.writeString(Originalprice);
        parcel.writeString(Presentprice);
        parcel.writeString(Commission);
        parcel.writeString(Settlementprice);
        parcel.writeString(Stock);
    }
}
