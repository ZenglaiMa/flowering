package com.happier.flowering.mine;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
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


public class FlowerOthermore extends AppCompatActivity implements View.OnClickListener{
    //个人信息
    private ImageView headImg;
    private TextView gender;
    private TextView profile;
    private TextView nickName;
    private TextView address;
    private TextView fans;
    private TextView follow;
    private TextView thumbs;
    private Button sendBtn;
    private Button followIs;
    private static final  String PATH_OTHER_SENDMESSAGE="/center/sendMessage";
    private static final  String PATH_OTHER_ISFOLLOW="/center/sendMessage";
    private static final  String PATH_OTHER_ADDFOLLOW="/center/sendMessage";
    private static final  String PATH_OTHER_REMOVEFOLLOW="/center/sendMessage";
    private Handler sHandler;
    private Handler isfHandler;
    private Handler addHandler;
    private Handler removeHandler;
    private PopupWindow popupWindow=null;
    private View popupView=null;
    //标识是否关注
    private boolean isAttention=false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flower_other_othermore);

        initPersonView();
        initProfile();
        //是否关注设置填充
        setByisAttention();
        //发送私信弹出框
        sendBtn=findViewById(R.id.q_sendMessage);
        follow=findViewById(R.id.q_setfollow);
        sendBtn.setOnClickListener(this);
        follow.setOnClickListener(this);






    }

    /**
     * 查询是否关注并设置follow  text
     */
    private void setByisAttention(){
        //查询是否关注
        isfHandler = new Handler() {
            @Override
            public void handleMessage(android.os.Message msg) {
                //判断是否回复
                String ms= (String) msg.obj;
                Log.e("是否关注",ms);
                if(ms.equals("yes")) {
                    Toast ts = Toast.makeText(FlowerOthermore.this,"已关注", Toast.LENGTH_LONG);
                    ts.show();
                    isAttention=true;
                    followIs.setText("已关注");
                }
                else
                {
                    Toast ts = Toast.makeText(FlowerOthermore.this, "未关注", Toast.LENGTH_LONG);
                    ts.show();
                }
            }

        };

        new Thread(){
            @Override
            public void run() {
                //查询私信数据
                try {
                    Log.e("查询是否关注","reply");
                    URL url= new URL(Constant.BASE_IP + PATH_OTHER_ISFOLLOW+"?userId="+"&otherId");
                    URLConnection conn = url.openConnection();
                    InputStream in = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
                    String info = reader.readLine();
                    android.os.Message message = new android.os.Message();
                    message.obj = info;
                    isfHandler.sendMessage(message);
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


    private void initPersonView(){
        headImg=findViewById(R.id.q_other_headImg);
        gender=findViewById(R.id.q_other_gender);
        nickName=findViewById(R.id.q_other_name);
        profile=findViewById(R.id.q_other_profile);
        address=findViewById(R.id.q_other_address);
        fans=findViewById(R.id.q_other_fans);
        follow=findViewById(R.id.q_other_follow);
        thumbs=findViewById(R.id.q_other_thumbs);
    }

    /**
     * 跳转携带userid查询他人信息
     * ----------需要查询
     */
    private void initProfile(){
// 填充信息


    }
    /**
     * 回复（发送）私信线程
     * @param mContent
     * @param senderId
     * @param recvId
     */
    public void replyMessage(int senderId,int recvId,String mContent){
        Log.e("回复私信","reply");
        new Thread(){
            @Override
            public void run() {
                //查询私信数据
                try {
                    Log.e("回复私信","reply");
                    URL url= new URL(Constant.BASE_IP +PATH_OTHER_SENDMESSAGE+"?userId="+
                            senderId+"&recvId="+recvId+"&mContent="+mContent);
                    URLConnection conn = url.openConnection();
                    InputStream in = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
                    String info = reader.readLine();
                    android.os.Message message = new android.os.Message();
                    message.obj = info;
                    sHandler.sendMessage(message);
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


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.q_sendMessage:
                onClicksendMessage(v);
                break;
            case R.id.q_setfollow:
                onClicksetfollow(v);
                break;
            default:
                break;
        }
    }
    public void onClicksendMessage(View v){
        showPopupWindow(v);

    }
    // 显示PopupWindow
    private void showPopupWindow(View view) {
        // 创建popupWindow对象
        if(popupWindow!=null&&popupWindow.isShowing()){
            return;
        }
        popupWindow = new PopupWindow();
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 通过布局填充器创建View
        LayoutInflater inf = LayoutInflater.from(this);
        popupView = inf
                .inflate(R.layout.mine_other_popwindow, null);



        // 设置PopupWindow显示的内容视图
        popupWindow.setContentView(popupView);
        // 设置PopupWindow是否能响应外部点击事件
        popupWindow.setOutsideTouchable(true);
        // 设置PopupWindow是否相应点击事件
        popupWindow.setTouchable(true);

        // 获取按钮并添加监听器
        EditText content=popupView.findViewById(R.id.q_text_sendContent);

        Button btnSend = popupView.findViewById(R.id.q_btn_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //插入数据库回复私信
                String mess=content.getText().toString();
                Log.e("123",mess);
                //接收者id在跳转过来时获取
                replyMessage(2,1,mess);
                sHandler = new Handler() {
                    @Override
                    public void handleMessage(android.os.Message msg) {
                        //判断是否回复
                        String ms= (String) msg.obj;
                        Log.e("回复私信",ms);
                        if(ms.equals("ok")) {
                            Toast ts = Toast.makeText(FlowerOthermore.this,"已发送", Toast.LENGTH_LONG);
                            ts.show();
                        }
                        else
                        {
                            Toast ts = Toast.makeText(FlowerOthermore.this, "发送失败", Toast.LENGTH_LONG);
                            ts.show();
                        }
                    }

                };

                popupWindow.dismiss();
            }
        });

        // 在指定控件下方显示PopupWindow

        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);
    }

    public void onClicksetfollow(View v){
        //取消关注
        if(isAttention==true){
            removeHandler= new Handler() {
                @Override
                public void handleMessage(android.os.Message msg) {
                    //判断是否回复
                    String ms= (String) msg.obj;
                    Log.e("REMOVE关注",ms);
                    if(ms.equals("yes")) {
                        Toast ts = Toast.makeText(FlowerOthermore.this,"已remove关注", Toast.LENGTH_LONG);
                        ts.show();
                        isAttention=false;
                        followIs.setText("+关注");
                    }
                    else
                    {
                        Toast ts = Toast.makeText(FlowerOthermore.this, "remove关注false", Toast.LENGTH_LONG);
                        ts.show();
                    }
                }

            };

            new Thread(){
                @Override
                public void run() {
                    //查询私信数据
                    try {
                        Log.e("取消关注","reply");
                        URL url= new URL(Constant.BASE_IP + PATH_OTHER_REMOVEFOLLOW+"?userId="+"&otherId");
                        URLConnection conn = url.openConnection();
                        InputStream in = conn.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
                        String info = reader.readLine();
                        android.os.Message message = new android.os.Message();
                        message.obj = info;
                        isfHandler.sendMessage(message);
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
        //+关注
        if(isAttention==false){
            addHandler= new Handler() {
                @Override
                public void handleMessage(android.os.Message msg) {
                    //判断是否回复
                    String ms= (String) msg.obj;
                    Log.e("+关注",ms);
                    if(ms.equals("yes")) {
                        Toast ts = Toast.makeText(FlowerOthermore.this,"已关注", Toast.LENGTH_LONG);
                        ts.show();
                        isAttention=true;
                        followIs.setText("已关注");
                    }
                    else
                    {
                        Toast ts = Toast.makeText(FlowerOthermore.this, "+关注失败", Toast.LENGTH_LONG);
                        ts.show();
                    }
                }

            };

            new Thread(){
                @Override
                public void run() {
                    //查询私信数据
                    try {
                        Log.e("加关注","reply");
                        URL url= new URL(Constant.BASE_IP + PATH_OTHER_ADDFOLLOW+"?userId="+"&otherId");
                        URLConnection conn = url.openConnection();
                        InputStream in = conn.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
                        String info = reader.readLine();
                        android.os.Message message = new android.os.Message();
                        message.obj = info;
                        isfHandler.sendMessage(message);
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


}
