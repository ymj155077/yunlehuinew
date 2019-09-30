package com.example.YunleHui.Bean;

import java.util.List;

public class Bean_orderList {


    /**
     * bannerUrlList : ["https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1567227465219&di=5e4e852800ed51c3648570fd6ea534a2&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F013ed659f2f10ea801216a4bae1c29.jpg%401280w_1l_2o_100sh.jpg"]
     * buyLimited : 0
     * commission : 1
     * description : {"details":[{"placeName":"火锅","number":["http://pv38yh1qq.bkt.clouddn.com/1157262125236883456"]}]}
     * distance :
     * goodsEffectiveTime : {"date":1,"day":4,"hours":0,"minutes":0,"month":7,"seconds":0,"time":1564588800000,"timezoneOffset":-480,"year":119}
     * goodsSetMealList : [{"commission":98,"id":73,"logoUrl":"http://n.sinaimg.cn/sinacn/w640h640/20180304/6b58-fxipenm7791113.jpg","name":"121套餐一","originalPrice":0,"price":596415,"remark":"","stock":0,"verificationPrice":695},{"commission":51,"id":74,"logoUrl":"http://n.sinaimg.cn/sinacn/w640h640/20180304/6b58-fxipenm7791113.jpg","name":"121套餐二","originalPrice":0,"price":984,"remark":"","stock":7,"verificationPrice":521},{"commission":9,"id":75,"logoUrl":"http://n.sinaimg.cn/sinacn/w640h640/20180304/6b58-fxipenm7791113.jpg","name":"121套餐三","originalPrice":0,"price":9541,"remark":"","stock":10,"verificationPrice":85},{"commission":5691,"id":76,"logoUrl":"http://n.sinaimg.cn/sinacn/w640h640/20180304/6b58-fxipenm7791113.jpg","name":"121套餐四","originalPrice":0,"price":5156,"remark":"","stock":771,"verificationPrice":96411}]
     * id : 121
     * intro : 重庆火锅，又称为毛肚火锅或麻辣火锅，是中国传统饮食方式，起源于明末清初的重庆嘉陵江畔、朝天门等码头船工纤夫的粗放餐饮方式，原料主要是牛毛肚、猪黄喉、鸭肠、牛血旺等。
     * inventory : 190
     * logoUrl : https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1108351223,4103199035&fm=26&gp=0.jpg
     * name : 火锅12-1
     * orderEffectiveTime : {"date":28,"day":5,"hours":17,"minutes":57,"month":5,"seconds":42,"time":1561715862000,"timezoneOffset":-480,"year":119}
     * originalPrice : 19900
     * posterUrl : http://img.daimg.com/uploads/allimg/181010/1-1Q010161035.jpg
     * preTime : 0
     * price : 11
     * salesVolume : 100
     * shop : {"address":"花卉园北路","commission":0,"distance":"","id":12,"intro":"店铺介绍","logoUrl":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563536200243&di=e02853590a5836a27ac7df4f95521913&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg","name":"商户一","phone":"15123458765","price":0,"salesVolume":100,"useTimeSlot":""}
     * shopList : [{"address":"石桥铺西路","commission":0,"distance":"11762371","id":10,"intro":"店铺介绍","logoUrl":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563536200243&di=e02853590a5836a27ac7df4f95521913&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg","name":"石桥铺核销店","phone":"159028308898","price":0,"salesVolume":100,"useTimeSlot":"0:00:00-24:00:00"},{"address":"红旗河沟转盘左边","commission":0,"distance":"11765525","id":13,"intro":"店铺介绍","logoUrl":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563536200243&di=e02853590a5836a27ac7df4f95521913&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg","name":"红旗河沟核销店","phone":"18133333333","price":0,"salesVolume":100,"useTimeSlot":"0:00:00-24:00:00"}]
     * specification : 份
     * verificationPrice : 1900
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
         * month : 7
         * seconds : 0
         * time : 1564588800000
         * timezoneOffset : -480
         * year : 119
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
         * date : 28
         * day : 5
         * hours : 17
         * minutes : 57
         * month : 5
         * seconds : 42
         * time : 1561715862000
         * timezoneOffset : -480
         * year : 119
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
         * address : 花卉园北路
         * commission : 0
         * distance :
         * id : 12
         * intro : 店铺介绍
         * logoUrl : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563536200243&di=e02853590a5836a27ac7df4f95521913&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg
         * name : 商户一
         * phone : 15123458765
         * price : 0
         * salesVolume : 100
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
         * commission : 98
         * id : 73
         * logoUrl : http://n.sinaimg.cn/sinacn/w640h640/20180304/6b58-fxipenm7791113.jpg
         * name : 121套餐一
         * originalPrice : 0
         * price : 596415
         * remark :
         * stock : 0
         * verificationPrice : 695
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
         * address : 石桥铺西路
         * commission : 0
         * distance : 11762371
         * id : 10
         * intro : 店铺介绍
         * logoUrl : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563536200243&di=e02853590a5836a27ac7df4f95521913&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg
         * name : 石桥铺核销店
         * phone : 159028308898
         * price : 0
         * salesVolume : 100
         * useTimeSlot : 0:00:00-24:00:00
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
