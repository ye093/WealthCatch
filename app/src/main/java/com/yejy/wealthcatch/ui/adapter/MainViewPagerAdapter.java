package com.yejy.wealthcatch.ui.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.yejy.wealthcatch.ui.base.BaseFragmentPagerAdapter;
import com.yejy.wealthcatch.ui.fragment.HomeFragment;

public class MainViewPagerAdapter extends BaseFragmentPagerAdapter {

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new HomeFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
