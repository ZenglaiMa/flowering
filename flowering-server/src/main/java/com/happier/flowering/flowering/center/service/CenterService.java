package com.happier.flowering.flowering.center.service;

import com.happier.flowering.entity.Attention;
import com.happier.flowering.entity.User;
import com.happier.flowering.mapper.AttentionMapper;


import com.happier.flowering.entity.Message;
import com.happier.flowering.entity.User;
import com.happier.flowering.mapper.MessageMapper;

import com.happier.flowering.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Resource
    private MessageMapper messageMapper;
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



    /**
     * 個人私信
     * @param userId
     * @return
     */
    public List<Map<String, Object>> searchMessageByUserId(int userId){
        List <Map<String, Object>> mUsers=new ArrayList<>();
        List<Message> messages= messageMapper.searchMessageByUserId(userId);
        for(int i=0;i<messages.size();i++){
            Map map = new HashMap();
            User user=userMapper.findUserById(messages.get(i).getUserIdSend());
            map.put("content",messages.get(i));
            map.put("sender",user);
            mUsers.add(map);
        }
        for(int j=0;j<mUsers.size();j++){
            System.out.println(mUsers.get(j).get("content").toString()+mUsers.get(j).get("sender").toString());
        }

        return mUsers;
    }


}
