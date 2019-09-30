package com.example.YunleHui.Bean;

/**
 * Created by admin on 2019/8/12 0012.
 */

public class BeanLogin {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : {"userInfo":{"id":2,"nickName":null,"realName":null,"gender":-1,"language":null,"address":null,"country":null,"province":null,"city":null,"avatarUrl":null,"phone":"18725621750","createTime":"2019-08-30","longitude":-1,"latitude":-1,"cityId":500000,"state":0,"remark":null,"userChannelVo":{"id":3,"userId":2,"openId":null,"unionId":null,"phone":"18725621750","userChannel":2,"nickName":null,"realName":null,"gender":-1,"language":null,"longitude":-1,"latitude":-1,"address":null,"city":null,"province":null,"country":null,"avatarUrl":null,"createTime":"2019-08-30 19:29:58.0","remark":null}},"userType":3,"token":"eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4YWQ5Y2I2ZTMxMTk0MjUwYWFiNTBiZTI3OWE2NTIwYiIsImlhdCI6MTU2NzIxNDU5MCwic3ViIjoie1wiYWRkcmVzc1wiOlwiXCIsXCJhdmF0YXJVcmxcIjpcIlwiLFwiY2l0eVwiOlwiXCIsXCJjaXR5SWRcIjo1MDAwMDAsXCJjb3VudHJ5XCI6XCJcIixcImNyZWF0ZVRpbWVcIjp7XCJkYXRlXCI6MzAsXCJkYXlcIjo1LFwiaG91cnNcIjowLFwibWludXRlc1wiOjAsXCJtb250aFwiOjcsXCJzZWNvbmRzXCI6MCxcInRpbWVcIjoxNTY3MDk0NDAwMDAwLFwidGltZXpvbmVPZmZzZXRcIjotNDgwLFwieWVhclwiOjExOX0sXCJnZW5kZXJcIjotMSxcImlkXCI6MixcImxhbmd1YWdlXCI6XCJcIixcImxhdGl0dWRlXCI6LTEsXCJsb25naXR1ZGVcIjotMSxcIm5pY2tOYW1lXCI6XCJcIixcInBob25lXCI6XCIxODcyNTYyMTc1MFwiLFwicHJvdmluY2VcIjpcIlwiLFwicmVhbE5hbWVcIjpcIlwiLFwicmVtYXJrXCI6XCJcIixcInN0YXRlXCI6MCxcInVzZXJDaGFubmVsVm9cIjp7XCJhZGRyZXNzXCI6XCJcIixcImF2YXRhclVybFwiOlwiXCIsXCJjaXR5XCI6XCJcIixcImNvdW50cnlcIjpcIlwiLFwiY3JlYXRlVGltZVwiOlwiMjAxOS0wOC0zMCAxOToyOTo1OC4wXCIsXCJnZW5kZXJcIjotMSxcImlkXCI6MyxcImxhbmd1YWdlXCI6XCJcIixcImxhdGl0dWRlXCI6LTEsXCJsb25naXR1ZGVcIjotMSxcIm5pY2tOYW1lXCI6XCJcIixcIm9wZW5JZFwiOlwiXCIsXCJwaG9uZVwiOlwiMTg3MjU2MjE3NTBcIixcInByb3ZpbmNlXCI6XCJcIixcInJlYWxOYW1lXCI6XCJcIixcInJlbWFya1wiOlwiXCIsXCJ1bmlvbklkXCI6XCJcIixcInVzZXJDaGFubmVsXCI6MixcInVzZXJJZFwiOjJ9fSIsImV4cCI6MTU2NzUxNjk5MH0.zAifhALAOqPNmxIyOulJjX3PxyQmcMbUFk21pFslIP4"}
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
         * userInfo : {"id":2,"nickName":null,"realName":null,"gender":-1,"language":null,"address":null,"country":null,"province":null,"city":null,"avatarUrl":null,"phone":"18725621750","createTime":"2019-08-30","longitude":-1,"latitude":-1,"cityId":500000,"state":0,"remark":null,"userChannelVo":{"id":3,"userId":2,"openId":null,"unionId":null,"phone":"18725621750","userChannel":2,"nickName":null,"realName":null,"gender":-1,"language":null,"longitude":-1,"latitude":-1,"address":null,"city":null,"province":null,"country":null,"avatarUrl":null,"createTime":"2019-08-30 19:29:58.0","remark":null}}
         * userType : 3
         * token : eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4YWQ5Y2I2ZTMxMTk0MjUwYWFiNTBiZTI3OWE2NTIwYiIsImlhdCI6MTU2NzIxNDU5MCwic3ViIjoie1wiYWRkcmVzc1wiOlwiXCIsXCJhdmF0YXJVcmxcIjpcIlwiLFwiY2l0eVwiOlwiXCIsXCJjaXR5SWRcIjo1MDAwMDAsXCJjb3VudHJ5XCI6XCJcIixcImNyZWF0ZVRpbWVcIjp7XCJkYXRlXCI6MzAsXCJkYXlcIjo1LFwiaG91cnNcIjowLFwibWludXRlc1wiOjAsXCJtb250aFwiOjcsXCJzZWNvbmRzXCI6MCxcInRpbWVcIjoxNTY3MDk0NDAwMDAwLFwidGltZXpvbmVPZmZzZXRcIjotNDgwLFwieWVhclwiOjExOX0sXCJnZW5kZXJcIjotMSxcImlkXCI6MixcImxhbmd1YWdlXCI6XCJcIixcImxhdGl0dWRlXCI6LTEsXCJsb25naXR1ZGVcIjotMSxcIm5pY2tOYW1lXCI6XCJcIixcInBob25lXCI6XCIxODcyNTYyMTc1MFwiLFwicHJvdmluY2VcIjpcIlwiLFwicmVhbE5hbWVcIjpcIlwiLFwicmVtYXJrXCI6XCJcIixcInN0YXRlXCI6MCxcInVzZXJDaGFubmVsVm9cIjp7XCJhZGRyZXNzXCI6XCJcIixcImF2YXRhclVybFwiOlwiXCIsXCJjaXR5XCI6XCJcIixcImNvdW50cnlcIjpcIlwiLFwiY3JlYXRlVGltZVwiOlwiMjAxOS0wOC0zMCAxOToyOTo1OC4wXCIsXCJnZW5kZXJcIjotMSxcImlkXCI6MyxcImxhbmd1YWdlXCI6XCJcIixcImxhdGl0dWRlXCI6LTEsXCJsb25naXR1ZGVcIjotMSxcIm5pY2tOYW1lXCI6XCJcIixcIm9wZW5JZFwiOlwiXCIsXCJwaG9uZVwiOlwiMTg3MjU2MjE3NTBcIixcInByb3ZpbmNlXCI6XCJcIixcInJlYWxOYW1lXCI6XCJcIixcInJlbWFya1wiOlwiXCIsXCJ1bmlvbklkXCI6XCJcIixcInVzZXJDaGFubmVsXCI6MixcInVzZXJJZFwiOjJ9fSIsImV4cCI6MTU2NzUxNjk5MH0.zAifhALAOqPNmxIyOulJjX3PxyQmcMbUFk21pFslIP4
         */

