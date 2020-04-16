package com.happier.flowering.entity;

import java.util.Date;

/**
 * @ClassName Reply
 * @Description 帖子的回复
 * @Author Seven
 * @Date 2020-04-15 09:33
 */
public class Reply {

    private Integer replyId;
    private Integer commentId; // 回复的哪条评论
    private Integer userId; // 回复人
    private String content; // 回复内容
    private Date time; // 回复时间

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

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
}
