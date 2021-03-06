package com.happier.flowering.flowering.post.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.happier.flowering.entity.Comment;
import com.happier.flowering.entity.Post;
import com.happier.flowering.mapper.CommentMapper;
import com.happier.flowering.mapper.PostMapper;
import com.happier.flowering.mapper.UserMapper;
import com.happier.flowering.model.CommentListModel;
import com.happier.flowering.model.PostListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName PostService
 * @Description 花现(帖子) service
 * @Author Seven
 * @Date 2020-04-15 15:15
 */
@Service
@Transactional(readOnly = true)
public class PostService {

    @Autowired
    private PostMapper postMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserMapper userMapper;

    public List<PostListModel> listPostsByCreateTime(int pageNum, int pageSize) {
        List<PostListModel> models = new ArrayList<>();
        PageHelper.startPage(pageNum, pageSize);
        Page<Post> page = (Page<Post>) postMapper.findAllByCreateTime();
        for (Post post : page.getResult()) {
            PostListModel model = new PostListModel();
            model.setPostId(post.getPostId());
            model.setPostText(post.getTxt());
            model.setPostImg(post.getImg());
            model.setPostCreateTime(post.getTime());
            model.setUserId(post.getUser().getUserId());
            model.setNickname(post.getUser().getNickname());
            model.setHeadImg(post.getUser().getHeadImg());
            model.setTopicName(post.getTopic().getTopicName());
            model.setThumbsUpCount(post.getThumbsUpCount());
            List<CommentListModel> commentListModels = new ArrayList<>();
            for (Comment comment : commentMapper.findByPostId(post.getPostId())) {
                CommentListModel commentListModel = new CommentListModel();
                commentListModel.setContent(comment.getContent());
                commentListModel.setUserName(userMapper.findUserById(comment.getUserId()).getNickname());
                commentListModels.add(commentListModel);
            }
            model.setCommentListModels(commentListModels);
            models.add(model);
        }

        return models;
    }

    public List<PostListModel> listPostsByThumbsUp(int pageNum, int pageSize) {
        List<PostListModel> models = new ArrayList<>();
        PageHelper.startPage(pageNum, pageSize);
        Page<Post> page = (Page<Post>) postMapper.findAllByThumbsUp();
        for (Post post : page.getResult()) {
            PostListModel model = new PostListModel();
            model.setPostId(post.getPostId());
            model.setPostText(post.getTxt());
            model.setPostImg(post.getImg());
            model.setPostCreateTime(post.getTime());
            model.setUserId(post.getUser().getUserId());
            model.setNickname(post.getUser().getNickname());
            model.setHeadImg(post.getUser().getHeadImg());
            model.setTopicName(post.getTopic().getTopicName());
            model.setThumbsUpCount(post.getThumbsUpCount());
            List<CommentListModel> commentListModels = new ArrayList<>();
            for (Comment comment : commentMapper.findByPostId(post.getPostId())) {
                CommentListModel commentListModel = new CommentListModel();
                commentListModel.setContent(comment.getContent());
                commentListModel.setUserName(userMapper.findUserById(comment.getUserId()).getNickname());
                commentListModels.add(commentListModel);
            }
            model.setCommentListModels(commentListModels);
            models.add(model);
        }

        return models;
    }

    public List<PostListModel> listPostsByTopic(int pageNum, int pageSize, Integer topicId) {
        List<PostListModel> models = new ArrayList<>();
        PageHelper.startPage(pageNum, pageSize);
        Page<Post> page = (Page<Post>) postMapper.findByTopicId(topicId);
        for (Post post : page.getResult()) {
            PostListModel model = new PostListModel();
            model.setPostId(post.getPostId());
            model.setPostText(post.getTxt());
            model.setPostImg(post.getImg());
            model.setPostCreateTime(post.getTime());
            model.setUserId(post.getUser().getUserId());
            model.setNickname(post.getUser().getNickname());
            model.setHeadImg(post.getUser().getHeadImg());
            model.setTopicName(post.getTopic().getTopicName());
            model.setThumbsUpCount(post.getThumbsUpCount());
            List<CommentListModel> commentListModels = new ArrayList<>();
            for (Comment comment : commentMapper.findByPostId(post.getPostId())) {
                CommentListModel commentListModel = new CommentListModel();
                commentListModel.setContent(comment.getContent());
                commentListModel.setUserName(userMapper.findUserById(comment.getUserId()).getNickname());
                commentListModels.add(commentListModel);
            }
            model.setCommentListModels(commentListModels);
            models.add(model);
        }

        return models;
    }

