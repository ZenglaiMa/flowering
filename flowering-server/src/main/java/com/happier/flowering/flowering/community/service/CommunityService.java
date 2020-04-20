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
import com.happier.flowering.entity.Article;
import com.happier.flowering.mapper.ArticleMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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

    /*
     * @description 任务调度 + JPush推送文章方法1
     * @author 赵语涵
     */
//    @Scheduled(cron = "0/2 * * * * ?")
    public void jpush() {
        Article article = articleMapper.getArticalById(1);
        System.out.println(article.toString());
        //TODO
        jSend_notification("一条消息", "c");
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
//                .setAudience(Audience.registrationId("140fe1da9e35c48bff1"))
                .setAudience(Audience.all())
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
