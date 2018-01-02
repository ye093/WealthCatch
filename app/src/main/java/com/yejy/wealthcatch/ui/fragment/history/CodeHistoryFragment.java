package com.yejy.wealthcatch.ui.fragment.history;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.yejy.wealthcatch.R;
import com.yejy.wealthcatch.net.MyHttp;
import com.yejy.wealthcatch.ui.base.BaseFragment;
import com.yejy.wealthcatch.ui.decoration.GridDividerItemDecoration;
import com.yejy.wealthcatch.ui.entity.HistoryOpenCode;
import com.yejy.wealthcatch.ui.fragment.adapter.HistoryOpenCodeAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CodeHistoryFragment  extends BaseFragment {

    TextView topTitle;
    private RecyclerView listView;
    private HistoryOpenCodeAdapter adapter;
    private String queryUrl;

    private static final String QUERY_KEY = "query_key";
    public static CodeHistoryFragment newInstance(String queryUrl) {
        CodeHistoryFragment fragment = new CodeHistoryFragment();
        Bundle args = new Bundle();
        args.putString(QUERY_KEY, queryUrl);
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
        queryUrl = getArguments().getString(QUERY_KEY);
        topTitle.setText("历史开奖");
        adapter = new HistoryOpenCodeAdapter();
        listView.setAdapter(adapter);
        listView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
        listView.addItemDecoration(new GridDividerItemDecoration(getActivity(), 1));
        if (queryUrl == null) return;
        MyHttp myHttp = new MyHttp();
        myHttp.doGet(queryUrl, new MyHttp.MyHttpCallback() {
            @Override
            public void result(String response) {
                if (TextUtils.isEmpty(response)) return;
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONObject jsonPeriod = jsonObject.getJSONObject("period");
                    JSONArray rowArray = jsonPeriod.getJSONArray("row");
                    final ArrayList<HistoryOpenCode> openCodes = new ArrayList<>();
                    for (int i = 0; i < rowArray.length(); i++) {
                        JSONObject rowObj = rowArray.getJSONObject(i);
                        String fet = rowObj.optString("fet");
                        String flag = rowObj.optString("flag");
                        String pid = rowObj.optString("pid");
                        String st = rowObj.optString("st");
                        String et = rowObj.optString("et");
                        String opencode = rowObj.optString("opencode");
                        if ("1".equals(flag)) continue;
                        HistoryOpenCode historyOpenCode = new HistoryOpenCode(fet, flag, pid, st,
                                et, opencode);
                        openCodes.add(historyOpenCode);
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.setDataSet(openCodes);
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
