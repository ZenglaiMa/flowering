package com.happier.flowering.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Type
 * @Description 文章类型
 * @Author Seven
 * @Date 2020-04-15 09:37
 */
public class Type {

    private Integer typeId; // 类型id
    private String typeName; // 类型名

    private Set<Article> articles = new HashSet<>(); // 该类型下包含的文章

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
}
