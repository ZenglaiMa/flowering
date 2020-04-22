package com.happier.flowering.flowering.post.service;

import com.happier.flowering.entity.Post;
import com.happier.flowering.mapper.PostMapper;
import com.happier.flowering.model.PostListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PostService
 * @Description 花现(帖子) service
 * @Author Seven
 * @Date 2020-04-15 15:15
 */
@Service
public class PostService {

    @Autowired
    private PostMapper postMapper;

    public List<PostListModel> listPosts() {
        List<PostListModel> models = new ArrayList<>();
        List<Post> posts = postMapper.findAll();
        for (Post post : posts) {
            PostListModel model = new PostListModel();
            model.setPostId(post.getPostId());
            model.setPostText(post.getTxt());
            model.setPostImg(post.getImg());
            model.setPostCreateTime(post.getTime());
            model.setUserId(post.getUser().getUserId());
            model.setNickname(post.getUser().getNickname());
            model.setHeadImg(post.getUser().getHeadImg());
            model.setTopicName(post.getTopic().getTopicName());
            models.add(model);
        }

        return models;
    }

}
