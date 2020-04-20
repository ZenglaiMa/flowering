package com.happier.flowering.flowering.community.controller;

import com.happier.flowering.flowering.community.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CommunityController
 * @Description 花间(即文章) controller
 * @Author Seven 赵语涵
 * @Date 2020-04-15 15:12
 */
@RestController
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

}
