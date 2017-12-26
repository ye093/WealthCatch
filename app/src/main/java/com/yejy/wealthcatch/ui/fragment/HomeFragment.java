package com.yejy.wealthcatch.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import com.yejy.wealthcatch.R;
import com.yejy.wealthcatch.ui.base.BaseFragment;


public class HomeFragment extends BaseFragment {

    @Override
    protected View onCreateView() {
        View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.frag_home, null);
        return contentView;
    }
}
