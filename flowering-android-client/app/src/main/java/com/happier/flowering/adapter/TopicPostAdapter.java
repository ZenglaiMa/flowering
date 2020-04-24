package com.happier.flowering.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.happier.flowering.R;
import com.happier.flowering.entity.Topic;

import java.util.List;

public class TopicPostAdapter extends BaseAdapter {

    private Context context;
    private List<Topic> topics;
    private int item_layout_id;


    public TopicPostAdapter(Context context, List<Topic> topics, int item_layout_id) {
        this.context = context;
        this.topics = topics;
        this.item_layout_id = item_layout_id;
    }

    @Override
    public int getCount() {
        if (topics != null) {
            return topics.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (topics != null) {
            return topics.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        if (topics != null) {
            return topics.get(position).getTopicId();
        }
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(item_layout_id, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.l_tv_topic_item);
        textView.setText(topics.get(position).getTopicName());

        return convertView;
    }
}
