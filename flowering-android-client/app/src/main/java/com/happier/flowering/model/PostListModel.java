package com.happier.flowering.model;

import java.util.Date;
import java.util.List;

/**
 * @ClassName PostListModel
 * @Description
 * @Author Seven
 * @Date 2020-04-22 17:24
 */
public class PostListModel {

    private Integer postId;
    private String postText;
    private String postImg;
    private Date postCreateTime;
    private Integer userId;
    private String nickname;
    private String headImg;
    private String topicName;
    private Integer thumbsUpCount;
    private List<CommentListModel> commentListModels;

    public List<CommentListModel> getCommentListModels() {
        return commentListModels;
    }

    public void setCommentListModels(List<CommentListModel> commentListModels) {
        this.commentListModels = commentListModels;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public String getPostImg() {
        return postImg;
    }

    public void setPostImg(String postImg) {
        this.postImg = postImg;
    }

    public Date getPostCreateTime() {
        return postCreateTime;
    }

    public void setPostCreateTime(Date postCreateTime) {
        this.postCreateTime = postCreateTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getThumbsUpCount() {
        return thumbsUpCount;
    }

    public void setThumbsUpCount(Integer thumbsUpCount) {
        this.thumbsUpCount = thumbsUpCount;
    }
}
