package com.happier.flowering.FlowerFinding;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.happier.flowering.R;
import com.happier.flowering.adapter.GridViewAdapter;
import com.happier.flowering.entity.Plant;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private int mFirstY;
    private Context mContext;
    private List<Bean> mList;
    public static final int TYPE_SEARCH = 0;
    public static final int TYPE_NORMAL = 1;
   // private GridView gridView;
    private GridViewAdapter gridViewAdapter;
    private List<Plant> plantList =  new ArrayList<>();
    public RecyclerViewAdapter(Context context, List<Bean> list,List<Plant> plantList) {
        this.mContext = context;
        this.mList = list;
        this.plantList = plantList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewAdapter.ViewHolder viewHolder = null;
        if (viewHolder == null) {
            View itemView = LayoutInflater.from(mContext).inflate(R.layout.addpter_flowerfinding, parent, false);
            viewHolder = new RecyclerViewAdapter.ViewHolder(itemView);
        }
        View view =  LayoutInflater.from(mContext).inflate(R.layout.addpter_flowerfinding, parent, false);


        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {

    }



    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }


    /**
     * 判断position对应的Item是否是组的第一项
     *
     * @param position
     * @return
     */
    public boolean isItemHeader(int position) {
        if  (position == 0) {
            return true;
        } else {
            String lastGroupName = mList.get(position - 1).getGroupName();
            String currentGroupName = mList.get(position).getGroupName();
            //判断上一个数据的组别和下一个数据的组别是否一致，如果不一致则是不同组，也就是为第一项（头部）
            if (lastGroupName.equals(currentGroupName)) {
                return false;
            } else {
                return true;
            }
        }
    }

    /**
     * 获取position对应的Item组名
     *
     * @param position
     * @return
     */
    public String getGroupName(int position) {
        return mList.get(position).getGroupName();
    }


    /**
     * 自定义ViewHolder
     */
    class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            MyGridView gridView=itemView.findViewById(R.id.gv);
            gridViewAdapter=new GridViewAdapter(plantList,mContext,R.layout.grindview_plant);
            gridView.setAdapter(gridViewAdapter);
            Log.e("setText","777");
            mTextView = itemView.findViewById(R.id.tv_item_text);

        }
    }





}
