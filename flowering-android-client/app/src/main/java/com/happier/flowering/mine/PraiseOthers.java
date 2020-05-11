package com.happier.flowering.mine;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.R;
import com.happier.flowering.adapter.BePraisedAdapter;
import com.happier.flowering.adapter.MinemoreHXAdapter;
import com.happier.flowering.adapter.PraiseOthersAdapter;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.entity.Post;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PraiseOthers extends Fragment {
    ListView listView;
    PraiseOthersAdapter praiseOthersAdapter;
    private Handler handler;
    //"userName""userImg""postTxt""postImg"
    private List<Map<String, Object>> dataList = new ArrayList<>();
    private Gson gson;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.activity_praise_others, container, false );
//        OkHttpClient okHttpClient = new OkHttpClient();
//        Request request = new Request.Builder().url( Constant.BASE_IP + "/logistics-server/assessServlet"  ).build();
//        Call call = okHttpClient.newCall( request );
//        call.enqueue( new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String info = response.body().string();
//                Log.e( "*****", info );
//                Type type = new TypeToken<List<Map<String, Object>>>() {
//                }.getType();
//                dataList = new Gson().fromJson( info, type );
//                listView = view.findViewById( R.id.c_lv_praisedOther );
//                praiseOthersAdapter = new PraiseOthersAdapter( getContext(), dataList, R.layout.mine_praiseothers_list );
//                listView.setAdapter( praiseOthersAdapter );
//                Log.e( "----------", dataList.toString() );
//            }
//        } );
        initData();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                String messages = (String) msg.obj;
                Log.e("获取——————————message",messages);
                Type type = new TypeToken<List<Map<String,Object>>>() {}.getType();
                dataList = new Gson().fromJson( messages, type );

                Log.e("喜欢####",dataList.toString());
                listView = view.findViewById( R.id.c_lv_praisedOther );
                praiseOthersAdapter = new PraiseOthersAdapter( getContext(), dataList, R.layout.mine_praiseothers_list );
                listView.setAdapter( praiseOthersAdapter );

            }

        };
        return view;
    }
    public void initData(){
        new Thread(){
            @Override
            public void run() {
                try {
                    URL url= new URL( Constant.BASE_IP +"/center/findThumbsOther" + "?id=" + 1 );
                    URLConnection conn = url.openConnection();
                    InputStream in = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
                    String info = reader.readLine();
                    Log.e("******************",info);
                    Message message = new Message();
                    message.obj = info;
                    handler.sendMessage(message);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }


        }.start();
    }
}
