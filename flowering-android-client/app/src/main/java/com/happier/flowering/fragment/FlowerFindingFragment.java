package com.happier.flowering.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.entity.Bean;
import com.happier.flowering.adapter.RecyclerViewAdapter;
import com.happier.flowering.view.StickHeaderDecoration;
import com.happier.flowering.view.TopSmoothScroller;
import com.happier.flowering.view.WordsNavigation;
import com.happier.flowering.R;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.entity.Plant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @ClassName FlowerFindingFragment
 * @Description 花觅Fragment
 * @Author seven
 * @date 2020/4/16 15:09
 * @Version 0.1
 */
public class FlowerFindingFragment extends Fragment {
    private LinearLayout searchBar;
    private int searchBarHeight;
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private WordsNavigation wordsNavigation;
    private String mLetter;
    private TextView ytv;
    private String[] letters = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
            "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private LinearLayoutManager mLayoutManager;
    List<Plant> plantList = new ArrayList<>();
    public static final String GETALLPLANT_PATH = "/discovery/plantinfo ";
    private final int  REQUEST_SUCCESS = 1;
    private final int  REQUEST_FAIL = 0;
    private Gson gson;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flower_finding, container, false);

        searchBar = view.findViewById(R.id.ll_search);
        searchBarHeight = searchBar.getHeight();
        mRecyclerView = view.findViewById(R.id.rv_list);
        wordsNavigation = view.findViewById(R.id.view_plant);
        ytv = view.findViewById(R.id.ytv_search);

        List<Bean> beanList = new ArrayList<>();
        for (int i = 0; i < letters.length; i++) {
            beanList.add(new Bean(letters[i]));
        }

        gson = new Gson();

        GetAllPlantInfosThread thread = new GetAllPlantInfosThread();
        thread.start();
        while (thread.flag==false){
            Log.e("Thread ","is running..");
        }

        mAdapter = new RecyclerViewAdapter(getContext(), beanList, plantList);
        mRecyclerView.addItemDecoration(new StickHeaderDecoration(getActivity()));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

        initListener();

        return view;
    }

    public class  GetAllPlantInfosThread extends  Thread{
        boolean flag=false;
        public GetAllPlantInfosThread(){

        }
        public void  run(){
            try {
                List<Plant> list = new ArrayList<>();
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(Constant.BASE_IP+GETALLPLANT_PATH)
                        .build();
                Response response = okHttpClient.newCall(request).execute();

                String plantJson = response.body().string();
                plantList = gson.fromJson(plantJson, new TypeToken<List<Plant>>() {
                }.getType());
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.e("执行完成 ","2");
            callback();
        }
        public void callback(){
            Log.e("子线程执行结束","1");
            flag = true;
        }
    }

    private void initListener() {
        wordsNavigation.setOnShowLetter(letter -> {
            mLetter = letter;
            Log.e("receive",mLetter);
            TopSmoothScroller scroller = new TopSmoothScroller(getActivity());
            switch (mLetter) {
                case "A":
                    mRecyclerView.scrollToPosition(0);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(0, 0);
                    break;
                case "B":
                    mRecyclerView.scrollToPosition(1);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(1, 0);
                    break;
                case "C":
                    mRecyclerView.scrollToPosition(2);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(2, 0);
                    break;
                case "D":
                    mRecyclerView.scrollToPosition(3);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(3, 0);
                    break;
                case "E":
                    mRecyclerView.scrollToPosition(4);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(4, 0);
                    break;
                case "F":
                    mRecyclerView.scrollToPosition(5);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(5, 0);
                    break;
                case "G":
                    mRecyclerView.scrollToPosition(6);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(6, 0);
                    break;
                case "H":
                    mRecyclerView.scrollToPosition(7);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(7, 0);
                    break;
                case "I":
                    mRecyclerView.scrollToPosition(8);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(8, 0);
                    break;
                case "J":
                    mRecyclerView.scrollToPosition(9);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(9, 0);
                    break;
                case "K":
                    mRecyclerView.scrollToPosition(10);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(10, 0);
                    break;
                case "L":
                    mRecyclerView.scrollToPosition(11);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(11, 0);
                    break;
                case "M":
                    mRecyclerView.scrollToPosition(12);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(12, 0);
                    break;
                case "N":
                    mRecyclerView.scrollToPosition(13);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(13, 0);
                    break;
                case "O":
                    mRecyclerView.scrollToPosition(14);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(14, 0);
                    break;
                case "P":
                    mRecyclerView.scrollToPosition(15);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(15, 0);
                    break;
                case "Q":
                    mRecyclerView.scrollToPosition(16);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(16, 0);
                    break;
                case "R":
                    mRecyclerView.scrollToPosition(17);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(17, 0);
                    break;
                case "S":
                    mRecyclerView.scrollToPosition(18);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(18, 0);
                    break;
                case "T":
                    mRecyclerView.scrollToPosition(19);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(19, 0);
                    break;
                case "U":
                    mRecyclerView.scrollToPosition(20);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(20, 0);
                    break;
                case "V":
                    mRecyclerView.scrollToPosition(21);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(21, 0);
                    break;
                case "W":
                    mRecyclerView.scrollToPosition(22);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(22, 0);
                    break;
                case "X":
                    mRecyclerView.scrollToPosition(23);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(23, 0);
                    break;
                case "Y":
                    mRecyclerView.scrollToPosition(24);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(24, 0);
                    break;
                case "Z":
                    mRecyclerView.scrollToPosition(25);
                    mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(25, 0);
                    break;
            }
        });
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(position);

    }
}
