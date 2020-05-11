package com.happier.flowering.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.happier.flowering.R;
import com.happier.flowering.entity.Type;

import java.util.List;

public class FloweringAmongLeftAdapter extends BaseAdapter {

    private Context context;
    private List<Type> dataSource;
    private int item_layout_id;

    public FloweringAmongLeftAdapter(List<Type> dataSource, Context context, int item_layout_id) {
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
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(item_layout_id, parent, false);
        }
        TextView tvName = convertView.findViewById(R.id.z_tv_flowering_among_left);
        tvName.setText(dataSource.get(position).getTypeName());

        return convertView;
    }
}
