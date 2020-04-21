package com.happier.flowering.view;

import android.app.AlertDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.happier.flowering.R;

import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author seven
 * @date 2020/4/21 9:26
 * @Version 0.1
 */
public class NineGridLayoutExd extends NineGridLayout {

    public NineGridLayoutExd(Context context) {
        super(context);
    }

    public NineGridLayoutExd(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected boolean displayOneImage(RatioImageView imageView, String url, int parentWidth) {
        return true;
    }

    @Override
    protected void displayImage(RatioImageView imageView, String url) {
        Glide.with(mContext).load(url).into(imageView);
    }

    @Override
    protected void onClickImage(int position, String url, List<String> urlList) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View dialogView = inflater.inflate(R.layout.dialog_origin_image, null);
        ImageView largeImage = dialogView.findViewById(R.id.m_large_image);
        Glide.with(mContext).load(url).into(largeImage);
        final AlertDialog dialog = new AlertDialog.Builder(mContext).create();
        dialog.setView(dialogView);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.background_dark);
        dialog.show();

        dialogView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialog.isShowing()) {
                    dialog.cancel();
                }
            }
        });
    }
}
