package com.happier.flowering.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.happier.flowering.R;

import java.util.ArrayList;
import java.util.List;

import static com.happier.flowering.R.drawable.add1;

/**
 * @ClassName TopicPostFragment
 * @Description 花现中话题对应的Fragment
 * @Author seven
 * @date 2020/4/20 14:47
 * @Version 0.1
 */
public class TopicPostFragment extends Fragment {
    private List<String> dataSource=new ArrayList<>();
    private TopicAdapter topicAdapter;
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_topic, container, false);
        ListView listView=view.findViewById(R.id.l_lv_topic);
        initTopics();
        topicAdapter=new TopicAdapter(view.getContext(),dataSource,R.layout.topic_item);
        listView.setAdapter(topicAdapter);
        return view;
    }

    private void initTopics() {
        dataSource.add("topic1");
        dataSource.add("topiccc2");
        dataSource.add("topic3");
        dataSource.add("topiccc4");
        dataSource.add("topic5");
        dataSource.add("topiccccc6");
        dataSource.add("topicccccc7");
        dataSource.add("topic8");
        dataSource.add("topic9");
        dataSource.add("topiccc11");
        dataSource.add("topic10");
        dataSource.add("topiccccc12");
    }

}
