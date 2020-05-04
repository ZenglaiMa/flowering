package com.happier.flowering.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zyao89.view.zloading.ZLoadingBuilder;
import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

public class LoadingActivity extends AppCompatActivity {
    private ZLoadingDialog zLoadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ZLoadingDialog dialog = new ZLoadingDialog(LoadingActivity.this);
        dialog.setLoadingBuilder(Z_TYPE.LEAF_ROTATE)//设置类型
                .setLoadingColor(Color.GREEN)//颜色
                .setHintText("Loading...")
                .show();

        Intent intent1 = getIntent();
        String path = intent1.getStringExtra("path");

        Intent intent2 = new Intent(LoadingActivity.this,FindPlantDetailActivity.class);
        intent2.putExtra("path",path);
        startActivity(intent2);
        finish();
    }


}
