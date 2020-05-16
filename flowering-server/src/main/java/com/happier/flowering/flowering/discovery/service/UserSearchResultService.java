package com.happier.flowering.flowering.discovery.service;

import com.happier.flowering.entity.User;
import com.happier.flowering.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName UserSearchResultService
 * @Description
 * @Author Seven
 * @Date 2020-05-16 10:17
 */
@Service
@Transactional(readOnly = true)
public class UserSearchResultService {

    @Autowired
    private UserMapper userMapper;

    public List<User> listUsersByNameLike(String keyword) {
        return userMapper.findByUserNameLike(keyword);
    }

}
