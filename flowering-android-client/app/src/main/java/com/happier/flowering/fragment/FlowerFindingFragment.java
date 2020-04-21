package com.happier.flowering.fragment;

import android.os.Bundle;
import android.os.CountDownTimer;
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
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.happier.flowering.FlowerFinding.Bean;
import com.happier.flowering.FlowerFinding.PreWordNavigation;
import com.happier.flowering.FlowerFinding.RecyclerViewAdapter;
import com.happier.flowering.FlowerFinding.ScrollEvent;
import com.happier.flowering.FlowerFinding.StickHeaderDecoration;
import com.happier.flowering.FlowerFinding.TopSmoothScroller;
import com.happier.flowering.FlowerFinding.WordsNavigation;
import com.happier.flowering.R;
import com.happier.flowering.entity.Plant;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

        Plant plant1 = new Plant();
        plant1.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587406686475&di=87d6364ea7ce9dd1c0093b0c8c369309&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fexp%2Fwhcrop%3D160%2C120%2Fsign%3D11126326e1fe9925cb593f125bd863ee%2F2fdda3cc7cd98d102ad277d2203fb80e7aec90ca.jpg");
        plant1.setNameCn("茉莉");
        plantList.add(plant1);
        Plant plant2 = new Plant();
        plant2.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587406686475&di=87d6364ea7ce9dd1c0093b0c8c369309&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fexp%2Fwhcrop%3D160%2C120%2Fsign%3D11126326e1fe9925cb593f125bd863ee%2F2fdda3cc7cd98d102ad277d2203fb80e7aec90ca.jpg");
        plant2.setNameCn("茉莉");
        plantList.add(plant2);
        Plant plant3 = new Plant();
        plant3.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587406686475&di=87d6364ea7ce9dd1c0093b0c8c369309&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fexp%2Fwhcrop%3D160%2C120%2Fsign%3D11126326e1fe9925cb593f125bd863ee%2F2fdda3cc7cd98d102ad277d2203fb80e7aec90ca.jpg");
        plant3.setNameCn("茉莉");
        plantList.add(plant3);
        Plant plant4 = new Plant();
        plant4.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587406686475&di=87d6364ea7ce9dd1c0093b0c8c369309&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fexp%2Fwhcrop%3D160%2C120%2Fsign%3D11126326e1fe9925cb593f125bd863ee%2F2fdda3cc7cd98d102ad277d2203fb80e7aec90ca.jpg");
        plant4.setNameCn("茉莉");
        plantList.add(plant4);
        Plant plant5 = new Plant();
        plant5.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587406686475&di=87d6364ea7ce9dd1c0093b0c8c369309&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fexp%2Fwhcrop%3D160%2C120%2Fsign%3D11126326e1fe9925cb593f125bd863ee%2F2fdda3cc7cd98d102ad277d2203fb80e7aec90ca.jpg");
        plant5.setNameCn("茉莉");
        plantList.add(plant5);
        mAdapter = new RecyclerViewAdapter(getContext(), beanList, plantList);
        mRecyclerView.addItemDecoration(new StickHeaderDecoration(getActivity()));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

        initListener();

        return view;
    }

    private void initListener() {
        wordsNavigation.setOnShowLetter(letter -> {
            mLetter = letter;
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
