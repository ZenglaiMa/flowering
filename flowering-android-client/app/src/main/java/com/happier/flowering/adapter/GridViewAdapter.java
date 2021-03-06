package com.happier.flowering.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.happier.flowering.R;
import com.happier.flowering.activity.PlantDetailActivity;
import com.happier.flowering.entity.Plant;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {

    private Context context;
    private List<Plant> dataSource;
    private int item_layout_id;
    private Gson gson = new Gson();

    public GridViewAdapter(List<Plant> dataSource, Context context, int item_layout_id) {
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
        Plant plant = dataSource.get(position);
        LinearLayout ll = convertView.findViewById(R.id.ll_plantDetail);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlantDetailActivity.class);
                String plantInfo = gson.toJson(plant);
                intent.putExtra("plantInfo", plantInfo);
                context.startActivity(intent);
            }
        });

        Log.e("position:", String.valueOf(position));
        ImageView img = convertView.findViewById(R.id.yimg_plant);
        TextView tvName = convertView.findViewById(R.id.ytv_plantName);

        Picasso.with(context).load(plant.getImg())
                .error(R.drawable.search)
                .into(img);
        tvName.setText(plant.getNameCn());
        return convertView;
    }

}
