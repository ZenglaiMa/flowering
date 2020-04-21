package com.happier.flowering.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.happier.flowering.R;
import com.happier.flowering.model.NineGridModel;
import com.happier.flowering.view.NineGridLayoutExd;
import com.wx.goodview.GoodView;

import java.util.List;

/**
 * @ClassName LatestPostAdapter
 * @Description 花现中最新板块中ListView对应的Adapter
 * @Author seven
 * @date 2020/4/21 10:01
 * @Version 0.1
 */
public class LatestPostAdapter extends BaseAdapter {

    private Context context;
    private List<NineGridModel> dataSource;
    private int itemId;

    public LatestPostAdapter(Context context, List<NineGridModel> dataSource, int itemId) {
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
    public View getView(int position, View convertView, final ViewGroup parent) {
        final ViewHolder viewHolder;
        if (null == convertView) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(itemId, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.ivUserHeaderImage = convertView.findViewById(R.id.m_post_user_header_img);
            viewHolder.tvUserName = convertView.findViewById(R.id.m_post_user_name);
            viewHolder.tvPostText = convertView.findViewById(R.id.m_post_text);
            viewHolder.nineGridImages = convertView.findViewById(R.id.layout_nine_grid);
            viewHolder.tvPublishTime = convertView.findViewById(R.id.m_post_publish_time);
            viewHolder.ivPostGood = convertView.findViewById(R.id.m_good);
            viewHolder.ivPostComment = convertView.findViewById(R.id.m_post_comment);
            viewHolder.ivPostShare = convertView.findViewById(R.id.m_post_share);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.nineGridImages.setIsShowAll(dataSource.get(position).isShowAll);
        viewHolder.nineGridImages.setUrlList(dataSource.get(position).urlList);

        // 点击头像进入个人中心
        viewHolder.ivUserHeaderImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // todo: 点击头像进入用户个人主页
                Toast.makeText(context, "todo: 用户个人主页", Toast.LENGTH_SHORT).show();
            }
        });

        // 点赞
        viewHolder.ivPostGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // todo: 执行点赞逻辑, 成功之后执行后边代码
                GoodView goodView = new GoodView(context);
                viewHolder.ivPostGood.setImageResource(R.drawable.good_selected);
                goodView.setText("+1");
                goodView.show(viewHolder.ivPostGood);
            }
        });

        // 评论
        viewHolder.ivPostComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // todo: 执行评论逻辑
                Toast.makeText(context, "todo: 评论", Toast.LENGTH_SHORT).show();
            }
        });

        // 分享
        viewHolder.ivPostShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow(parent);
            }
        });

        return convertView;
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
    }
}
