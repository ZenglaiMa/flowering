package com.happier.flowering;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.happier.flowering.fragment.FlowerAmongFragment;
import com.happier.flowering.fragment.FlowerFindingFragment;
import com.happier.flowering.fragment.FlowerMineFragment;
import com.happier.flowering.fragment.FlowerPostFragment;
import com.yinglan.alphatabs.AlphaTabsIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MainActivity
 * @Description 搭建基本的显示框架, 即TabHost + Fragment, 仿微信效果
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
        viewPager.setAdapter(new CustomPageAdapter(getSupportFragmentManager(), fragments));

        alphaTabsIndicator = findViewById(R.id.alphaIndicator);
        alphaTabsIndicator.setViewPager(viewPager);

    }
}
