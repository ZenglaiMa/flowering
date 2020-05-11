package com.happier.flowering.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.happier.flowering.R;
import com.happier.flowering.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FansAdapter    extends BaseAdapter{
        private Context context;
        private  List<User> contents = new ArrayList<>();
        private int itemLayoutId;

        public FansAdapter(Context context, List<User> contents, int itemLayoutId) {
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
            ImageView img = convertView.findViewById( R.id.c_iv_fansImg);
//            img.setImageResource( Integer.parseInt(contents.get(position).getHeadImg()));
            TextView name = convertView.findViewById(R.id.c_tv_fansName);
            name.setText(contents.get(position).getNickname());
            return convertView;
        }
}