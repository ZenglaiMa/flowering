package com.happier.flowering.mine;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.R;
import com.happier.flowering.adapter.BePraisedAdapter;
import com.happier.flowering.constant.Constant;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BePraised extends Fragment {

    private ListView listView;
    private BePraisedAdapter bePraisedAdapter;
    private List<Map<String, Object>> dataList;

    private String result = null;

    private static final String FLAG = "GetThumbsUpSuccess";

    private int currentUserId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_be_praised, container, false);

        currentUserId = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE).getInt("userId", 0);

        listView = view.findViewById(R.id.c_lv_bePraised);

        initData();

        return view;
    }

    private void initData() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(Constant.BASE_IP + "/center/findThumbsMe" + "?id=" + currentUserId).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                result = response.body().string();
                EventBus.getDefault().post("GetThumbsUpSuccess");
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void showLayout(String flag) {
        if (flag.equals(FLAG)) {
            dataList = new Gson().fromJson(result, new TypeToken<List<Map<String, Object>>>() {}.getType());
            bePraisedAdapter = new BePraisedAdapter(getActivity(), dataList, R.layout.mine_bepraised_list);
            listView.setAdapter(bePraisedAdapter);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
