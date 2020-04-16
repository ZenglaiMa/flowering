package com.happier.flowering.flowering.post.controller;

import com.happier.flowering.flowering.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName PostController
 * @Description 花现(帖子) controller
 * @Author Seven
 * @Date 2020-04-15 15:15
 */
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

}
