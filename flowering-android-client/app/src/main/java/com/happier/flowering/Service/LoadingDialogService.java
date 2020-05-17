package com.happier.flowering.Service;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.IBinder;

import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

public class LoadingDialogService extends Service {

    private ZLoadingDialog zLoadingDialog;

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ZLoadingDialog dialog = new ZLoadingDialog(getApplicationContext());
        dialog.setLoadingBuilder(Z_TYPE.LEAF_ROTATE)//设置类型
                .setLoadingColor(Color.GREEN)//颜色
                .setHintText("Loading...")
                .show();
        return super.onStartCommand(intent, flags, startId);
    }
}
