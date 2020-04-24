package com.happier.flowering.fragment;

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
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.R;
import com.happier.flowering.activity.TopicDetailActivity;
import com.happier.flowering.adapter.TopicPostAdapter;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.entity.Topic;

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

    private List<Topic> dataSource = new ArrayList<>();
    private TopicPostAdapter topicPostAdapter;
    private ListView listView;

    private Handler handler;
    private Gson gson = new Gson();
    private static final String PATH_TOPIC_LIST = "/topic/list";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_topic, container, false);
        listView = view.findViewById(R.id.l_lv_topic);

        initTopics();

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                String topics = (String) msg.obj;
                dataSource = gson.fromJson(topics, new TypeToken<List<Topic>>() {}.getType());
                topicPostAdapter = new TopicPostAdapter(getContext(), dataSource, R.layout.topic_item);
                listView.setAdapter(topicPostAdapter);
            }
        };

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), TopicDetailActivity.class);
                intent.putExtra("topicId", id);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        return view;
    }

    private void initTopics() {
        new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL(Constant.BASE_IP + PATH_TOPIC_LIST);
                    URLConnection conn = url.openConnection();
                    InputStream in = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
                    String info = reader.readLine();
                    Message message = new Message();
                    message.obj = info;
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
