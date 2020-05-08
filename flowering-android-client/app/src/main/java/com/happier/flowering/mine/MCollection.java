package com.happier.flowering.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.R;
import com.happier.flowering.adapter.CollectionAdapter;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.entity.Article;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MCollection extends AppCompatActivity {
    private ListView listView;
    private CollectionAdapter CollectionAdapter;

    private List<Article> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_mcollection );

        Log.e("收藏",dataList.toString());
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url( Constant.BASE_IP + "/center/findCollect" + "?id=" + 1 ).build();
        Call call = okHttpClient.newCall( request );

        call.enqueue( new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String info = response.body().string();
                Type type = new TypeToken<List<Article>>() {
                }.getType();
                dataList= new Gson().fromJson( info, type );
                findViews();
                setAdapters();
            }
        } );

    }

    public void findViews() {
        listView = findViewById( R.id.c_lv_collection );
    }


    public void setAdapters() {
        CollectionAdapter = new CollectionAdapter( this, dataList, R.layout.mine_collection_lisview );
        listView.setAdapter( CollectionAdapter );
    }
}
