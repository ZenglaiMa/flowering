package com.happier.flowering.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.happier.flowering.entity.Message;

import java.util.List;

public class MinemoreMessageAdapter extends BaseAdapter {
    private Context context;
    private List<Message> messages;
    private int item_message_id;
    public MinemoreMessageAdapter(Context context, List<Message> messages, int  item_message_id) {
        this.context = context;
        this.messages = messages;
        this.item_message_id = item_message_id;
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
