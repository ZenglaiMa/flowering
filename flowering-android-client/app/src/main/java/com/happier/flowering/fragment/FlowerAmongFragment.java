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
 * @ClassName FlowerAmongFragment
 * @Description 花间Fragment
 * @Author seven 赵语涵
 * @date 2020/4/16 15:09
 * @Version 0.1
 */
public class FlowerAmongFragment extends Fragment {
    private ListView lvLeft = null;
    private ListView lvRight = null;
    private OkHttpClient client = new OkHttpClient();
    private List<Article> articles = new ArrayList<>();
    private List<Article> articlesTemp = new ArrayList<>();
    private List<Type> types = new ArrayList<>();
    private FloweringAmongLeftAdapter adapter;
    private FloweringAmongRightAdapter adapter1;
    private Gson gson = new Gson();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flower_among, container, false);

        lvLeft = view.findViewById(R.id.z_lv_left);
        getAllTypes();

        lvRight = view.findViewById(R.id.z_lv_rigth);
        getAllArticles();
        listeners();
        return view;
    }
    public void getAllTypes(){
        Request request = new Request.Builder().url(Constant.BASE_IP + "/community/getAllTypes").build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                String resultTemp = "0yy" + result;
                EventBus.getDefault().post(resultTemp);
            }
        });
    }
    public void getAllArticles(){
        Request request = new Request.Builder().url(Constant.BASE_IP + "/community/getAllArticles").build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                String resultTemp = "1yy" + result;
                EventBus.getDefault().post(resultTemp);
            }
        });
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void init(String result) {
        String[] strs = result.split("yy");
        if(strs[0].equals("0")){
            types = gson.fromJson(strs[1], new TypeToken<List<Type>>() {
            }.getType());
            adapter = new FloweringAmongLeftAdapter(types, getContext(), R.layout.adapter_flowering_among_left);
            lvLeft.setAdapter(adapter);
        }else if(strs[0].equals("1")){
            articles = gson.fromJson(strs[1], new TypeToken<List<Article>>() {
            }.getType());
            adapter1 = new FloweringAmongRightAdapter(articles,getContext(), R.layout.adapter_flowering_among_right);
            lvRight.setAdapter(adapter1);
        }else if(strs[0].equals("2")){
            articlesTemp = gson.fromJson(strs[1], new TypeToken<List<Article>>() {
            }.getType());
            Log.e("articlesTemp", articlesTemp.toString());
            articles.clear();
            Log.e("articles1", articles.toString());
            for (int i=0; i<articlesTemp.size(); i++){
                articles.add(articlesTemp.get(i));
            }
            Log.e("articles2", articles.toString());
            adapter1.notifyDataSetChanged();
        }
    }
    public void listeners(){
        lvRight.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                addReadingNum(articles.get(position).getArticleId());
                articles.get(position).setReadingNum(articles.get(position).getReadingNum()+1);
                Intent intent = new Intent(getContext(), ArticleDetail.class);
                intent.putExtra("article", new Gson().toJson(articles.get(position)));
                startActivity(intent);
                adapter1.notifyDataSetChanged();
            }
        });
        lvLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getArticlesByType(types.get(position).getTypeId());

            }
        });
    }
    //阅读人数+1
    public void addReadingNum(int articleId){
        RequestBody requestBody = RequestBody.create(
                MediaType.parse("text/plain;charset=utf-8"),
                articleId+"");
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
    public void getArticlesByType(int typeId){
        RequestBody requestBody = RequestBody.create(
                MediaType.parse("text/plain;charset=utf-8"),
                typeId+"");
        Request request = new Request.Builder()
                .post(requestBody)
                .url(Constant.BASE_IP + "/community/getArticleByType")
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                String resultTemp = "2yy" + result;
                EventBus.getDefault().post(resultTemp);
            }
        });
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
