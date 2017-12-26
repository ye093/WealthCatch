package com.yejy.wealthcatch.ui.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;

import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.QMUITabSegment;
import com.yejy.wealthcatch.R;
import com.yejy.wealthcatch.ui.adapter.MainViewPagerAdapter;
import com.yejy.wealthcatch.ui.base.BaseActivity;

public class MainActivity  extends BaseActivity{
    private QMUITabSegment mTabSegment;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_m);
        viewPager = findViewById(R.id.pager);
        mTabSegment = findViewById(R.id.tabs);
        initTabs();
        initPagers();
    }
    private void initTabs() {
        int normalColor = QMUIResHelper.getAttrColor(this, R.attr.qmui_config_color_gray_6);
        int selectColor = QMUIResHelper.getAttrColor(this, R.attr.qmui_config_color_blue);
        mTabSegment.setDefaultNormalColor(normalColor);
        mTabSegment.setDefaultSelectedColor(selectColor);
        QMUITabSegment.Tab component = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(this, R.drawable.icon_new_msg),
                ContextCompat.getDrawable(this, R.drawable.icon_new_msg_selected),
                getResources().getText(R.string.new_message), false
        );

        QMUITabSegment.Tab util = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(this, R.drawable.icon_gonggao),
                ContextCompat.getDrawable(this, R.drawable.icon_gonggao_selected),
                getResources().getText(R.string.open_indicate), false
        );
        QMUITabSegment.Tab lab = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(this, R.drawable.icon_manager),
                ContextCompat.getDrawable(this, R.drawable.icon_manager_selected),
                getResources().getText(R.string.mine_ticket), false
        );
        mTabSegment.addTab(component)
                .addTab(util)
                .addTab(lab);
    }

    private void initPagers() {
        MainViewPagerAdapter mViewPager = new MainViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mViewPager);
        mTabSegment.setupWithViewPager(viewPager, false);
    }
}
