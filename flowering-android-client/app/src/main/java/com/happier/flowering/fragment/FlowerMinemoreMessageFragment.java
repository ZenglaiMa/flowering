package com.happier.flowering.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.R;
import com.happier.flowering.adapter.MinemoreMessageAdapter;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.entity.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 //        * @ClassName FlowerMinemoreFragment
 //        * @Description 我的详情私信Fragment
 //        * @Author q
 //        * @date 2020/4/16 15:09
 //        * @Version 0.1
 //        */
public class FlowerMinemoreMessageFragment extends Fragment  {
    private List<Map<String, Object>> dataSource =new ArrayList<>();
    private MinemoreMessageAdapter messageAdapter;
    private ListView listView;
    private Handler handler;
    private Gson gson=new Gson();
    private static final  String PATH_MINEMORE_MESSAGE="/center/getAllMineMessage";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.minemore_fragment_message, container, false);
        listView=view.findViewById(R.id.q_commentlist);
        initMessageData();
        handler = new Handler() {
            @Override
            public void handleMessage(android.os.Message msg) {
                String messages = (String) msg.obj;
                dataSource = gson.fromJson(messages, new TypeToken<List<Map<String, Object>>>(){}.getType());
                messageAdapter = new MinemoreMessageAdapter(getContext(),dataSource, R.layout.minemore_fragment_mlist);
                listView.setAdapter(messageAdapter);
                //listView.setOnItemClickListener(FlowerMinemoreMessageFragment.this);
            }

        };


        return view;
    }
    private void initMessageData(){
        new Thread(){
            @Override
            public void run() {
                //查询私信数据
                try {
                    URL url= new URL(Constant.BASE_IP + PATH_MINEMORE_MESSAGE);
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
