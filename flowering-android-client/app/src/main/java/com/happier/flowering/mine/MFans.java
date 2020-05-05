package com.happier.flowering.mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.happier.flowering.R;
import com.happier.flowering.adapter.AttentionAdapter;
import com.happier.flowering.adapter.FansAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MFans extends AppCompatActivity {
    private ListView listView;
    private FansAdapter fansAdapter;

    private List<Map<String, Object>> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_mfans );
        findViews();
        setAdapters();
    }


    public void findViews() {
        listView = findViewById( R.id.c_lv_collection );
    }


    public void setAdapters() {
        fansAdapter = new FansAdapter( this, dataList, R.layout.mine_fans_list );
        listView.setAdapter( fansAdapter);
    }
}