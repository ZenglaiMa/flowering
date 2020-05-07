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

public class PraiseOthersAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String,Object>> contents = new ArrayList<>();
    private int itemLayoutId;

    public PraiseOthersAdapter(Context context,List<Map<String,Object>> contents, int itemLayoutId) {
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
        //"userName""userImg""postTxt""postImg"
        TextView userName = convertView.findViewById( R.id.c_tv_PraiseOthers_user_name);
        ImageView userImg = convertView.findViewById(R.id.c_iv_PraiseOthers_user_Img);
        TextView postTxt = convertView.findViewById(R.id.c_tv_PraiseOthers_post_txt);
        ImageView postImg = convertView.findViewById( R.id.c_iv_PraiseOthers_post_Img);
        userName.setText( contents.get( position ).get("userName").toString());
        userImg.setImageResource( (int)contents.get( position ).get("userImg") );
        postTxt.setText( contents.get( position ).get("postTxt ").toString());
        postImg.setImageResource((int)contents.get( position ).get("postImg"));

        return convertView;
    }
}
