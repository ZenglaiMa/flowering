package com.happier.flowering.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.happier.flowering.R;
import com.happier.flowering.model.NineGridModel;
import com.happier.flowering.view.NineGridLayoutExd;

import java.util.List;

/**
 * @ClassName LatestPostAdapter
 * @Description 花现中最新板块中ListView对应的Adapter
 * @Author seven
 * @date 2020/4/21 10:01
 * @Version 0.1
 */
public class LatestPostAdapter extends BaseAdapter {

    private Context context;
    private List<NineGridModel> dataSource;
    private int itemId;

    public LatestPostAdapter(Context context, List<NineGridModel> dataSource, int itemId) {
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
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(itemId, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.ivUserHeaderImage = convertView.findViewById(R.id.m_post_user_header_img);
            viewHolder.tvUserName = convertView.findViewById(R.id.m_post_user_name);
            viewHolder.tvPostText = convertView.findViewById(R.id.m_post_text);
            viewHolder.nineGridImages = convertView.findViewById(R.id.layout_nine_grid);
            viewHolder.tvPublishTime = convertView.findViewById(R.id.m_post_publish_time);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.nineGridImages.setIsShowAll(dataSource.get(position).isShowAll);
        viewHolder.nineGridImages.setUrlList(dataSource.get(position).urlList);

        return convertView;
    }

    private class ViewHolder {
        public ImageView ivUserHeaderImage;
        public TextView tvUserName;
        public TextView tvPostText;
        public NineGridLayoutExd nineGridImages;
        public TextView tvPublishTime;
    }
}
