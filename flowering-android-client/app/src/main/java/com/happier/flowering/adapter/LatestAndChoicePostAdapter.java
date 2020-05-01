package com.happier.flowering.adapter;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.happier.flowering.R;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.model.CommentListModel;
import com.happier.flowering.model.NineGridModel;
import com.happier.flowering.view.NineGridLayoutExd;
import com.wx.goodview.GoodView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @ClassName LatestAndChoicePostAdapter
 * @Description 花现中最新和精选板块中ListView对应的Adapter
 * @Author seven
 * @date 2020/4/21 10:01
 * @Version 0.1
 */
public class LatestAndChoicePostAdapter extends BaseAdapter {

    private Context context;
    private List<Map<String, Object>> dataSource;
    private int itemId;

    private static final String DO_GOOD_PATH = "/post/good";
    private static final String DO_COMMENT_PATH = "/comment/send";

    private OkHttpClient client = new OkHttpClient();

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.obj.equals("success")) {
                notifyDataSetChanged();
            }
        }
    };

    // todo: 当前用户user_id, 从SharedPreference中获取, 目前暂定为1
    private Integer currentUserId = 1;

    public LatestAndChoicePostAdapter(Context context, List<Map<String, Object>> dataSource, int itemId) {
        this.context = context;
        this.dataSource = dataSource;
        this.itemId = itemId;
    }

    @Override
    public int getCount() {
        if (dataSource != null) {
            return dataSource.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (dataSource != null) {
            return dataSource.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (null == convertView) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(itemId, parent, false);

            viewHolder = new ViewHolder();
            findViews(viewHolder, convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        setDataAndEvent(viewHolder, position, parent);

        return convertView;
    }

    private void setDataAndEvent(final ViewHolder viewHolder, int position, final ViewGroup parent) {

        Map<String, Object> data = dataSource.get(position);

        Glide.with(context).load(Constant.BASE_IP + data.get("head_img").toString()).into(viewHolder.ivUserHeaderImage);
        viewHolder.tvUserName.setText(data.get("nickname").toString());
        viewHolder.tvTopicName.setText(data.get("topic_name").toString());
        viewHolder.tvPostText.setText(data.get("post_text").toString());
        viewHolder.tvPublishTime.setText(data.get("create_time").toString());
        viewHolder.tvThumbsUpCount.setText(String.valueOf(data.get("thumbs_up_count")));
        viewHolder.nineGridImages.setIsShowAll(((NineGridModel) data.get("nine_grid")).isShowAll);
        viewHolder.nineGridImages.setUrlList(((NineGridModel) data.get("nine_grid")).urlList);

        setListener(viewHolder, position, parent);

        // 初始化评论列表
        List<CommentListModel> models = (List<CommentListModel>) data.get("comment_list");
        if (models != null) {
            List<Map<String, String>> comments = new ArrayList<>();
            for (int i = 0; i < models.size(); i++) {
                Map<String, String> map = new HashMap<>();
                map.put("name", models.get(i).getUserName());
                map.put("content", models.get(i).getContent());
                comments.add(map);
            }
            PostCommentListAdapter adapter = new PostCommentListAdapter(context, comments, R.layout.post_comments_list_item);
            viewHolder.lvComments.setAdapter(adapter);
        }
    }

    private void setListener(ViewHolder viewHolder, int position, ViewGroup parent) {
        EventListener listener = new EventListener(viewHolder, position, parent);
        viewHolder.ivUserHeaderImage.setOnClickListener(listener);
        viewHolder.ivPostGood.setOnClickListener(listener);
        viewHolder.ivPostComment.setOnClickListener(listener);
        viewHolder.ivPostShare.setOnClickListener(listener);
        viewHolder.tvShowComments.setOnClickListener(listener);
    }

    private class EventListener implements View.OnClickListener {
        private ViewHolder viewHolder;
        private int position;
        private ViewGroup parent;

        public EventListener(ViewHolder viewHolder, int position, ViewGroup parent) {
            this.viewHolder = viewHolder;
            this.position = position;
            this.parent = parent;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.m_post_user_header_img:
                    // todo: 点击头像进入用户个人主页
                    Toast.makeText(context, "todo: 用户(id=" + Integer.valueOf(dataSource.get(position).get("user_id").toString()) + ")个人主页", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.m_good:
                    doGood(Integer.valueOf(dataSource.get(position).get("post_id").toString()));
                    GoodView goodView = new GoodView(context);
                    viewHolder.ivPostGood.setImageResource(R.drawable.good_selected_64px);
                    goodView.setText("+1");
                    goodView.show(viewHolder.ivPostGood);
                    viewHolder.tvThumbsUpCount.setText(String.valueOf(Integer.valueOf(viewHolder.tvThumbsUpCount.getText().toString()) + 1));
                    break;
                case R.id.m_post_comment:
                    doComment(position);
                    break;
                case R.id.m_post_share:
                    showPopupWindow(parent);
                    break;
                case R.id.tv_show_comments:
                    if (viewHolder.lvComments.getVisibility() == View.GONE) {
                        viewHolder.lvComments.setVisibility(View.VISIBLE);
                        viewHolder.tvShowComments.setText("收起评论");
                    } else {
                        viewHolder.lvComments.setVisibility(View.GONE);
                        viewHolder.tvShowComments.setText("查看评论");
                    }
                    break;
            }
        }
    }

    private void doComment(int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_comment, null);
        Dialog dialog = new Dialog(context);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().setGravity(Gravity.BOTTOM | Gravity.CENTER);
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = 500;
        dialog.getWindow().setAttributes(params);
        EditText etContent = view.findViewById(R.id.m_et_comment_content);
        view.findViewById(R.id.m_tv_send_comment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = etContent.getText().toString();
                if (TextUtils.isEmpty(content)) {
                    Toast.makeText(context, "请输入评论内容", Toast.LENGTH_SHORT).show();
                } else {
                    Request request = new Request.Builder()
                            .url(Constant.BASE_IP + DO_COMMENT_PATH + "?userId=" + currentUserId + "&postId=" + dataSource.get(position).get("post_id").toString() + "&content=" + content)
                            .build();
                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            CommentListModel model = new CommentListModel();
                            model.setUserName(response.body().string());
                            model.setContent(content);
                            ((List<CommentListModel>) (dataSource.get(position).get("comment_list"))).add(model);
                            Message message = new Message();
                            message.obj = "success";
                            handler.sendMessage(message);
                        }
                    });
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }

    private void doGood(int postId) {
        Request request = new Request.Builder().url(Constant.BASE_IP + DO_GOOD_PATH + "?postId=" + postId + "&userId=" + currentUserId).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
            }
        });
    }

    private void findViews(ViewHolder viewHolder, View convertView) {
        viewHolder.ivUserHeaderImage = convertView.findViewById(R.id.m_post_user_header_img);
        viewHolder.tvUserName = convertView.findViewById(R.id.m_post_user_name);
        viewHolder.tvPostText = convertView.findViewById(R.id.m_post_text);
        viewHolder.nineGridImages = convertView.findViewById(R.id.layout_nine_grid);
        viewHolder.tvPublishTime = convertView.findViewById(R.id.m_post_publish_time);
        viewHolder.ivPostGood = convertView.findViewById(R.id.m_good);
        viewHolder.ivPostComment = convertView.findViewById(R.id.m_post_comment);
        viewHolder.ivPostShare = convertView.findViewById(R.id.m_post_share);
        viewHolder.tvShowComments = convertView.findViewById(R.id.tv_show_comments);
        viewHolder.lvComments = convertView.findViewById(R.id.m_lv_comments);
        viewHolder.tvTopicName = convertView.findViewById(R.id.m_post_topic);
        viewHolder.tvThumbsUpCount = convertView.findViewById(R.id.m_thumbs_up_count);
    }

    private void showPopupWindow(ViewGroup parent) {
        PopupWindow popupWindow = new PopupWindow();
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        View view = LayoutInflater.from(context).inflate(R.layout.popup_window_share, null);
        popupWindow.setContentView(view);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchable(true);
        popupWindow.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
    }

    private class ViewHolder {
        public ImageView ivUserHeaderImage;
        public TextView tvUserName;
        public TextView tvPostText;
        public NineGridLayoutExd nineGridImages;
        public TextView tvPublishTime;
        public ImageView ivPostGood;
        public ImageView ivPostComment;
        public ImageView ivPostShare;
        public TextView tvShowComments;
        public ListView lvComments;
        public TextView tvTopicName;
        public TextView tvThumbsUpCount;
    }

}
