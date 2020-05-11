package com.happier.flowering.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.happier.flowering.R;

public class FlowerChoose extends AppCompatActivity {
    private Button registBtn;
    private Button loginBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.flower_main_loginc);
        registBtn=findViewById(R.id.q_regist);
        loginBtn=findViewById(R.id.q_login);
        registBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FlowerChoose.this,RegistActivity.class);
                startActivity(intent);

            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FlowerChoose.this,LoginActivity.class);
                startActivity(intent);

            }
        });
    }
}
