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
 * @ClassName FlowerFindingFragment
 * @Description 花觅Fragment
 * @Author seven
 * @date 2020/4/16 15:09
 * @Version 0.1
 */
public class FlowerFindingFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flower_finding, container, false);

        return view;
    }
}
