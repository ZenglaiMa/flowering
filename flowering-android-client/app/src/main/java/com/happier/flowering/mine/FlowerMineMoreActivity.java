package com.happier.flowering.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.happier.flowering.R;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.entity.User;
import com.happier.flowering.fragment.FlowerMineMoreHXFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FlowerMineMoreActivity extends AppCompatActivity {

    private ImageView ivHeadImg;
    private TextView tvUserName;
    private TextView tvGender;
    private TextView tvAddress;
    private ImageView ivEditInfo;
    private TextView tvPersonalProfile;

    private int userId;

    private OkHttpClient client = new OkHttpClient();

    private static final String USER_SIMPLE_INFO = "/center/UserSimpleInfo";
    private static final String FLAG = "UserSimpleInfo";

    private String result = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flower_mine_minemore);

        EventBus.getDefault().register(this);

        userId = getIntent().getIntExtra("userId", 0);

        findViews();
        getUserSimpleInfo();

        showFragment();

//        editMess = findViewById(R.id.q_edit_mess);
//        editMess.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(FlowerMineMoreActivity.this, EditMess.class);
//                startActivity(intent);
//            }
//        });

    }

    private void getUserSimpleInfo() {
        Request request = new Request.Builder().url(Constant.BASE_IP + USER_SIMPLE_INFO + "?userId=" + userId).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                result = response.body().string();
                EventBus.getDefault().post("UserSimpleInfo");
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updateTopLayout(String flag) {
        if (flag.equals(FLAG)) {
            User user = new Gson().fromJson(result, User.class);
            Glide.with(this).load(Constant.BASE_IP + user.getHeadImg()).apply(new RequestOptions().circleCrop()).into(ivHeadImg);
            tvUserName.setText(user.getNickname());
            tvGender.setText(user.getSex() == 1 ? "男" : "女");
            tvAddress.setText(user.getAddress());
            tvPersonalProfile.setText(user.getProfile());
        }
    }

    private void showFragment() {
        Fragment fragment = new FlowerMineMoreHXFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!fragment.isAdded()) {
            transaction.add(R.id.q_tab_content, fragment);
        }
        transaction.show(fragment);
        transaction.commit();
    }

    private void findViews() {
        ivHeadImg = findViewById(R.id.q_img_headImg);
        tvUserName = findViewById(R.id.q_text_name);
        tvGender = findViewById(R.id.q_text_gender);
        tvAddress = findViewById(R.id.q_text_address);
        ivEditInfo = findViewById(R.id.q_edit_mess);
        tvPersonalProfile = findViewById(R.id.q_text_profile);
        int currentUserId = getSharedPreferences("data", MODE_PRIVATE).getInt("userId", 0);
        if (userId != currentUserId) {
            ivEditInfo.setVisibility(View.GONE);
        }
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
