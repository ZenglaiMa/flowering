package com.happier.flowering.flowering.post.controller;

import com.happier.flowering.flowering.post.service.PostService;
import com.happier.flowering.model.PostListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
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

    @GetMapping("/listByText")
    public List<PostListModel> listByText(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize, @RequestParam("textKeyWord") String keyword) {
        return postService.listPostsByText(pageNum, pageSize, keyword);
    }

    @PostMapping("/publish")
    public String publishPost(@RequestParam("postText") String postText, @RequestParam("topicId") Integer topicId, @RequestParam("userId") Integer userId, @RequestParam("pic") MultipartFile[] files) {
        System.out.println("publish post");
        StringBuffer picPath = new StringBuffer();
        if (files != null) {
            for (MultipartFile file : files) {
                try {
                    String tempPath = ResourceUtils.getURL("classpath:").getPath() + "static/post-img";
                    String realPath = tempPath.replace("%20", " ").replace("/", "\\").substring(1);
                    String fileName = System.currentTimeMillis() + ".jpg";
                    file.transferTo(new File(realPath, fileName));
                    picPath.append("/post-img/" + fileName + ",");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (postService.publishPost(postText, picPath.substring(0, picPath.length() - 1), topicId, userId, new Date())) {
            return "success";
        } else {
            return "fail";
        }
    }

    @GetMapping("/good")
    public void doGood(@RequestParam("postId") Integer postId, @RequestParam("userId") Integer userId) {
        postService.doGood(userId, postId);
    }

    /**
     * 個人發現
     *
     * @param userId
     * @return
     */
    public String searchPostByUserId(int userId) {
        return "";
    }

}
