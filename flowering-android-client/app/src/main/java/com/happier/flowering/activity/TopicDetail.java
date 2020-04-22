package com.happier.flowering.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.happier.flowering.MainActivity;
import com.happier.flowering.R;

import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;

import com.happier.flowering.fragment.FlowerPostFragment;
import com.happier.flowering.fragment.LatestPostFragment;
import com.happier.flowering.fragment.TopicPostFragment;
import com.yinglan.alphatabs.AlphaTabsIndicator;
import com.yinglan.alphatabs.OnTabChangedListner;

public class TopicDetail extends AppCompatActivity {
    private AlphaTabsIndicator topicIndicator;
    private ImageView back;
    private static final int TAB_normal = 0;
    private static final int TAB_hotter = 1;

    private Fragment curFragment = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_detail);
        showFragment(new LatestPostFragment());
        topicIndicator = findViewById(R.id.alphaIndicator_post);
        topicIndicator.setOnTabChangedListner(new OnTabChangedListner() {
            @Override
            public void onTabSelected(int tabNum) {
                Fragment fragment = null;
                if (tabNum == TAB_normal) {
                    //            add.setImageResource(R.drawable.add_48px);
                    fragment = new LatestPostFragment();
                } else if (tabNum == TAB_hotter) {
                    //            add.setImageResource(R.drawable.add_48px);
                    fragment = new LatestPostFragment();
                }
                showFragment(fragment);
            }
        });

        back=findViewById(R.id.l_iv_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TopicDetail.this, MainActivity.class);
                intent.putExtra("back",true);
                startActivity(intent);
            }
        });
    }

    private void showFragment(Fragment fragment) {
        if (curFragment == fragment) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (curFragment != null) {
            transaction.hide(curFragment);
        }
        if (!fragment.isAdded()) {
            transaction.add(R.id.l_post_content, fragment);
        }
        transaction.show(fragment);
        curFragment = fragment;
        transaction.commit();
    }

}
