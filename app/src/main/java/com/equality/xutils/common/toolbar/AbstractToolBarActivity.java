package com.equality.xutils.common.toolbar;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.equality.xutils.common.activity.BaseActivity;


/**
 * Created by moon.zhong on 2015/6/12.
 */
public abstract class AbstractToolBarActivity extends BaseActivity {

    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        ToolBarHelper mToolBarHelper = new ToolBarHelper(this, layoutResID);

        toolbar = mToolBarHelper.getToolBar();
        bind(mToolBarHelper);

        setContentView(mToolBarHelper.getContentView());
        // 自定义的一些操作
        onCreateCustomToolBar(toolbar);
        // 设置toolbar到Activity中
        setSupportActionBar(toolbar);
    }

    protected void bind(ToolBarHelper toolBarHelper) {

    }

    public void onCreateCustomToolBar(Toolbar toolbar) {
        toolbar.setContentInsetsRelative(0, 0);
    }
}
