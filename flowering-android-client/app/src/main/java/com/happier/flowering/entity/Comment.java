package com.happier.flowering.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Comment
 * @Description 评论实体类
 * @Author Seven
 * @Date 2020-04-15 09:11
 */
public class Comment {

    private Integer commentId; // 评论id
    private Integer userId; // 评论者id
    private Integer postId; // 被评论帖子(花现)id
    private String content; // 评论内容
    private Date time; // 评论时间

    private Set<Reply> replies = new HashSet<>(); // 该评论的回复

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Set<Reply> getReplies() {
        return replies;
    }

    public void setReplies(Set<Reply> replies) {
        this.replies = replies;
    }
}
