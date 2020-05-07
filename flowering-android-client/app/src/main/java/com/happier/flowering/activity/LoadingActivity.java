package com.happier.flowering.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.happier.flowering.CompressImageUtil;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.entity.Plant;
import com.zyao89.view.zloading.ZLoadingBuilder;
import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoadingActivity extends AppCompatActivity {
    private ZLoadingDialog zLoadingDialog;
    private Gson gson = new Gson();
    private static final String FINDPLANT_PATH = "/discovery/findplant";
    private   String path;
    private OkHttpClient client = new OkHttpClient();
    private CompressImageUtil compressImageUtil = new CompressImageUtil();
    private File mFile;
    ZLoadingDialog dialog = new ZLoadingDialog(LoadingActivity.this);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog.setLoadingBuilder(Z_TYPE.LEAF_ROTATE)//设置类型
                .setLoadingColor(Color.GREEN)//颜色
                .setHintText("Loading...")
                .show();

        Intent intent = getIntent();
        path = intent.getStringExtra("path");
        sendToServer(path);
    }


    private void sendToServer(String path) {
        List<Plant> list = new ArrayList<>();
        OkHttpClient okHttpClient = new OkHttpClient();
        String outPath = "/storage/emulated/0/Download/" + System.currentTimeMillis() + ".jpg";//压缩后图片路径
       // compressImageUtil.compressByQuality(path,);
        mFile = new File(path);
        if (mFile.length()>=3000000){
            try {
                compressImageUtil.compressByQuality(path,outPath,2048,false);
                mFile = new File(outPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        RequestBody body = RequestBody.create(MediaType.parse("image/*"), mFile);
        Request request = new Request.Builder()
                .post(body)
                .url(Constant.BASE_IP+FINDPLANT_PATH)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String plantJson = response.body().string();
                dialog.dismiss();
                finish();
                Intent intent2 = new Intent(LoadingActivity.this,FindPlantDetailActivity.class);
                intent2.putExtra("plantInfos",plantJson);
                intent2.putExtra("path",path);
                startActivity(intent2);
            }
        });
    }

}
