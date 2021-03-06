package com.happier.flowering.mine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.happier.flowering.R;

public class MPraise extends AppCompatActivity {

    // 用于记录当前正在显示的Fragment
    private Fragment curFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpraise);

        showFragment(new BePraised());

    }

    // 根据不同的选项卡显示不同的Fragment
    public void showFragment(Fragment fragment) {
        if (curFragment == fragment) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (curFragment != null) {
            transaction.hide(curFragment);
        }
        if (!fragment.isAdded()) {
            transaction.add(R.id.thumbs_up_tab_content, fragment);
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