    public List<PostListModel> listPostsByText(int pageNum, int pageSize, String text) {
        List<PostListModel> models = new ArrayList<>();
        PageHelper.startPage(pageNum, pageSize);
        Page<Post> page = (Page<Post>) postMapper.findByText(text);
        for (Post post : page.getResult()) {
            PostListModel model = new PostListModel();
            model.setPostId(post.getPostId());
            model.setPostText(post.getTxt());
            model.setPostImg(post.getImg());
            model.setPostCreateTime(post.getTime());
            model.setUserId(post.getUser().getUserId());
            model.setNickname(post.getUser().getNickname());
            model.setHeadImg(post.getUser().getHeadImg());
            model.setTopicName(post.getTopic().getTopicName());
            model.setThumbsUpCount(post.getThumbsUpCount());
            List<CommentListModel> commentListModels = new ArrayList<>();
            for (Comment comment : commentMapper.findByPostId(post.getPostId())) {
                CommentListModel commentListModel = new CommentListModel();
                commentListModel.setContent(comment.getContent());
                commentListModel.setUserName(userMapper.findUserById(comment.getUserId()).getNickname());
                commentListModels.add(commentListModel);
            }
            model.setCommentListModels(commentListModels);
            models.add(model);
        }

        return models;
    }

    public List<PostListModel> listPostsByUserId(int pageNum, int pageSize, Integer userId) {
        List<PostListModel> models = new ArrayList<>();
        PageHelper.startPage(pageNum, pageSize);
        Page<Post> page = (Page<Post>) postMapper.findByUserId(userId);
        for (Post post : page.getResult()) {
            PostListModel model = new PostListModel();
            model.setPostId(post.getPostId());
            model.setPostText(post.getTxt());
            model.setPostImg(post.getImg());
            model.setPostCreateTime(post.getTime());
            model.setUserId(post.getUser().getUserId());
            model.setNickname(post.getUser().getNickname());
            model.setHeadImg(post.getUser().getHeadImg());
            model.setTopicName(post.getTopic().getTopicName());
            model.setThumbsUpCount(post.getThumbsUpCount());
            List<CommentListModel> commentListModels = new ArrayList<>();
            for (Comment comment : commentMapper.findByPostId(post.getPostId())) {
                CommentListModel commentListModel = new CommentListModel();
                commentListModel.setContent(comment.getContent());
                commentListModel.setUserName(userMapper.findUserById(comment.getUserId()).getNickname());
                commentListModels.add(commentListModel);
            }
            model.setCommentListModels(commentListModels);
            models.add(model);
        }

        return models;
    }

    public List<PostListModel> listPostById(Integer postId) {
        List<PostListModel> models = new ArrayList<>();
        List<Post> posts = postMapper.findByPostId(postId);
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
            model.setThumbsUpCount(post.getThumbsUpCount());
            List<CommentListModel> commentListModels = new ArrayList<>();
            for (Comment comment : commentMapper.findByPostId(post.getPostId())) {
                CommentListModel commentListModel = new CommentListModel();
                commentListModel.setContent(comment.getContent());
                commentListModel.setUserName(userMapper.findUserById(comment.getUserId()).getNickname());
                commentListModels.add(commentListModel);
            }
            model.setCommentListModels(commentListModels);
            models.add(model);
        }

        return models;
    }

    @Transactional(readOnly = false)
    public boolean publishPost(String txt, String img, Integer topicId, Integer userId, Date time) {
        return postMapper.savePost(txt, img, topicId, userId, time) > 0 ? true : false;
    }

    @Transactional(readOnly = false)
    public int doGood(Integer userId, Integer postId) {
        return postMapper.saveThumbsUp(userId, postId, new Date());
    }

}
