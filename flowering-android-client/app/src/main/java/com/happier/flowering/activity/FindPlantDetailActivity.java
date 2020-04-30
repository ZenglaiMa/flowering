package com.happier.flowering.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.R;
import com.happier.flowering.adapter.StringNullAdapter;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.entity.Baike_info;
import com.happier.flowering.entity.Plant;
import com.happier.flowering.entity.PlantBaike;
import com.happier.flowering.entity.Result;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FindPlantDetailActivity extends AppCompatActivity {
    private ImageView drawBackImg;
    private  TextView tv_plantName;
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
        Gson gson = new Gson();
        tv_plantName = findViewById(R.id.ytv_plantDetailName1);
        ig_plantImg = findViewById(R.id.yimg_plantDetailImg1);
        tv_plantDesc = findViewById(R.id.ytv_plantDesc1);
        Intent intent = getIntent();
        path = intent.getStringExtra("path");
        GetPlantInfosThread getPlantInfosThread = new GetPlantInfosThread();
        getPlantInfosThread.start();
        while (getPlantInfosThread.flag==false){
            Log.e("Thread ","is running..");
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








    public class  GetPlantInfosThread extends  Thread{
        boolean flag=false;
        public GetPlantInfosThread(){

        }
        public void  run(){
            try {
                List<Plant> list = new ArrayList<>();
                OkHttpClient okHttpClient = new OkHttpClient();
                File mFile = new File(path);
                RequestBody body = RequestBody.create(MediaType.parse("image/*"), mFile);
                Request request = new Request.Builder()
                        .post(body)
                        .url(Constant.BASE_IP+FINDPLANT_PATH)
                        .build();
                Response response = okHttpClient.newCall(request).execute();
                String plantJson = response.body().string();

                plantBaike = gson.fromJson(plantJson,new TypeToken<PlantBaike>(){}.getType());
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
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.e("执行完成 ","2");
            callback();
        }
        public void callback(){
            Log.e("子线程执行结束","1");
            flag = true;
        }
    }

}