        private UserInfoBean userInfo;
        private int userType;
        private String token;

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public static class UserInfoBean {
            /**
             * id : 2
             * nickName : null
             * realName : null
             * gender : -1
             * language : null
             * address : null
             * country : null
             * province : null
             * city : null
             * avatarUrl : null
             * phone : 18725621750
             * createTime : 2019-08-30
             * longitude : -1.0
             * latitude : -1.0
             * cityId : 500000
             * state : 0
             * remark : null
             * userChannelVo : {"id":3,"userId":2,"openId":null,"unionId":null,"phone":"18725621750","userChannel":2,"nickName":null,"realName":null,"gender":-1,"language":null,"longitude":-1,"latitude":-1,"address":null,"city":null,"province":null,"country":null,"avatarUrl":null,"createTime":"2019-08-30 19:29:58.0","remark":null}
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

            public static class UserChannelVoBean {
                /**
                 * id : 3
                 * userId : 2
                 * openId : null
                 * unionId : null
                 * phone : 18725621750
                 * userChannel : 2
                 * nickName : null
                 * realName : null
                 * gender : -1
                 * language : null
                 * longitude : -1.0
                 * latitude : -1.0
                 * address : null
                 * city : null
                 * province : null
                 * country : null
                 * avatarUrl : null
                 * createTime : 2019-08-30 19:29:58.0
                 * remark : null
                 */

                private int id;
                private int userId;
                private String openId;
                private String unionId;
                private String phone;
                private int userChannel;
                private String nickName;
                private String realName;
                private int gender;
                private String language;
                private double longitude;
                private double latitude;
                private String address;
                private String city;
                private String province;
                private String country;
                private String avatarUrl;
                private String createTime;
                private String remark;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public String getOpenId() {
                    return openId;
                }

                public void setOpenId(String openId) {
                    this.openId = openId;
                }

                public String getUnionId() {
                    return unionId;
                }

                public void setUnionId(String unionId) {
                    this.unionId = unionId;
                }

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public int getUserChannel() {
                    return userChannel;
                }

                public void setUserChannel(int userChannel) {
                    this.userChannel = userChannel;
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

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public String getProvince() {
                    return province;
                }

                public void setProvince(String province) {
                    this.province = province;
                }

                public String getCountry() {
                    return country;
                }

                public void setCountry(String country) {
                    this.country = country;
                }

                public String getAvatarUrl() {
                    return avatarUrl;
                }

                public void setAvatarUrl(String avatarUrl) {
                    this.avatarUrl = avatarUrl;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }
            }
        }
    }
}
