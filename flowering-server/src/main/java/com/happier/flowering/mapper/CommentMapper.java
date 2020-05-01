package com.happier.flowering.mapper;

import com.happier.flowering.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName CommentMapper
 * @Description
 * @Author Seven
 * @Date 2020-04-15 15:08
 */
public interface CommentMapper {

    @Select("select user_id, content from comment where post_id = #{postId}")
    List<Comment> findByPostId(Integer postId);

    @Insert("insert into comment(user_id, post_id, content) values(#{userId}, #{postId}, #{content})")
    int save(@Param("userId") Integer userId, @Param("postId") Integer postId, @Param("content") String content);
}
