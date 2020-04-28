package com.happier.flowering.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import com.happier.flowering.constant.Constant;

import org.devio.takephoto.app.TakePhoto;
import org.devio.takephoto.app.TakePhotoActivity;
import org.devio.takephoto.model.TImage;
import org.devio.takephoto.model.TResult;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

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
    private static final String POST_PUBLISH_PATH = "/post/publish";

    private final String[] topics = {"#爱花展示#", "#阳台养花#", "#今日花事#", "#生活要有花#", "#花花世界#", "#花友交流#", "#爱花互换#", "#养花日记#", "#识花鉴花#", "#开心一天#", "#云赏花#", "#百花迎春#", "#今日萌宠#", "#早安日签#", "#艺术插花#", "#夏花绚烂#", "#盛夏花语#", "#秋日美好时光#", "#冬之物语#", "#多肉植物#"};
    private int topicId = 0;

    private OkHttpClient client = new OkHttpClient();

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
                    String postText = etPostText.getText().toString();
                    if (TextUtils.isEmpty(postText) || dataSource.size() == 0 || dataSource == null || topicId == 0) {
                        Toast.makeText(PostPublishActivity.this, "请完善花现内容", Toast.LENGTH_SHORT).show();
                    } else {
                        publish(postText, dataSource.toString(), topicId);
                        finish();
                        overridePendingTransition(R.anim.left_in, R.anim.right_out);
                    }
                    break;
                case R.id.m_btn_add_topic:
                    addTopic();
                    break;
            }
        }
    }

    // todo: 该方法有问题!
    private void publish(String postText, String picPath, int selectedTopic) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        builder.addFormDataPart("postText", postText);
        builder.addFormDataPart("topicId", String.valueOf(selectedTopic));
        builder.addFormDataPart("userId", String.valueOf(1)); // todo: 得到真实user_id
        String[] paths = picPath.split(",");
        for (String path : paths) {
            File file = new File(path);
            if (file != null) {
                builder.addFormDataPart("pic", file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
            }
        }
        MultipartBody body = builder.build();
        Request request = new Request.Builder().url(Constant.BASE_IP + POST_PUBLISH_PATH).post(body).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("result", response.body().string());
            }
        });
    }

    private void addTopic() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择一个话题");
        builder.setItems(topics, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                btnAddTopicToPost.setText(topics[which]);
                topicId = which + 1;
            }
        });
        builder.show();
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
