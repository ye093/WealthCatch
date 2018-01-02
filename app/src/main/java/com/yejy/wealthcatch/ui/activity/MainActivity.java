package com.yejy.wealthcatch.ui.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.QMUITabSegment;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import com.yejy.wealthcatch.R;
import com.yejy.wealthcatch.ui.adapter.MainViewPagerAdapter;
import com.yejy.wealthcatch.ui.base.BaseFragment;
import com.yejy.wealthcatch.ui.base.BaseFragmentActivity;
import com.yejy.wealthcatch.ui.fragment.history.CodeHistoryFragment;
import com.yejy.wealthcatch.ui.fragment.main.MainFragment;

public class MainActivity  extends BaseFragmentActivity {
    public static final String NOT_HOME_KEY = "not_home_key";
    private boolean isNotHome;

    public static final String CODE_HISTORY_KEY = "code_history_key";
    public static final String CODE_HISTORY_DATA_KEY = "code_history_data_key";
    private boolean isOpenCodeHistoryPage;


    @Override
    protected int getContextViewId() {
        return R.id.qmuidemo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isNotHome = getIntent().getBooleanExtra(NOT_HOME_KEY, false);
        isOpenCodeHistoryPage = getIntent().getBooleanExtra(CODE_HISTORY_KEY, false);
        if (savedInstanceState == null) {
            BaseFragment fragment = null;
            if (isNotHome) {
                if (isOpenCodeHistoryPage) {
                    String queryUrl = getIntent().getStringExtra(CODE_HISTORY_DATA_KEY);
                    fragment = CodeHistoryFragment.newInstance(queryUrl);
                }
            } else {
                fragment = new MainFragment();
            }
            if (fragment != null)
                getSupportFragmentManager()
                    .beginTransaction()
                    .add(getContextViewId(), fragment, fragment.getClass().getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        if (isNotHome) {
            super.onBackPressed();
            return;
        }
        new QMUIDialog.MessageDialogBuilder(this)
                .setTitle("提示")
                .setMessage("确定要退出吗？")
                .addAction("取消", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                    }
                })
                .addAction(0, "退出", QMUIDialogAction.ACTION_PROP_NEGATIVE, new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        finish();
                        dialog.dismiss();
                    }
                })
                .show();
    }
}
