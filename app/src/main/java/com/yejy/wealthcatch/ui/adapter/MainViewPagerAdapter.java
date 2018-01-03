package com.yejy.wealthcatch.ui.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.yejy.wealthcatch.ui.base.BaseFragmentPagerAdapter;
import com.yejy.wealthcatch.ui.fragment.AboutUsFragment;
import com.yejy.wealthcatch.ui.fragment.HomeFragment;
import com.yejy.wealthcatch.ui.fragment.OpenResultFragment;

public class MainViewPagerAdapter extends BaseFragmentPagerAdapter {
    private static final String[] TITLES = new String[] {
            "彩票资讯",
            "开奖公告",
            "彩票新闻"
    };

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        if (position == 1) {
            fragment = OpenResultFragment.newInstance(TITLES[position]);
        } else if(position == 0) {
            fragment = HomeFragment.newInstance(TITLES[position]);
        } else {
            fragment = AboutUsFragment.newInstance(TITLES[position]);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
