package com.happier.flowering.flowering.center.service;

import com.happier.flowering.entity.*;
import com.happier.flowering.mapper.*;
import org.springframework.stereotype.Service;

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
    @Resource
    private CommentMapper commentMapper;

    public User findUser(int id) {
        return this.userMapper.findUserById(id);
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
        List<Article> articles = new ArrayList<>();
        for (Integer i : ids) {
            Article article = this.articleMapper.getArticalById(i);
            articles.add(article);
        }
        return articles;
    }

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

    public List<Map<String, Object>> findThumbsMe(int userId) {
        List<Post> posts = postMapper.searchPostByUserId(userId);
        List<Map<String, Object>> resultSet = new ArrayList<>();
        for (Post post : posts) {
            List<ThumbsUp> thumbsUps = thumbsUpMapper.findThumbsMe(post.getPostId());
            for (ThumbsUp thumbsUp : thumbsUps) {
                Map<String, Object> map = new HashMap<>();
                User user = userMapper.findUserById(thumbsUp.getUserId());
                map.put("userName", user.getNickname());
                map.put("userHeadImg", user.getHeadImg());
                map.put("thumbsUpTime", thumbsUp.getTime());
                resultSet.add(map);
            }
        }

        return resultSet;
    }

    public List<Map<String, Object>> findComments(int userId) {
        List<Map<String, Object>> list = new ArrayList<>();
        List<Post> posts = this.postMapper.searchPostByUserId(userId);
        for (Post post : posts) {
            List<Comment> comments = this.commentMapper.findCommentByPostId(post.getPostId());
            for (Comment comment : comments) {
                User user = this.userMapper.findUserById(comment.getUserId());
                Map map = new HashMap();
                map.put("CommentTime", comment.getTime());
                map.put("UserName", user.getNickname());
                map.put("PostImg", post.getImg());
                map.put("PostId", post.getPostId());
                list.add(map);
            }
        }

        return list;
    }

    public List<Post> findPosts(int userId) {
        List<Post> posts = this.postMapper.searchPostByUserId(userId);
        return posts;
    }

    public String addAttention(int userInitiative, int userPassive) {
        int num = this.attentionMapper.insertAttention(userInitiative, userPassive);
        if (num == 1) {
            return "no";
        }
        return "yes";
    }

    public String ifAttention(int userInitiative, int userPassive) {
        int a = this.attentionMapper.ifAttention(userInitiative, userPassive);
        if (a == 0) {
            return "no";
        } else {
            return "yes";
        }
    }

    public String removeAttention(int userInitiative, int userPassive) {
        int num = this.attentionMapper.deleteAttention(userInitiative, userPassive);
        if (num == 1) {
            return "no";
        }
        return "yes";

    }

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

    public int sendMessage(int sendId, int recvId, String content) {
        Date time = new Date(new java.util.Date().getTime());
        int num = messageMapper.sendMessage(sendId, recvId, content, time);
        return num;
    }

    public int registUser(String nickname, Integer sex, String password, String address, String profile) {
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

    public User loginUser(String pass, String name) {
        return userMapper.loginUser(pass, name);
    }

    public int uploadHeaderImage(int id, String path) {
        return userMapper.updateImg(id, path);
    }

    public int updateName(int id, String name) {
        return userMapper.updateName(id, name);
    }

    public int updateProfile(int id, String profile) {
        return userMapper.updateProfile(id, profile);
    }

    public int updatePersonalInfo(Integer userId, String nickname, int gender, String address, String profile) {
        return userMapper.updateUserInfo(userId, nickname, gender, address, profile);
    }

}
