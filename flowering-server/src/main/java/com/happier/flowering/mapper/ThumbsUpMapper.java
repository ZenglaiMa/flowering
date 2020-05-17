package com.happier.flowering.mapper;

import com.happier.flowering.entity.ThumbsUp;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName ThumbsUpMapper
 * @Description
 * @Author Seven
 * @Date 2020-04-15 15:09
 */
public interface ThumbsUpMapper {

    List<Integer> findThumbsOther(int id);

    @Select("select * from thumbsup where post_id = #{id} order by time desc")
    List<ThumbsUp> findThumbsMe(int id);

}
