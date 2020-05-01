package com.happier.flowering.flowering.center.service;
import com.happier.flowering.entity.*;
import com.happier.flowering.mapper.*;
import com.happier.flowering.entity.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.*;


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

    /**
     * 個人私信
     * @param userId
     * @return
     */
    public List<Message> searchMessageByUserId(int userId){
        return messageMapper.searchMessageByUserId(userId);
    }


}
