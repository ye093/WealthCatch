package com.yejy.wealthcatch.ui.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.yejy.wealthcatch.ui.base.BaseFragmentPagerAdapter;
import com.yejy.wealthcatch.ui.fragment.HomeFragment;

public class MainViewPagerAdapter extends BaseFragmentPagerAdapter {
    private static final String[] TITLES = new String[] {
            "彩票资讯",
            "开奖公告",
            "我的彩票"
    };

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return HomeFragment.newInstance(TITLES[position]);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
