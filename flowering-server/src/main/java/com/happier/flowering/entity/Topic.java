package com.happier.flowering.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Topic
 * @Description 话题
 * @Author Seven
 * @Date 2020-04-15 09:36
 */
public class Topic {

    private Integer topicId; // 话题id
    private String topicName; // 话题名
    private String introduction;

    private Set<Post> posts = new HashSet<>(); // 该话题下包含的帖子

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getIntroduction() {
        return introduction;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
