package com.happier.flowering.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.R;
import com.happier.flowering.activity.FlowerChoose;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.mine.FlowerMineMoreActivity;
import com.happier.flowering.mine.MAttention;
import com.happier.flowering.mine.MCollection;
import com.happier.flowering.mine.MFans;
import com.happier.flowering.mine.MNotice;
import com.happier.flowering.mine.MPraise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * @ClassName FlowerMineFragment
 * @Description 我的Fragment
 * @Author seven
 * @date 2020/4/16 15:09
 * @Version 0.1
 */
public class FlowerMineFragment extends Fragment {

    private LinearLayout collection;
    private LinearLayout praise;
    private Map<String, Object> map;
    private Handler handler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_flower_mine, container, false);

        getInfo();

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                String messages = (String) msg.obj;
                Log.e("获取——————————userInfo", messages);
                Type type = new TypeToken<Map<String, Object>>() {}.getType();
                map = new Gson().fromJson(messages, type);
            }

        };

        // 登陆
        view.findViewById(R.id.m_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FlowerChoose.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        //昵称
        TextView nickName = view.findViewById(R.id.c_nickname);
//        nickName.setText(map.get("username").toString());
        //头像
//        ImageView userImg = view.findViewById(R.id.c_userImg);
//        userImg.setImageResource(Integer.valueOf(map.get("userImg").toString()));
        //获赞
        TextView bePraisedNum = view.findViewById(R.id.c_bePraised_num);
//        bePraisedNum.setText(map.get("bepraised").toString());
        //关注
        TextView attentionNum = view.findViewById(R.id.c_attention_num);
//        attentionNum.setText(map.get("attention").toString());
        //粉丝
        TextView fansNum = view.findViewById(R.id.c_fans_num);
//        fansNum.setText(map.get("fans").toString());
//        ImageView userImg = view.findViewById(R.id.c_userImg);
//        userImg.setImageResource(Integer.valueOf(map.get( "userImg" ).toString()));

        //跳转收藏
        collection = view.findViewById(R.id.c_m_shou);
        collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MCollection.class);
                startActivity(intent);
            }
        });

        //跳转获赞
        praise = view.findViewById(R.id.c_praise);
        praise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MPraise.class);
                startActivity(intent);
            }
        });

        //跳到个人主页
        view.findViewById(R.id.c_iv_center).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentUserId = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE).getInt("userId", 0);
                if (currentUserId == 0) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getActivity(), FlowerMineMoreActivity.class);
                    intent.putExtra("userId", currentUserId);
                    startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.right_in, R.anim.left_out);
                }
            }
        });

        //通知
        view.findViewById(R.id.c_m_tong).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MNotice.class);
                startActivity(intent);
            }
        });

        //关注
        view.findViewById(R.id.c_attention).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MAttention.class);
                startActivity(intent);
            }
        });

        //粉丝
        view.findViewById(R.id.c_fans).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MFans.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public void getInfo() {
        new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL(Constant.BASE_IP + "/center/userInfo" + "?id=" + 1);
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

}
