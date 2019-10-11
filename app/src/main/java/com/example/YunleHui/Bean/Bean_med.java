package com.example.YunleHui.Bean;

import java.util.List;

public class Bean_med {


    /**
     * bannerUrlList : ["http://pz4yvu336.bkt.clouddn.com/1182116315096289280,http://pz4yvu336.bkt.clouddn.com/1182116308511232000,http://pz4yvu336.bkt.clouddn.com/1182122682163007488"]
     * buyLimited : 0
     * commission : 18000
     * description : [{"number":"http://pz4yvu336.bkt.clouddn.com/1182116308511232000,http://pz4yvu336.bkt.clouddn.com/1182122672465776640","placeName":"大家觉得打击盗版"},{"number":"http://pz4yvu336.bkt.clouddn.com/1182116318078439424,http://pz4yvu336.bkt.clouddn.com/1182143237863903232,http://pz4yvu336.bkt.clouddn.com/1182478743810215936","placeName":"大家觉得打击盗版"}]
     * distance :
     * goodsEffectiveTime : {"date":1,"day":4,"hours":0,"minutes":0,"month":0,"seconds":0,"time":883584000000,"timezoneOffset":-480,"year":98}
     * goodsSetMealList : [{"commission":1000,"id":182,"logoUrl":"http://pz4yvu336.bkt.clouddn.com/1182132249898913792","name":"","originalPrice":11000,"price":64000,"remark":"奖学金打家劫舍","stock":76,"verificationPrice":1000},{"commission":18000,"id":183,"logoUrl":"http://pz4yvu336.bkt.clouddn.com/1182143237863903232","name":"","originalPrice":99000,"price":45000,"remark":"DJ记得记得就","stock":99,"verificationPrice":1000}]
     * id : 668
     * intro : 加到几点回电话
     * inventory : 175
     * logoUrl : http://pz4yvu336.bkt.clouddn.com/1182116315096289280
     * name : 僵尸叔叔
     * orderEffectiveTime : {"date":1,"day":3,"hours":0,"minutes":0,"month":7,"seconds":0,"time":649436400000,"timezoneOffset":-540,"year":90}
     * originalPrice : 11000
     * posterUrl : http://pz4yvu336.bkt.clouddn.com/1182122676785909760
     * preTime : 9
     * price : 45000
     * salesVolume : 0
     * shop : {"address":"李付款呢肥牛饭","commission":0,"distance":"","id":385,"intro":"","logoUrl":"http://pz4yvu336.bkt.clouddn.com/1182113906835984384","name":"🎣️⛸️🚣️🏂️🏊️🏈️","phone":"18725621750","price":0,"salesVolume":0,"useTimeSlot":""}
     * shopList : [{"address":"李付款呢肥牛饭","commission":0,"distance":"157426","id":385,"intro":"","logoUrl":"http://pz4yvu336.bkt.clouddn.com/1182113906835984384","name":"🎣️⛸️🚣️🏂️🏊️🏈️","phone":"18725621750","price":0,"salesVolume":0,"useTimeSlot":"0:00:00-0:00:00"}]
     * specification : 件
     * verificationPrice : 0
     */

    private int buyLimited;
    private int commission;
    private String description;
    private String distance;
    private GoodsEffectiveTimeBean goodsEffectiveTime;
    private int id;
    private String intro;
    private int inventory;
    private String logoUrl;
    private String name;
    private OrderEffectiveTimeBean orderEffectiveTime;
    private int originalPrice;
    private String posterUrl;
    private int preTime;
    private int price;
    private int salesVolume;
    private ShopBean shop;
    private String specification;
    private int verificationPrice;
    private List<String> bannerUrlList;
    private List<GoodsSetMealListBean> goodsSetMealList;
    private List<ShopListBean> shopList;

    public int getBuyLimited() {
        return buyLimited;
    }

