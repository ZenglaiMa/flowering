package com.happier.flowering.flowering.center.service;

import com.happier.flowering.entity.*;
import com.happier.flowering.mapper.*;
import com.happier.flowering.entity.User;
<<<<<<< HEAD



import com.happier.flowering.entity.Attention;
import com.happier.flowering.entity.User;
=======
>>>>>>> 31c113d6ed61d93effc4be50efc1fe11310f58cf
import com.happier.flowering.mapper.AttentionMapper;
import com.happier.flowering.entity.Message;
import com.happier.flowering.mapper.MessageMapper;
import com.happier.flowering.mapper.UserMapper;
<<<<<<< HEAD

=======
>>>>>>> 31c113d6ed61d93effc4be50efc1fe11310f58cf
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
<<<<<<< HEAD

import java.util.*;


=======
>>>>>>> 31c113d6ed61d93effc4be50efc1fe11310f58cf
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
<<<<<<< HEAD

=======
>>>>>>> 31c113d6ed61d93effc4be50efc1fe11310f58cf

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
    private UserMapper userMapper;
    @Resource
    private MessageMapper messageMapper;
<<<<<<< HEAD
    /**
     * @ClassName CenterService
     * @Description 根据用户id查询用户基本信息
     * @Author 陈雅楠
     * @Date 2020/5/1
     */
    public User findUser(int id){
      User user=this.userMapper.findUserById(id);
      return user;
    }
    /**
     * @ClassName CenterService
     * @Description 查询关注
     * @Author 陈雅楠
     * @Date 2020/5/1
     */
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
    /**
     * @ClassName CenterService
     * @Description 查询粉丝
     * @Author 陈雅楠
     * @Date 2020/5/1
     */
    public  List<User> findPassive(int id){
        List<Integer> ids= this.attentionMapper.findUserpassiveId(id);
        List<User> users = new ArrayList<>();
        for(Integer i:ids){
            User user= this.userMapper.findUserById(i);
            users.add(user);
        }return users;
    }

=======
    @Resource
    private AttentionMapper attentionMapper;
>>>>>>> 31c113d6ed61d93effc4be50efc1fe11310f58cf
    @Resource
    private CollectMapper collectMapper;
    @Resource
    private ArticleMapper articleMapper;
