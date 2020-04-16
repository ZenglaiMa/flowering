package com.happier.flowering;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @ClassName CustomPageAdapter
 * @Description 自定义ViewPagerAdapter, 用来填充ViewPager
 * @Author seven
 * @date 2020/4/16 15:09
 * @Version 0.1
 */
public class CustomPageAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public CustomPageAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
