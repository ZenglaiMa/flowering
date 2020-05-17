package com.happier.flowering.mine;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
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

    private ImageView ivEditImg;
    private EditText editName;
    private RadioButton editMale;
    private RadioButton editFemale;
    private EditText editAddress;
    private EditText editProfile;
    private ImageView ivConfirmEdit;

    private static final int REQUEST_CODE_SELECT_GRAPH = 200;
    private static final String UPLOAD_PATH = "/center/uploadHeaderImage";
    private static final String UPDATE_PERSONAL_INFO_PATH = "/center/UpdatePersonalInfo";
    private static final String HEAD_IMG_UPLOAD_SUCCESS = "1";
    private static final int PERSONAL_INFO_EDIT_SUCCESS = 1;

    private OkHttpClient client = new OkHttpClient();

    private Intent intent;

    private int currentUserId;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int result = (int) msg.obj;
            if (result == PERSONAL_INFO_EDIT_SUCCESS) {
                Toast.makeText(EditMess.this, "编辑成功", Toast.LENGTH_SHORT).show();
                finish();
                overridePendingTransition(R.anim.left_in, R.anim.right_out);
            } else {
                Toast.makeText(EditMess.this, "编辑失败, 请稍后重试", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mess);

        EventBus.getDefault().register(this);

        currentUserId = getSharedPreferences("data", MODE_PRIVATE).getInt("userId", 0);

        findViews();

        intent = getIntent();
        initLayout();

        ivEditImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent albumIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(albumIntent, REQUEST_CODE_SELECT_GRAPH);
            }
        });

        ivConfirmEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nickname = editName.getText().toString();
                int gender = 0;
                if (editMale.isChecked()) {
                    gender = 1;
                } else if (editFemale.isChecked()) {
                    gender = 2;
                }
                String address = editAddress.getText().toString();
                String profile = editProfile.getText().toString();
                if (TextUtils.isEmpty(nickname) || gender == 0 || TextUtils.isEmpty(address) || TextUtils.isEmpty(profile)) {
                    Toast.makeText(EditMess.this, "请完善信息", Toast.LENGTH_SHORT).show();
                } else {
                    updatePersonalInfo(nickname, gender, address, profile);
                }
            }
        });

    }

    private void updatePersonalInfo(String nickname, int gender, String address, String profile) {
        Request request = new Request.Builder().url(Constant.BASE_IP + UPDATE_PERSONAL_INFO_PATH + "?nickname=" + nickname + "&gender=" + gender + "&address=" + address + "&profile=" + profile + "&userId=" + currentUserId).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                int result = Integer.valueOf(response.body().string());
                Message message = new Message();
                message.obj = result;
                handler.sendMessage(message);
            }
        });
    }

    private void initLayout() {
        Glide.with(this).load(Constant.BASE_IP + intent.getStringExtra("headImg")).apply(new RequestOptions().circleCrop()).into(ivEditImg);
        editName.setText(intent.getStringExtra("nickname"));
        editAddress.setText(intent.getStringExtra("address"));
        editProfile.setText(intent.getStringExtra("profile"));
        int gender = intent.getIntExtra("gender", 0);
        if (gender == 1) {
            editMale.setChecked(true);
        } else if (gender == 2) {
            editFemale.setChecked(true);
        }
    }

    private void findViews() {
        ivEditImg = findViewById(R.id.m_head_edit_img);
        editName = findViewById(R.id.m_edit_name);
        editMale = findViewById(R.id.m_rb_male);
        editFemale = findViewById(R.id.m_rb_female);
        editAddress = findViewById(R.id.m_edit_address);
        editProfile = findViewById(R.id.m_edit_profile);
        ivConfirmEdit = findViewById(R.id.m_confirm_edit);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_CANCELED) {
            return;
        }
        if (requestCode == REQUEST_CODE_SELECT_GRAPH && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            Cursor cursor = getApplicationContext().getContentResolver().query(uri, null, null, null, null);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    String imagePath = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                    RequestOptions options = new RequestOptions().circleCrop();
                    Glide.with(this).load(Uri.fromFile(new File(imagePath))).apply(options).into(ivEditImg);
                    uploadToServer(imagePath);
                }
            }
        }
    }

    private void uploadToServer(String imagePath) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        builder.addFormDataPart("userId", String.valueOf(currentUserId));
        File file = new File(imagePath);
        if (file != null) {
            builder.addFormDataPart("pName", file.getName(), RequestBody.create(MediaType.parse("image/*"), file));
        }
        MultipartBody body = builder.build();
        Request request = new Request.Builder().url(Constant.BASE_IP + UPLOAD_PATH).post(body).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                try {
                    String result = response.body().string();
                    EventBus.getDefault().post(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handleUploadResult(String result) {
        if (result.equals(HEAD_IMG_UPLOAD_SUCCESS)) {
            Toast.makeText(this, "头像上传成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "头像上传失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
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
