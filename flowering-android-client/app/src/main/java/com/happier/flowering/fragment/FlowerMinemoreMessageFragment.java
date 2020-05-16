package com.happier.flowering.fragment;

import android.animation.Animator;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.R;
import com.happier.flowering.adapter.MinemoreMessageAdapter;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.entity.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

/**
 //        * @ClassName FlowerMinemoreFragment
 //        * @Description 我的详情私信Fragment
 //        * @Author q
 //        * @date 2020/4/16 15:09
 //        * @Version 0.1
 //        */
public class FlowerMinemoreMessageFragment extends Fragment implements AdapterView.OnItemClickListener {
    private List<Map<String, Object>> dataSource =new ArrayList<>();
    private MinemoreMessageAdapter messageAdapter;
    private ListView listView;
    private Handler handler;
    private Handler sHandler;
    private Gson gson=new Gson();
    private PopupWindow popupWindow=null;
    private View popupView=null;
    private String myId=String.valueOf(getActivity().getSharedPreferences("data", MODE_PRIVATE).getInt("userId", 0));
    //定义一个bool值：
//    private boolean isGetData = false;

    private static final  String PATH_MINEMORE_REPLYMESSAGE="/center/sendMessage";
    private static final  String PATH_MINEMORE_MESSAGE="/center/getAllMineMessage";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.minemore_fragment_message, container, false);
        listView=view.findViewById(R.id.q_messlist);
        initMessageData();
        Log.e("cc","查询");
        handler = new Handler() {
            @Override
            public void handleMessage(android.os.Message msg) {
                String messages = (String) msg.obj;
                dataSource = gson.fromJson(messages, new TypeToken<List<Map<String, Object>>>(){}.getType());
                Log.e("私信查询",dataSource.toString());
                messageAdapter = new MinemoreMessageAdapter(getContext(),dataSource, R.layout.minemore_fragment_mlist);
                listView.setAdapter(messageAdapter);
                listView.setOnItemClickListener(FlowerMinemoreMessageFragment.this);
            }

        };


        return view;
    }



    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {   // 不在最前端显示 相当于调用了onPause();
            return;
        }else{  // 在最前端显示 相当于调用了onResume();
            //网络数据刷新
            initMessageData();
        }
    }

    public void initMessageData(){
        new Thread(){
            @Override
            public void run() {
                //查询私信数据
                try {
                    URL url= new URL(Constant.BASE_IP + PATH_MINEMORE_MESSAGE+"?userId="+myId);
                    URLConnection conn = url.openConnection();
                    InputStream in = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
                    String info = reader.readLine();
                    android.os.Message message = new android.os.Message();
                    message.obj = info;
                    handler.sendMessage(message);
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


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        showPopupWindow(position,view);

    }
    // 显示PopupWindow
    private void showPopupWindow(int position,View view) {
        // 创建popupWindow对象
        if(popupWindow!=null&&popupWindow.isShowing()){
            return;
        }
        popupWindow = new PopupWindow();
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 通过布局填充器创建View
        LayoutInflater inf = LayoutInflater.from(this.getContext());
        popupView = inf
                .inflate(R.layout.minemore_message_popwindow, null);
        //通过popView对其中内容进行填充
        Map<String, Object> map = dataSource.get(position);
        TextView messMore=popupView.findViewById(R.id.q_message_content);
        messMore.setText(dataSource.get(position).get("content").toString());
        EditText replyMess=popupView.findViewById(R.id.q_text_reply);



        // 设置PopupWindow显示的内容视图
        popupWindow.setContentView(popupView);
        // 设置PopupWindow是否能响应外部点击事件
        popupWindow.setOutsideTouchable(true);
        // 设置PopupWindow是否相应点击事件
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);

        // 获取按钮并添加监听器

        Button btnReply = popupView.findViewById(R.id.q_btn_reply);
        btnReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //插入数据库回复私信
                String reply=replyMess.getText().toString();
                Log.e("123",reply);
//                int senderId=(int) Double.parseDouble(dataSource.get(position).get("senderId").toString());
                int recvId=(int) Double.parseDouble(dataSource.get(position).get("senderId").toString());
//                Integer.parseInt(dataSource.get(position).get("recvId").toString());
                replyMessage(2,recvId,reply);
                sHandler = new Handler() {
                    @Override
                    public void handleMessage(android.os.Message msg) {
                        //判断是否回复
                        String ms= (String) msg.obj;
                        Log.e("回复私信",ms);
                        if(ms.equals("ok")) {
                            Toast ts = Toast.makeText(getContext(), "已回复", Toast.LENGTH_LONG);
                            ts.show();
                        }
                        else
                        {
                            Toast ts = Toast.makeText(getContext(), "回复失败", Toast.LENGTH_LONG);
                            ts.show();
                        }
                    }

                };

                popupWindow.dismiss();
            }
        });

        // 在指定控件下方显示PopupWindow

        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);
    }

    /**
     * 回复私信线程
     * @param mContent
     * @param senderId
     * @param recvId
     */
    public void replyMessage(int senderId,int recvId,String mContent){
        Log.e("回复私信","reply");
        new Thread(){
            @Override
            public void run() {
                //查询私信数据
                try {
                    Log.e("回复私信","reply");
                    URL url= new URL(Constant.BASE_IP + PATH_MINEMORE_REPLYMESSAGE+"?userId="+
                            senderId+"&recvId="+recvId+"&mContent="+mContent);
                    URLConnection conn = url.openConnection();
                    InputStream in = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
                    String info = reader.readLine();
                    android.os.Message message = new android.os.Message();
                    message.obj = info;
                    sHandler.sendMessage(message);
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
