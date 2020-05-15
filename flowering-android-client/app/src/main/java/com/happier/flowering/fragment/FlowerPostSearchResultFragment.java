package com.happier.flowering.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.happier.flowering.R;

/**
 * @ClassName FlowerPostSearchResultFragment
 * @Description 根据文字内容查询花现并做展示的Fragment
 * @Author seven
 * @date 2020/5/15 22:01
 * @Version 0.1
 */
public class FlowerPostSearchResultFragment extends Fragment {

    private String keyword = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flower_post_search_result, container, false);

        keyword = getActivity().getIntent().getStringExtra("keyword");

        return view;
    }
}
