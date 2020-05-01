package com.happier.flowering.adapter;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.happier.flowering.R;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.entity.Message;
import com.happier.flowering.entity.User;
import com.happier.flowering.fragment.FlowerMinemoreMessageFragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class MinemoreMessageAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String, Object>> messages;
    private int item_message_id;
    private PopupWindow popupWindow=null;
    private View popupView=null;
    private static final  String PATH_MINEMORE_REPLYMESSAGE="/center/replyMineMessage";
    private Handler handler;
    //    private List <User> users;
    public MinemoreMessageAdapter(Context context, List<Map<String, Object>> messages, int  item_message_id) {
        this.context = context;
        this.messages = messages;
        this.item_message_id = item_message_id;
    }
    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int position) {
        return messages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        if (null == convertView) {
            convertView = inflater.inflate(item_message_id, null);
        }
        final ImageView headImg = convertView.findViewById(R.id.q_mlist_head);
        final TextView name = convertView.findViewById(R.id.q_mlist_name);
        final TextView content = convertView.findViewById(R.id.q_mlist_content);
        final TextView time = convertView.findViewById(R.id.q_mlist_time);
        Map<String, Object> map = messages.get(position);
        //填充数据
//            headImg.setBackgroundResource(R.drawable.((User)messages.get(position).get("sender")).getHeadImg());
        content.setText(((Message)messages.get(position).get("content")).getContent().toString());
        time.setText(((Message)messages.get(position).get("content")).getTime().toString());
        name.setText(((User)messages.get(position).get("sender")).getNickname().toString());


        return convertView;
    }

    // 显示PopupWindow
    private void showPopupWindow(int position,View view) {
        // 创建popupWindow对象
        popupWindow = new PopupWindow();
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 通过布局填充器创建View
        LayoutInflater inf = LayoutInflater.from(this.context);

        popupView = inf
                .inflate(R.layout.minemore_message_popwindow, null);
        //通过popView对其中内容进行填充
        Map<String, Object> map = messages.get(position);
        TextView messMore=popupView.findViewById(R.id.q_message_content);
        messMore.setText(((Message)messages.get(position).get("content")).getContent().toString());
//        TextView serve=popupView.findViewById(R.id.serve);
//        serve.setText(map.get("bound").toString());
//        TextView phone=popupView.findViewById(R.id.phone);
//        phone.setText(map.get("phone").toString());
//        TextView address=popupView.findViewById(R.id.address);
//        address.setText(map.get("message2").toString());
        EditText replyMess=popupView.findViewById(R.id.q_message_content);



        // 设置PopupWindow显示的内容视图
        popupWindow.setContentView(popupView);
        // 设置PopupWindow是否能响应外部点击事件
        popupWindow.setOutsideTouchable(false);
        // 设置PopupWindow是否相应点击事件
        popupWindow.setTouchable(true);

        // 获取按钮并添加监听器

        Button btnReply = popupView.findViewById(R.id.q_btn_reply);
        btnReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //插入数据库回复私信
                String reply=replyMess.getText().toString();
                Log.e("123",reply);
//                int senderId=

                replyMessage(reply);
                handler = new Handler() {
                    @Override
                    public void handleMessage(android.os.Message msg) {
                        //判断是否回复
                        Toast ts = Toast.makeText(context,"已回复",Toast.LENGTH_LONG);
                        ts.show();
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
     * @param reply
     */
    public void replyMessage(String reply){
        new Thread(){
            @Override
            public void run() {
                //查询私信数据
                try {
                    URL url= new URL(Constant.BASE_IP + PATH_MINEMORE_REPLYMESSAGE+"? senderId"+"? replyId");
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
}
