package com.happier.flowering.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName User
 * @Description 用户实体类
 * @Author Seven
 * @Date 2020-04-15 09:38
 */
public class User {

    private Integer userId; // 用户id
    private String nickname; // 用户名
    private Integer sex; // 性别 1为男, 2为女
    private String address; // 地址
    private String profile; // 个人简介
    private String headImg; // 头像

    private Set<Post> posts = new HashSet<>(); // 该用户发布的帖子

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
