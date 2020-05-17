package com.happier.flowering.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.happier.flowering.R;
import com.happier.flowering.activity.FlowerChoose;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.mine.FlowerMineMoreActivity;
import com.happier.flowering.mine.MAttention;
import com.happier.flowering.mine.MCollection;
import com.happier.flowering.mine.MFans;
import com.happier.flowering.mine.MNotice;
import com.happier.flowering.mine.MPraise;
import com.happier.flowering.model.UserInfoModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ClassName FlowerMineFragment
 * @Description 我的Fragment
 * @Author seven
 * @date 2020/4/16 15:09
 * @Version 0.1
 */
public class FlowerMineFragment extends Fragment {

    private ImageView ivLogin;
    private TextView nickName;
    private ImageView userImg;
    private TextView bePraisedNum;
    private TextView attentionNum;
    private TextView fansNum;
    private LinearLayout collection;
    private LinearLayout praise;
    private ImageView ivSkipToCenter;
    private LinearLayout llNote;
    private LinearLayout llAttention;
    private LinearLayout llFans;

    private int currentUserId;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String result = (String) msg.obj;
            UserInfoModel model = new Gson().fromJson(result, UserInfoModel.class);
            nickName.setText(model.getUsername());
            Glide.with(getActivity()).load(Constant.BASE_IP + model.getUserImg()).apply(new RequestOptions().circleCrop()).into(userImg);
            bePraisedNum.setText(String.valueOf(model.getBepraised()));
            attentionNum.setText(String.valueOf(model.getAttention()));
            fansNum.setText(String.valueOf(model.getFans()));
        }

    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_flower_mine, container, false);

        currentUserId = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE).getInt("userId", 0);

        findViews(view);

        if (currentUserId != 0) {
            getInfo();
        }

        // 登陆
        ivLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FlowerChoose.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        // 跳到个人主页
        ivSkipToCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

        // 跳转获赞
        praise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentUserId == 0) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getActivity(), MPraise.class);
                    startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.right_in, R.anim.left_out);
                }
            }
        });

        // 跳到关注
        llAttention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentUserId == 0) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getActivity(), MAttention.class);
                    startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.right_in, R.anim.left_out);
                }
            }
        });

        // 跳到粉丝
        llFans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentUserId == 0) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getActivity(), MFans.class);
                    startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.right_in, R.anim.left_out);
                }
            }
        });

        // 跳转收藏
        collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentUserId == 0) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getActivity(), MCollection.class);
                    startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.right_in, R.anim.left_out);
                }
            }
        });

        // 跳到通知
        llNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentUserId == 0) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getActivity(), MNotice.class);
                    startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.right_in, R.anim.left_out);
                }
            }
        });

        return view;
    }

    private void findViews(View view) {
        ivLogin = view.findViewById(R.id.m_login);
        nickName = view.findViewById(R.id.c_nickname);
        userImg = view.findViewById(R.id.c_userImg);
        bePraisedNum = view.findViewById(R.id.c_bePraised_num);
        attentionNum = view.findViewById(R.id.c_attention_num);
        fansNum = view.findViewById(R.id.c_fans_num);
        collection = view.findViewById(R.id.c_m_shou);
        praise = view.findViewById(R.id.c_praise);
        ivSkipToCenter = view.findViewById(R.id.c_iv_center);
        llNote = view.findViewById(R.id.c_m_tong);
        llAttention = view.findViewById(R.id.c_attention);
        llFans = view.findViewById(R.id.c_fans);
    }

    public void getInfo() {
        new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL(Constant.BASE_IP + "/center/userInfo" + "?id=" + currentUserId);
                    URLConnection conn = url.openConnection();
                    InputStream in = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
                    String info = reader.readLine();
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
