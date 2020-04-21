package com.happier.flowering.mapper;

import com.happier.flowering.entity.Article;

import java.util.List;

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
    /*
     * @description 查询article表有多少条数据
     * @return 数据条数
     * @author 赵语涵
     */
    public int getCount();
    /*
     * @description 查询所有文章（带类型）
     * @return
     * @author adi
     */
    public List<Article> getAllArtical();
}
