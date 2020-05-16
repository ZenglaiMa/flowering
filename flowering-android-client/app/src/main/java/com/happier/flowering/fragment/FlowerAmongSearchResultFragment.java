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
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.R;
import com.happier.flowering.activity.ArticleDetail;
import com.happier.flowering.adapter.FloweringAmongLeftAdapter;
import com.happier.flowering.adapter.FloweringAmongRightAdapter;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.entity.Article;
import com.happier.flowering.entity.Type;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @ClassName FlowerAmongSearchResultFragment
 * @Description 根据标题查询花间文章并做展示的Fragment
 * @Author seven
 * @date 2020/5/15 21:59
 * @Version 0.1
 */
public class FlowerAmongSearchResultFragment extends Fragment {

    private String keyword = null;
    private ListView listView = null;
    private OkHttpClient client = new OkHttpClient();
    private FloweringAmongRightAdapter adapter = null;
    private List<Article> articles = new ArrayList<>();
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_flower_among_search_result, container, false);
        listView = view.findViewById(R.id.z_lv_search);
        keyword = getActivity().getIntent().getStringExtra("keyword");

        initData(keyword);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                addReadingNum(articles.get(position).getArticleId());
                articles.get(position).setReadingNum(articles.get(position).getReadingNum() + 1);
                Intent intent = new Intent(getContext(), ArticleDetail.class);
                intent.putExtra("article", new Gson().toJson(articles.get(position)));
                startActivity(intent);
                adapter.notifyDataSetChanged();
            }
        });
        return view;
    }

    public void initData(String keyword) {
        RequestBody requestBody = RequestBody.create(
                MediaType.parse("text/plain;charset=utf-8"),
                keyword);
        Request request = new Request.Builder()
                .post(requestBody)
                .url(Constant.BASE_IP + "/community/search")
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                EventBus.getDefault().post(result);
            }
        });
    }
    //阅读人数+1
    public void addReadingNum(int articleId) {
        RequestBody requestBody = RequestBody.create(
                MediaType.parse("text/plain;charset=utf-8"),
                articleId + "");
        Request request = new Request.Builder()
                .post(requestBody)
                .url(Constant.BASE_IP + "/community/addReadingNum")
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
            }
        });
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void init(String result) {
        articles = new Gson().fromJson(result, new TypeToken<List<Article>>() {}.getType());
        adapter = new FloweringAmongRightAdapter(articles, getContext(), R.layout.adapter_flowering_among_right);
        listView.setAdapter(adapter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
