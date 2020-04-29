package com.happier.flowering.flowering.center.controller;

import com.google.gson.Gson;
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
