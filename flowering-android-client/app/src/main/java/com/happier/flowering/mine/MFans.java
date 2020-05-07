package com.happier.flowering.mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.R;
import com.happier.flowering.adapter.AttentionAdapter;
import com.happier.flowering.adapter.FansAdapter;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.entity.User;

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

public class MFans extends AppCompatActivity {
    private ListView listView;
    private FansAdapter fansAdapter;

    private List<User> dataList = new ArrayList<>();

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
    public void getFans(){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url( Constant.BASE_IP + "/center/findPassive" + "?id=" + 1 ).build();
        Call call = okHttpClient.newCall( request );

        call.enqueue( new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String info = response.body().string();
                Type type = new TypeToken<List<User>>() {
                }.getType();
                dataList= new Gson().fromJson( info, type );
            }
        } );
    }
}