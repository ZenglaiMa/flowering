package com.happier.flowering.AboutJPush;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.happier.flowering.MainActivity;

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
//        Log.e("test", "接收到通知, 通知标题：" + notificationMessage.notificationTitle
//                + "  通知内容:" + notificationMessage.notificationContent + " 附加字段：" + notificationMessage.notificationExtras);
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
