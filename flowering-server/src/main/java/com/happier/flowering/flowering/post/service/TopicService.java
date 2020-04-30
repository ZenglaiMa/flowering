package com.happier.flowering.flowering.post.service;

import com.happier.flowering.entity.Topic;
import com.happier.flowering.mapper.TopicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TopicService
 * @description:TODO
 * @author:lky
 * @date:2020/4/23 21:30
 */
@Service
public class TopicService {

    @Autowired
    private TopicMapper topicMapper;

    public List<Topic> listTopics(){
        return topicMapper.findAll();
    }

}
