package com.happier.flowering.mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.happier.flowering.R;
import com.happier.flowering.adapter.CollectionAdapter;
import com.happier.flowering.adapter.NoticeAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MNotice extends AppCompatActivity {
    private ListView listView;
    private NoticeAdapter noticeAdapter;

    private List<Map<String,Object>> dataList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_mnotice );
        findViews();
        setAdapters();
    }
    public void findViews() {
        listView = findViewById( R.id.c_lv_notice );
    }


    public void setAdapters() {
        noticeAdapter = new NoticeAdapter( this, dataList, R.layout.mine_notice_listview );
        listView.setAdapter( noticeAdapter );
    }
}
