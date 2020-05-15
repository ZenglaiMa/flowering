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
 * @ClassName UserSearchResultFragment
 * @Description 根据用户名查询用户并做展示的Fragment
 * @Author seven
 * @date 2020/5/15 22:03
 * @Version 0.1
 */
public class UserSearchResultFragment extends Fragment {

    private String keyword = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user_search_result, container, false);

        keyword = getActivity().getIntent().getStringExtra("keyword");

        return view;

    }
}
