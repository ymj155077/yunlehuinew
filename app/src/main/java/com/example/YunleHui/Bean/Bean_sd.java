package com.example.YunleHui.Bean;

public class Bean_sd {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : {"id":2,"nickName":"","realName":"","gender":1,"language":"","address":"","country":"","province":"","city":"","avatarUrl":"","phone":"","createTime":"2019-08-30T11:29:58.000+0000","longitude":0,"latitude":0,"cityId":500000,"state":0,"remark":"","userChannelVo":{"id":0,"userId":null,"openId":null,"unionId":null,"phone":null,"userChannel":null,"nickName":null,"realName":null,"gender":null,"language":null,"longitude":null,"latitude":null,"address":null,"city":null,"province":null,"country":null,"avatarUrl":null,"createTime":null,"remark":null},"identity":0}
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
         * id : 2
         * nickName :
         * realName :
         * gender : 1
         * language :
         * address :
         * country :
         * province :
         * city :
         * avatarUrl :
         * phone :
         * createTime : 2019-08-30T11:29:58.000+0000
         * longitude : 0.0
         * latitude : 0.0
         * cityId : 500000
         * state : 0
         * remark :
         * userChannelVo : {"id":0,"userId":null,"openId":null,"unionId":null,"phone":null,"userChannel":null,"nickName":null,"realName":null,"gender":null,"language":null,"longitude":null,"latitude":null,"address":null,"city":null,"province":null,"country":null,"avatarUrl":null,"createTime":null,"remark":null}
         * identity : 0
         */

        private int id;
        private String nickName;
        private String realName;
        private int gender;
        private String language;
        private String address;
        private String country;
        private String province;
        private String city;
        private String avatarUrl;
        private String phone;
        private String createTime;
        private double longitude;
        private double latitude;
        private int cityId;
        private int state;
        private String remark;
        private UserChannelVoBean userChannelVo;
        private int identity;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
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

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public UserChannelVoBean getUserChannelVo() {
            return userChannelVo;
        }

        public void setUserChannelVo(UserChannelVoBean userChannelVo) {
            this.userChannelVo = userChannelVo;
        }

        public int getIdentity() {
            return identity;
        }

        public void setIdentity(int identity) {
            this.identity = identity;
        }

        public static class UserChannelVoBean {
            /**
             * id : 0
             * userId : null
             * openId : null
             * unionId : null
             * phone : null
             * userChannel : null
             * nickName : null
             * realName : null
             * gender : null
             * language : null
             * longitude : null
             * latitude : null
             * address : null
             * city : null
             * province : null
             * country : null
             * avatarUrl : null
             * createTime : null
             * remark : null
             */

            private int id;
            private Object userId;
            private Object openId;
            private Object unionId;
            private Object phone;
            private Object userChannel;
            private Object nickName;
            private Object realName;
            private Object gender;
            private Object language;
            private Object longitude;
            private Object latitude;
            private Object address;
            private Object city;
            private Object province;
            private Object country;
            private Object avatarUrl;
            private Object createTime;
            private Object remark;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getUserId() {
                return userId;
            }

            public void setUserId(Object userId) {
                this.userId = userId;
            }

            public Object getOpenId() {
                return openId;
            }

            public void setOpenId(Object openId) {
                this.openId = openId;
            }

            public Object getUnionId() {
                return unionId;
            }

            public void setUnionId(Object unionId) {
                this.unionId = unionId;
            }

            public Object getPhone() {
                return phone;
            }

            public void setPhone(Object phone) {
                this.phone = phone;
            }

            public Object getUserChannel() {
                return userChannel;
            }

            public void setUserChannel(Object userChannel) {
                this.userChannel = userChannel;
            }

            public Object getNickName() {
                return nickName;
            }

            public void setNickName(Object nickName) {
                this.nickName = nickName;
            }

            public Object getRealName() {
                return realName;
            }

            public void setRealName(Object realName) {
                this.realName = realName;
            }

            public Object getGender() {
                return gender;
            }

            public void setGender(Object gender) {
                this.gender = gender;
            }

            public Object getLanguage() {
                return language;
            }

            public void setLanguage(Object language) {
                this.language = language;
            }

            public Object getLongitude() {
                return longitude;
            }

            public void setLongitude(Object longitude) {
                this.longitude = longitude;
            }

            public Object getLatitude() {
                return latitude;
            }

            public void setLatitude(Object latitude) {
                this.latitude = latitude;
            }

            public Object getAddress() {
                return address;
            }

            public void setAddress(Object address) {
                this.address = address;
            }

            public Object getCity() {
                return city;
            }

            public void setCity(Object city) {
                this.city = city;
            }

            public Object getProvince() {
                return province;
            }

            public void setProvince(Object province) {
                this.province = province;
            }

            public Object getCountry() {
                return country;
            }

            public void setCountry(Object country) {
                this.country = country;
            }

            public Object getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(Object avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }
        }
    }
}
