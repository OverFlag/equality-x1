package com.equality.xutils.activity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;

import com.equality.xutils.R;
import com.equality.xutils.common.BaseActivity;

import java.lang.ref.WeakReference;

/**
 * description
 *
 * @author WangYaoDong
 * @date 2018/3/23 11:54
 */
public class SplashActivity extends BaseActivity {

    /**
     * 延时时间
     */
    private static final int TIME_MILLIS_DELAY = 1000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (ActivityUtils.getInstance().size() > 0) {
            finish();
        } else {
            MyHandler handler = new MyHandler(this);
            handler.sendEmptyMessageDelayed(1, TIME_MILLIS_DELAY);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    private static class MyHandler extends Handler {
        private final WeakReference<SplashActivity> mActivity;

        MyHandler(SplashActivity activity) {
            mActivity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            SplashActivity activity = mActivity.get();
            super.handleMessage(msg);
            if (1 == msg.what) {
                if (activity != null) {
                    activity.goHome();
                    activity.finish();
                }
            }
        }
    }
}
