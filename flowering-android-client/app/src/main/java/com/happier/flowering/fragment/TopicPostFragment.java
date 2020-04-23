package com.happier.flowering.fragment;

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
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.MainActivity;
import com.happier.flowering.R;
import com.happier.flowering.adapter.TopicAdapter;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.entity.Topic;
import com.happier.flowering.model.PostListModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TopicPostFragment
 * @Description 花现中话题对应的Fragment
 * @Author seven
 * @date 2020/4/20 14:47
 * @Version 0.1
 */
public class TopicPostFragment extends Fragment {
    private List<Topic> dataSource=new ArrayList<>();
    private TopicAdapter topicAdapter;
    private ListView listView;

    private Handler handler;
    private Gson gson=new Gson();
    private static final String Topic_List = "/topic/list";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_topic, container, false);
        listView=view.findViewById(R.id.l_lv_topic);
        initTopics();
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                String topics= (String) msg.obj;
                Log.e("topics",topics);
                dataSource= gson.fromJson(topics, new TypeToken<List<Topic>>() {}.getType());
                topicAdapter=new TopicAdapter(view.getContext(),dataSource,R.layout.topic_item);
                listView.setAdapter(topicAdapter);
            }
        };

        return view;
    }

    private void initTopics() {
        new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL(Constant.BASE_IP1 + Topic_List);
                    URLConnection conn = url.openConnection();
                    InputStream in = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
                    String info = reader.readLine();
                    Message message=new Message();
                    message.obj=info;
                    handler.sendMessage(message);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

}
