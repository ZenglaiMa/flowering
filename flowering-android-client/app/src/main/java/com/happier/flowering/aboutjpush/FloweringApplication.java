package com.happier.flowering.aboutjpush;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

import cn.jpush.android.api.JPushInterface;

public class FloweringApplication extends Application {

    public static String registrationId;

    private List<Activity> mList = new LinkedList<Activity>();
    public static FloweringApplication instance;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

        registrationId = JPushInterface.getRegistrationID(this);
        Log.e("1099", "run:--------->registrationId： " + registrationId);
    }

    public FloweringApplication() {
    }

    public static String getRegistrationId() {
        return registrationId;
    }

    public static void setRegistrationId(String registrationId) {
        FloweringApplication.registrationId = registrationId;
    }

}
