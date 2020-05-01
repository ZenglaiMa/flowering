package com.happier.flowering.flowering.post.controller;

import com.happier.flowering.flowering.post.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CommentController
 * @Description
 * @Author Seven
 * @Date 2020-04-29 21:20
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/send")
    public String doComment(@RequestParam("userId") Integer userId, @RequestParam("postId") Integer postId, @RequestParam("content") String content) {
        return commentService.publishComment(userId, postId, content);
    }
}
