package com.example.YunleHui.Bean;

public class Bean_uesrDetail {


    /**
     * address :
     * avatarUrl :
     * city :
     * cityId : 500000
     * country :
     * createTime : {"date":30,"day":5,"hours":19,"minutes":29,"month":7,"seconds":58,"time":1567164598000,"timezoneOffset":-480,"year":119}
     * gender : -1
     * id : 2
     * language :
     * latitude : -1
     * longitude : -1
     * nickName : 周星驰
     * phone : 18725621750
     * province :
     * realName :
     * remark :
     * state : 0
     * userChannelVo : {"address":"","avatarUrl":"","city":"","country":"","createTime":"2019-08-30 19:29:58.0","gender":-1,"id":3,"language":"","latitude":-1,"longitude":-1,"nickName":"","openId":"","phone":"18725621750","province":"","realName":"","remark":"","unionId":"","userChannel":2,"userId":2}
     */

    private String address;
    private String avatarUrl;
    private String city;
    private int cityId;
    private String country;
    private CreateTimeBean createTime;
    private int gender;
    private int id;
    private String language;
    private int latitude;
    private int longitude;
    private String nickName;
    private String phone;
    private String province;
    private String realName;
    private String remark;
    private int state;
    private UserChannelVoBean userChannelVo;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public CreateTimeBean getCreateTime() {
        return createTime;
    }

    public void setCreateTime(CreateTimeBean createTime) {
        this.createTime = createTime;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public UserChannelVoBean getUserChannelVo() {
        return userChannelVo;
    }

    public void setUserChannelVo(UserChannelVoBean userChannelVo) {
        this.userChannelVo = userChannelVo;
    }

    public static class CreateTimeBean {
        /**
         * date : 30
         * day : 5
         * hours : 19
         * minutes : 29
         * month : 7
         * seconds : 58
         * time : 1567164598000
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

    public static class UserChannelVoBean {
        /**
         * address :
         * avatarUrl :
         * city :
         * country :
         * createTime : 2019-08-30 19:29:58.0
         * gender : -1
         * id : 3
         * language :
         * latitude : -1
         * longitude : -1
         * nickName :
         * openId :
         * phone : 18725621750
         * province :
         * realName :
         * remark :
         * unionId :
         * userChannel : 2
         * userId : 2
         */

        private String address;
        private String avatarUrl;
        private String city;
        private String country;
        private String createTime;
        private int gender;
        private int id;
        private String language;
        private int latitude;
        private int longitude;
        private String nickName;
        private String openId;
        private String phone;
        private String province;
        private String realName;
        private String remark;
        private String unionId;
        private int userChannel;
        private int userId;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public int getLatitude() {
            return latitude;
        }

        public void setLatitude(int latitude) {
            this.latitude = latitude;
        }

        public int getLongitude() {
            return longitude;
        }

        public void setLongitude(int longitude) {
            this.longitude = longitude;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getUnionId() {
            return unionId;
        }

        public void setUnionId(String unionId) {
            this.unionId = unionId;
        }

        public int getUserChannel() {
            return userChannel;
        }

        public void setUserChannel(int userChannel) {
            this.userChannel = userChannel;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
