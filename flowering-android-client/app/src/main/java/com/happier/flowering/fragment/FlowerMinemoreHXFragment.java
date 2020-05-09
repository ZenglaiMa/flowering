package com.happier.flowering.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.R;
import com.happier.flowering.adapter.MinemoreHXAdapter;
import com.happier.flowering.adapter.MinemoreMessageAdapter;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.entity.Post;
import com.happier.flowering.mine.FlowerMinemore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 //        * @ClassName FlowerMinemoreFragment
 //        * @Description 我的详情花现1Fragment
 //        * @Author q
 //        * @date 2020/4/16 15:09
 //        * @Version 0.1
 //        */
public class FlowerMinemoreHXFragment extends Fragment implements AdapterView.OnItemClickListener {
    private List<Post> myPosts =new ArrayList<>();
    private MinemoreHXAdapter minemoreHXAdapter;
    private Handler handler;
    private ListView listView;
    private Gson gson;
    private static final  String PATH_MINEMORE_HX="/center/findPosts";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.minemore_fragment_finding, container, false);
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();
        listView=view.findViewById(R.id.q_finginglist);
        initPostData();
        handler = new Handler() {
            @Override
            public void handleMessage(android.os.Message msg) {
                String messages = (String) msg.obj;
                myPosts = gson.fromJson(messages, new TypeToken<List<Post>>(){}.getType());
                Log.e("話現查询",myPosts.toString());
                minemoreHXAdapter = new MinemoreHXAdapter(getContext(),myPosts, R.layout.minemore_fragment_flist);
                listView.setAdapter(minemoreHXAdapter);
                listView.setOnItemClickListener(FlowerMinemoreHXFragment.this);
            }

        };



        return view;
    }
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {   // 不在最前端显示 相当于调用了onPause();
            return;
        }else{  // 在最前端显示 相当于调用了onResume();
            //网络数据刷新
            initPostData();
        }
    }
    public void initPostData(){
        new Thread(){
            @Override
            public void run() {
                //查询私信数据
                Log.e("我的花","查詢");
                try {
                    URL url= new URL(Constant.BASE_IP + PATH_MINEMORE_HX+"?id=2");
                    URLConnection conn = url.openConnection();
                    InputStream in = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
                    String info = reader.readLine();
                    android.os.Message message = new android.os.Message();
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

    /**
     * 跳轉詳情頁
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
