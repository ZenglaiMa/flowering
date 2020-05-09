package com.happier.flowering.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.happier.flowering.MainActivity;
import com.happier.flowering.R;
import com.happier.flowering.constant.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class LoginActivity extends AppCompatActivity {
    private EditText passTxt;
    private EditText nameTxt;
    private Button loginBtn;
    private Handler handler;
    private static final  String PATH_LOGIN="/center/loginUser";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passTxt.getText().toString().trim().equals("")||nameTxt.getText().toString().trim().equals("")){
                    Toast.makeText(LoginActivity.this,"请输入用户名密码", Toast.LENGTH_SHORT).show();

                }
                else{
                       loginUser();
                    handler = new Handler() {
                        @Override
                        public void handleMessage(android.os.Message msg) {
                            String messages = (String) msg.obj;
                            int userId=Integer.parseInt(messages);
                            Log.e("ID","HHH"+userId);
                            //APP全局存储
                            SharedPreferences sPreferences= getSharedPreferences("data", MODE_PRIVATE);
                            SharedPreferences.Editor editor=sPreferences.edit();
                            editor.putInt("userId",userId);
                            editor.commit();
                            Toast.makeText(LoginActivity.this,"登录成功", Toast.LENGTH_SHORT).show();
                            Intent intent =new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intent);
                            SharedPreferences ssh=getSharedPreferences("data",MODE_PRIVATE);
                            int i=ssh.getInt("userId",123);
                            Log.e("ID","HHH"+i);

                        }

                    };
                }
            }
        });
    }
    public void findViews(){
        passTxt=findViewById(R.id.q_login_pass);
        nameTxt=findViewById(R.id.q_login_name);
        loginBtn=findViewById(R.id.q_confirmlogin);

    }
    public void loginUser(){
        new Thread(){
            @Override
            public void run() {
                //查询私信数据

                try {
                    URL url= new URL(Constant.BASE_IP+PATH_LOGIN+"?password="+passTxt.getText().toString().trim()+
                            "&nickname="+nameTxt.getText().toString().trim());
                    URLConnection conn = url.openConnection();
                    InputStream in = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
                    String info = reader.readLine();
                    android.os.Message message = new android.os.Message();
                    message.obj = info;
                    handler.sendMessage(message);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }


        }.start();
    }
}
