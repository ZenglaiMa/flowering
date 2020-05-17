package com.happier.flowering.flowering.community.service;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.Notification;
import com.google.gson.Gson;
import com.happier.flowering.entity.Article;
import com.happier.flowering.entity.Collect;
import com.happier.flowering.entity.Type;
import com.happier.flowering.mapper.ArticleMapper;
import com.happier.flowering.mapper.CollectMapper;
import com.happier.flowering.mapper.TypeMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ClassName CommunityService
 * @Description 花间(即文章) service
 * @Author Seven 赵语涵
 * @Date 2020-04-15 15:12
 */
@Service
@Transactional(readOnly = false)
public class CommunityService {
    private final static String appKey = "17b9165411a620c111f01372";
    private final static String masterSecret = "44346d9b2e6467923cebfd1d";

    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private TypeMapper typeMapper;
    @Resource
    private CollectMapper collectMapper;

    /**
     * @Description 查询用户收藏的文章
     * @Author Seven
     * @Date 2020/5/17 17:27
     * @Params [userId]
     * @return java.util.List<com.happier.flowering.entity.Article>
     **/
    public List<Article> listArticlesOfUserCollected(Integer userId) {
        return articleMapper.getArticlesByUserCollected(userId);
    }

    /*
     * @description 花间的模糊查找
     * @param keyWord 模糊查找的关键字
     * @return
     * @author 赵语涵
     */
    public List<Article> searchArtical(String keyWord) {
        return articleMapper.searchArtical(keyWord);
    }

    /*
     * @description 为某篇文章增加一个阅读量
     * @param articleId 针对哪篇文章
     * @return
     * @author 赵语涵
     */
    public void updateReadingNum(int articleId) {
        int num = articleMapper.getReadingNum(articleId);
        articleMapper.addReadingNum(articleId, num + 1);
    }

    /*
     * @description 获取某个类型的所有文章
     * @param typeId
     * @return
     * @author 赵语涵
     */
    public List<Article> getArticleByType(int typeId) {
        return articleMapper.getArticleByType(typeId);
    }

    /*
     * @description 某个人将某个文章取消收藏
     * @param collect
     * @author 赵语涵
     */
    public void unStar(Collect collect) {
        collectMapper.unStar(collect);
    }

    /*
     * @description 判断一篇文章是否被一个用户收藏
     * @param collect
     * @return
     * @author 赵语涵
     */
    public int isStar(Collect collect) {
        int count = collectMapper.isStar(collect);
        if (count == 0) {
            return 0;//没有收藏
        } else {
            return 1;//收藏了
        }
    }

    /*
     * @description 某个人将某个文章收藏
     * @param collect 传进来的collect
     * @return
     * @author 赵语涵
     */
    public void setStar(Collect collect) {
        collectMapper.setStar(collect);
    }

    /*
     * @description 获取所有的类型
     * @author 赵语涵
     */
    public List<Type> getAllTypes() {
        return typeMapper.getAllTypes();
    }

    /*
     * @description 获取所有的文章
     * @return
     * @author 赵语涵
     */
    public List<Article> getAllArticle() {
        return articleMapper.getAllArtical();
    }

    /*
     * @description 任务调度 + JPush推送文章方法1
     * @author 赵语涵
     */
//    @Scheduled(cron = "0/10 * * * * ?")
    public void jpush() {
        int count = articleMapper.getCount();
        Random rand = new Random();
        int randNum = rand.nextInt(count) + 1;
        Article article = articleMapper.getArticalById(randNum);
        System.out.println(article.toString());

        Map<String, Object> map = new HashMap<>();
        map.put("flag", "0");//0代表是文章推送，1代表是私信
        map.put("artical", new Gson().toJson(article));
        jSend_notification(article.getTitle(), new Gson().toJson(map));
    }

    /*
     * @description JPush推送文章方法2
     * @param registrationId  特定的用户的registrationId 暂时没用到 删除了
     * @param alert 提醒的内容
     * @param extrasparam 附带的参数
     * @author 赵语涵
     */
    public void jSend_notification(String alert, String extrasparam) {
        JPushClient jpushClient = new JPushClient(masterSecret, appKey, 3);
        PushPayload payload = send_N(alert, extrasparam);
        try {
            PushResult result = jpushClient.sendPush(payload);
            System.out.println(result + "==========");
        } catch (APIConnectionException e) {
            System.out.println(e);
        } catch (APIRequestException e) {
            System.out.println(e);
            System.out.println("Error response from JPush server. Should review and fix it. " + e);
            System.out.println("HTTP Status: " + e.getStatus());
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("Error Message: " + e.getErrorMessage());
            System.out.println("Msg ID: " + e.getMsgId());
        }
    }

    /*
     * @description JPush推送文章方法3
     * @param registrationId  特定的用户的registrationId 暂时没用到 删除了
     * @param alert 提醒的内容
     * @param extrasparam 附带的参数
     * @author 赵语涵
     */
    public PushPayload send_N(String alert, String extrasparam) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())//    推送平台设置：所有平台
                .setAudience(Audience.registrationId("140fe1da9e35c48bff1"))
//                .setAudience(Audience.all())
//    			.setNotification(Notification.alert(alert))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .setAlert(alert)
                                .addExtra("extras", extrasparam)
                                .build()).build())
                .setOptions(Options.newBuilder()
                        .setApnsProduction(false)
                        .build())
                .build();
    }
}
