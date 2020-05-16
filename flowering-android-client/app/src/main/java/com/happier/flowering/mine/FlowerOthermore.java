package com.happier.flowering.mine;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.R;
import com.happier.flowering.adapter.MinemoreHXAdapter;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.entity.Post;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import java.util.ArrayList;
import java.util.List;


public class FlowerOthermore extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
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
    private static final String PATH_OTHER_SENDMESSAGE = "/center/sendMessage";
    private static final String PATH_OTHER_ISFOLLOW = "/center/ifAttention";
    private static final String PATH_OTHER_ADDFOLLOW = "/center/addAttention";
    private static final String PATH_OTHER_REMOVEFOLLOW = "/center/removeAttention";
    private Handler sHandler;
    private Handler isfHandler;
    private Handler addHandler;
    private Handler removeHandler;
    private Gson gson;
    private ListView listView;
    private List<Post> myPosts = new ArrayList<>();
    private MinemoreHXAdapter minemoreHXAdapter;
    private Map<String, Object> infomap = new HashMap<>();
    private Handler handler;
    private static final String PATH_MINEMORE_HX = "/center/findPosts";
    //q_other_findinglist
    private PopupWindow popupWindow = null;
    private View popupView = null;
    //标识是否关注
    private boolean isAttention = false;
    private String myId=String.valueOf(getSharedPreferences("data", MODE_PRIVATE).getInt("userId", 0));
    private int otherId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flower_other_othermore);
        otherId=getIntent().getExtras().getInt("otherId");
        initPersonView();
        initProfile();
        //是否关注设置填充
