package com.happier.flowering.flowering.post.service;

import com.happier.flowering.mapper.CommentMapper;
import com.happier.flowering.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName CommentService
 * @Description
 * @Author Seven
 * @Date 2020-04-29 21:20
 */
@Service
@Transactional(readOnly = false)
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserMapper userMapper;

    public String publishComment(Integer userId, Integer postId, String content) {
        commentMapper.save(userId, postId, content);
        return userMapper.findUserById(userId).getNickname();
    }

}
