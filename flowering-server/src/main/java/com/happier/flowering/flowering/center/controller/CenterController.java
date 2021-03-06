package com.happier.flowering.flowering.center.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.happier.flowering.entity.Article;
import com.happier.flowering.entity.Post;
import com.happier.flowering.entity.User;
import com.happier.flowering.flowering.center.service.CenterService;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
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
    public String getUser(@RequestParam("id") int id) {
        Map<String, Object> map = new HashMap<>();
        User user = this.centerService.findUser(id);
        map.put("username", user.getNickname());
        map.put("userImg", user.getHeadImg());
        map.put("address", user.getAddress());
        map.put("sex", user.getSex());
        map.put("profile", user.getProfile());
        List attention = this.centerService.findInitiative(id);
        map.put("attention", attention.size());
        List fans = this.centerService.findPassive(id);
        map.put("fans", fans.size());
        List BePraised = this.centerService.findThumbsMe(id);
        map.put("bepraised", BePraised.size());

        return new Gson().toJson(map);
    }

    @RequestMapping("/findInitiative")
    public String findInitiative(@RequestParam("id") int id) {
        List<User> users = this.centerService.findInitiative(id);
        System.out.println("我的关注" + new Gson().toJson(users));
        return new Gson().toJson(users);
    }

    @RequestMapping("/findPassive")
    public String findPassive(@RequestParam("id") int id) {
        List<User> users = this.centerService.findPassive(id);
        System.out.println("我的粉丝" + new Gson().toJson(users));
        return new Gson().toJson(users);
    }

    @RequestMapping("/findCollect")
    public String findCollect(@RequestParam("id") int id) {
        List<Article> articles = this.centerService.findCollect(id);
        System.out.println("我的收藏" + new Gson().toJson(articles));
        return new Gson().toJson(articles);
    }

    @RequestMapping("/findThumbsOther")
    public String findThumbsOther(@RequestParam("id") int id) {
        List<Map<String, Object>> maps = this.centerService.findThumbsOther(id);
        System.out.println("我的点赞" + new Gson().toJson(maps));
        return new Gson().toJson(maps);
    }

    @RequestMapping("/findThumbsMe")
    public String findThumbsMe(@RequestParam("id") int id) {
        List<Map<String, Object>> maps = this.centerService.findThumbsMe(id);
        return new Gson().toJson(maps);
    }

    @RequestMapping("/findComments")
    public String findComments(@RequestParam("id") int id) {
        List<Map<String, Object>> maps = this.centerService.findComments(id);
        return new Gson().toJson(maps);
    }

    /**
     * qiao  日期格式进行了修改
     *
     * @param id
     * @return
     */
    @RequestMapping("/findPosts")
    public String findPosts(@RequestParam("id") int id) {
        List<Post> posts = this.centerService.findPosts(id);
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();
        return gson.toJson(posts);
    }

    /**
     * =============关注相关===========
     *
     * @param userInitiative
     * @param userPassive
     */
    @RequestMapping("/addAttention")
    public String addAttention(@RequestParam("userInitiative") int userInitiative, @RequestParam("userPassive") int userPassive) {
        //userInitiative:主动关注者
        //userPassive:被动关注者
        return this.centerService.addAttention(userInitiative, userPassive);
    }

    @RequestMapping("/ifAttention")
    public String ifAttention(@RequestParam("userInitiative") int userInitiative, @RequestParam("userPassive") int userPassive) {
        return this.centerService.ifAttention(userInitiative, userPassive);
    }

    @RequestMapping("/removeAttention")
    public String removeAttention(@RequestParam("userInitiative") int userInitiative, @RequestParam("userPassive") int userPassive) {
        return this.centerService.removeAttention(userInitiative, userPassive);
    }

    /**
     * 個人詳情私信
     *
     * @param userId
     * @return
     */
    @RequestMapping("/getAllMineMessage")
    public String searchMessageByUserId(@RequestParam("userId") int userId) {
        List<Map<String, Object>> messageAboutList = this.centerService.searchMessageByUserId(userId);
        return new Gson().toJson(messageAboutList);
    }

    /**
     * 发送私信
     *
     * @param userId
     * @param recvId
     * @param mContent
     * @return
     */
    @RequestMapping("/sendMessage")
    public String sendMessage(@RequestParam("userId") int userId, @RequestParam("recvId") int recvId, @RequestParam("mContent") String mContent) {
        int num = this.centerService.sendMessage(userId, recvId, mContent);
        if (num == 1) {
            return "ok";
        }
        return "fail";
    }

    @RequestMapping("/registUser")
    public int registUser(@RequestParam("nickname") String nickname, @RequestParam("gender") Integer sex, @RequestParam("password") String password,
                          @RequestParam("address") String address, @RequestParam("profile") String profile) {
        return centerService.registUser(nickname, sex, password, address, profile);
    }

    @RequestMapping("/loginUser")
    public int loginUser(@RequestParam("password") String pass, @RequestParam("nickname") String name) {
        User user = centerService.loginUser(pass, name);
        return user.getUserId();
    }

    /**
     * =======编辑信息相关=======
     */
    @RequestMapping("/uploadHeaderImage")
    public int uploadHeaderImage(@RequestParam("userId") int id, @RequestParam("pName") MultipartFile file) {
        String path = "/header-img/" + System.currentTimeMillis() + ".jpg";
        System.out.println("upHead");
        StringBuffer picPath = new StringBuffer();
        if (file != null) {
            System.out.println(file.getSize());
            try {
                String tempPath = ResourceUtils.getURL("classpath:").getPath() + "static/header-img";
                String realPath = tempPath.replace("%20", " ").replace("/", "\\").substring(1);
                String fileName = System.currentTimeMillis() + ".jpg";
                file.transferTo(new File(realPath, fileName));
                System.out.println(realPath);
                picPath.append("/header-img/" + fileName + ",");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return this.centerService.uploadHeaderImage(id, path);
    }

    @RequestMapping("/editName")
    public int updateName(@RequestParam("userId") int userId, @RequestParam("name") String name) {
        return this.centerService.updateName(userId, name);
    }

    @RequestMapping("/editProfile")
    public int updateProfile(@RequestParam("userId") int userId, @RequestParam("profile") String profile) {
        return this.centerService.updateProfile(userId, profile);
    }

    @GetMapping("/UserSimpleInfo")
    public User showSimpleInfo(@RequestParam("userId") Integer userId) {
        return centerService.findUser(userId);
    }

    @GetMapping("/UpdatePersonalInfo")
    public int editPersonalInfo(@RequestParam("userId") Integer userId, @RequestParam("nickname") String nickname, @RequestParam("gender") int gender, @RequestParam("address") String address, @RequestParam("profile") String profile) {
        return centerService.updatePersonalInfo(userId, nickname, gender, address, profile);
    }

}
