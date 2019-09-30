package com.example.YunleHui.Bean;

import java.util.List;

public class Bean_shequ {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : {"lastCommunityInfo":null,"communityInfoCollection":{"totalCount":100,"entityList":[{"id":5,"communityName":"新欧鹏教育城","communityAddress":"江北区江北嘴鲁溉路(中央公园旁)","sortNum":0,"description":"社区代理:尹国红","logoUrl":"https://file.aicenyi.com/iconbb2ee733-51d1-480e-b94a-9621c00f86c31548925475954.jpg","tel":"17726638949","state":1,"longitude":106.5732,"latitude":29.59,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0},{"id":6,"communityName":"珊瑚水岸","communityAddress":"重庆市南岸区南滨路28号","sortNum":0,"description":"社区代理:王浩","logoUrl":"https://file.aicenyi.com/icon69e2c5ee-2c85-4e83-adb2-5506209866c51548924684091.jpg","tel":"13883345634","state":1,"longitude":106.57493,"latitude":29.53985,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0},{"id":7,"communityName":"天龙广场三期","communityAddress":"南坪宏声路35号","sortNum":0,"description":"社区代理:张波","logoUrl":"https://file.aicenyi.com/icon878380e6-d580-401a-974a-ed46fce525a21549000603401.jpg","tel":"13827658820","state":1,"longitude":106.570107,"latitude":29.531195,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0},{"id":8,"communityName":"星宇花园","communityAddress":"南坪东路11号","sortNum":0,"description":"社区代理:张伯","logoUrl":"https://file.aicenyi.com/iconbf2699e2-f7ba-416b-b319-1a557cf9de171548924806365.jpg","tel":"13877632190","state":1,"longitude":106.571002,"latitude":29.529924,"del":0,"returnPercentage":1000,"openId":"oCZVp1Cbrtd_BOHE_uhpPd11gpvY","wechatLogin":0,"areaCode":"500000","distance":0},{"id":9,"communityName":"天龙城市花园","communityAddress":"南坪正街1号","sortNum":0,"description":"社区代理:张薇","logoUrl":"https://file.aicenyi.com/icon5658d531-2a33-4cb4-9adc-ee4934a2bafb1549000795342.jpg","tel":"13965784967","state":1,"longitude":106.568283,"latitude":29.530665,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0},{"id":10,"communityName":"恒大滨河左岸","communityAddress":"南岸区长生镇长生雅苑旁","sortNum":0,"description":"社区代理:周宇","logoUrl":"https://file.aicenyi.com/icon799d1c07-033b-45a5-9d6e-ff7385d77bd21549001986016.jpg","tel":"13967426627","state":1,"longitude":106.67188,"latitude":29.508272,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0},{"id":11,"communityName":"同景国际城W组团","communityAddress":"茶园丁香路1号","sortNum":0,"description":"社区代理:李好","logoUrl":"https://file.aicenyi.com/icon50ca2d47-5857-47ae-afb8-502dcc689ff41548926014611.jpg","tel":"15625478906","state":1,"longitude":106.65596,"latitude":29.50291,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0},{"id":12,"communityName":"同景国际城香溪迈上","communityAddress":"重庆市南岸区月季路","sortNum":0,"description":"社区代理:李霞","logoUrl":"https://file.aicenyi.com/icondd261124-a514-49ef-826b-d5d15dd498c81548926157739.jpg","tel":"15625492201","state":1,"longitude":106.648877,"latitude":29.490292,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0},{"id":13,"communityName":"融创伊顿庄园","communityAddress":"茶园米兰路38号","sortNum":0,"description":"社区代理:陈杰","logoUrl":"https://file.aicenyi.com/iconbec4d168-dbe9-4b0a-aebd-3663b99226a31549000950725.jpg","tel":"15936452301","state":1,"longitude":106.62511,"latitude":29.47258,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0},{"id":14,"communityName":"光华安纳溪湖","communityAddress":"南岸区米兰路","sortNum":0,"description":"社区代理:陈东","logoUrl":"https://file.aicenyi.com/icon4feb4d35-256b-4873-bd49-f85416f00fff1548926321890.jpg","tel":"15944567893","state":1,"longitude":106.63064,"latitude":29.48043,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0}]}}
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
         * lastCommunityInfo : null
         * communityInfoCollection : {"totalCount":100,"entityList":[{"id":5,"communityName":"新欧鹏教育城","communityAddress":"江北区江北嘴鲁溉路(中央公园旁)","sortNum":0,"description":"社区代理:尹国红","logoUrl":"https://file.aicenyi.com/iconbb2ee733-51d1-480e-b94a-9621c00f86c31548925475954.jpg","tel":"17726638949","state":1,"longitude":106.5732,"latitude":29.59,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0},{"id":6,"communityName":"珊瑚水岸","communityAddress":"重庆市南岸区南滨路28号","sortNum":0,"description":"社区代理:王浩","logoUrl":"https://file.aicenyi.com/icon69e2c5ee-2c85-4e83-adb2-5506209866c51548924684091.jpg","tel":"13883345634","state":1,"longitude":106.57493,"latitude":29.53985,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0},{"id":7,"communityName":"天龙广场三期","communityAddress":"南坪宏声路35号","sortNum":0,"description":"社区代理:张波","logoUrl":"https://file.aicenyi.com/icon878380e6-d580-401a-974a-ed46fce525a21549000603401.jpg","tel":"13827658820","state":1,"longitude":106.570107,"latitude":29.531195,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0},{"id":8,"communityName":"星宇花园","communityAddress":"南坪东路11号","sortNum":0,"description":"社区代理:张伯","logoUrl":"https://file.aicenyi.com/iconbf2699e2-f7ba-416b-b319-1a557cf9de171548924806365.jpg","tel":"13877632190","state":1,"longitude":106.571002,"latitude":29.529924,"del":0,"returnPercentage":1000,"openId":"oCZVp1Cbrtd_BOHE_uhpPd11gpvY","wechatLogin":0,"areaCode":"500000","distance":0},{"id":9,"communityName":"天龙城市花园","communityAddress":"南坪正街1号","sortNum":0,"description":"社区代理:张薇","logoUrl":"https://file.aicenyi.com/icon5658d531-2a33-4cb4-9adc-ee4934a2bafb1549000795342.jpg","tel":"13965784967","state":1,"longitude":106.568283,"latitude":29.530665,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0},{"id":10,"communityName":"恒大滨河左岸","communityAddress":"南岸区长生镇长生雅苑旁","sortNum":0,"description":"社区代理:周宇","logoUrl":"https://file.aicenyi.com/icon799d1c07-033b-45a5-9d6e-ff7385d77bd21549001986016.jpg","tel":"13967426627","state":1,"longitude":106.67188,"latitude":29.508272,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0},{"id":11,"communityName":"同景国际城W组团","communityAddress":"茶园丁香路1号","sortNum":0,"description":"社区代理:李好","logoUrl":"https://file.aicenyi.com/icon50ca2d47-5857-47ae-afb8-502dcc689ff41548926014611.jpg","tel":"15625478906","state":1,"longitude":106.65596,"latitude":29.50291,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0},{"id":12,"communityName":"同景国际城香溪迈上","communityAddress":"重庆市南岸区月季路","sortNum":0,"description":"社区代理:李霞","logoUrl":"https://file.aicenyi.com/icondd261124-a514-49ef-826b-d5d15dd498c81548926157739.jpg","tel":"15625492201","state":1,"longitude":106.648877,"latitude":29.490292,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0},{"id":13,"communityName":"融创伊顿庄园","communityAddress":"茶园米兰路38号","sortNum":0,"description":"社区代理:陈杰","logoUrl":"https://file.aicenyi.com/iconbec4d168-dbe9-4b0a-aebd-3663b99226a31549000950725.jpg","tel":"15936452301","state":1,"longitude":106.62511,"latitude":29.47258,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0},{"id":14,"communityName":"光华安纳溪湖","communityAddress":"南岸区米兰路","sortNum":0,"description":"社区代理:陈东","logoUrl":"https://file.aicenyi.com/icon4feb4d35-256b-4873-bd49-f85416f00fff1548926321890.jpg","tel":"15944567893","state":1,"longitude":106.63064,"latitude":29.48043,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0}]}
         */

