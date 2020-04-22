package com.happier.flowering;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.happier.flowering.adapter.CustomPageAdapter;
import com.happier.flowering.fragment.FlowerAmongFragment;
import com.happier.flowering.fragment.FlowerFindingFragment;
import com.happier.flowering.fragment.FlowerMineFragment;
import com.happier.flowering.fragment.FlowerPostFragment;
import com.happier.flowering.fragment.TopicPostFragment;
import com.yinglan.alphatabs.AlphaTabsIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MainActivity
 * @Description 搭建基本的显示框架, 即TabHost + Fragment, 此类不允许改动!!(如非改动不可请联系马增来)
 * @Author seven
 * @date 2020/4/16 15:09
 * @Version 0.1
 */
public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private AlphaTabsIndicator alphaTabsIndicator;

    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.vp);
        fragments.add(new FlowerFindingFragment());
        fragments.add(new FlowerAmongFragment());
        fragments.add(new FlowerPostFragment());
        fragments.add(new FlowerMineFragment());
<<<<<<< HEAD
        viewPager.setOffscreenPageLimit(4);
=======

>>>>>>> 1b06b62febbd90f6163a9a9258846823e5687af9
        viewPager.setAdapter(new CustomPageAdapter(getSupportFragmentManager(), fragments));

        alphaTabsIndicator = findViewById(R.id.alphaIndicator);
        alphaTabsIndicator.setViewPager(viewPager);


        Intent intent = getIntent();
        Boolean back = intent.getBooleanExtra("back", false);
        if (back) {
            fragments.remove(2);
            Fragment post = new FlowerPostFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("back",2);
            post.setArguments(bundle);
            fragments.add(2, post);
            viewPager.setCurrentItem(2);
        }

    }
}
