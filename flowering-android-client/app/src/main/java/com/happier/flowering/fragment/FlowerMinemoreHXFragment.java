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
 //        * @ClassName FlowerMinemoreFragment
 //        * @Description 我的详情花现1Fragment
 //        * @Author q
 //        * @date 2020/4/16 15:09
 //        * @Version 0.1
 //        */
public class FlowerMinemoreHXFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.minemore_fragment_finding, container, false);

        return view;
    }
}
