package com.happier.flowering.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.happier.flowering.R;
import com.happier.flowering.fragment.FlowerAmongSearchResultFragment;
import com.happier.flowering.fragment.FlowerPostSearchResultFragment;
import com.happier.flowering.fragment.UserSearchResultFragment;
import com.yinglan.alphatabs.AlphaTabsIndicator;
import com.yinglan.alphatabs.OnTabChangedListner;

public class SearchResultActivity extends AppCompatActivity {

    private AlphaTabsIndicator indicator;
    private Fragment curFragment = null;

    private static final int TAB_RESULT_FLOWERING_ARTICLE = 0;
    private static final int TAB_RESULT_FLOWERING_POST = 1;
    private static final int TAB_RESULT_USER = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        showFragment(new FlowerAmongSearchResultFragment());
        indicator = findViewById(R.id.alphaIndicator_search_result);
        indicator.setOnTabChangedListner(new OnTabChangedListner() {
            @Override
            public void onTabSelected(int tabNum) {
                Fragment fragment = null;
                if (tabNum == TAB_RESULT_FLOWERING_ARTICLE) {
                    fragment = new FlowerAmongSearchResultFragment();
                } else if (tabNum == TAB_RESULT_FLOWERING_POST) {
                    fragment = new FlowerPostSearchResultFragment();
                } else if (tabNum == TAB_RESULT_USER) {
                    fragment = new UserSearchResultFragment();
                }
                showFragment(fragment);
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
            transaction.add(R.id.tab_content_search_result, fragment);
        }
        transaction.show(fragment);
        curFragment = fragment;
        transaction.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            overridePendingTransition(R.anim.left_in, R.anim.right_out);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
