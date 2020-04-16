package com.happier.flowering.entity;

/**
 * @ClassName Collection
 * @Description 用户和文章(花间)的收藏关系实体类
 * @Author Seven
 * @Date 2020-04-15 09:10
 */
public class Collect {

    private Integer id;
    private Integer userId;
    private Integer articleId;

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

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}
