package com.happier.flowering.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.happier.flowering.R;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.entity.User;

import java.util.List;

public class FansAdapter extends BaseAdapter {

    private Context context;
    private List<User> contents;
    private int itemLayoutId;

    public FansAdapter(Context context, List<User> contents, int itemLayoutId) {
        this.context = context;
        this.contents = contents;
        this.itemLayoutId = itemLayoutId;
    }

    @Override
    public int getCount() {
        if (null != contents) {
            return contents.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (null != contents) {
            return contents.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        if (null != contents) {
            return contents.get(position).getUserId();
        }
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = LayoutInflater.from(context).inflate(itemLayoutId, parent, false);
        }

        ImageView ivHeaderImg = convertView.findViewById(R.id.c_iv_fansImg);
        TextView tvUserName = convertView.findViewById(R.id.c_tv_fansName);

        RequestOptions options = new RequestOptions().circleCrop();
        Glide.with(context).load(Constant.BASE_IP + contents.get(position).getHeadImg()).apply(options).into(ivHeaderImg);
        tvUserName.setText(contents.get(position).getNickname());

        return convertView;
    }
}