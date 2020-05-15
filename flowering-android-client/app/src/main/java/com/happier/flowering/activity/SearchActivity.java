package com.happier.flowering.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.happier.flowering.R;

public class SearchActivity extends AppCompatActivity {

    private EditText etSearchBar;
    private TextView tvSearch;
    private ImageView ivCancel;

    private String text = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        findViews();

        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = etSearchBar.getText().toString();
                if (TextUtils.isEmpty(text)) {
                    Toast.makeText(SearchActivity.this, "请输入要查询的内容", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(SearchActivity.this, SearchResultActivity.class);
                    intent.putExtra("keyword", text);
                    startActivity(intent);
                    overridePendingTransition(R.anim.right_in, R.anim.left_out);
                    etSearchBar.setText("");
                }
            }
        });

        ivCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.left_in, R.anim.right_out);
            }
        });
    }

    private void findViews() {
        etSearchBar = findViewById(R.id.m_et_search_bar);
        tvSearch = findViewById(R.id.m_tv_confirm_search);
        ivCancel = findViewById(R.id.y_cancel);
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
