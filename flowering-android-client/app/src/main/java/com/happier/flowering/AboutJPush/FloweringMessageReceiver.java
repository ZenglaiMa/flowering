package com.happier.flowering.aboutjpush;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.entity.Article;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.service.JPushMessageReceiver;

public class FloweringMessageReceiver extends JPushMessageReceiver {
    //处理消息
    //通知消息到达时回调(通知)
    @Override
    public void onNotifyMessageArrived(Context context, NotificationMessage notificationMessage) {
        super.onNotifyMessageArrived(context, notificationMessage);
        Log.e("test", "通知到达");
        String extras = notificationMessage.notificationExtras;
        String flag="";
        try {
            JSONObject jsonObject = new JSONObject(extras);
            String str = jsonObject.optString("extras");
            Map<String, Object> map = new Gson().fromJson(str, new TypeToken<Map<String, Object>>() {}.getType());
            flag = (String)map.get("flag");
            if(flag.equals("0")) {//文章推送
                Article article = new Gson().fromJson((String)map.get("artical"), Article.class);
            }else {//私信

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //用户点击通知时被回调(通知)
    @Override
    public void onNotifyMessageOpened(Context context, NotificationMessage notificationMessage) {
        super.onNotifyMessageOpened(context, notificationMessage);
        Log.e("test", "通知被点击");
        //点击通知时回调，可以启动固定界面(例子是点击进入首页)
//        Intent intent = new Intent(context, MainActivity.class);
//        intent.putExtra("extraData", notificationMessage.notificationExtras);
//        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);//如果已经处于活动状态就不会再被启动
//        context.startActivity(intent);
    }
    //用户收到自定义消息时被回调(消息)
    @Override
    public void onMessage(Context context, CustomMessage customMessage) {
        super.onMessage(context, customMessage);
        Log.e("test", "自定义消息到达");
//        Log.e("test", customMessage.message);
//        Intent intent = new Intent(context, MainActivity.class);
//        intent.putExtra("text", customMessage.message);//自定义消息内容
//        intent.putExtra("extraData", customMessage.extra);//自定义消息的额外数据(字段)，json格式
//        context.startActivity(intent);
    }


}
