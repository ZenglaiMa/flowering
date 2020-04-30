package com.happier.flowering.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.happier.flowering.R;
import com.happier.flowering.activity.PlantDetailActivity;
import com.happier.flowering.entity.Plant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private List<Plant> dataSource = new ArrayList<>();
    private int item_layout_id;
    private LinearLayout linearLayout;

    public GridViewAdapter(List<Plant> dataSource, Context context,int item_layout_id){
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
        Gson gson = new Gson();
        Plant plant = dataSource.get(position);
        linearLayout = convertView.findViewById(R.id.y_toPlantDetail);
        ImageView img = convertView.findViewById(R.id.yimg_plant);
        TextView tvName = convertView.findViewById(R.id.ytv_plantName);

        Picasso.with(context).load(plant.getImg())
                .error(R.drawable.search)
                .into(img);
        tvName.setText(plant.getNameCn());

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlantDetailActivity.class);
                String plantInfoJason = gson.toJson(plant);
                intent.putExtra("plantInfo",plantInfoJason);
                context.startActivity(intent);
            }
        });


        return convertView;
    }
}
