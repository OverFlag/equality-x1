package com.equality.xutils.common.toolbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.equality.xutils.R;


/**
 * Created by moon.zhong on 2015/6/12.
 */
public class ToolBarHelper {

    /**
     * 上下文，创建view的时候需要用到
     */
    private Context mContext;
    /**
     * 界面
     */
    private FrameLayout mContentView;
    /**
     * 用户定义的view
     */
    private View mUserView;
    /**
     * toolbar
     */
    private Toolbar mToolBar;
    /**
     * 视图构造器
     */
    private LayoutInflater mInflater;
    /**
     * 两个属性
     * 1、toolbar是否悬浮在窗口之上
     * 2、toolbar的高度获取
     */
    private static int[] ATTRS = {R.attr.windowActionBarOverlay, R.attr.actionBarSize};

    public ToolBarHelper(Context context, int layoutId) {
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
        // 初始化整个内容
        initContentView();
        // 初始化用户定义的布局
        initUserView(layoutId);
        // 初始化toolbar
        initToolBar();
    }

    /**
     * 直接创建一个帧布局，作为视图容器的父容器
     */
    private void initContentView() {
        mContentView = new FrameLayout(mContext);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mContentView.setFitsSystemWindows(true);
        mContentView.setLayoutParams(params);
    }

    /**
     * 初始化用户定义的布局
     *
     * @param layoutId resId
     */
    @SuppressLint("ResourceType")
    private void initUserView(int layoutId) {
        mUserView = mInflater.inflate(layoutId, null);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        TypedArray typedArray = mContext.getTheme().obtainStyledAttributes(ATTRS);
        // 获取主题中定义的悬浮标志
        boolean overly = typedArray.getBoolean(0, false);
        // 获取主题中定义的toolbar的高度
        int height = (int) mContext.getResources().getDimension(R.dimen.abc_action_bar_default_height_material);
        int toolBarSize = (int) typedArray.getDimension(1, height);
        typedArray.recycle();
        // 如果是悬浮状态，则不需要设置间距
        params.topMargin = overly ? 0 : toolBarSize;
        mContentView.addView(mUserView, params);
    }

    /**
     * 初始化toolbar
     */
    private void initToolBar() {
        // 通过inflater获取toolbar的布局文件
        View toolbar = mInflater.inflate(R.layout.tx_layout_base_toolbar, mContentView);
        mToolBar = (Toolbar) toolbar.findViewById(R.id.tx_tool_bar);
        if (mToolBar == null) {
            Log.d("toolbar", "mToolBar == null");
        }
    }

    public FrameLayout getContentView() {
        return mContentView;
    }

    public View getUserView() {
        return mUserView;
    }

    public Toolbar getToolBar() {
        return mToolBar;
    }
}
