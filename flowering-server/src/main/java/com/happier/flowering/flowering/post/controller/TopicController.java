package com.happier.flowering.flowering.post.controller;

import com.happier.flowering.entity.Topic;
import com.happier.flowering.flowering.post.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName TopicController
 * @description:TODO
 * @author:lky
 * @date:2020/4/23 21:29
 */
@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @RequestMapping("/list")
    public List<Topic> list() {
        System.out.println("topicList");
        return topicService.listTopics();
    }
}
