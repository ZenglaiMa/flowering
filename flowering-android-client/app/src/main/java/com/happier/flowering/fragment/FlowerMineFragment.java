package com.happier.flowering.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.happier.flowering.R;
import com.happier.flowering.mine.MCollection;
import com.happier.flowering.mine.MPraise;

/**
 * @ClassName FlowerMineFragment
 * @Description 我的Fragment
 * @Author seven
 * @date 2020/4/16 15:09
 * @Version 0.1
 */
public class FlowerMineFragment extends Fragment {
    private LinearLayout collection;
    private LinearLayout praise;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_flower_mine, container, false );
        collection = view.findViewById( R.id.c_m_shou);

        collection.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MCollection.class );
                startActivity( intent );
            }
        } );
        praise = view.findViewById( R.id.c_praise );
        praise.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MPraise.class );
                startActivity( intent );
            }
        } );
        return view;


    }

}
