package com.happier.flowering.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.happier.flowering.R;

import java.util.List;
import java.util.Map;

/**
 * @ClassName
 * @Description
 * @Author seven
 * @date 2020/4/22 9:45
 * @Version 0.1
 */
public class PostCommentListAdapter extends BaseAdapter {

    private Context context;
    private List<Map<String, String>> dataSource;
    private int itemId;

    public PostCommentListAdapter(Context context, List<Map<String, String>> dataSource, int itemId) {
        this.context = context;
        this.dataSource = dataSource;
        this.itemId = itemId;
    }

    @Override
    public int getCount() {
        if (dataSource != null) {
            return dataSource.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (dataSource != null) {
            return dataSource.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (null == convertView) {
            convertView = LayoutInflater.from(context).inflate(itemId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvName = convertView.findViewById(R.id.m_comment_user_name);
            viewHolder.tvContent = convertView.findViewById(R.id.m_comment_content);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvName.setText(dataSource.get(position).get("name").toString());
        viewHolder.tvContent.setText(dataSource.get(position).get("content").toString());

        return convertView;
    }

    private class ViewHolder {
        public TextView tvName;
        public TextView tvContent;
    }
}
