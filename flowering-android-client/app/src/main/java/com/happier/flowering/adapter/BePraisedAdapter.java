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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class BePraisedAdapter extends BaseAdapter {

    private Context context;
    private List<Map<String, Object>> contents;
    private int itemLayoutId;

    public BePraisedAdapter(Context context, List<Map<String, Object>> contents, int itemLayoutId) {
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = LayoutInflater.from(context).inflate(itemLayoutId, parent, false);
        }

        ImageView userImg = convertView.findViewById(R.id.c_iv_bePraised_user_Img);
        TextView userName = convertView.findViewById(R.id.c_tv_bePraised_user_name);
        TextView thumbsUpTime = convertView.findViewById(R.id.m_thumbs_up_time);

        Glide.with(context).load(Constant.BASE_IP + String.valueOf(contents.get(position).get("userHeadImg"))).apply(new RequestOptions().circleCrop()).into(userImg);
        userName.setText(contents.get(position).get("userName").toString());
        Date date = new Date(contents.get(position).get("thumbsUpTime").toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        thumbsUpTime.setText(sdf.format(date));

        return convertView;
    }
}