        private Object lastCommunityInfo;
        private CommunityInfoCollectionBean communityInfoCollection;

        public Object getLastCommunityInfo() {
            return lastCommunityInfo;
        }

        public void setLastCommunityInfo(Object lastCommunityInfo) {
            this.lastCommunityInfo = lastCommunityInfo;
        }

        public CommunityInfoCollectionBean getCommunityInfoCollection() {
            return communityInfoCollection;
        }

        public void setCommunityInfoCollection(CommunityInfoCollectionBean communityInfoCollection) {
            this.communityInfoCollection = communityInfoCollection;
        }

        public static class CommunityInfoCollectionBean {
            /**
             * totalCount : 100
             * entityList : [{"id":5,"communityName":"新欧鹏教育城","communityAddress":"江北区江北嘴鲁溉路(中央公园旁)","sortNum":0,"description":"社区代理:尹国红","logoUrl":"https://file.aicenyi.com/iconbb2ee733-51d1-480e-b94a-9621c00f86c31548925475954.jpg","tel":"17726638949","state":1,"longitude":106.5732,"latitude":29.59,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0},{"id":6,"communityName":"珊瑚水岸","communityAddress":"重庆市南岸区南滨路28号","sortNum":0,"description":"社区代理:王浩","logoUrl":"https://file.aicenyi.com/icon69e2c5ee-2c85-4e83-adb2-5506209866c51548924684091.jpg","tel":"13883345634","state":1,"longitude":106.57493,"latitude":29.53985,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0},{"id":7,"communityName":"天龙广场三期","communityAddress":"南坪宏声路35号","sortNum":0,"description":"社区代理:张波","logoUrl":"https://file.aicenyi.com/icon878380e6-d580-401a-974a-ed46fce525a21549000603401.jpg","tel":"13827658820","state":1,"longitude":106.570107,"latitude":29.531195,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0},{"id":8,"communityName":"星宇花园","communityAddress":"南坪东路11号","sortNum":0,"description":"社区代理:张伯","logoUrl":"https://file.aicenyi.com/iconbf2699e2-f7ba-416b-b319-1a557cf9de171548924806365.jpg","tel":"13877632190","state":1,"longitude":106.571002,"latitude":29.529924,"del":0,"returnPercentage":1000,"openId":"oCZVp1Cbrtd_BOHE_uhpPd11gpvY","wechatLogin":0,"areaCode":"500000","distance":0},{"id":9,"communityName":"天龙城市花园","communityAddress":"南坪正街1号","sortNum":0,"description":"社区代理:张薇","logoUrl":"https://file.aicenyi.com/icon5658d531-2a33-4cb4-9adc-ee4934a2bafb1549000795342.jpg","tel":"13965784967","state":1,"longitude":106.568283,"latitude":29.530665,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0},{"id":10,"communityName":"恒大滨河左岸","communityAddress":"南岸区长生镇长生雅苑旁","sortNum":0,"description":"社区代理:周宇","logoUrl":"https://file.aicenyi.com/icon799d1c07-033b-45a5-9d6e-ff7385d77bd21549001986016.jpg","tel":"13967426627","state":1,"longitude":106.67188,"latitude":29.508272,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0},{"id":11,"communityName":"同景国际城W组团","communityAddress":"茶园丁香路1号","sortNum":0,"description":"社区代理:李好","logoUrl":"https://file.aicenyi.com/icon50ca2d47-5857-47ae-afb8-502dcc689ff41548926014611.jpg","tel":"15625478906","state":1,"longitude":106.65596,"latitude":29.50291,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0},{"id":12,"communityName":"同景国际城香溪迈上","communityAddress":"重庆市南岸区月季路","sortNum":0,"description":"社区代理:李霞","logoUrl":"https://file.aicenyi.com/icondd261124-a514-49ef-826b-d5d15dd498c81548926157739.jpg","tel":"15625492201","state":1,"longitude":106.648877,"latitude":29.490292,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0},{"id":13,"communityName":"融创伊顿庄园","communityAddress":"茶园米兰路38号","sortNum":0,"description":"社区代理:陈杰","logoUrl":"https://file.aicenyi.com/iconbec4d168-dbe9-4b0a-aebd-3663b99226a31549000950725.jpg","tel":"15936452301","state":1,"longitude":106.62511,"latitude":29.47258,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0},{"id":14,"communityName":"光华安纳溪湖","communityAddress":"南岸区米兰路","sortNum":0,"description":"社区代理:陈东","logoUrl":"https://file.aicenyi.com/icon4feb4d35-256b-4873-bd49-f85416f00fff1548926321890.jpg","tel":"15944567893","state":1,"longitude":106.63064,"latitude":29.48043,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":"500000","distance":0}]
             */

