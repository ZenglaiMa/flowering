package com.happier.flowering.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.R;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.entity.Baike_info;
import com.happier.flowering.entity.Plant;
import com.happier.flowering.entity.PlantBaike;
import com.happier.flowering.entity.Result;
import com.squareup.picasso.Picasso;
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

public class FindPlantDetailActivity extends AppCompatActivity {
    private ImageView drawBackImg;
    private TextView tv_plantName;
    private ImageView ig_plantImg;
    private  TextView tv_plantDesc;
    private String plantName;
    private Result result;
    private Baike_info baike_info;
    private String plantDesc;
    private  String base64;
    private static final String FINDPLANT_PATH = "/discovery/findplant";
    private PlantBaike plantBaike;
    private String imgUrl;
    Gson gson = new GsonBuilder().serializeNulls().create();
    private   String path;
    private OkHttpClient client = new OkHttpClient();
    private  ZLoadingDialog dialog;
    String plantInfos;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finddetail);

        drawBackImg = findViewById(R.id.yimg_drawback1);
        drawBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tv_plantName = findViewById(R.id.ytv_plantDetailName1);
        ig_plantImg = findViewById(R.id.yimg_plantDetailImg1);
        tv_plantDesc = findViewById(R.id.ytv_plantDesc1);


        Intent intent = getIntent();
        plantInfos = intent.getStringExtra("plantInfos");
        path = intent.getStringExtra("path");


        plantBaike = gson.fromJson(plantInfos,new TypeToken<PlantBaike>(){}.getType());
        Object objectPlant = plantBaike.getResult().get(0).getBaike_info();
        String objectJson = gson.toJson(objectPlant);
        Log.e("objectJson",objectJson);
        if (objectJson.equals("[]")){
            baike_info = null;
        }else {
            baike_info = gson.fromJson(objectJson,new TypeToken<Baike_info>(){}.getType());
            plantName = plantBaike.getResult().get(0).getName();
            imgUrl = baike_info.getImage_url();
            plantDesc = baike_info.getDescription();
        }


        if (plantBaike==null){
            Log.e("isNull","baike");
        }else {
            Log.e("baike",plantBaike.getResult().get(0).getName());
        }
        tv_plantName.setText(plantBaike.getResult().get(0).getName());

        if (baike_info==null){
            //若无百科信息则加载本地图片
            File mFile=new File(path);
            //若该文件存在
            if (mFile.exists()) {
                Bitmap bitmap= BitmapFactory.decodeFile(path);
                ig_plantImg.setImageBitmap(bitmap);
            }
            tv_plantDesc.setText("暂无简介");
        }else {
            Picasso.with(this).load(imgUrl).into(ig_plantImg);
            tv_plantDesc.setText(plantDesc);
        }






    }

}




