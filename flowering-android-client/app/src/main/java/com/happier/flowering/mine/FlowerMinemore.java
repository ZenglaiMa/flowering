package com.happier.flowering.mine;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.R;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.fragment.FlowerMinemoreHXFragment;
import com.happier.flowering.fragment.FlowerMinemoreMessageFragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class FlowerMinemore extends AppCompatActivity {
    private Map<String, Object> infomap;
    private Handler handler;

    private class MyTabSpec {

        private TextView textView = null;
        private Fragment fragment = null;

<<<<<<< HEAD
=======

>>>>>>> e85b7e472cd903a3b203ef90189db204bf703eb2
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
                case R.id.q_tab_huaxian:
                    changeTab( tabStrId[0] );
                    break;
                case R.id.q_tab_message:
                    changeTab( tabStrId[1] );
                    break;
            }

        }
    }

    private Map<String, MyTabSpec> map = new HashMap<>();
    private String[] tabStrId = {"花现", "我的私信"};
    // 用于记录当前正在显示的Fragment
    private Fragment curFragment = null;
    private Button editMess=null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
<<<<<<< HEAD
        super.onCreate( savedInstanceState );
        setContentView( R.layout.flower_mine_minemore );
        //查询个人信息
        getInfo();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                String messages = (String) msg.obj;
                Log.e( "获取——————————userInfo", messages );
                Type type = new TypeToken<Map<String, Object>>() {
                }.getType();
                infomap = new Gson().fromJson( messages, type );
            }

        };

=======
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flower_mine_minemore);
//        editMess=findViewById(R.id.q_edit_mess);
//        editMess.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(FlowerMinemore.this, EditMess.class);
//            }
//        });
>>>>>>> e85b7e472cd903a3b203ef90189db204bf703eb2
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
        map.get( tabStrId[0] ).setFragment( new FlowerMinemoreHXFragment() );
        map.get( tabStrId[1] ).setFragment( new FlowerMinemoreMessageFragment() );
//        map.get(tabStrId[2]).setFragment(new FlowerMinemoreMessageFragment());
    }

    private void findView() {
        TextView tv1 = findViewById( R.id.q_tab_huaxian );
        TextView tv2 = findViewById( R.id.q_tab_message );

//        map.get(tabStrId[0]).setImageView(iv1);
        map.get( tabStrId[0] ).setTextView( tv1 );

//        map.get(tabStrId[1]).setImageView(iv2);
        map.get( tabStrId[1] ).setTextView( tv2 );

    }

    private void setListener() {
        TextView textView1 = findViewById( R.id.q_tab_huaxian );
        TextView textView2 = findViewById( R.id.q_tab_message );
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
<<<<<<< HEAD
        changeTextV( s );
=======
        changeTextV(s);
>>>>>>> e85b7e472cd903a3b203ef90189db204bf703eb2
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
            transaction.add( R.id.q_tab_content, fragment );
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

    public void getInfo() {
        new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL( Constant.BASE_IP + "/center/userInfo" + "?id=" + 1 );
                    URLConnection conn = url.openConnection();
                    InputStream in = conn.getInputStream();
                    BufferedReader reader = new BufferedReader( new InputStreamReader( in, "utf-8" ) );
                    String info = reader.readLine();
                    Log.e( "******************", info );
                    Message message = new Message();
                    message.obj = info;
                    handler.sendMessage( message );
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }


        }.start();
    }
}
