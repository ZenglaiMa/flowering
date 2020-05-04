package com.happier.flowering.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.R;
import com.happier.flowering.entity.Plant;
import com.squareup.picasso.Picasso;

//植物详情页
public class PlantDetailActivity extends AppCompatActivity {
    private TextView plantName;
    private ImageView drawBackImg;
    private ImageView plantPic;
    private TextView plantDesc;
    private TextView plantFoster;
    private Intent intent;
    private TextView plantFamily;
    private TextView plantSkill;

    private Gson gson = new Gson();
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantdetail_info);
        drawBackImg = findViewById(R.id.yimg_drawback);
        plantPic = findViewById(R.id.yimg_plantDetailImg);
        plantDesc = findViewById(R.id.ytv_plantDesc);
        plantFoster = findViewById(R.id.ytv_Foster);
        plantName = findViewById(R.id.ytv_plantDetailName);
        plantFamily = findViewById(R.id.ytv_plantFamilt);
        plantSkill = findViewById(R.id.ytv_Skill);


        intent = getIntent();
        String plantInfo = intent.getStringExtra("plantInfo");
        Log.e("plantInfo",plantInfo);
        Plant plant = gson.fromJson(plantInfo,new TypeToken<Plant>() {
        }.getType());

        plantName.setText(plant.getNameCn());

        drawBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Picasso.with(this).load(plant.getImg()).into(plantPic);

        plantFamily.setText(plant.getFamily());

        plantDesc.setText(plant.getDescription());

        plantFoster.setText(plant.getConservation());

        plantSkill.setText(plant.getSkill());


    }
}
