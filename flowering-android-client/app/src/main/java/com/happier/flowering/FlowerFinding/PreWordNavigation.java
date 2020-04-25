package com.happier.flowering.FlowerFinding;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.happier.flowering.R;
import com.happier.flowering.view.WordsNavigation;

public class PreWordNavigation extends LinearLayout{
    private Context mContext;
    private WordsNavigation.onShowLetterListener onShowLetterListener = null;
    public PreWordNavigation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        setOrientation(VERTICAL);
        initView();
    }
    public void setOnShowLetter(WordsNavigation.onShowLetterListener showLetterListener) {
        this.onShowLetterListener = showLetterListener;
    }

    private void initView() {

        for (char i = 'A'; i <= 'Z'; i++) {
            final String character = i + "";
            TextView tv = buildTextLayout(character);
            addView(tv);
        }
    }

    private TextView buildTextLayout(final String character){
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1);
        TextView tv = new TextView(mContext);
        tv.setLayoutParams(layoutParams);
        tv.setGravity(Gravity.CENTER);
        tv.setClickable(true);
        tv.setText(character);
        tv.setTextColor(getResources().getColor(R.color.colorGreen));


        tv.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        refreshLetterIndex(character);
                        Log.e("clicked",character);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        refreshLetterIndex(character);
                        Log.e("clicked",character);
                        break;
                }
                return true;
            }
        });
        return tv;
    }

    private void refreshLetterIndex(String character) {
        if (onShowLetterListener != null) {
            onShowLetterListener.showLatter(character);
        }
        invalidate();
    }
}
