package com.yejy.wealthcatch.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

/**
 * 项目名称：WealthCatch
 * 类描述：
 * 创建人：yejinyun
 * 创建时间：2017/12/26 16:21
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QMUIStatusBarHelper.translucent(this);
    }
}
