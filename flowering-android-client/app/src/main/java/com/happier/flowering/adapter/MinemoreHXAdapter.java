package com.happier.flowering.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.happier.flowering.entity.Post;

import java.util.List;

public class MinemoreHXAdapter extends BaseAdapter {
    private Context context;
    private List<Post> posts;
    private int item_post_id;
    public MinemoreHXAdapter(Context context, List<Post> posts, int  item_post_id) {
        this.context = context;
        this.posts = posts;
        this.item_post_id = item_post_id;
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
