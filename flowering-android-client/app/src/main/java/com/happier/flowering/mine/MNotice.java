package com.happier.flowering.mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.R;
import com.happier.flowering.adapter.CollectionAdapter;
import com.happier.flowering.adapter.NoticeAdapter;
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

public class MNotice extends AppCompatActivity {
    private ListView listView;
    private NoticeAdapter noticeAdapter;
    private List<Map<String,Object>> dataList = new ArrayList<>();
  //  "CommentContent", "CommentTime","UserName", "UserImg", "PostContent", "PostImg"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_mnotice );
        Log.e("通知",dataList.toString());
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url( Constant.BASE_IP + "/center/findComments" + "?id=" + 1 ).build();
        Call call = okHttpClient.newCall( request );

        call.enqueue( new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String info = response.body().string();
                Type type = new TypeToken<List<Map<String,Object>>>() {
                }.getType();
                dataList= new Gson().fromJson( info, type );
                findViews();
                setAdapters();
            }
        } );

    }
    public void findViews() {
        listView = findViewById( R.id.c_lv_notice );
    }


    public void setAdapters() {
        noticeAdapter = new NoticeAdapter( this, dataList, R.layout.mine_notice_listview );
        listView.setAdapter( noticeAdapter );
    }

}
