package com.happier.flowering.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.happier.flowering.R;
import com.happier.flowering.entity.Post;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


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
        return  posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        if (null == convertView) {
            convertView = inflater.inflate(item_post_id, null);
        }
        final ImageView headImg = convertView.findViewById(R.id.q_post_img);
        final TextView content = convertView.findViewById(R.id.q_post_content);
        final TextView time = convertView.findViewById(R.id.q_post_time);

        //填充数据按照时间降序显示最新
//            headImg.setBackgroundResource(R.drawable.(messages.get(position).get("senderHead").toString()));
        content.setText(posts.get(position).getTxt().toString());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");//格式化为：xxxx年xx月xx日
        time.setText(sdf.format(posts.get(position).getTime()).toString());

        return convertView;

    }
}
