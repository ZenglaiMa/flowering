package com.happier.flowering.view;

import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.happier.flowering.R;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

/**
 * @ClassName NineGridLayoutExd
 * @Description 九宫格的显示以及图片的点击效果
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
        View dialogView = LayoutInflater.from(mContext).inflate(R.layout.dialog_origin_image, null);
        final Dialog dialog = new Dialog(mContext, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        Banner banner = dialogView.findViewById(R.id.m_large_image_banner);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(mContext).load(path).into(imageView);
            }
        });
        banner.setImages(urlList);
        banner.isAutoPlay(false);
        banner.setBannerAnimation(Transformer.ZoomIn);
        banner.setBannerAnimation(Transformer.ZoomOut);
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });
        banner.start();
        dialog.setContentView(dialogView);
        Window dialogWindow = dialog.getWindow();
        dialogWindow.setWindowAnimations(R.style.DialogStyle);
        dialog.show();
    }
}
