package com.yejy.wealthcatch.ui.fragment.main;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.QMUITabSegment;
import com.yejy.wealthcatch.R;
import com.yejy.wealthcatch.ui.adapter.MainViewPagerAdapter;
import com.yejy.wealthcatch.ui.base.BaseFragment;
import com.yejy.wealthcatch.ui.fragment.HomeFragment;

/**
 * Created by yejy_ on 2017-12-26.
 */

public class MainFragment extends BaseFragment {

    private final static String TAG = HomeFragment.class.getSimpleName();

    private QMUITabSegment mTabSegment;
    private ViewPager viewPager;


    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.activity_main_m, null);
        viewPager = layout.findViewById(R.id.pager);
        mTabSegment = layout.findViewById(R.id.tabs);
        initTabs();
        initPagers();
        return layout;
    }
    private void initTabs() {
        int normalColor = QMUIResHelper.getAttrColor(getActivity(), R.attr.qmui_config_color_gray_6);
        int selectColor = QMUIResHelper.getAttrColor(getActivity(), R.attr.qmui_config_color_blue);
        mTabSegment.setDefaultNormalColor(normalColor);
        mTabSegment.setDefaultSelectedColor(selectColor);
        QMUITabSegment.Tab component = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(getActivity(), R.drawable.icon_new_msg),
                ContextCompat.getDrawable(getActivity(), R.drawable.icon_new_msg_selected),
                getResources().getText(R.string.new_message), false
        );

        QMUITabSegment.Tab util = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(getActivity(), R.drawable.icon_gonggao),
                ContextCompat.getDrawable(getActivity(), R.drawable.icon_gonggao_selected),
                getResources().getText(R.string.open_indicate), false
        );
        QMUITabSegment.Tab lab = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(getActivity(), R.drawable.icon_manager),
                ContextCompat.getDrawable(getActivity(), R.drawable.icon_manager_selected),
                getResources().getText(R.string.mine_ticket), false
        );
        mTabSegment.addTab(component)
                .addTab(util)
                .addTab(lab);
    }

    private void initPagers() {
        MainViewPagerAdapter mViewPager = new MainViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(mViewPager);
        mTabSegment.setupWithViewPager(viewPager, false);
    }

}
