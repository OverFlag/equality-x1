package com.equality.xutils.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.equality.xutils.MainActivity;
import com.equality.xutils.R;
import com.equality.xutils.common.activity.BaseActivity;
import com.equality.xutils.utils.ActivityUtils;
import com.equality.xutils.utils.AppUtils;

import java.lang.ref.WeakReference;

import butterknife.BindView;

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

    @BindView(R.id.tvVersion)
    TextView tvVersion;

    @Override
    public int getViewByXml() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
        String version = "V" + AppUtils.getVersionName(this);
        tvVersion.setText(version);

        if (ActivityUtils.getInstance().size() > 1) {
            finish();
        } else {
            LeakHandler handler = new LeakHandler(this);
            handler.sendEmptyMessageDelayed(1, TIME_MILLIS_DELAY);
        }
    }

    @Override
    public void initData() {

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

    private static class LeakHandler extends Handler {
        private final WeakReference<SplashActivity> mActivity;

        LeakHandler(SplashActivity activity) {
            mActivity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            SplashActivity activity = mActivity.get();
            super.handleMessage(msg);
            if (1 == msg.what) {
                if (activity != null) {
                    Intent intent = new Intent(activity, MainActivity.class);
                    activity.startActivity(intent);
                    activity.finish();
                }
            }
        }
    }
}
