package com.happier.flowering.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.happier.flowering.R;
import com.yinglan.alphatabs.AlphaTabsIndicator;
import com.yinglan.alphatabs.OnTabChangedListner;

/**
 * @ClassName FlowerPostFragment
 * @Description 花现Fragment, 此类不允许改动!!(如非改动不可请联系马增来)
 * @Author seven
 * @date 2020/4/16 15:09
 * @Version 0.1
 */
public class FlowerPostFragment extends Fragment {

    private AlphaTabsIndicator indicator;
    private ImageView ivPublishPost;

    private static final int TAB_LATEST = 0;
    private static final int TAB_CHOICE = 1;
    private static final int TAB_TOPIC = 2;

    // 用于记录当前正在显示的Fragment
    private Fragment curFragment = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flower_post, container, false);

        ivPublishPost = view.findViewById(R.id.iv_publish_post);

        indicator = view.findViewById(R.id.alphaIndicator_post);
        indicator.setOnTabChangedListner(new OnTabChangedListner() {
            @Override
            public void onTabSelected(int tabNum) {
                Fragment fragment = null;
                if (tabNum == TAB_LATEST) {
                    fragment = new LatestPostFragment();
                } else if (tabNum == TAB_CHOICE) {
                    fragment = new ChoicePostFragment();
                } else if (tabNum == TAB_TOPIC) {
                    fragment = new TopicPostFragment();
                }
                showFragment(fragment);
            }
        });

        // 设置顶部选项卡
        if (getArguments() != null && getArguments().get("back") != null) {
            int position = (int) getArguments().get("back");
            indicator.setTabCurrenItem(position);
            getArguments().clear();
        } else {
            showFragment(new LatestPostFragment());
        }
        //发布
        ivPublishPost = view.findViewById(R.id.iv_publish_post);
        ivPublishPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                publishPost();
            }
        });

        return view;
    }


    // 根据不同的选项卡显示不同的Fragment
    public void showFragment(Fragment fragment) {
        if (curFragment == fragment) {
            return;
        }
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        if (curFragment != null) {
            transaction.hide(curFragment);
        }
        if (!fragment.isAdded()) {
            transaction.add(R.id.tab_content, fragment);
        }
        transaction.show(fragment);
        curFragment = fragment;
        transaction.commit();
    }

    /**
     * @return void
     * @Description 跳转到发布花现界面进行花现的发布
     * @Author seven
     * @Date 2020/4/20 14:33
     * @Params []
     **/
    private void publishPost() {
        // todo: 跳转到发布花现界面
        Toast.makeText(getContext(), "todo: 跳转到发布花现界面", Toast.LENGTH_SHORT).show();
    }

}
