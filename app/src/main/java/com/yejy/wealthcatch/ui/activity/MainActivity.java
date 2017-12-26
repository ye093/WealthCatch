package com.yejy.wealthcatch.ui.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.qmuiteam.qmui.widget.QMUITabSegment;
import com.yejy.wealthcatch.R;
import com.yejy.wealthcatch.ui.adapter.MainViewPagerAdapter;
import com.yejy.wealthcatch.ui.base.BaseActivity;

public class MainActivity  extends BaseActivity{
    private QMUITabSegment qmuiTabSegment;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_m);
        viewPager = findViewById(R.id.viewPager);
        qmuiTabSegment = findViewById(R.id.tabSegment);
        MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        qmuiTabSegment.addTab(new QMUITabSegment.Tab("首页"));
        qmuiTabSegment.addTab(new QMUITabSegment.Tab("咨询"));
        qmuiTabSegment.addTab(new QMUITabSegment.Tab("开奖"));
        qmuiTabSegment.setupWithViewPager(viewPager, false);
        qmuiTabSegment.setHasIndicator(true);
        qmuiTabSegment.setIndicatorPosition(false);
        qmuiTabSegment.setDefaultTabIconPosition(0);

    }
}