<<<<<<< HEAD
    /**
     * @ClassName CenterService
     * @Description 查询收藏的花间
     * @Author 陈雅楠
     * @Date 2020/5/1
     */
    public List<Article> findCollect(int id){
        List<Integer> ids= this.collectMapper.findCollect(id);
=======
    @Resource
    private ThumbsUpMapper thumbsUpMapper;
    @Resource
    private PostMapper postMapper;

    public User findUser(int id) {
        User user = this.userMapper.findUserById(id);
        return user;
    }

    public List<User> findInitiative(int id) {
        List<Integer> ids = this.attentionMapper.findUserInitiativeId(id);
        List<User> users = new ArrayList<>();
        for (Integer i : ids) {
            User user = this.userMapper.findUserById(i);
            users.add(user);
        }
        return users;
    }

    public List<User> findPassive(int id) {
        List<Integer> ids = this.attentionMapper.findUserpassiveId(id);
        List<User> users = new ArrayList<>();
        for (Integer i : ids) {
            User user = this.userMapper.findUserById(i);
            users.add(user);
        }
        return users;
    }

    public List<Article> findCollect(int id) {
        List<Integer> ids = this.collectMapper.findCollect(id);
>>>>>>> 31c113d6ed61d93effc4be50efc1fe11310f58cf
        List<Article> articles = new ArrayList<>();
        for (Integer i : ids) {
            Article article = this.articleMapper.getArticalById(i);
            articles.add(article);
        }
        return articles;
    }
<<<<<<< HEAD
    @Resource
    private ThumbsUpMapper thumbsUpMapper;
    @Resource
    private PostMapper postMapper;
    /**
     * @ClassName CenterService
     * @Description 查询点赞别人的帖子
     * @Author 陈雅楠
     * @Date 2020/5/1
     */
    public List<Map<String,String>> findThumbsOther(int id){
        List<Integer> ids= this.thumbsUpMapper.findThumbsOther(id);
        List<Map<String,String>> posts = new ArrayList<>();
        for(Integer i:ids){
=======

    public List<Map<String, String>> findThumbsOther(int id) {
        List<Integer> ids = this.thumbsUpMapper.findThumbsOther(id);
        List<Map<String, String>> posts = new ArrayList<>();
        for (Integer i : ids) {
>>>>>>> 31c113d6ed61d93effc4be50efc1fe11310f58cf
            Post post = this.postMapper.searchPostByPostId(i);
            Map map = new HashMap();
            System.out.println(post.getUserId() + "***************");
            User user = this.userMapper.findUserById(post.getUserId());
            map.put("userName", user.getNickname());
            map.put("userImg", user.getHeadImg());
            map.put("postTxt", post.getTxt());
            map.put("postImg", post.getImg());
            posts.add(map);
        }
        return posts;
    }
<<<<<<< HEAD
    /**
     * @ClassName CenterService
     * @Description 查询我的帖子的获赞
     * @Author 陈雅楠
     * @Date 2020/5/1
     */
    public List<Map<String,String>> findThumbsMe(int id) {
        List<Post> myposts = this.postMapper.searchPostByUserId(id);
        List<Map<String, String>> list = new ArrayList<>();
        for (Post p : myposts) {
            Post post = this.postMapper.searchPostByPostId(p.getPostId());
            List<Integer> ids = this.thumbsUpMapper.findThumbsMe(p.getPostId());
            for (Integer i : ids) {
                Map map = new HashMap();
                User user = this.userMapper.findUserById(i);
                map.put("userName", user.getNickname());
                map.put("userImg", user.getHeadImg());
                map.put("postTxt", post.getTxt());
                map.put("postImg", post.getImg());
                list.add(map);
            }

=======

    public List<Map<String, String>> findThumbsMe(int id) {
        Post post = this.postMapper.searchPostByPostId(id);
        List<Integer> ids = this.thumbsUpMapper.findThumbsMe(id);
        List<Map<String, String>> list = new ArrayList<>();
        for (Integer i : ids) {
            Map map = new HashMap();
            User user = this.userMapper.findUserById(i);
            map.put("userName", user.getNickname());
            map.put("userImg", user.getHeadImg());
            map.put("postTxt", post.getTxt());
            map.put("postImg", post.getImg());
            list.add(map);
>>>>>>> 31c113d6ed61d93effc4be50efc1fe11310f58cf
        }
        return list;
    }

<<<<<<< HEAD
        /**
         * 個人私信
         * @param userId
         * @return
         */
        public List<Map<String, Object>> searchMessageByUserId ( int userId){
            List<Map<String, Object>> mUsers = new ArrayList<>();
            List<Message> messages = messageMapper.searchMessageByUserId(userId);
            for (int i = 0; i < messages.size(); i++) {
                Map map = new HashMap();
                User user = userMapper.findUserById(messages.get(i).getUserIdSend());
                map.put("content", messages.get(i));
                map.put("sender", user);
                mUsers.add(map);
            }
            for (int j = 0; j < mUsers.size(); j++) {
                System.out.println(mUsers.get(j).get("content").toString() + mUsers.get(j).get("sender").toString());
            }

            return mUsers;
        }


=======
    /**
     * 個人私信
     *
     * @param userId
     * @return
     */
    public List<Map<String, Object>> searchMessageByUserId(int userId) {
        List<Map<String, Object>> mUsers = new ArrayList<>();
        List<Message> messages = messageMapper.searchMessageByUserId(userId);
        for (int i = 0; i < messages.size(); i++) {
            Map map = new HashMap();
            User user = userMapper.findUserById(messages.get(i).getUserIdSend());
            map.put("content", messages.get(i));
            map.put("sender", user);
            mUsers.add(map);
        }
        for (int j = 0; j < mUsers.size(); j++) {
            System.out.println(mUsers.get(j).get("content").toString() + mUsers.get(j).get("sender").toString());
        }

        return mUsers;
    }
>>>>>>> 31c113d6ed61d93effc4be50efc1fe11310f58cf
}
