package com.happier.flowering.flowering.center.controller;

import com.google.gson.Gson;
import com.happier.flowering.entity.Article;
import com.happier.flowering.entity.Message;
import com.happier.flowering.entity.User;
import com.happier.flowering.flowering.center.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CenterController
 * @Description 个人中心 controller
 * @Author Seven
 * @Date 2020-04-15 15:11
 */
@RestController
@RequestMapping("/center")
public class CenterController {

    @Resource
    private CenterService centerService;

    @RequestMapping("/userInfo")
    public String getUser(@RequestParam("id") int id){
      User user=  this.centerService.findUser(id);
      System.out.println(user.getNickname());
     return new Gson().toJson(user);
    }

    @RequestMapping("/findInitiative")
    public String findInitiative(@RequestParam("id") int id){
        List<User> users = this.centerService.findInitiative(id);
        return new Gson().toJson(users);
    }
    @RequestMapping("/findPassive")
    public String findPassive(@RequestParam("id") int id){
        List<User> users = this.centerService.findPassive(id);
        return new Gson().toJson(users);
    }
    @RequestMapping("/findCollect")
    public String findCollect(@RequestParam("id") int id){
        List<Article> articles = this.centerService.findCollect(id);
        return new Gson().toJson(articles);
    }
    @RequestMapping("/findThumbsOther")
    public String findThumbsOther(@RequestParam("id") int id){
        List<Map<String,String>> maps = this.centerService.findThumbsOther(id);
        return new Gson().toJson(maps);
    }
    @RequestMapping("/findThumbsMe")
    public String findThumbsMe(@RequestParam("id") int id){
        List<Map<String,String>> maps = this.centerService.findThumbsMe(id);
        return new Gson().toJson(maps);
    }
    /**
     * 個人詳情私信
     * @param userId
     * @return
     */
    @RequestMapping("/getAllMineMessage")
    public  String searchMessageByUserId(int userId) {
        List<Message> messageList = this.centerService.searchMessageByUserId(userId);
        return new Gson().toJson(messageList);

    }

}
