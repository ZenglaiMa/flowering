package com.happier.flowering.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.R;
import com.happier.flowering.adapter.FansAdapter;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.entity.User;
import com.happier.flowering.mine.FlowerMineMoreActivity;

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

/**
 * @ClassName UserSearchResultFragment
 * @Description 根据用户名查询用户并做展示的Fragment
 * @Author seven
 * @date 2020/5/15 22:03
 * @Version 0.1
 */
public class UserSearchResultFragment extends Fragment {

    private ListView lvUserList;

    private List<User> dataSource = new ArrayList<>();

    private OkHttpClient client = new OkHttpClient();

    private static final String USER_LIST_SEARCH_RESULT = "/UserSearchResult/users";
    private static final String FLAG = "search_result_of_user";

    private String keyword = null;
    private String result = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user_search_result, container, false);

        keyword = getActivity().getIntent().getStringExtra("keyword");

        lvUserList = view.findViewById(R.id.m_lv_user_list);

        getUserInfo();

        lvUserList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), FlowerMineMoreActivity.class);
                intent.putExtra("userId", (int) id);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        return view;
    }

    private void getUserInfo() {
        Request request = new Request.Builder().url(Constant.BASE_IP + USER_LIST_SEARCH_RESULT + "?keyword=" + keyword).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                result = response.body().string();
                EventBus.getDefault().post("search_result_of_user");
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handleData(String flag) {
        if (flag.equals(FLAG)) {
            dataSource = new Gson().fromJson(result, new TypeToken<List<User>>() {
            }.getType());
            FansAdapter adapter = new FansAdapter(getActivity(), dataSource, R.layout.mine_fans_list);
            lvUserList.setAdapter(adapter);
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
