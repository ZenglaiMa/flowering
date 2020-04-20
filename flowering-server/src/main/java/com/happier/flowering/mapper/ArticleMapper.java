package com.happier.flowering.mapper;

import com.happier.flowering.entity.Article;

/**
 * @ClassName ArticleMapper
 * @Description
 * @Author Seven
 * @Date 2020-04-15 15:06
 */
public interface ArticleMapper {
    /*
     * @description 根据id查询某篇文章
     * @param id ： article_id
     * @return
     * @author adi
     */
    public Article getArticalById(int id);
}
