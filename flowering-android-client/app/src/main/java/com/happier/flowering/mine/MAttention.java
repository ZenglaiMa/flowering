package com.happier.flowering.mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.happier.flowering.R;
import com.happier.flowering.adapter.AttentionAdapter;
import com.happier.flowering.adapter.CollectionAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MAttention extends AppCompatActivity {
    private ListView listView;
    private AttentionAdapter attentionAdapter;

    private List<Map<String,Object>> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_mattention );
        findViews();
        setAdapters();
    }
    public void findViews() {
        listView = findViewById( R.id.c_lv_collection );
    }


    public void setAdapters() {
       attentionAdapter = new AttentionAdapter( this, dataList, R.layout.mine_collection_lisview );
        listView.setAdapter( attentionAdapter);
    }
}



