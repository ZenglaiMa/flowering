package com.happier.flowering.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.happier.flowering.R;
import com.happier.flowering.adapter.BePraisedAdapter;
import com.happier.flowering.adapter.PraiseOthersAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PraiseOthers extends AppCompatActivity {
    private ListView listView;
    private PraiseOthersAdapter praiseOthersAdapter;

    private List<Map<String,Object>> dataList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_praise_others );
    }



    public void findViews() {
        listView = findViewById( R.id.c_lv_collection );
    }


    public void setAdapters() {
       praiseOthersAdapter= new PraiseOthersAdapter( this, dataList, R.layout.mine_praiseothers_list );
        listView.setAdapter(praiseOthersAdapter);
    }
}
