package com.happier.flowering.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.happier.flowering.R;
import com.happier.flowering.adapter.TopicAdapter;

public class HotterPostFragment {
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_topic, container, false);
        ListView listView=view.findViewById(R.id.l_lv_topic);
//        initPosts();
//        topicAdapter=new TopicAdapter(view.getContext(),dataSource,R.layout.topic_item);
//        listView.setAdapter(topicAdapter);
        return view;
    }
}
