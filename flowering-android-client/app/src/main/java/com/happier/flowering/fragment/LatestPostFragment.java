package com.happier.flowering.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.happier.flowering.R;
import com.happier.flowering.adapter.LatestPostAdapter;
import com.happier.flowering.model.NineGridModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LatestPostFragment
 * @Description 花现中最新对应的Fragment
 * @Author seven
 * @date 2020/4/20 14:44
 * @Version 0.1
 */
public class LatestPostFragment extends Fragment {

    private List<NineGridModel> dataSource = new ArrayList<>();
    private String[] urls = new String[]{"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587446029746&di=b54b967a6392105e396cca810dad9e5c&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201509%2F03%2F20150903205521_wxrcs.thumb.700_0.jpeg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587446029745&di=e61b62c4b208c7fab7aa1368d28a49c6&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20200108%2F5f0f63bc4d414c8ab1092dd779e6e643.jpeg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587446029745&di=38163f8ecbc47881ebe4b08fff1e2189&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201702%2F01%2F20170201152621_EBN3W.thumb.700_0.jpeg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587446029744&di=bab8ba07eacc87023feb2e28aac98f2e&imgtype=0&src=http%3A%2F%2Fimg.duoziwang.com%2F2018%2F16%2F04201836720282.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587446029744&di=175670b3b1e48a1e95c5e4dc86a4c3f1&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201608%2F06%2F20160806154406_8TCdc.jpeg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587446029743&di=ff47c46a0dd6df41bd994605123b861a&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201610%2F01%2F20161001075817_rnt4A.jpeg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587446029743&di=3dd21e45af74255610b6ee0e8e2b63ca&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fw%3D580%2Fsign%3Dacc8b46530f33a879e6d0012f65d1018%2F4c3063c2d56285359c2ce5749aef76c6a6ef6373.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587446029742&di=f23ce384b323229d528164d20a0419b9&imgtype=0&src=http%3A%2F%2Fimage.biaobaiju.com%2Fuploads%2F20190920%2F11%2F1568948930-obCxPGsKBU.jpeg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587446029742&di=fda862cd0066b0ef6e681ec669c8b185&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fw%3D580%2Fsign%3Dae2c4c75b312c8fcb4f3f6c5cc0292b4%2F8dcf880f4bfbfbed77c3082a72f0f736aec31fa9.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587446029739&di=7293565dc5522672adf816deca3705ff&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201509%2F29%2F20150929081638_FsPJa.thumb.700_0.jpeg",};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_latest_and_choice, container, false);

        initData();
        LatestPostAdapter adapter = new LatestPostAdapter(getContext(), dataSource, R.layout.post_show_list_item);
        ListView listView = view.findViewById(R.id.m_post_lv);
        listView.setAdapter(adapter);

        return view;
    }

    private void initData() {

        NineGridModel model1 = new NineGridModel();
        model1.urlList.add(urls[0]);
        model1.isShowAll = false;
        dataSource.add(model1);

        NineGridModel model2 = new NineGridModel();
        for (int i = 0; i < 2; i++) {
            model2.urlList.add(urls[i]);
        }
        model2.isShowAll = false;
        dataSource.add(model2);

        NineGridModel model3 = new NineGridModel();
        for (int i = 0; i < 3; i++) {
            model3.urlList.add(urls[i]);
        }
        model3.isShowAll = false;
        dataSource.add(model3);

        NineGridModel model4 = new NineGridModel();
        for (int i = 0; i < 4; i++) {
            model4.urlList.add(urls[i]);
        }
        model4.isShowAll = false;
        dataSource.add(model4);

        NineGridModel model5 = new NineGridModel();
        for (int i = 0; i < 5; i++) {
            model5.urlList.add(urls[i]);
        }
        model5.isShowAll = false;
        dataSource.add(model5);

        NineGridModel model6 = new NineGridModel();
        for (int i = 0; i < 6; i++) {
            model6.urlList.add(urls[i]);
        }
        model6.isShowAll = false;
        dataSource.add(model6);

        NineGridModel model7 = new NineGridModel();
        for (int i = 0; i < 7; i++) {
            model7.urlList.add(urls[i]);
        }
        model7.isShowAll = false;
        dataSource.add(model7);

        NineGridModel model8 = new NineGridModel();
        for (int i = 0; i < 8; i++) {
            model8.urlList.add(urls[i]);
        }
        model8.isShowAll = false;
        dataSource.add(model8);

        NineGridModel model9 = new NineGridModel();
        for (int i = 0; i < 9; i++) {
            model9.urlList.add(urls[i]);
        }
        model9.isShowAll = false;
        dataSource.add(model9);

        NineGridModel model10 = new NineGridModel();
        for (int i = 0; i < urls.length; i++) {
            model10.urlList.add(urls[i]);
        }
        model10.isShowAll = false;
        dataSource.add(model10);
    }
}
