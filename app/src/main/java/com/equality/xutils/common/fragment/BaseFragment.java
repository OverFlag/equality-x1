package com.equality.xutils.common.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.equality.xutils.common.IBaseFragment;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * description
 *
 * @author WangYaoDong
 * @date 2018/3/23 11:55
 */
public abstract class BaseFragment  extends Fragment implements IBaseFragment {

    private static final Handler handler = new Handler();

    protected View mView;

    private Unbinder unbinder;

    private boolean isEventBusEnabled = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return mView = inflater.inflate(getLayoutByXml(), container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        unbinder = ButterKnife.bind(this, mView);

        initArguments(getArguments());
        initView();
        initData();

        if (isEventBusEnabled) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onDestroyView() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        super.onDestroyView();
    }

    @Override
    public void initArguments(Bundle data) {
    }
    /**
     * 开启EventBus
     */
    public void setEventBusEnabled() {
        isEventBusEnabled = true;
    }
    @Override
    @NonNull
    public View getView() {
        return mView;
    }

    @SuppressWarnings("unchecked")
    protected <T extends View> T findView(int resId) {
        return (T) (getView().findViewById(resId));
    }

    protected final Handler getHandler() {
        return handler;
    }

    protected final void postRunnable(final Runnable runnable) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (!isAdded()) {
                    return;
                }
                runnable.run();
            }
        });
    }

    protected final void postDelayed(final Runnable runnable, long delay) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isAdded()) {
                    return;
                }
                runnable.run();
            }
        }, delay);
    }
}
