package com.yejy.wealthcatch.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.yejy.wealthcatch.R;
import com.yejy.wealthcatch.ui.base.BaseFragment;


public class HomeFragment extends BaseFragment {
    TextView topTitle;
    private static final String TITLE_KEY = "title_key";

    public static HomeFragment newInstance(String title) {
        HomeFragment homeFragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(TITLE_KEY, title);
        homeFragment.setArguments(args);
        return homeFragment;
    }

    @Override
    protected View onCreateView() {
        View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.frag_home, null);
        topTitle = contentView.findViewById(R.id.topTitle);
        return contentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String title = getArguments().getString(TITLE_KEY, "");
        topTitle.setText(title);
    }
}
