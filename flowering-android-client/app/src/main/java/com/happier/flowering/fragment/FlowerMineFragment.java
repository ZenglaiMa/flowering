package com.happier.flowering.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.R;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.entity.User;
import com.happier.flowering.mine.FlowerMinemore;
import com.happier.flowering.mine.MCollection;
import com.happier.flowering.mine.MPraise;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @ClassName FlowerMineFragment
 * @Description 我的Fragment
 * @Author seven
 * @date 2020/4/16 15:09
 * @Version 0.1
 */
public class FlowerMineFragment extends Fragment {
    private LinearLayout collection;
    private LinearLayout praise;
    private User user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_flower_mine, container, false );
        OkhttpThread okhttpThread = new OkhttpThread();
        okhttpThread.start();
        //设置昵称
        TextView nickName = view.findViewById(R.id.c_nickname);
//        nickName.setText(user.getNickname());
        collection = view.findViewById( R.id.c_m_shou);
        collection.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MCollection.class );
                startActivity( intent );
            }
        } );
        praise = view.findViewById( R.id.c_praise );
        praise.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MPraise.class );
                startActivity( intent );
            }
        } );
        view.findViewById(R.id.c_iv_center).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), FlowerMinemore.class);
                intent.putExtra("username",user.getNickname());
                intent.putExtra("userImg", user.getHeadImg());
                intent.putExtra( "address",user.getAddress());
                intent.putExtra( "sex",user.getSex() );
                intent.putExtra( "profile",user.getProfile());
                startActivity(intent);
            }
        } );
        return view;


    }
    private class OkhttpThread extends Thread{

        @Override
        public void run() {
            super.run();
            OkHttpClient okHttpClient = new OkHttpClient();
            Request request = new Request.Builder().url(Constant.BASE_IP + "/center/userInfo" + "?id=" + 1 ).build();
            Call call = okHttpClient.newCall(request);

            call.enqueue( new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String info = response.body().string();
                    Type type = new TypeToken<User>() {
                    }.getType();
                    user = new Gson().fromJson( info, type );
                    Log.e("用户",user.getNickname());
                }
            } );

        }

    }


}
