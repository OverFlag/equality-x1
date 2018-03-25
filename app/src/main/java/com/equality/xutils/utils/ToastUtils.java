package com.equality.xutils.utils;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by xjh1994 on 2016/7/15.
 */
public class ToastUtils {

    public static boolean isShow = true;

    private static Toast mToast;
    private static Handler mHandler = new Handler();
    private static Runnable r = new Runnable() {
        @Override
        public void run() {
            mToast.cancel();
        }
    };

    private ToastUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 标准的 toast
     */
    public static void showShort(Context context, CharSequence message) {
        if (isShow) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }

    public static void showShort(Context context, @StringRes int message) {
        if (isShow) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }

    public static void showLong(Context context, CharSequence message) {
        if (isShow) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }

    public static void showLong(Context context, @StringRes int message) {
        if (isShow) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 自定义Toast，会覆盖前一个Toast 如：非重要重复的提示
     */
    public static void show(Context context, @StringRes int message) {
        show(context, message, Toast.LENGTH_SHORT);
    }

    public static void show(Context context, CharSequence message) {
        show(context, message, Toast.LENGTH_SHORT);
    }

    public static void showL(Context context, @StringRes int message) {
        show(context, message, Toast.LENGTH_LONG);
    }

    public static void showL(Context context, CharSequence message) {
        show(context, message, Toast.LENGTH_LONG);
    }

    /**
     * 自定义显示Toast时间
     *
     * @param context  Context
     * @param message  ""
     * @param duration duration
     */
    public static void show(Context context, @StringRes int message, int duration) {
        show(context, context.getResources().getText(message), duration);
    }

    public static void show(Context context, CharSequence message, int duration) {
        if (TextUtils.isEmpty(message) || !isShow) {
            return;
        }
        mHandler.removeCallbacks(r);
        if (mToast != null) {
            mToast.setDuration(duration);
            mToast.setText(message);
            mToast.show();
        } else {
            mToast = Toast.makeText(context, message, duration);
            mToast.show();
        }
    }
}
