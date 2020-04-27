package com.happier.flowering.mine;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.happier.flowering.R;

public class MPraise extends AppCompatActivity {
    private String[] tags = {"A_tag", "B_tag"};
    private String[] titles = {"获赞", "点赞"};

    //用于跳转至不同的Activity
    private Intent[] intents = new Intent[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_mpraise );
        TabHost tabHost = (TabHost) findViewById( R.id.c_tabhost );
        TabWidget tabWidget = (TabWidget) findViewById( android.R.id.tabs );
//        tabWidget.setDividerDrawable(null);//设置tabWeight没有竖线分割
        tabWidget.setBackgroundColor( Color.WHITE );
        //初始化activity管理者
        LocalActivityManager manager = new LocalActivityManager( MPraise.this, false );
        //通过管理者保存当前页面状态
        manager.dispatchCreate( savedInstanceState );
        //将管理者类对象添加至TabHost
        tabHost.setup( manager );
        init_intent();
        for (int i = 0; i < intents.length; i++) {
            TabHost.TabSpec spec = tabHost.newTabSpec( tags[i] );
            spec.setIndicator( titles[i] );//设置文字
            spec.setContent( intents[i] );//设置内容
            //将创建的选项卡添加至tabHost上
            tabHost.addTab( spec );
        }
    }

    private void init_intent() {
        intents[0] = new Intent( this, BePraised.class );
        intents[1] = new Intent( this, PraiseOthers.class );
    }
}
