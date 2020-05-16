package com.happier.flowering.mapper;

import com.happier.flowering.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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
    int updateImg(int userId,String path);
    int updateName(int userId,String name);
    int updateProfile(int userId,String profile);

    @Select("select * from user where nickname like \"%\"#{keyword}\"%\"")
    List<User> findByUserNameLike(String keyword);

}