    public void setBuyLimited(int buyLimited) {
        this.buyLimited = buyLimited;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public GoodsEffectiveTimeBean getGoodsEffectiveTime() {
        return goodsEffectiveTime;
    }

    public void setGoodsEffectiveTime(GoodsEffectiveTimeBean goodsEffectiveTime) {
        this.goodsEffectiveTime = goodsEffectiveTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrderEffectiveTimeBean getOrderEffectiveTime() {
        return orderEffectiveTime;
    }

    public void setOrderEffectiveTime(OrderEffectiveTimeBean orderEffectiveTime) {
        this.orderEffectiveTime = orderEffectiveTime;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public int getPreTime() {
        return preTime;
    }

    public void setPreTime(int preTime) {
        this.preTime = preTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(int salesVolume) {
        this.salesVolume = salesVolume;
    }

    public ShopBean getShop() {
        return shop;
    }

    public void setShop(ShopBean shop) {
        this.shop = shop;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public int getVerificationPrice() {
        return verificationPrice;
    }

    public void setVerificationPrice(int verificationPrice) {
        this.verificationPrice = verificationPrice;
    }

    public List<String> getBannerUrlList() {
        return bannerUrlList;
    }

    public void setBannerUrlList(List<String> bannerUrlList) {
        this.bannerUrlList = bannerUrlList;
    }

    public List<GoodsSetMealListBean> getGoodsSetMealList() {
        return goodsSetMealList;
    }

    public void setGoodsSetMealList(List<GoodsSetMealListBean> goodsSetMealList) {
        this.goodsSetMealList = goodsSetMealList;
    }

    public List<ShopListBean> getShopList() {
        return shopList;
    }

    public void setShopList(List<ShopListBean> shopList) {
        this.shopList = shopList;
    }

    public static class GoodsEffectiveTimeBean {
        /**
         * date : 1
         * day : 4
         * hours : 0
         * minutes : 0
         * month : 0
         * seconds : 0
         * time : 883584000000
         * timezoneOffset : -480
         * year : 98
         */

        private int date;
        private int day;
        private int hours;
        private int minutes;
        private int month;
        private int seconds;
        private long time;
        private int timezoneOffset;
        private int year;

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public int getHours() {
            return hours;
        }

        public void setHours(int hours) {
            this.hours = hours;
        }

        public int getMinutes() {
            return minutes;
        }

        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getSeconds() {
            return seconds;
        }

        public void setSeconds(int seconds) {
            this.seconds = seconds;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public int getTimezoneOffset() {
            return timezoneOffset;
        }

        public void setTimezoneOffset(int timezoneOffset) {
            this.timezoneOffset = timezoneOffset;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }
    }

    public static class OrderEffectiveTimeBean {
        /**
         * date : 1
         * day : 3
         * hours : 0
         * minutes : 0
         * month : 7
         * seconds : 0
         * time : 649436400000
         * timezoneOffset : -540
         * year : 90
         */

        private int date;
        private int day;
        private int hours;
        private int minutes;
        private int month;
        private int seconds;
        private long time;
        private int timezoneOffset;
        private int year;

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public int getHours() {
            return hours;
        }

        public void setHours(int hours) {
            this.hours = hours;
        }

        public int getMinutes() {
            return minutes;
        }

        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getSeconds() {
            return seconds;
        }

        public void setSeconds(int seconds) {
            this.seconds = seconds;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public int getTimezoneOffset() {
            return timezoneOffset;
        }

        public void setTimezoneOffset(int timezoneOffset) {
            this.timezoneOffset = timezoneOffset;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }
    }

    public static class ShopBean {
        /**
         * address : 李付款呢肥牛饭
         * commission : 0
         * distance :
         * id : 385
         * intro :
         * logoUrl : http://pz4yvu336.bkt.clouddn.com/1182113906835984384
         * name : 🎣️⛸️🚣️🏂️🏊️🏈️
         * phone : 18725621750
         * price : 0
         * salesVolume : 0
         * useTimeSlot :
         */

        private String address;
        private int commission;
        private String distance;
        private int id;
        private String intro;
        private String logoUrl;
        private String name;
        private String phone;
        private int price;
        private int salesVolume;
        private String useTimeSlot;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getCommission() {
            return commission;
        }

        public void setCommission(int commission) {
            this.commission = commission;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getSalesVolume() {
            return salesVolume;
        }

        public void setSalesVolume(int salesVolume) {
            this.salesVolume = salesVolume;
        }

        public String getUseTimeSlot() {
            return useTimeSlot;
        }

        public void setUseTimeSlot(String useTimeSlot) {
            this.useTimeSlot = useTimeSlot;
        }
    }

    public static class GoodsSetMealListBean {
        /**
         * commission : 1000
         * id : 182
         * logoUrl : http://pz4yvu336.bkt.clouddn.com/1182132249898913792
         * name :
         * originalPrice : 11000
         * price : 64000
         * remark : 奖学金打家劫舍
         * stock : 76
         * verificationPrice : 1000
         */

        private int commission;
        private int id;
        private String logoUrl;
        private String name;
        private int originalPrice;
        private int price;
        private String remark;
        private int stock;
        private int verificationPrice;

        public int getCommission() {
            return commission;
        }

        public void setCommission(int commission) {
            this.commission = commission;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOriginalPrice() {
            return originalPrice;
        }

        public void setOriginalPrice(int originalPrice) {
            this.originalPrice = originalPrice;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public int getVerificationPrice() {
            return verificationPrice;
        }

        public void setVerificationPrice(int verificationPrice) {
            this.verificationPrice = verificationPrice;
        }
    }

    public static class ShopListBean {
        /**
         * address : 李付款呢肥牛饭
         * commission : 0
         * distance : 157426
         * id : 385
         * intro :
         * logoUrl : http://pz4yvu336.bkt.clouddn.com/1182113906835984384
         * name : 🎣️⛸️🚣️🏂️🏊️🏈️
         * phone : 18725621750
         * price : 0
         * salesVolume : 0
         * useTimeSlot : 0:00:00-0:00:00
         */

        private String address;
        private int commission;
        private String distance;
        private int id;
        private String intro;
        private String logoUrl;
        private String name;
        private String phone;
        private int price;
        private int salesVolume;
        private String useTimeSlot;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getCommission() {
            return commission;
        }

        public void setCommission(int commission) {
            this.commission = commission;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getSalesVolume() {
            return salesVolume;
        }

        public void setSalesVolume(int salesVolume) {
            this.salesVolume = salesVolume;
        }

        public String getUseTimeSlot() {
            return useTimeSlot;
        }

        public void setUseTimeSlot(String useTimeSlot) {
            this.useTimeSlot = useTimeSlot;
        }
    }
}
