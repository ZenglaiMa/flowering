package com.happier.flowering.mapper;

import com.happier.flowering.entity.Topic;

import java.util.List;

/**
 * @ClassName TopicMapper
 * @Description
 * @Author Seven
 * @Date 2020-04-15 15:09
 */
public interface TopicMapper {
    List<Topic> findAll();
}
