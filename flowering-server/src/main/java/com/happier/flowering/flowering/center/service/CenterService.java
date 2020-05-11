package com.happier.flowering.flowering.center.service;

import com.happier.flowering.entity.*;
import com.happier.flowering.mapper.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Date;
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
    private UserMapper userMapper;
    @Resource
    private MessageMapper messageMapper;
    @Resource
    private AttentionMapper attentionMapper;
    @Resource
    private CollectMapper collectMapper;
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ThumbsUpMapper thumbsUpMapper;
    @Resource
    private PostMapper postMapper;

    /**
     * @ClassName CenterService
     * @Description 根据用户id查询用户基本信息
     * @Author 陈雅楠
     * @Date 2020/5/1
     */
    public User findUser(int id) {
        User user = this.userMapper.findUserById(id);
        return user;
    }

    /**
     * @ClassName CenterService
     * @Description 查询关注
     * @Author 陈雅楠
     * @Date 2020/5/1
     */
    public List<User> findInitiative(int id) {
        List<Integer> ids = this.attentionMapper.findUserInitiativeId(id);
        List<User> users = new ArrayList<>();
        for (Integer i : ids) {
            User user = this.userMapper.findUserById(i);
            users.add(user);
        }
        return users;
    }

    /**
     * @ClassName CenterService
     * @Description 查询粉丝
     * @Author 陈雅楠
     * @Date 2020/5/1
     */
    public List<User> findPassive(int id) {
        List<Integer> ids = this.attentionMapper.findUserpassiveId(id);
        List<User> users = new ArrayList<>();
        for (Integer i : ids) {
            User user = this.userMapper.findUserById(i);
            users.add(user);
        }
        return users;
    }

    /**
     * @ClassName CenterService
     * @Description 查询收藏的花间
     * @Author 陈雅楠
     * @Date 2020/5/1
     */
    public List<Article> findCollect(int id) {
        List<Integer> ids = this.collectMapper.findCollect(id);
        List<Article> articles = new ArrayList<>();
        for (Integer i : ids) {
            Article article = this.articleMapper.getArticalById(i);
            articles.add(article);
        }
        return articles;
    }

    /**
     * @ClassName CenterService
     * @Description 查询点赞别人的帖子
     * @Author 陈雅楠
     * @Date 2020/5/1
     */
    public List<Map<String, Object>> findThumbsOther(int id) {
        List<Integer> ids = this.thumbsUpMapper.findThumbsOther(id);
        List<Map<String, Object>> posts = new ArrayList<>();
        for (Integer i : ids) {
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

    /**
     * @ClassName CenterService
     * @Description 查询我的帖子的获赞
     * @Author 陈雅楠
     * @Date 2020/5/1
     */

    public List<Map<String, Object>> findThumbsMe(int userId) {
        List<Post> posts = this.postMapper.searchPostByUserId(userId);
        List<Map<String, Object>> list = new ArrayList<>();
        for (Post post : posts) {
            post = this.postMapper.searchPostByPostId(post.getPostId());
            List<Integer> userIds = this.thumbsUpMapper.findThumbsMe(post.getPostId());
            for (Integer i : userIds) {
                Map map = new HashMap();
                User user = this.userMapper.findUserById(i);
                map.put("userName", user.getNickname());
                map.put("userImg", user.getHeadImg());
                map.put("postTxt", post.getTxt());
                map.put("postImg", post.getImg());
                list.add(map);
            }
        }
        return list;
    }

    /**
     * @ClassName CenterService
     * @Description 查询我的通知
     * @Author 陈雅楠
     * @Date 2020/5/2
     */
    @Resource
    CommentMapper commentMapper;

    public List<Map<String, Object>> findComments(int userId) {
        List<Map<String, Object>> list = new ArrayList<>();
        List<Post> posts = this.postMapper.searchPostByUserId(userId);
        for (Post post : posts) {
            List<Comment> comments = this.commentMapper.findCommentByPostId(post.getPostId());
            for (Comment comment : comments) {
                User user = this.userMapper.findUserById(comment.getUserId());
                Map map = new HashMap();
                map.put("CommentContent", comment.getContent());
                map.put("CommentTime", comment.getTime());
                map.put("UserName", user.getNickname());
                map.put("UserImg", user.getHeadImg());
                map.put("PostContent", post.getTxt());
                map.put("PostImg", post.getImg());
                list.add(map);
            }
        }
        return list;
    }


    public List<Post> findPosts(int userId){
        List<Post> posts = this.postMapper.searchPostByUserId(userId);
        return  posts;
    }

    public void addAttention(int userInitiative, int userPassive){

        this.attentionMapper.insertAttention(userInitiative,userPassive);
    }
    public String ifAttention(int userInitiative, int userPassive) {
        int a = this.attentionMapper.ifAttention(userInitiative, userPassive);
        if (a == 0) {
            return "no";
        }
        else return "yes";
    }
    /**
     * 個人私信
     *
     * @param userId
     * @return
     */
    public List<Map<String, Object>> searchMessageByUserId(int userId) {
        List<Map<String, Object>> maUsers = new ArrayList<>();
        List<Message> messages = messageMapper.searchMessageByUserId(userId);
        for (int i = 0; i < messages.size(); i++) {
            Map map = new HashMap();
            User user = this.userMapper.findUserById(messages.get(i).getUserIdSend());
            map.put("content", messages.get(i).getContent());
            map.put("senderId", messages.get(i).getUserIdSend());
            map.put("time", messages.get(i).getTime());
            map.put("uid", messages.get(i).getUserIdSend());
            map.put("senderHead", user.getHeadImg());
            map.put("senderName", user.getNickname());
            maUsers.add(map);
        }

        return maUsers;
    }
    /**
     * 回复私信发送
     */
    public int sendMessage(int sendId,int recvId,String content){
        Date time= new Date(new java.util.Date().getTime());
        int num=messageMapper.sendMessage(sendId,recvId,content,time);
        return num;
    }
/**
 * ==========注册登陆相关=========
 */
    /**
     * 注册返回自增id
     * @param nickname
     * @param sex
     * @param password
     * @param address
     * @param profile
     * @return
     */
    public int registUser(String nickname,Integer sex,String password,String address,String profile) {
        User u = new User();
        u.setNickname(nickname);
        u.setSex(sex);
        u.setPassword(password);
        u.setAddress(address);
        u.setProfile(profile);
        if (userMapper.registUser(u) == 1) {
            return u.getUserId();
        }
        return 0;
    }
    public User loginUser(String pass, String name){
        return userMapper.loginUser(pass,name);

    }
}
