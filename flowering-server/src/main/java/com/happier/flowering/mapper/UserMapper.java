package com.happier.flowering.mapper;

import com.happier.flowering.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    User loginUser(String password, String name);

    int updateImg(int userId, String path);

    int updateName(int userId, String name);

    int updateProfile(int userId, String profile);

    @Select("select * from user where nickname like \"%\"#{keyword}\"%\"")
    List<User> findByUserNameLike(String keyword);

    @Update("update user set nickname = #{nickname}, sex = #{gender}, address = #{address}, profile = #{profile} where user_id = #{userId}")
    int updateUserInfo(@Param("userId") Integer userId, @Param("nickname") String nickname, @Param("gender") int gender, @Param("address") String address, @Param("profile") String profile);
}
