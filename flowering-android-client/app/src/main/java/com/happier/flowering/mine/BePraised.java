package com.happier.flowering.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.R;
import com.happier.flowering.adapter.AttentionAdapter;
import com.happier.flowering.adapter.BePraisedAdapter;
import com.happier.flowering.adapter.CollectionAdapter;
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

public class BePraised extends AppCompatActivity {
    private ListView listView;
    private BePraisedAdapter bePraisedAdapter;

    private List<Map<String,Object>> dataList ;
    //"userName"  "userImg"  "postTxt"  "postImg"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_be_praised );
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url( Constant.BASE_IP + "/center/findThumbsMe" + "?id=" + 1 ).build();
        Call call = okHttpClient.newCall( request );
        call.enqueue( new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String info = response.body().string();
                Log.e("*****",info);
                Type type = new TypeToken<List<Map<String,Object>>>() {
                }.getType();
                dataList= new Gson().fromJson( info, type );
                findViews();
                setAdapters();
                Log.e("----------",dataList.toString());
            }
        } );
//        Log.e("获赞最终....",dataList.toString());
//        findViews();
//        setAdapters();
    }
    public void findViews() {
        listView = findViewById( R.id.c_lv_bePraised);
    }


    public void setAdapters() {
        bePraisedAdapter= new BePraisedAdapter( this, dataList, R.layout.mine_bepraised_list );
        listView.setAdapter(bePraisedAdapter);
    }

}
