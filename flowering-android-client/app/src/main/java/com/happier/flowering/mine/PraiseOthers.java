package com.happier.flowering.mine;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.R;
import com.happier.flowering.adapter.BePraisedAdapter;
import com.happier.flowering.adapter.PraiseOthersAdapter;
import com.happier.flowering.constant.Constant;

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

public class PraiseOthers extends AppCompatActivity {
    ListView listView;
    PraiseOthersAdapter praiseOthersAdapter;
    //"userName""userImg""postTxt""postImg"
    private List<Map<String, Object>> dataList;
    private static final int COMPLETED = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_praise_others );
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url( Constant.BASE_IP + "/center/findThumbsOther" + "?id=" + 1 ).build();
        Call call = okHttpClient.newCall( request );
        call.enqueue( new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String info = response.body().string();
                Type type = new TypeToken<List<Map<String, Object>>>() {
                }.getType();
                dataList = new Gson().fromJson( info, type );
                Log.e("我的点赞***",dataList.toString());
                listView = findViewById( R.id.c_lv_praisedOther );
                praiseOthersAdapter = new PraiseOthersAdapter( PraiseOthers.this, dataList, R.layout.mine_praiseothers_list );
                listView.setAdapter(praiseOthersAdapter);
            }
        } );

    }


//
//    public void findViews() {
//        listView = findViewById( R.id.c_lv_praisedOther );
//    }
//
//
//    public void setAdapters() {
//        praiseOthersAdapter = new PraiseOthersAdapter( this, dataList, R.layout.mine_praiseothers_list );
//        listView.setAdapter( praiseOthersAdapter );
//    }
}
