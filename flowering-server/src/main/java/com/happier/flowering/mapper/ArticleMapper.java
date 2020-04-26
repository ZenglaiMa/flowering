package com.happier.flowering.mapper;

import com.happier.flowering.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ArticleMapper
 * @Description
 * @Author Seven 赵语涵
 * @Date 2020-04-15 15:06
 */
public interface ArticleMapper {
    /*
     * @description 查询当前的阅读量
     * @param articleId 针对哪篇文章
     * @return
     * @author adi
     */
    public int getReadingNum(int articleId);
    /*
     * @description 对某个文章增加一个阅读量
     * @param articleId 针对哪篇文章
     * @param readingNum 最新的阅读数
     * @return
     * @author 赵语涵
     */
    public int addReadingNum(@Param("articleId") int articleId, @Param("readingNum") int readingNum);
    /*
     * @description 查询某个类型的所有文章
     * @param id ： article_id
     * @return
     * @author 赵语涵
     */
    public List<Article> getArticleByType(int typeId);
    /*
     * @description 根据id查询某篇文章
     * @param id ： article_id
     * @return
     * @author 赵语涵
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
     * @author 赵语涵
     */
    public List<Article> getAllArtical();
}
