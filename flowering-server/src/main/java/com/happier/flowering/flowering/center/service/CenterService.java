package com.happier.flowering.flowering.center.service;

import com.happier.flowering.entity.User;
import com.happier.flowering.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName CenterService
 * @Description 个人中心 service
 * @Author Seven
 * @Date 2020-04-15 15:10
 */
@Service
@Transactional(readOnly = false)
public class CenterService {
    @Resource
    private  UserMapper userMapper;
    public User findUser(int id){
      User user=  userMapper.findUserById(id);
      return user;
    }
}
