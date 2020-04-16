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
 * @ClassName FlowerAmongFragment
 * @Description 花间Fragment
 * @Author seven
 * @date 2020/4/16 15:09
 * @Version 0.1
 */
public class FlowerAmongFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flower_among, container, false);

        return view;
    }

}
