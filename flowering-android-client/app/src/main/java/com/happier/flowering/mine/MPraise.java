package com.happier.flowering.mine;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.happier.flowering.R;

import java.util.HashMap;
import java.util.Map;

public class MPraise extends AppCompatActivity {

    private class MyTabSpec {

        private TextView textView = null;
        private Fragment fragment = null;

        // 设置是否被选中
        public void setSelect(boolean b) {
            if (b) {
//                imageView.setImageResource(selectImage);
                textView.setBackgroundResource( R.drawable.q_textview_border );
            } else {
//                imageView.setImageResource(normalImage);
                textView.setBackgroundColor( Color.parseColor( "#ffffff" ) );
//                textView.se
            }
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }


        public Fragment getFragment() {
            return fragment;
        }

        public void setFragment(Fragment fragment) {
            this.fragment = fragment;
        }

    }

    private class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.c_btn_bePraised:
                    changeTab( tabStrId[0] );
                    break;
                case R.id.c_btn_PraiseOthers:
                    changeTab( tabStrId[1] );
                    break;
            }

        }
    }

    private Map<String, MyTabSpec> map = new HashMap<>();
    private String[] tabStrId = {"获赞", "喜欢"};
    // 用于记录当前正在显示的Fragment
    private Fragment curFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_mpraise );
        // 1. 初始化MyTabSpec对象
        // Fragment、ImageView、TextView、normalImage、selectImage
        initData();

        // 2. 设置监听器，在监听器中完成切换
        setListener();

        // 3. 设置默认显示的TabSpec
        changeTab( tabStrId[0] );

    }


    private void initData() {
        // 1 创建MyTabSpec对象
        map.put( tabStrId[0], new MyTabSpec() );
        map.put( tabStrId[1], new MyTabSpec() );

        // 2 设置Fragment
        setFragment();

        // 3 设置ImageView和TextView
        findView();

        // 4 设置图片资源
//       setTag()


    }

    private void setFragment() {
        map.get( tabStrId[0] ).setFragment( new BePraised());
        map.get( tabStrId[1] ).setFragment( new PraiseOthers());

    }

    private void findView() {
        TextView tv1 = findViewById( R.id.c_btn_bePraised);
        TextView tv2 = findViewById( R.id.c_btn_PraiseOthers );
        map.get( tabStrId[0] ).setTextView( tv1 );
        map.get( tabStrId[1] ).setTextView( tv2 );

    }

    private void setListener() {
        TextView textView1 = findViewById( R.id.c_btn_bePraised );
        TextView textView2 = findViewById( R.id.c_btn_PraiseOthers);
//        TextView textView3 = findViewById(R.id.q_tab_comment);

        MyListener listener = new MyListener();
        textView1.setOnClickListener( listener );
        textView2.setOnClickListener( listener );
//        textView3.setOnClickListener(listener);
    }

    private void changeTab(String s) {
        // 1 切换Fragment
        changeFragment( s );
        // 2 切换图标及字体颜色
        changeTextV( s );
    }

    private void changeFragment(String s) {
        Fragment fragment = map.get( s ).getFragment();
        if (curFragment == fragment)
            return;
        // Fragment 事务 - Fragment事务管理器来获取
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // 将之前显示的Fragment隐藏掉
        if (curFragment != null)
            transaction.hide( curFragment );
        // 如果当前Fragment没有被添加过 则添加到Activity的帧布局中
        if (!fragment.isAdded()) {
            transaction.add( R.id.c_praise_container, fragment );
        }
        // 显示对应Fragment
        transaction.show( fragment );
        curFragment = fragment;
        transaction.commit();
    }

    // 根据Tab ID 切换Tab显示的图片及字体颜色
    private void changeTextV(String s) {
        // 1 所有Tab的图片和字体恢复默认
        for (String key : map.keySet()) {
            map.get( key ).setSelect( false );
        }
        // 2 设置选中的Tab的图片和字体颜色
        map.get( s ).setSelect( true );
    }
}