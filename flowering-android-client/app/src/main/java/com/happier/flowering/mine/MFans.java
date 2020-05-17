package com.happier.flowering.mine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.R;
import com.happier.flowering.adapter.FansAdapter;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.entity.User;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MFans extends AppCompatActivity {

    private ListView listView;
    private FansAdapter fansAdapter;
    private List<User> dataList = new ArrayList<>();

    private static final String FLAG = "fans";

    private String result = null;

    private int currentUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mfans);

        EventBus.getDefault().register(this);

        currentUserId = getSharedPreferences("data", MODE_PRIVATE).getInt("userId", 0);

        listView = findViewById(R.id.c_lv_mFans);

        initData();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MFans.this, FlowerMineMoreActivity.class);
                intent.putExtra("userId", (int) id);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });
    }

    private void initData() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(Constant.BASE_IP + "/center/findPassive" + "?id=" + currentUserId).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                result = response.body().string();
                EventBus.getDefault().post("fans");
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handleResult(String flag) {
        if (flag.equals(FLAG)) {
            dataList = new Gson().fromJson(result, new TypeToken<List<User>>() {}.getType());
            fansAdapter = new FansAdapter(this, dataList, R.layout.mine_fans_list);
            listView.setAdapter(fansAdapter);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            overridePendingTransition(R.anim.left_in, R.anim.right_out);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}