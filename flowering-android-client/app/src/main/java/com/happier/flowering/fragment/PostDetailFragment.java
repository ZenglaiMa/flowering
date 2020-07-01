package com.happier.flowering.fragment;

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
import com.happier.flowering.adapter.LatestAndChoicePostAdapter;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.model.NineGridModel;
import com.happier.flowering.model.PostListModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @ClassName PostDetailFragment
 * @Description
 * @Author seven
 * @date 2020/5/17 19:59
 * @Version 0.1
 */
public class PostDetailFragment extends Fragment {

    private ListView listView;
    private SmartRefreshLayout refreshLayout;
    private List<Map<String, Object>> dataSource = new ArrayList<>();
    private LatestAndChoicePostAdapter adapter = null;

    private OkHttpClient client = new OkHttpClient();
    private Gson gson = new Gson();

    private static final String POST_DETAIL_SHOW_PATH = "/post/detail";
    private static final String FLAG = "detail";

    private String result = null;

    private int postId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_post_latest_and_choice, container, false);

        postId = (Double.valueOf(getActivity().getIntent().getStringExtra("postId"))).intValue();

        listView = view.findViewById(R.id.m_post_lv);
        refreshLayout = view.findViewById(R.id.m_post_list_refresh);
        refreshLayout.setEnableRefresh(false).setEnableLoadMore(false);

        getPostInfo();

        return view;
    }

    private void getPostInfo() {
        Request request = new Request.Builder().url(Constant.BASE_IP + POST_DETAIL_SHOW_PATH + "?postId=" + postId).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                result = response.body().string();
                if (result != null && !result.equals("")) {
                    EventBus.getDefault().post("detail");
                }
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void initData(String flag) {
        if (FLAG.equals(flag)) {
            List<PostListModel> models = gson.fromJson(result, new TypeToken<List<PostListModel>>() {}.getType());
            for (PostListModel model : models) {
                Map<String, Object> map = new HashMap<>();
                map.put("post_id", model.getPostId());
                map.put("post_text", model.getPostText());
                map.put("nickname", model.getNickname());
                map.put("head_img", model.getHeadImg());
                map.put("topic_name", model.getTopicName());
                map.put("user_id", model.getUserId());
                map.put("thumbs_up_count", model.getThumbsUpCount());
                map.put("comment_list", model.getCommentListModels());

                String[] imgUrls = model.getPostImg().split(",");
                NineGridModel nineGridModel = new NineGridModel();
                for (int i = 0; i < imgUrls.length; i++) {
                    nineGridModel.urlList.add(Constant.BASE_IP + imgUrls[i]);
                }
                nineGridModel.isShowAll = false;
                map.put("nine_grid", nineGridModel);

                long createTime = model.getPostCreateTime().getTime();
                long currentTime = System.currentTimeMillis();
                long sub = currentTime - createTime;
                if (sub < 1000 * 60) {
                    map.put("create_time", "刚刚");
                } else if (sub < 1000 * 60 * 60) {
                    map.put("create_time", sub / (1000 * 60) + "分钟前");
                } else if (sub < 1000 * 60 * 60 * 24) {
                    map.put("create_time", sub / (1000 * 60 * 60) + "小时前");
                } else {
                    map.put("create_time", sub / (1000 * 60 * 60 * 24) + "天前");
                }

                dataSource.add(map);
            }

            if (adapter == null) {
                setAdapter();
            } else {
                adapter.notifyDataSetChanged();
            }
        }
    }

    private void setAdapter() {
        adapter = new LatestAndChoicePostAdapter(getContext(), dataSource, R.layout.post_show_list_item);
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