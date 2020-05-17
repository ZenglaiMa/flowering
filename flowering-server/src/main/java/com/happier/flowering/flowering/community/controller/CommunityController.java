package com.happier.flowering.flowering.community.controller;

import com.google.gson.Gson;
import com.happier.flowering.entity.Article;
import com.happier.flowering.entity.Collect;
import com.happier.flowering.entity.Type;
import com.happier.flowering.flowering.community.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @ClassName CommunityController
 * @Description 花间(即文章) controller 每个方法的解释参考service层
 * @Author Seven 赵语涵
 * @Date 2020-04-15 15:12
 */
@RestController
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @RequestMapping("/getAllTypes")
    public String getAllTypes() {
        List<Type> typeList = communityService.getAllTypes();
        return new Gson().toJson(typeList);
    }

    @RequestMapping("/getAllArticles")
    public String getAllArticles() {
        List<Article> typeList = communityService.getAllArticle();
        return new Gson().toJson(typeList);
    }

    @RequestMapping("/setStar")
    public void setStar(HttpServletRequest request) {
        try {
            ServletInputStream is = request.getInputStream();
            InputStreamReader isR = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isR);
            String jsonStr = reader.readLine();
            Collect collect = new Gson().fromJson(jsonStr, Collect.class);
            communityService.setStar(collect);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/isStar")
    public String isStar(HttpServletRequest request) {
        try {
            ServletInputStream is = request.getInputStream();
            InputStreamReader isR = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isR);
            String jsonStr = reader.readLine();
            Collect collect = new Gson().fromJson(jsonStr, Collect.class);
            int flag = communityService.isStar(collect);
            return flag + "";
        } catch (Exception e) {
            e.printStackTrace();
            return "-------";
        }
    }

    @RequestMapping("/unStar")
    public void unStar(HttpServletRequest request) {
        try {
            ServletInputStream is = request.getInputStream();
            InputStreamReader isR = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isR);
            String jsonStr = reader.readLine();
            Collect collect = new Gson().fromJson(jsonStr, Collect.class);
            communityService.unStar(collect);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/getArticleByType")
    public String getArticleByType(HttpServletRequest request) {
        try {
            ServletInputStream is = request.getInputStream();
            InputStreamReader isR = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isR);
            String str = reader.readLine();
            List<Article> articles = communityService.getArticleByType(Integer.parseInt(str));
            return new Gson().toJson(articles);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

    @RequestMapping("/addReadingNum")
    public void addReadingNum(HttpServletRequest request) {
        try {
            ServletInputStream is = request.getInputStream();
            InputStreamReader isR = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isR);
            String str = reader.readLine();
            communityService.updateReadingNum(Integer.parseInt(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/search")
    public String search(HttpServletRequest request) {
        try {
            ServletInputStream is = request.getInputStream();
            InputStreamReader isR = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isR);
            String str = reader.readLine();
            List<Article> articles = communityService.searchArtical(str);
            return new Gson().toJson(articles);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @GetMapping("/collect")
    public List<Article> getCollectedArticles(@RequestParam("userId") Integer userId) {
        return communityService.listArticlesOfUserCollected(userId);
    }
}
