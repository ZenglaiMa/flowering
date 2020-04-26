package com.happier.flowering.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.R;
import com.happier.flowering.adapter.FloweringAmongLeftAdapter;
import com.happier.flowering.adapter.FloweringAmongRightAdapter;
import com.happier.flowering.constant.Constant;
import com.happier.flowering.entity.Article;
import com.happier.flowering.entity.Collect;
import com.happier.flowering.entity.Type;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @ClassName ArticleDetail
 * @Description 文章详情页
 * @Author 赵语涵
 */
public class ArticleDetail extends AppCompatActivity {
    private TextView tv = null;
    private LinearLayout llStar = null;
    private LinearLayout llShare = null;
    private PopupWindow popupWindow;
    private MyListener myListener = new MyListener();
    private ImageView ivStar = null;
    private OkHttpClient client = new OkHttpClient();
    private Gson gson = new Gson();
    private Article article;
    private Boolean flag = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_detail);

        Intent intent = getIntent();
        article = new Gson().fromJson(intent.getStringExtra("article"), Article.class);
        init();
        tv.setText(Html.fromHtml(article.getContent(), new MImageGetter(), null));
    }

    public void init() {
        tv = findViewById(R.id.z_tv_content);
        llShare = findViewById(R.id.z_ll_share);
        llStar = findViewById(R.id.z_ll_star);
        ivStar = findViewById(R.id.z_iv_star);
        llStar.setOnClickListener(myListener);
        llShare.setOnClickListener(myListener);
        isStar();
    }

    private class MImageGetter implements Html.ImageGetter {
        @Override
        public Drawable getDrawable(String source) {
            //异步 获取 网络图片并返回：  这里使用  Glide 获取 图片  当然你也可以使用   其他：
            //1,设置 图片占位符：
            final LevelListDrawable draw = new LevelListDrawable();
            Drawable empty = getResources().getDrawable(R.mipmap.ic_launcher);
            draw.addLevel(0, 0, empty);
            draw.setBounds(0, 0, 100, 100);

            final String url = source;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Bitmap bitmap = null;
                    Drawable drawable = null;
                    //请求  图片
                    try {
                        //2,获取 网络图片   该方法  为同步方法   需在子线程中执行
                        drawable =
                                Glide.with(ArticleDetail.this)
                                        .load(url)
                                        .into(com.bumptech.glide.request.target.Target.SIZE_ORIGINAL, com.bumptech.glide.request.target.Target.SIZE_ORIGINAL)
                                        .get();
                        BitmapDrawable bd = (BitmapDrawable) drawable;
                        bitmap = bd.getBitmap();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.i("info", "异常");
                    }
                    //3,设置  图片
                    runUiThr(bitmap, draw);
                }
            }).start();
            return draw;
        }
    }

    private void runUiThr(final Bitmap bitmap, final LevelListDrawable draw) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (bitmap != null) {
                    BitmapDrawable drawable = new BitmapDrawable(bitmap);
                    draw.addLevel(1, 1, drawable);
                    draw.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    draw.setLevel(1);

                    CharSequence charSequence = tv.getText();
                    tv.setText(charSequence);
                    tv.invalidate();
                }
            }
        });
    }

    private class MyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.z_ll_star:
                    if(!flag) {
                        ivStar.setImageResource(R.drawable.star_filled);
                        setStar();
                        flag = true;
                    }else {
                        ivStar.setImageResource(R.drawable.star);
                        unStar();
                        flag = false;
                    }
                    break;
                case R.id.z_ll_share:
                    // 显示PopupWindow
                    if (popupWindow == null || !popupWindow.isShowing())
                        showPopupWindow();
                    break;
            }
        }
    }

    // 显示PopupWindow
    private void showPopupWindow() {
        popupWindow = new PopupWindow();
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        View view = LayoutInflater.from(this).inflate(R.layout.popup_window_share, null);
        View parent = LayoutInflater.from(this).inflate(R.layout.article_detail, null);
        popupWindow.setContentView(view);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchable(true);
        popupWindow.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
    }

    //查询当前文章是否被收藏
    public void isStar() {
        Collect collect = new Collect();
        collect.setArticleId(article.getArticleId());
        collect.setUserId(1);//TODO 用户id还没有取到

        RequestBody requestBody = RequestBody.create(
                MediaType.parse("text/plain;charset=utf-8"),
                new Gson().toJson(collect));
        Request request = new Request.Builder()
                .post(requestBody)
                .url(Constant.BASE_IP + "/community/isStar")
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                EventBus.getDefault().post(result+"aa");
            }
        });
    }

    //收藏
    public void setStar() {
        Collect collect = new Collect();
        collect.setArticleId(article.getArticleId());
        collect.setUserId(1);//TODO 用户id还没有取到

        RequestBody requestBody = RequestBody.create(
                MediaType.parse("text/plain;charset=utf-8"),
                new Gson().toJson(collect));
        Request request = new Request.Builder()
                .post(requestBody)
                .url(Constant.BASE_IP + "/community/setStar")
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
            }
        });
    }

    //取消收藏
    public void unStar() {
        Collect collect = new Collect();
        collect.setArticleId(article.getArticleId());
        collect.setUserId(1);//TODO 用户id还没有取到

        RequestBody requestBody = RequestBody.create(
                MediaType.parse("text/plain;charset=utf-8"),
                new Gson().toJson(collect));
        Request request = new Request.Builder()
                .post(requestBody)
                .url(Constant.BASE_IP + "/community/unStar")
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
            }
        });
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void init(String result) {
        if (result.equals("0aa")){//没被收藏
            flag = false;
            ivStar.setImageResource(R.drawable.star);
        }else {//被收藏了
            flag = true;
            ivStar.setImageResource(R.drawable.star_filled);
        }
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
