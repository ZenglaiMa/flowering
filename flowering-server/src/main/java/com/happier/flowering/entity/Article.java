package com.happier.flowering.entity;

import java.util.Date;

/**
 * @ClassName Article
 * @Description 文章(花间)实体类
 * @Author Seven
 * @Date 2020-04-15 08:58
 */
public class Article {

    private Integer articleId; // 文章id
    private String title; // 文章标题
    private String img; // 封面图
    private String content; // 文章正文
    private String overview; // 文章一句话描述
    private Date time; // 发布(推送)时间
    private Integer readingNum; // 阅读量
    private Integer typeId; // 文章类型id

    private Type type; // 文章类型

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getReadingNum() {
        return readingNum;
    }

    public void setReadingNum(Integer readingNum) {
        this.readingNum = readingNum;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