//        setByisAttention();

        //发送私信弹出框
        sendBtn = findViewById(R.id.q_sendMessage);
        follow = findViewById(R.id.q_setfollow);
        sendBtn.setOnClickListener(this);
        follow.setOnClickListener(this);
        listView = findViewById(R.id.q_finginglist);
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();
        listView = findViewById(R.id.q_other_findinglist);
        initPostData();
        handler = new Handler() {
            @Override
            public void handleMessage(android.os.Message msg) {
                String messages = (String) msg.obj;
                myPosts = gson.fromJson(messages, new TypeToken<List<Post>>() {}.getType());
                Log.e("話現查询", myPosts.toString());
                minemoreHXAdapter = new MinemoreHXAdapter(FlowerOthermore.this, myPosts, R.layout.minemore_fragment_flist);
                listView.setAdapter(minemoreHXAdapter);
                listView.setOnItemClickListener(FlowerOthermore.this);
            }

        };


    }

    public void initPostData() {
        new Thread() {
            @Override
            public void run() {
                //查询私信数据
                Log.e("我的花", "查詢");
                try {
                    URL url = new URL(Constant.BASE_IP + PATH_MINEMORE_HX + "?id="+otherId);
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

    /**
     * 查询是否关注并设置follow  text
     */
    private void setByisAttention() {
        //查询是否关注
        isfHandler = new Handler() {
            @Override
            public void handleMessage(android.os.Message msg) {
                //判断是否回复
                String ms = (String) msg.obj;
                Log.e("是否关注", ms);
                if (ms.equals("yes")) {
                    Toast ts = Toast.makeText(FlowerOthermore.this, "已关注", Toast.LENGTH_LONG);
                    ts.show();
                    isAttention = true;
                    followIs.setText("已关注");
                } else {
                    Toast ts = Toast.makeText(FlowerOthermore.this, "未关注", Toast.LENGTH_LONG);
                    ts.show();
                }
            }

        };

        new Thread() {
            @Override
            public void run() {
                //查询私信数据
                try {
                    Log.e("查询是否关注", "reply");
                    URL url = new URL(Constant.BASE_IP + PATH_OTHER_ISFOLLOW + "?userId="+myId+"&otherId="+otherId);
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

    private void initPersonView() {
        headImg = findViewById(R.id.q_other_headImg);
        gender = findViewById(R.id.q_other_gender);
        nickName = findViewById(R.id.q_other_name);
        profile = findViewById(R.id.q_other_profile);
        address = findViewById(R.id.q_other_address);
        fans = findViewById(R.id.q_other_fans);
        follow = findViewById(R.id.q_other_follow);
        thumbs = findViewById(R.id.q_other_thumbs);
    }

    /**
     *
     * ----------需要查询
     */
    private void initProfile() {
        // 填充信息
        //查询个人信息
        getInfo();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                String messages = (String) msg.obj;
                Log.e("获取——————————userInfo", messages);
                Type type = new TypeToken<Map<String, Object>>() {
                }.getType();
                infomap = new Gson().fromJson(messages, type);
                nickName.setText(infomap.get("username").toString());
//                headImg.setImageResource(Integer.valueOf(infomap.get("userImg").toString()));
                if(!infomap.get("userImg").toString().trim().equals("")&&infomap.get("userImg").toString().trim()!=null) {
                    RequestOptions options = new RequestOptions().circleCrop();
                    Glide.with(FlowerOthermore.this).load(Uri.fromFile(new File(Constant.BASE_IP + infomap.get("userImg").toString()))).apply(options).into(headImg);
                }
                gender.setText(infomap.get("sex").toString());
                profile.setText(infomap.get("profile").toString());
                address.setText(infomap.get("address").toString());
                fans.setText(infomap.get("fans").toString());
                follow.setText(infomap.get("attention").toString());
                thumbs.setText(infomap.get("bepraised").toString());

            }

        };

    }

    /**
     * 回复（发送）私信线程
     *
     * @param mContent
     * @param senderId
     * @param recvId
     */
    public void replyMessage(int senderId, int recvId, String mContent) {
        Log.e("回复私信", "reply");
        new Thread() {
            @Override
            public void run() {
                //查询私信数据
                try {
                    Log.e("回复私信", "reply");
                    URL url = new URL(Constant.BASE_IP + PATH_OTHER_SENDMESSAGE + "?userId=" +
                            senderId + "&recvId=" + recvId + "&mContent=" + mContent);
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

    public void onClicksendMessage(View v) {
        showPopupWindow(v);

    }

    // 显示PopupWindow
    private void showPopupWindow(View view) {
        // 创建popupWindow对象
        if (popupWindow != null && popupWindow.isShowing()) {
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
        popupWindow.setFocusable(true);

        // 获取按钮并添加监听器
        EditText content = popupView.findViewById(R.id.q_text_sendContent);

        Button btnSend = popupView.findViewById(R.id.q_btn_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //插入数据库回复私信
                String mess = content.getText().toString();
                Log.e("123", mess);
                //接收者id在跳转过来时获取
                replyMessage(Integer.parseInt(myId), otherId, mess);
                sHandler = new Handler() {
                    @Override
                    public void handleMessage(android.os.Message msg) {
                        //判断是否回复
                        String ms = (String) msg.obj;
                        Log.e("回复私信", ms);
                        if (ms.equals("ok")) {
                            Toast ts = Toast.makeText(FlowerOthermore.this, "已发送", Toast.LENGTH_LONG);
                            ts.show();
                        } else {
                            Toast ts = Toast.makeText(FlowerOthermore.this, "发送失败", Toast.LENGTH_LONG);
                            ts.show();
                        }
                    }

                };

                popupWindow.dismiss();
            }
        });

        // 在指定控件下方显示PopupWindow

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
    }

    public void onClicksetfollow(View v) {
        //取消关注
        if (isAttention == true) {
            removeHandler = new Handler() {
                @Override
                public void handleMessage(android.os.Message msg) {
                    //判断是否回复
                    String ms = (String) msg.obj;
                    Log.e("REMOVE关注", ms);
                    if (ms.equals("yes")) {
                        Toast ts = Toast.makeText(FlowerOthermore.this, "已取消关注", Toast.LENGTH_LONG);
                        ts.show();
                        isAttention = false;
                        followIs.setText("+ 关 注");
                    } else {
                        Toast ts = Toast.makeText(FlowerOthermore.this, "取消失敗", Toast.LENGTH_LONG);
                        ts.show();
                    }
                }

            };

            new Thread() {
                @Override
                public void run() {
                    //查询私信数据
                    try {
                        Log.e("取消关注", "reply");
                        URL url = new URL(Constant.BASE_IP + PATH_OTHER_REMOVEFOLLOW + "?userId=" +myId+ "&otherId"+otherId);
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
        if (isAttention == false) {
            addHandler = new Handler() {
                @Override
                public void handleMessage(android.os.Message msg) {
                    //判断是否回复
                    String ms = (String) msg.obj;
                    Log.e("+关注", ms);
                    if (ms.equals("yes")) {
                        Toast ts = Toast.makeText(FlowerOthermore.this, "已关注", Toast.LENGTH_LONG);
                        ts.show();
                        isAttention = true;
                        followIs.setText("已 关 注");
                    } else {
                        Toast ts = Toast.makeText(FlowerOthermore.this, "+关注失败", Toast.LENGTH_LONG);
                        ts.show();
                    }
                }

            };

            new Thread() {
                @Override
                public void run() {
                    //查询私信数据
                    try {
                        Log.e("加关注", "reply");
                        URL url = new URL(Constant.BASE_IP + PATH_OTHER_ADDFOLLOW + "?userId=" +myId+ "&otherId="+otherId);
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

    public void getInfo() {
        new Thread() {
            @Override
            public void run() {
                try {

                    URL url = new URL(Constant.BASE_IP + "/center/userInfo" + "?id=" + myId);
                    URLConnection conn = url.openConnection();
                    InputStream in = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
                    String info = reader.readLine();
                    Log.e("******************", info);
                    Message message = new Message();
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
