package com.happier.flowering.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.happier.flowering.R;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.model.NineGridModel;
import com.happier.flowering.view.NineGridLayoutExd;
import com.wx.goodview.GoodView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//        帖子id
//        Integer postId = Integer.valueOf(data.get("post_id").toString());

        Glide.with(context).load(Constant.BASE_IP + data.get("head_img").toString()).into(viewHolder.ivUserHeaderImage);
        viewHolder.tvUserName.setText(data.get("nickname").toString());
        viewHolder.tvTopicName.setText(data.get("topic_name").toString());
        viewHolder.tvPostText.setText(data.get("post_text").toString());
        viewHolder.tvPublishTime.setText(data.get("create_time").toString());
        viewHolder.nineGridImages.setIsShowAll(((NineGridModel) data.get("nine_grid")).isShowAll);
        viewHolder.nineGridImages.setUrlList(((NineGridModel) data.get("nine_grid")).urlList);

        setListener(viewHolder, position, parent);

        // 初始化评论列表
        List<Map<String, String>> dataSource = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("name", "评论者" + (i + 1) + "号");
            map.put("content", "第" + (i + 1) + "条评论内容");
            dataSource.add(map);
        }
        PostCommentListAdapter adapter = new PostCommentListAdapter(context, dataSource, R.layout.post_comments_list_item);
        viewHolder.lvComments.setAdapter(adapter);

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
                    // todo: 先执行点赞逻辑, 成功之后执行后边代码
                    GoodView goodView = new GoodView(context);
                    viewHolder.ivPostGood.setImageResource(R.drawable.good_selected);
                    goodView.setText("+1");
                    goodView.show(viewHolder.ivPostGood);
                    break;
                case R.id.m_post_comment:
                    // todo: 执行评论逻辑
                    Toast.makeText(context, "todo: 评论", Toast.LENGTH_SHORT).show();
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
    }
}
