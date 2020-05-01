package com.happier.flowering.flowering.center.service;
<<<<<<< HEAD
import com.happier.flowering.entity.Attention;
import com.happier.flowering.entity.User;
import com.happier.flowering.mapper.AttentionMapper;
=======

import com.happier.flowering.entity.Message;
import com.happier.flowering.entity.User;
import com.happier.flowering.mapper.MessageMapper;
>>>>>>> 61342c5b9dd6972f9116ce87063f9df0bc730916
import com.happier.flowering.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> 61342c5b9dd6972f9116ce87063f9df0bc730916
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
<<<<<<< HEAD
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
=======
    private MessageMapper messageMapper;

    /**
     * 個人私信
     * @param userId
     * @return
     */
    public List<Message> searchMessageByUserId(int userId){
        return messageMapper.searchMessageByUserId(userId);
    }

>>>>>>> 61342c5b9dd6972f9116ce87063f9df0bc730916
}
