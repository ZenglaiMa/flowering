package com.happier.flowering.flowering.center.service;
import com.happier.flowering.entity.Attention;
import com.happier.flowering.entity.User;
import com.happier.flowering.mapper.AttentionMapper;
import com.happier.flowering.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
      User user=this.userMapper.findUserById(id);
      return user;
    }
    @Resource
    private AttentionMapper attentionMapper;
    public  List<User> findInitiative(int id){
       List<Integer> ids= this.attentionMapper.findUserInitiativeId(id);
       List<User> users = new ArrayList<>();
       for(Integer i:ids){
           User user=  userMapper.findUserById(i);
           users.add(user);
    }return users;
    }
    public  List<User> findpassive(int id){
        List<Integer> ids= this.attentionMapper.findUserpassiveId(id);
        List<User> users = new ArrayList<>();
        for(Integer i:ids){
            User user=  userMapper.findUserById(i);
            users.add(user);
        }return users;
    }
}
