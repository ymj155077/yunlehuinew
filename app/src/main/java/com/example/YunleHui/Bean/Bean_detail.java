package com.example.YunleHui.Bean;

import java.util.List;

/**
 * Created by admin on 2019/8/15 0015.
 */

public class Bean_detail {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : {"id":121,"logoUrl":"https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1108351223,4103199035&fm=26&gp=0.jpg","name":"火锅12-1","intro":"重庆火锅，又称为毛肚火锅或麻辣火锅，是中国传统饮食方式，起源于明末清初的重庆嘉陵江畔、朝天门等码头船工纤夫的粗放餐饮方式，原料主要是牛毛肚、猪黄喉、鸭肠、牛血旺等。","price":11,"originalPrice":19900,"commission":1,"verificationPrice":1900,"inventory":199,"salesVolume":100,"description":"{\"details\":[{\"placeName\":\"火锅\",\"number\":[\"http://pv38yh1qq.bkt.clouddn.com/1157262125236883456\"]}]}","posterUrl":"http://img.daimg.com/uploads/allimg/181010/1-1Q010161035.jpg","specification":"份","buyLimited":0,"goodsSetMealList":[{"id":73,"name":"121套餐一","logoUrl":"http://n.sinaimg.cn/sinacn/w640h640/20180304/6b58-fxipenm7791113.jpg","price":596415,"originalPrice":0,"commission":98,"verificationPrice":695,"stock":2},{"id":74,"name":"121套餐二","logoUrl":"http://n.sinaimg.cn/sinacn/w640h640/20180304/6b58-fxipenm7791113.jpg","price":984,"originalPrice":0,"commission":51,"verificationPrice":521,"stock":8},{"id":75,"name":"121套餐三","logoUrl":"http://n.sinaimg.cn/sinacn/w640h640/20180304/6b58-fxipenm7791113.jpg","price":9541,"originalPrice":0,"commission":9,"verificationPrice":85,"stock":10},{"id":76,"name":"121套餐四","logoUrl":"http://n.sinaimg.cn/sinacn/w640h640/20180304/6b58-fxipenm7791113.jpg","price":5156,"originalPrice":0,"commission":5691,"verificationPrice":96411,"stock":777}],"bannerUrlList":["https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1567227465219&di=5e4e852800ed51c3648570fd6ea534a2&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F013ed659f2f10ea801216a4bae1c29.jpg%401280w_1l_2o_100sh.jpg"],"shopList":[{"id":10,"logoUrl":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563536200243&di=e02853590a5836a27ac7df4f95521913&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg","name":"石桥铺核销店","intro":"店铺介绍","phone":"159028308898","address":"石桥铺西路","salesVolume":100,"distance":"11762371","price":0,"commission":0,"useTimeSlot":"0:00:00-24:00:00"},{"id":13,"logoUrl":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563536200243&di=e02853590a5836a27ac7df4f95521913&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg","name":"红旗河沟核销店","intro":"店铺介绍","phone":"18133333333","address":"红旗河沟转盘左边","salesVolume":100,"distance":"11765525","price":0,"commission":0,"useTimeSlot":"0:00:00-24:00:00"}],"shop":{"id":12,"logoUrl":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563536200243&di=e02853590a5836a27ac7df4f95521913&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg","name":"商户一","intro":"店铺介绍","phone":"15123458765","address":"花卉园北路","salesVolume":100,"distance":null,"price":0,"commission":0,"useTimeSlot":null},"preTime":0,"goodsEffectiveTime":"2019-07-31T16:00:00.000+0000","orderEffectiveTime":"2019-06-28T09:57:42.000+0000","distance":null}
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
         * id : 121
         * logoUrl : https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1108351223,4103199035&fm=26&gp=0.jpg
         * name : 火锅12-1
         * intro : 重庆火锅，又称为毛肚火锅或麻辣火锅，是中国传统饮食方式，起源于明末清初的重庆嘉陵江畔、朝天门等码头船工纤夫的粗放餐饮方式，原料主要是牛毛肚、猪黄喉、鸭肠、牛血旺等。
         * price : 11
         * originalPrice : 19900
         * commission : 1
         * verificationPrice : 1900
         * inventory : 199
         * salesVolume : 100
         * description : {"details":[{"placeName":"火锅","number":["http://pv38yh1qq.bkt.clouddn.com/1157262125236883456"]}]}
         * posterUrl : http://img.daimg.com/uploads/allimg/181010/1-1Q010161035.jpg
         * specification : 份
         * buyLimited : 0
         * goodsSetMealList : [{"id":73,"name":"121套餐一","logoUrl":"http://n.sinaimg.cn/sinacn/w640h640/20180304/6b58-fxipenm7791113.jpg","price":596415,"originalPrice":0,"commission":98,"verificationPrice":695,"stock":2},{"id":74,"name":"121套餐二","logoUrl":"http://n.sinaimg.cn/sinacn/w640h640/20180304/6b58-fxipenm7791113.jpg","price":984,"originalPrice":0,"commission":51,"verificationPrice":521,"stock":8},{"id":75,"name":"121套餐三","logoUrl":"http://n.sinaimg.cn/sinacn/w640h640/20180304/6b58-fxipenm7791113.jpg","price":9541,"originalPrice":0,"commission":9,"verificationPrice":85,"stock":10},{"id":76,"name":"121套餐四","logoUrl":"http://n.sinaimg.cn/sinacn/w640h640/20180304/6b58-fxipenm7791113.jpg","price":5156,"originalPrice":0,"commission":5691,"verificationPrice":96411,"stock":777}]
         * bannerUrlList : ["https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1567227465219&di=5e4e852800ed51c3648570fd6ea534a2&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F013ed659f2f10ea801216a4bae1c29.jpg%401280w_1l_2o_100sh.jpg"]
         * shopList : [{"id":10,"logoUrl":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563536200243&di=e02853590a5836a27ac7df4f95521913&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg","name":"石桥铺核销店","intro":"店铺介绍","phone":"159028308898","address":"石桥铺西路","salesVolume":100,"distance":"11762371","price":0,"commission":0,"useTimeSlot":"0:00:00-24:00:00"},{"id":13,"logoUrl":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563536200243&di=e02853590a5836a27ac7df4f95521913&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg","name":"红旗河沟核销店","intro":"店铺介绍","phone":"18133333333","address":"红旗河沟转盘左边","salesVolume":100,"distance":"11765525","price":0,"commission":0,"useTimeSlot":"0:00:00-24:00:00"}]
         * shop : {"id":12,"logoUrl":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563536200243&di=e02853590a5836a27ac7df4f95521913&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg","name":"商户一","intro":"店铺介绍","phone":"15123458765","address":"花卉园北路","salesVolume":100,"distance":null,"price":0,"commission":0,"useTimeSlot":null}
         * preTime : 0
         * goodsEffectiveTime : 2019-07-31T16:00:00.000+0000
         * orderEffectiveTime : 2019-06-28T09:57:42.000+0000
         * distance : null
         */

        private int id;
        private String logoUrl;
        private String name;
        private String intro;
        private int price;
        private int originalPrice;
        private int commission;
        private int verificationPrice;
        private int inventory;
        private int salesVolume;
        private String description;
        private String posterUrl;
        private String specification;
        private int buyLimited;
        private ShopBean shop;
        private int preTime;
        private String goodsEffectiveTime;
        private String orderEffectiveTime;
        private Object distance;
        private List<GoodsSetMealListBean> goodsSetMealList;
        private List<String> bannerUrlList;
        private List<ShopListBean> shopList;

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

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getOriginalPrice() {
            return originalPrice;
        }

        public void setOriginalPrice(int originalPrice) {
            this.originalPrice = originalPrice;
        }

        public int getCommission() {
            return commission;
        }

        public void setCommission(int commission) {
            this.commission = commission;
        }

        public int getVerificationPrice() {
            return verificationPrice;
        }

        public void setVerificationPrice(int verificationPrice) {
            this.verificationPrice = verificationPrice;
        }

        public int getInventory() {
            return inventory;
        }

        public void setInventory(int inventory) {
            this.inventory = inventory;
        }

        public int getSalesVolume() {
            return salesVolume;
        }

        public void setSalesVolume(int salesVolume) {
            this.salesVolume = salesVolume;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPosterUrl() {
            return posterUrl;
        }

        public void setPosterUrl(String posterUrl) {
            this.posterUrl = posterUrl;
        }

        public String getSpecification() {
            return specification;
        }

        public void setSpecification(String specification) {
            this.specification = specification;
        }

        public int getBuyLimited() {
            return buyLimited;
        }

        public void setBuyLimited(int buyLimited) {
            this.buyLimited = buyLimited;
        }

        public ShopBean getShop() {
            return shop;
        }

        public void setShop(ShopBean shop) {
            this.shop = shop;
        }

        public int getPreTime() {
            return preTime;
        }

        public void setPreTime(int preTime) {
            this.preTime = preTime;
        }

        public String getGoodsEffectiveTime() {
            return goodsEffectiveTime;
        }

        public void setGoodsEffectiveTime(String goodsEffectiveTime) {
            this.goodsEffectiveTime = goodsEffectiveTime;
        }

        public String getOrderEffectiveTime() {
            return orderEffectiveTime;
        }

        public void setOrderEffectiveTime(String orderEffectiveTime) {
            this.orderEffectiveTime = orderEffectiveTime;
        }

        public Object getDistance() {
            return distance;
        }

        public void setDistance(Object distance) {
            this.distance = distance;
        }

        public List<GoodsSetMealListBean> getGoodsSetMealList() {
            return goodsSetMealList;
        }

        public void setGoodsSetMealList(List<GoodsSetMealListBean> goodsSetMealList) {
            this.goodsSetMealList = goodsSetMealList;
        }

        public List<String> getBannerUrlList() {
            return bannerUrlList;
        }

        public void setBannerUrlList(List<String> bannerUrlList) {
            this.bannerUrlList = bannerUrlList;
        }

        public List<ShopListBean> getShopList() {
            return shopList;
        }

        public void setShopList(List<ShopListBean> shopList) {
            this.shopList = shopList;
        }

        public static class ShopBean {
            /**
             * id : 12
             * logoUrl : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563536200243&di=e02853590a5836a27ac7df4f95521913&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg
             * name : 商户一
             * intro : 店铺介绍
             * phone : 15123458765
             * address : 花卉园北路
             * salesVolume : 100
             * distance : null
             * price : 0
             * commission : 0
             * useTimeSlot : null
             */

            private int id;
            private String logoUrl;
            private String name;
            private String intro;
            private String phone;
            private String address;
            private int salesVolume;
            private Object distance;
            private int price;
            private int commission;
            private Object useTimeSlot;

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

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public int getSalesVolume() {
                return salesVolume;
            }

            public void setSalesVolume(int salesVolume) {
                this.salesVolume = salesVolume;
            }

            public Object getDistance() {
                return distance;
            }

            public void setDistance(Object distance) {
                this.distance = distance;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getCommission() {
                return commission;
            }

            public void setCommission(int commission) {
                this.commission = commission;
            }

            public Object getUseTimeSlot() {
                return useTimeSlot;
            }

            public void setUseTimeSlot(Object useTimeSlot) {
                this.useTimeSlot = useTimeSlot;
            }
        }

        public static class GoodsSetMealListBean {
            /**
             * id : 73
             * name : 121套餐一
             * logoUrl : http://n.sinaimg.cn/sinacn/w640h640/20180304/6b58-fxipenm7791113.jpg
             * price : 596415
             * originalPrice : 0
             * commission : 98
             * verificationPrice : 695
             * stock : 2
             */

            private int id;
            private String name;
            private String logoUrl;
            private int price;
            private int originalPrice;
            private int commission;
            private int verificationPrice;
            private int stock;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLogoUrl() {
                return logoUrl;
            }

            public void setLogoUrl(String logoUrl) {
                this.logoUrl = logoUrl;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getOriginalPrice() {
                return originalPrice;
            }

            public void setOriginalPrice(int originalPrice) {
                this.originalPrice = originalPrice;
            }

            public int getCommission() {
                return commission;
            }

            public void setCommission(int commission) {
                this.commission = commission;
            }

            public int getVerificationPrice() {
                return verificationPrice;
            }

            public void setVerificationPrice(int verificationPrice) {
                this.verificationPrice = verificationPrice;
            }

            public int getStock() {
                return stock;
            }

            public void setStock(int stock) {
                this.stock = stock;
            }
        }

        public static class ShopListBean {
            /**
             * id : 10
             * logoUrl : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563536200243&di=e02853590a5836a27ac7df4f95521913&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg
             * name : 石桥铺核销店
             * intro : 店铺介绍
             * phone : 159028308898
             * address : 石桥铺西路
             * salesVolume : 100
             * distance : 11762371
             * price : 0
             * commission : 0
             * useTimeSlot : 0:00:00-24:00:00
             */

            private int id;
            private String logoUrl;
            private String name;
            private String intro;
            private String phone;
            private String address;
            private int salesVolume;
            private String distance;
            private int price;
            private int commission;
            private String useTimeSlot;

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

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public int getSalesVolume() {
                return salesVolume;
            }

            public void setSalesVolume(int salesVolume) {
                this.salesVolume = salesVolume;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getCommission() {
                return commission;
            }

            public void setCommission(int commission) {
                this.commission = commission;
            }

            public String getUseTimeSlot() {
                return useTimeSlot;
            }

            public void setUseTimeSlot(String useTimeSlot) {
                this.useTimeSlot = useTimeSlot;
            }
        }
    }
}
