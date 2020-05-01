package com.happier.flowering.flowering.center.service;
<<<<<<< HEAD
import com.happier.flowering.entity.*;
import com.happier.flowering.mapper.*;
import com.happier.flowering.entity.User;

=======

import com.happier.flowering.entity.Attention;
import com.happier.flowering.entity.User;
import com.happier.flowering.mapper.AttentionMapper;


import com.happier.flowering.entity.Message;
import com.happier.flowering.entity.User;
import com.happier.flowering.mapper.MessageMapper;

import com.happier.flowering.mapper.UserMapper;
>>>>>>> cfdd22e1249577e0a60e777071be1d31ad980b48
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
<<<<<<< HEAD

import java.util.*;

=======
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
>>>>>>> cfdd22e1249577e0a60e777071be1d31ad980b48

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
           User user= this.userMapper.findUserById(i);
           users.add(user);
    }return users;
    }
    public  List<User> findPassive(int id){
        List<Integer> ids= this.attentionMapper.findUserpassiveId(id);
        List<User> users = new ArrayList<>();
        for(Integer i:ids){
            User user= this.userMapper.findUserById(i);
            users.add(user);
        }return users;
    }
<<<<<<< HEAD
    @Resource
    private CollectMapper collectMapper;
    @Resource
    private ArticleMapper articleMapper;
    public List<Article> findCollect(int id){
        List<Integer> ids= this.collectMapper.findCollect(id);
        List<Article> articles = new ArrayList<>();
        for(Integer i:ids){
            Article article = this.articleMapper.getArticalById(i);
            articles.add(article);
        }
        return articles;
    }
    @Resource
    private ThumbsUpMapper thumbsUpMapper;
    @Resource
    private PostMapper postMapper;

    public List<Map<String,String>> findThumbsOther(int id){
        List<Integer> ids= this.thumbsUpMapper.findThumbsOther(id);
        List<Map<String,String>> posts = new ArrayList<>();
        for(Integer i:ids){
            Post post = this.postMapper.searchPostByPostId(i);
            Map map = new HashMap();
            System.out.println(post.getUserId()+"***************");
            User user = this.userMapper.findUserById(post.getUserId());
            map.put("userName",user.getNickname());
            map.put("userImg",user.getHeadImg());
            map.put("postTxt",post.getTxt());
            map.put("postImg",post.getImg());
            posts.add(map);
        }
        return posts;
    }
    public List<Map<String,String>> findThumbsMe(int id){
        Post post = this.postMapper.searchPostByPostId(id);
        List<Integer> ids= this.thumbsUpMapper.findThumbsMe(id);
        List<Map<String,String>> list =new ArrayList<>();
        for(Integer i:ids){
            Map map = new HashMap();
            User user = this.userMapper.findUserById(i);
            map.put("userName",user.getNickname());
            map.put("userImg",user.getHeadImg());
            map.put("postTxt",post.getTxt());
            map.put("postImg",post.getImg());
            list.add(map);
        }
        return list;
    }
    private MessageMapper messageMapper;
=======


>>>>>>> cfdd22e1249577e0a60e777071be1d31ad980b48

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
