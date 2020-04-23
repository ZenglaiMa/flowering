package com.happier.flowering.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.happier.flowering.R;
import com.happier.flowering.adapter.FloweringAmongLeftAdapter;
import com.happier.flowering.adapter.FloweringAmongRightAdapter;
import com.happier.flowering.entity.Article;
import com.happier.flowering.entity.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FlowerAmongFragment
 * @Description 花间Fragment
 * @Author seven
 * @date 2020/4/16 15:09
 * @Version 0.1
 */
public class FlowerAmongFragment extends Fragment {
    private ListView lvLeft = null;
    private ListView lvRight = null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flower_among, container, false);
        //TODO 查询类型 左
        lvLeft = view.findViewById(R.id.z_lv_left);
        List<Type> types = new ArrayList<>();
        FloweringAmongLeftAdapter adapter = new FloweringAmongLeftAdapter(types, getContext(), R.layout.adapter_flowering_among_left);
        lvLeft.setAdapter(adapter);

        //TODO 查询所有文章 右
        List<Article> articles = new ArrayList<>();
        lvRight = view.findViewById(R.id.z_lv_rigth);
        FloweringAmongRightAdapter adapter1 = new FloweringAmongRightAdapter(articles,getContext(), R.layout.adapter_flowering_among_right);
        lvRight.setAdapter(adapter1);

        return view;
    }

}