            private int totalCount;
            private List<EntityListBean> entityList;

            public int getTotalCount() {
                return totalCount;
            }

            public void setTotalCount(int totalCount) {
                this.totalCount = totalCount;
            }

            public List<EntityListBean> getEntityList() {
                return entityList;
            }

            public void setEntityList(List<EntityListBean> entityList) {
                this.entityList = entityList;
            }

            public static class EntityListBean {
                /**
                 * id : 5
                 * communityName : 新欧鹏教育城
                 * communityAddress : 江北区江北嘴鲁溉路(中央公园旁)
                 * sortNum : 0
                 * description : 社区代理:尹国红
                 * logoUrl : https://file.aicenyi.com/iconbb2ee733-51d1-480e-b94a-9621c00f86c31548925475954.jpg
                 * tel : 17726638949
                 * state : 1
                 * longitude : 106.5732
                 * latitude : 29.59
                 * del : 0
                 * returnPercentage : 1000
                 * openId : null
                 * wechatLogin : -1
                 * areaCode : 500000
                 * distance : 0
                 */

                private int id;
                private String communityName;
                private String communityAddress;
                private int sortNum;
                private String description;
                private String logoUrl;
                private String tel;
                private int state;
                private double longitude;
                private double latitude;
                private int del;
                private int returnPercentage;
                private Object openId;
                private int wechatLogin;
                private String areaCode;
                private int distance;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getCommunityName() {
                    return communityName;
                }

