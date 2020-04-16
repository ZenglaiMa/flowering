package com.happier.flowering.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Post
 * @Description 帖子(花现)实体类
 * @Author Seven
 * @Date 2020-04-15 09:31
 */
public class Post {

    private Integer postId; // 帖子id
    private String txt; // 帖子文字内容
    private String img; // 帖子图片内容
    private Integer topicId; // 所属话题id
    private Integer userId; // 所属用户id
    private Date time; // 发布时间

    private Topic topic; // 所属话题
    private Set<Comment> comments = new HashSet<>(); // 该帖子的评论
    private User user; // 所属用户

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
