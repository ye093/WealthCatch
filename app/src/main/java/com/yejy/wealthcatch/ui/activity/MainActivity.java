package com.yejy.wealthcatch.ui.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;

import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.QMUITabSegment;
import com.yejy.wealthcatch.R;
import com.yejy.wealthcatch.ui.adapter.MainViewPagerAdapter;
import com.yejy.wealthcatch.ui.base.BaseFragment;
import com.yejy.wealthcatch.ui.base.BaseFragmentActivity;
import com.yejy.wealthcatch.ui.fragment.main.MainFragment;

public class MainActivity  extends BaseFragmentActivity {
    @Override
    protected int getContextViewId() {
        return R.id.qmuidemo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            BaseFragment fragment = new MainFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(getContextViewId(), fragment, fragment.getClass().getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .commit();
        }
    }

}
