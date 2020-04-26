package com.happier.flowering.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.happier.flowering.R;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.entity.Article;
import com.happier.flowering.entity.Type;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FloweringAmongRightAdapter extends BaseAdapter {

    private Context context;
    private List<Article> dataSource = new ArrayList<>();
    private int item_layout_id;

    public FloweringAmongRightAdapter(List<Article> dataSource, Context context, int item_layout_id){
        this.context = context;
        this.dataSource = dataSource;
        this.item_layout_id = item_layout_id;
    }
    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(item_layout_id,null);
        }
        TextView tvType = convertView.findViewById(R.id.z_tv_type);
        ImageView iv = convertView.findViewById(R.id.z_iv_img);
        TextView tvOverview = convertView.findViewById(R.id.z_tv_overview);
        TextView tvTitle = convertView.findViewById(R.id.z_tv_title);
        TextView tvReadingNum = convertView.findViewById(R.id.z_tv_reading_num);

        tvType.setText(dataSource.get(position).getType().getTypeName());
        tvTitle.setText(dataSource.get(position).getTitle());
        tvOverview.setText(dataSource.get(position).getOverview());
        tvReadingNum.setText(dataSource.get(position).getReadingNum()+"人阅读");
        Glide.with(context)
                .load(Constant.BASE_IP + dataSource.get(position).getImg())
                .into(iv);
        return convertView;
    }
}