                public void setCommunityName(String communityName) {
                    this.communityName = communityName;
                }

                public String getCommunityAddress() {
                    return communityAddress;
                }

                public void setCommunityAddress(String communityAddress) {
                    this.communityAddress = communityAddress;
                }

                public int getSortNum() {
                    return sortNum;
                }

                public void setSortNum(int sortNum) {
                    this.sortNum = sortNum;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getLogoUrl() {
                    return logoUrl;
                }

                public void setLogoUrl(String logoUrl) {
                    this.logoUrl = logoUrl;
                }

                public String getTel() {
                    return tel;
                }

                public void setTel(String tel) {
                    this.tel = tel;
                }

                public int getState() {
                    return state;
                }

                public void setState(int state) {
                    this.state = state;
                }

                public double getLongitude() {
                    return longitude;
                }

                public void setLongitude(double longitude) {
                    this.longitude = longitude;
                }

                public double getLatitude() {
                    return latitude;
                }

                public void setLatitude(double latitude) {
                    this.latitude = latitude;
                }

                public int getDel() {
                    return del;
                }

                public void setDel(int del) {
                    this.del = del;
                }

                public int getReturnPercentage() {
                    return returnPercentage;
                }

                public void setReturnPercentage(int returnPercentage) {
                    this.returnPercentage = returnPercentage;
                }

                public Object getOpenId() {
                    return openId;
                }

                public void setOpenId(Object openId) {
                    this.openId = openId;
                }

                public int getWechatLogin() {
                    return wechatLogin;
                }

                public void setWechatLogin(int wechatLogin) {
                    this.wechatLogin = wechatLogin;
                }

                public String getAreaCode() {
                    return areaCode;
                }

                public void setAreaCode(String areaCode) {
                    this.areaCode = areaCode;
                }

                public int getDistance() {
                    return distance;
                }

                public void setDistance(int distance) {
                    this.distance = distance;
                }
            }
        }
    }
}
