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
import android.widget.RadioButton;
import android.widget.Toast;

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


public class RegistActivity extends AppCompatActivity {





       private static final  String PATH_REGIST="/center/registUser";
       private EditText nameTxt;
       private RadioButton maleBtn;
       private RadioButton femaleBtn;
       private EditText addressTxt;
       private EditText profileTxt;
       private EditText passTxt;
       private EditText confirmTxt;
       private Button registBtn;
       private Handler handler;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        findViews();

        registBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("开始注册","123");
               boolean sta= prePared();
               if(sta==true){
                   regist();
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
                           Toast.makeText(RegistActivity.this,"注册成功", Toast.LENGTH_SHORT).show();
                           Intent intent =new Intent(RegistActivity.this,LoginActivity.class);
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
    public void regist(){

        new Thread(){
            @Override
            public void run() {
                //查询私信数据

                try {
                    int gender=1;
                    if(maleBtn.isChecked()){
                         gender=1;
                    }
                    if(femaleBtn.isChecked()){
                         gender=2;
                    }
                    URL url= new URL(Constant.BASE_IP+PATH_REGIST+"?nickname="+nameTxt.getText().toString().trim()+"&gender="+gender+"&password="+passTxt.getText().toString().trim()+"&address="+addressTxt.getText().toString().trim()
                            +"&profile="+profileTxt.getText().toString().trim());
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
    public void findViews(){
       nameTxt=findViewById(R.id.q_regist_name);
        maleBtn=findViewById(R.id.q_regist_male);;
        femaleBtn=findViewById(R.id.q_regist_female);
      addressTxt=findViewById(R.id.q_regist_address);
         profileTxt=findViewById(R.id.q_regist_profile);
        passTxt=findViewById(R.id.q_regist_pass);
        confirmTxt=findViewById(R.id.q_regist_confirmpass);
       registBtn=findViewById(R.id.q_regist_confirm);
    }


    public boolean prePared(){
        Log.e("hhh",nameTxt.getText().toString());
        Log.e("hhh",passTxt.getText().toString());
        Log.e("hh",confirmTxt.getText().toString());
        Log.e("h",addressTxt.getText().toString());
        Log.e("h",profileTxt.getText().toString());
        if(nameTxt.getText().toString().trim().equals("")){
            Toast.makeText(this,"用户名不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(passTxt.getText().toString().trim().equals("")){
            Toast.makeText(this,"请输入密码", Toast.LENGTH_SHORT).show();
            return false;

        }
         if(confirmTxt.getText().toString().trim().equals("")){
             Toast.makeText(this,"请确认密码", Toast.LENGTH_SHORT).show();
             return false;
        }
        else if(!passTxt.getText().toString().equals(confirmTxt.getText().toString())){
             Toast.makeText(this, "两次输入密码不符", Toast.LENGTH_SHORT).show();
            return false;
         }
         if(addressTxt.getText().toString().trim().equals("")){
            addressTxt.setText("地址保密");
         }
         if(profileTxt.getText().toString().trim().equals("")){
            profileTxt.setText("写下你的个性签名");
         }
         return true;

    }
}
