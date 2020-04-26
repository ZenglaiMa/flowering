package com.happier.flowering.flowering.post.controller;

import com.happier.flowering.flowering.post.service.PostService;
import com.happier.flowering.model.PostListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/latest")
    public List<PostListModel> listByCreateTime(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        return postService.listPostsByCreateTime(pageNum, pageSize);
    }

    @GetMapping("/choice")
    public List<PostListModel> listByThumbsUp(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        return postService.listPostsByThumbsUp(pageNum, pageSize);
    }

    @GetMapping("/topic")
    public List<PostListModel> listByTopic(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize, @RequestParam("topicId") Integer topicId) {
        return postService.listPostsByTopic(pageNum, pageSize, topicId);
    }

}
