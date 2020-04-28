package com.happier.flowering.mapper;

import com.happier.flowering.entity.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @ClassName PostMapper
 * @Description
 * @Author Seven
 * @Date 2020-04-15 15:08
 */
public interface PostMapper {

    List<Post> findAllByCreateTime();

    List<Post> findAllByThumbsUp();

    List<Post> findByTopicId(Integer topicId);

    @Insert("insert into post(txt, img, topic_id, user_id, time) values(#{txt}, #{img}, #{topicId}, #{userId}, #{time})")
    int savePost(@Param("txt") String txt, @Param("img") String img, @Param("topicId") Integer topicId, @Param("userId") Integer userId, @Param("time") Date time);

}
