package com.happier.flowering.mine;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.happier.flowering.R;
import com.happier.flowering.constant.Constant;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class EditMess extends AppCompatActivity {

//    private TextView changeHead;
//    private ImageView headImg;
//    private ImageView editName;
//    private ImageView editProfile;
//
//    private static final int REQUEST_CODE_SELECT_GRAPH = 200;
//    private static final String UPLOAD_PATH = "/center/uploadHeaderImage";
//    private static final String SUCCESS = "1";
//
//    private OkHttpClient client = new OkHttpClient();
//
//    private String myId = String.valueOf(getSharedPreferences("data", MODE_PRIVATE).getInt("userId", 0));

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mess);

//        EventBus.getDefault().register(this);
//
//        headImg = findViewById(R.id.header);
//        editName = findViewById(R.id.q_name_change);
//        editProfile = findViewById(R.id.q_profile_change);
//        changeHead = findViewById(R.id.q_head_change);
//
//        changeHead.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(intent, REQUEST_CODE_SELECT_GRAPH);
//            }
//        });
//
//        editName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(EditMess.this, EditDetail.class);
//                intent.putExtra("title", "name");//参数：name、value
//                startActivity(intent);
//            }
//        });
//
//        editProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(EditMess.this, EditDetail.class);
//                intent.putExtra("title", "profile");//参数：name、value
//                startActivity(intent);
//            }
//        });

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        // 用户没有进行有效的设置操作，返回
//        if (resultCode == RESULT_CANCELED) {
//            return;
//        }
//        if (requestCode == REQUEST_CODE_SELECT_GRAPH && resultCode == RESULT_OK) {
//            Uri uri = data.getData();
//            Cursor cursor = getApplicationContext().getContentResolver().query(uri, null, null, null, null);
//            if (cursor != null) {
//                if (cursor.moveToFirst()) {
//                    String imagePath = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
//                    RequestOptions options = new RequestOptions().circleCrop();
//                    Glide.with(this).load(Uri.fromFile(new File(imagePath))).apply(options).into(headImg);
//                    uploadToServer(imagePath);
//                }
//            }
//        }
//    }
//
//    private void uploadToServer(String imagePath) {
//        MultipartBody.Builder builder = new MultipartBody.Builder();
//        builder.setType(MultipartBody.FORM);
//
//        builder.addFormDataPart("userId", myId);
//        File file = new File(imagePath);
//        if (file != null) {
//            builder.addFormDataPart("pName", file.getName(), RequestBody.create(MediaType.parse("image/*"), file));
//        }
//
//        MultipartBody body = builder.build();
//        Request request = new Request.Builder().url(Constant.BASE_IP + UPLOAD_PATH).post(body).build();
//        Call call = client.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) {
//                try {
//                    String result = response.body().string();
//                    EventBus.getDefault().post(result);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void handleResult(String result) {
//        if (result.equals(SUCCESS)) {
//            Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "修改失败", Toast.LENGTH_SHORT).show();
//        }
//    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        EventBus.getDefault().unregister(this);
//    }

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
