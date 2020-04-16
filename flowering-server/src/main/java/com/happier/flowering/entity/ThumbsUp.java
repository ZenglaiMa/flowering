package com.happier.flowering.entity;

import java.util.Date;

/**
 * @ClassName ThumbsUp
 * @Description 点赞
 * @Author Seven
 * @Date 2020-04-15 09:35
 */
public class ThumbsUp {

    private Integer id;
    private Integer userId; // 点赞人
    private Integer postId; // 被点赞的帖子
    private Date time; // 点赞时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
