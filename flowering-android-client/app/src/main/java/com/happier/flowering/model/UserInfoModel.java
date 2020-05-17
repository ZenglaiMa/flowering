package com.happier.flowering.model;

/**
 * @ClassName UserInfoModel
 * @Description 进一步封装User信息
 * @Author seven
 * @date 2020/5/17 9:16
 * @Version 0.1
 */
public class UserInfoModel {

    private String username;
    private String userImg;
    private String address;
    private int bepraised;
    private int sex;
    private String profile;
    private int attention;
    private int fans;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBepraised() {
        return bepraised;
    }

    public void setBepraised(int bepraised) {
        this.bepraised = bepraised;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getAttention() {
        return attention;
    }

    public void setAttention(int attention) {
        this.attention = attention;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

}
