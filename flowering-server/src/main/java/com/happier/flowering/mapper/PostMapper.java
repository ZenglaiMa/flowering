package com.happier.flowering.mapper;

import com.happier.flowering.entity.Post;

import java.util.List;

/**
 * @ClassName PostMapper
 * @Description
 * @Author Seven
 * @Date 2020-04-15 15:08
 */
public interface PostMapper {

    List<Post> findAll();

}
