package com.yejy.wealthcatch.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.yejy.wealthcatch.R;
import com.yejy.wealthcatch.ui.base.BaseFragment;

public class AboutUsFragment extends BaseFragment {

    String topTitle;
    TextView titleTV;
    public static AboutUsFragment newInstance(String topTitle) {
        AboutUsFragment fragment = new AboutUsFragment();
        Bundle args = new Bundle();
        args.putString("title", topTitle);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected View onCreateView() {
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View view = layoutInflater.inflate(R.layout.frag_about_us, null);
        titleTV = view.findViewById(R.id.topTitle);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        topTitle = getArguments().getString("title");
        titleTV.setText(topTitle);
    }
}
