package com.yejy.wealthcatch.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.yejy.wealthcatch.R;
import com.yejy.wealthcatch.ui.base.BaseFragment;
import com.yejy.wealthcatch.ui.decoration.GridDividerItemDecoration;
import com.yejy.wealthcatch.ui.fragment.adapter.OpenResultAdapter;

/**
 * Created by yejinyun on 2017/12/27.
 */

public class OpenResultFragment  extends BaseFragment {
    TextView topTitle;
    private static final String TITLE_KEY = "title_key";
    private RecyclerView listView;
    private OpenResultAdapter adapter;

    public static OpenResultFragment newInstance(String title) {
        OpenResultFragment fragment = new OpenResultFragment();
        Bundle args = new Bundle();
        args.putString(TITLE_KEY, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected View onCreateView() {
        View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.frag_open_result, null);
        topTitle = contentView.findViewById(R.id.topTitle);
        listView = contentView.findViewById(R.id.recyclerView);
        return contentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String title = getArguments().getString(TITLE_KEY, "");
        topTitle.setText(title);
        adapter = new OpenResultAdapter();
        listView.setAdapter(adapter);
        int spanCount = 2;
        listView.setLayoutManager(new GridLayoutManager(getContext(), spanCount));
        listView.addItemDecoration(new GridDividerItemDecoration(getContext(), spanCount));
    }
}
