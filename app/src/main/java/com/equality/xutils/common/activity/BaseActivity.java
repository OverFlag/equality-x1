package com.equality.xutils.common.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.equality.xutils.common.IBaseActivity;
import com.equality.xutils.utils.ActivityUtils;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

/**
 * description
 *
 * @author WangYaoDong
 * @date 2018/3/23 11:55
 */
public abstract class BaseActivity extends AppCompatActivity implements IBaseActivity {

    protected InputMethodManager inputMethodManager;

    private boolean isEventBusEnabled = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        beforeOnCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        if (!isTaskRoot()) {
            Intent intent = getIntent();
            String action = intent.getAction();
            if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && Intent.ACTION_MAIN.equals(action)) {
                finish();
                return;
            }
        }
        afterOnCreate(savedInstanceState);

        inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        ActivityUtils.getInstance().addActivity(this);

        if (getViewByXml() != 0) {
            setContentView(getViewByXml());
        }
        ButterKnife.bind(this);
        // 初始化
        init();
        if (isEventBusEnabled) {
            EventBus.getDefault().register(this);
        }
    }

    protected void init() {
        initView();
        initData();
    }

    /**
     * 开启EventBus
     */
    public void setEventBusEnabled() {
        isEventBusEnabled = true;
    }

    /**
     * 基类ActivityOnCreate之前
     */
    protected void beforeOnCreate(Bundle savedInstanceState) {

    }

    /**
     * 基类Activity OnCreate之后，setContentView之前
     */
    protected void afterOnCreate(Bundle savedInstanceState) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        inputMethodManager = null;
        ActivityUtils.getInstance().finishActivity(this);
    }

    protected void hideSoftKeyboard() {
        if (getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
            if (getCurrentFocus() != null && inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }
}
