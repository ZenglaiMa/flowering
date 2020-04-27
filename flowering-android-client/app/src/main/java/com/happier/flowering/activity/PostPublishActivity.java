package com.happier.flowering.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.happier.flowering.R;
import com.happier.flowering.adapter.PictureShowGridViewAdapter;

import org.devio.takephoto.app.TakePhoto;
import org.devio.takephoto.app.TakePhotoActivity;
import org.devio.takephoto.model.TImage;
import org.devio.takephoto.model.TResult;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PostPublishActivity
 * @Description 发布花现的Activity
 * @Author seven
 * @date 2020/4/27 14:59
 * @Version 0.1
 */
public class PostPublishActivity extends TakePhotoActivity {

    private ImageView ivBackToUp;
    private TextView tvPublishPost;
    private EditText etPostText;
    private Button btnAddTopicToPost;

    private GridView gridView;
    private List<String> dataSource = new ArrayList<>();
    private PictureShowGridViewAdapter adapter;

    private static final int MAX_SELECT_PIC_NUM = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_publish);

        findViews();
        setOnClickListener();

        initGridView();
    }

    private void initGridView() {
        adapter = new PictureShowGridViewAdapter(this, dataSource, R.layout.picture_show_grid_item);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == parent.getChildCount() - 1) {
                    TakePhoto takePhoto = getTakePhoto();
                    if (dataSource.size() == 0) {
                        takePhoto.onPickMultiple(MAX_SELECT_PIC_NUM);
                    } else {
                        takePhoto.onPickMultiple(MAX_SELECT_PIC_NUM - dataSource.size());
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    private class CustomListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.m_back_to_up:
                    finish();
                    overridePendingTransition(R.anim.left_in, R.anim.right_out);
                    break;
                case R.id.m_publish_post:
                    // todo: 执行发布花现逻辑
                    Toast.makeText(PostPublishActivity.this, "发布成功", Toast.LENGTH_SHORT).show();
                    finish();
                    overridePendingTransition(R.anim.left_in, R.anim.right_out);
                    break;
                case R.id.m_btn_add_topic:
                    // todo: 给帖子添加话题, 用Dialog
                    Toast.makeText(PostPublishActivity.this, "给帖子添加话题", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    @Override
    public void takeSuccess(TResult result) {
        super.takeSuccess(result);
        for (TImage tImage : result.getImages()) {
            dataSource.add(tImage.getOriginalPath());
        }
    }

    @Override
    public void takeFail(TResult result, String msg) {
        super.takeFail(result, msg);
        Toast.makeText(this, "error: " + msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void takeCancel() {
        super.takeCancel();
    }

    private void setOnClickListener() {
        CustomListener listener = new CustomListener();
        ivBackToUp.setOnClickListener(listener);
        tvPublishPost.setOnClickListener(listener);
        btnAddTopicToPost.setOnClickListener(listener);
    }

    private void findViews() {
        ivBackToUp = findViewById(R.id.m_back_to_up);
        tvPublishPost = findViewById(R.id.m_publish_post);
        etPostText = findViewById(R.id.m_et_post_text);
        gridView = findViewById(R.id.m_grid_view_show_picture);
        btnAddTopicToPost = findViewById(R.id.m_btn_add_topic);
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
