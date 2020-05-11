package com.happier.flowering.mapper;

import com.happier.flowering.entity.User;

/**
 * @ClassName UserMapper
 * @Description
 * @Author Seven
 * @Date 2020-04-15 15:10
 */
public interface UserMapper {
    User findUserById(int id);
    //注冊
    int registUser(User u);
    //登录
    User loginUser(String password,String name);

}
