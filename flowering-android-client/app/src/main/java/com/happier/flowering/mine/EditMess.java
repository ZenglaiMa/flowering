package com.happier.flowering.mine;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.happier.flowering.R;
import com.happier.flowering.constant.Constant;

import org.greenrobot.eventbus.EventBus;

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
    private TextView changeHead;
    private static final int REQUEST_CODE_TAKE_PHOTO = 100;
    private static final int REQUEST_CODE_SELECT_GRAPH = 200;
    private static final String UPLOAD_PATH = "/center/uploadHeaderImage";
    private OkHttpClient client = new OkHttpClient();
    private ImageView ivHeader;
    private ImageView editName;
    private ImageView editProfile;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mess);
        ivHeader=findViewById(R.id.header);
        editName=findViewById(R.id.q_name_change);
        editProfile=findViewById(R.id.q_profile_change);
        changeHead=findViewById(R.id.q_head_change);
        changeHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQUEST_CODE_SELECT_GRAPH);
            }
        });
        editName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(EditMess.this, EditDetail.class);
                intent.putExtra("title", "name");//参数：name、value
                startActivity(intent);
            }
        });
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(EditMess.this, EditDetail.class);
                intent.putExtra("title", "profile");//参数：name、value
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

// 用户没有进行有效的设置操作，返回
        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(getApplication(), "取消", Toast.LENGTH_LONG).show();
            return;
        }
        if (requestCode == REQUEST_CODE_SELECT_GRAPH && resultCode == RESULT_OK){
            Toast.makeText(getApplication(), "更换", Toast.LENGTH_LONG).show();
            Uri uri = data.getData();
            Cursor cursor = getApplicationContext().getContentResolver().query(uri, null, null, null, null);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    String imagePath = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                    Log.e( "uri"+imagePath,"12");
                    RequestOptions options = new RequestOptions().circleCrop();
                    Log.e("33","start");
                    Glide.with(this).load(Uri.fromFile(new File(imagePath))).apply(options).into(ivHeader);
                    Log.e("33","end");
                    uploadToServer(imagePath);
                    Log.e("33","d");
                }
            }

        }
        super.onActivityResult(requestCode, resultCode, data);

    }

    private void uploadToServer(String imagePath) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        builder.addFormDataPart("userId","16");
            File file = new File(imagePath);
            Log.e("22",file.getName().toString());
            if (file != null) {
                Log.e("2",file.getName().toString());
                builder.addFormDataPart("pName", file.getName(), RequestBody.create(MediaType.parse("image/*"), file));
            }

        MultipartBody body = builder.build();
        Request request = new Request.Builder().url(Constant.BASE_IP + UPLOAD_PATH).post(body).build();

//        String.valueOf(getSharedPreferences("data", MODE_PRIVATE).getInt("userId", 0)
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                Log.e("upload", "ff");
            }

            @Override
            public void onResponse(Call call, Response response) {
                EventBus.getDefault().post(response.body().toString());
                String result = response.body().toString();
                Log.e("upload", Integer.parseInt(result) == 1 ? "success" : "fail");
            }
        });
    }
}
