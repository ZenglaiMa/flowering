package com.happier.flowering.mine;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class EditDetail  extends AppCompatActivity {
    private TextView titleTxt;
    private EditText editTxt;
    private Button editBtn;
    private Handler handler;
    private String PATH_EDIT = "/center/editName";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_detail);
        Intent intent = getIntent();
        findViews();
        String title = intent.getExtras().get("title").toString();
        switch (title) {
            case "name":
                titleTxt.setText("修改昵称");
                PATH_EDIT = "/center/editName";
//                int id=

                break;
            case "profile":
                titleTxt.setText("修改个性签名");
                PATH_EDIT = "/center/editProfile";
                break;
        }

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editmore=editTxt.getText().toString();
                if(editTxt.getText().toString().trim().equals("")){
                    Toast ts = Toast.makeText(EditDetail.this, "请重新输入", Toast.LENGTH_LONG);
                    ts.show();
                }
                else {
                    edit(2, editmore);
                    handler = new Handler() {
                        @Override
                        public void handleMessage(android.os.Message msg) {
                            String messages = (String) msg.obj;
                            Log.e("re",messages+"");
                            if (messages.equals("1")) {
                                Toast ts = Toast.makeText(EditDetail.this, "修改成功", Toast.LENGTH_LONG);
                                ts.show();
                            } else {
                                Toast ts = Toast.makeText(EditDetail.this, "修改失败", Toast.LENGTH_LONG);
                                ts.show();
                            }

                        }

                    };
                }
            }
        });

    }

    private void findViews() {
        titleTxt = findViewById(R.id.q_edit_title);
        editTxt = findViewById(R.id.q_edit_new);
        editBtn = findViewById(R.id.q_confirm_edit);
    }

    private void edit(int id,String edit) {
        new Thread() {
            @Override
            public void run() {
                //查询私信数据
                Log.e("我的花", "查詢");
                try {
                    String pathmore="&name=";
                    switch (titleTxt.getText().toString()){
                        case"修改昵称":
                            pathmore = "&name=";
                            break;


                        case "修改个性签名":
                            pathmore = "&profile=";
                            break;

                    }
                    URL url = new URL(Constant.BASE_IP + PATH_EDIT + "?userId="+id+pathmore+edit);
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
