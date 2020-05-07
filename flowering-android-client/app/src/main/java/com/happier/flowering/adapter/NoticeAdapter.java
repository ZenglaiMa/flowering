package com.happier.flowering.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.happier.flowering.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NoticeAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String,Object>> contents = new ArrayList<>();
    private int itemLayoutId;

    public NoticeAdapter(Context context,List<Map<String,Object>> contents, int itemLayoutId) {
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
            return contents.get( position );
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
            //加载item对应的布局文件
            LayoutInflater inflater = LayoutInflater.from( context );
            convertView = inflater.inflate( itemLayoutId, null );
        }
//  "CommentContent", "CommentTime","UserName", "UserImg", "PostContent", "PostImg"
        TextView CommentContent = convertView.findViewById(R.id.c_tv_notice_comment_content);
        TextView CommentTime = convertView.findViewById(R.id.c_tv_notice_comment_time);
        TextView UserName = convertView.findViewById(R.id.c_tv_notice_user_name);
        ImageView UserImg = convertView.findViewById(R.id.c_iv_notice_user_Img);
        ImageView PostImg = convertView.findViewById(R.id.c_iv_notice_post_Img);
        CommentContent.setText(contents.get(position).get("CommentContent").toString());
        CommentTime.setText(contents.get(position).get("CommentTime").toString());
        UserName.setText(contents.get(position).get("UserName").toString());
        UserImg.setImageResource((int)contents.get(position).get("UserImg"));
        PostImg.setImageResource((int)contents.get(position).get("PostImg"));
        return convertView;
    }
}
