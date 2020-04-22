package com.happier.flowering.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * @ClassName NoScrollListView
 * @Description 利用android中的事件分发机制, 让父ListView不再拦截触摸事件, 以便让子ListView能够顺利滑动
 * @Author seven
 * @date 2020/4/22 10:27
 * @Version 0.1
 */
public class NoScrollListView extends ListView {

    public NoScrollListView(Context context) {
        super(context);
    }

    public NoScrollListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoScrollListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
