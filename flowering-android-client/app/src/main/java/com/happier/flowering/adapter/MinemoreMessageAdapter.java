package com.happier.flowering.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.happier.flowering.R;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.entity.Message;
import com.happier.flowering.entity.User;
import com.happier.flowering.fragment.FlowerMinemoreMessageFragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class MinemoreMessageAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String, Object>> messages;
    private int item_message_id;
    //    private List <User> users;
    public MinemoreMessageAdapter(Context context, List<Map<String, Object>> messages, int  item_message_id) {
        this.context = context;
        this.messages = messages;
        this.item_message_id = item_message_id;
    }
    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int position) {
        return messages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        if (null == convertView) {
            convertView = inflater.inflate(item_message_id, null);
        }
        final ImageView headImg = convertView.findViewById(R.id.q_mlist_head);
        final TextView name = convertView.findViewById(R.id.q_mlist_name);
        final TextView content = convertView.findViewById(R.id.q_mlist_content);
        final TextView time = convertView.findViewById(R.id.q_mlist_time);
        Map<String, Object> map = messages.get(position);
        //填充数据

//            headImg.setBackgroundResource(R.drawable.(messages.get(position).get("senderHead").toString()));
//        Message ms=new Message();
//        ms= messages.get(position).get("content").;
        content.setText(messages.get(position).get("content").toString());
        time.setText(messages.get(position).get("time").toString());
        name.setText(messages.get(position).get("senderName").toString());


        return convertView;
    }



}
