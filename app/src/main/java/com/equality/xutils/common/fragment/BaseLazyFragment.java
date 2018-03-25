package com.equality.xutils.common.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.equality.xutils.common.IBaseFragment;

import butterknife.ButterKnife;

/**
 * 懒加载：  在 initData()初始化
 * 非懒加载：在 initViews()初始化, initData()留空
 * <p>
 * <p>
 * 懒加载方法：
 * 方式一、 ViewPager中使用，调用setUserVisibleHint();
 * 方式二、 FragmentTransaction的show和hide的方法来控制显示，调用onHiddenChanged();
 * 针对初始就show的Fragment，为了触发onHiddenChanged事件达到lazy效果，需要先hide再show
 * transaction.hide(aFragment);
 * transaction.show(aFragment);
 *
 * @author wang
 */
public abstract class BaseLazyFragment extends Fragment implements IBaseFragment {
    /**
     * 是否可见状态 为了避免和{@link Fragment#isVisible()}冲突 换个名字
     */
    private boolean isFragmentVisible=false;
    /**
     * 是否View初始化已经完成
     */
    private boolean isPrepared=false;
    /**
     * 是否第一次加载
     */
    private boolean isFirstLoad = true;
    /**
     * 强制刷新
     * 一般用于PagerAdapter需要刷新各个子Fragment的场景, 不要new新的PagerAdapter，而采取reset数据的方式，
     * 所以要求Fragment重新走initData方法, 故使用 setForceLoad()来让Fragment下次执行initData
     */
    private boolean forceLoad = false;

    protected View mView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null && bundle.size() > 0) {
            initArguments(bundle);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        isFirstLoad = true;
        mView = inflater.inflate(getLayoutByXml(), container, false);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ButterKnife.bind(this, mView);
        initArguments(getArguments());
        initView();
        isPrepared = true;
        lazyLoad();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isPrepared = false;
    }

    /**
     * ViewPager调用此方法
     *
     * @param isVisibleToUser 是否可见
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            onVisible();
        } else {
            onInvisible();
        }
    }

    /**
     * ViewPager使用
     * 需要刷新被移除的Fragment中数据, 需要重新put数据
     * 下次显示时会从 getArguments()中重新获取数据
     */
    public void initArguments(Bundle bundle) {
    }

    /**
     * FragmentTransaction的show和hide 调用此方法
     * 若是初始就show的 Fragment,为了触发该事件需要先hide再show
     *
     * @param hidden true：hidden, false：visible.
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            onVisible();
        } else {
            onInvisible();
        }
    }

    protected void onVisible() {
        isFragmentVisible = true;
        lazyLoad();
    }

    protected void onInvisible() {
        isFragmentVisible = false;
    }

    protected void lazyLoad() {
        if (isPrepared() && isFragmentVisible()) {
            if (forceLoad || isFirstLoad()) {
                forceLoad = false;
                isFirstLoad = false;
                initData();
            }
        }
    }


    /**
     * 初始化视图
     */
    public abstract void initView();

    /**
     * 初始化数据
     */
    public abstract void initData();


    public boolean isFragmentVisible() {
        return isFragmentVisible;
    }

    public boolean isPrepared() {
        return isPrepared;
    }

    public boolean isFirstLoad() {
        return isFirstLoad;
    }

    /**
     * 强制刷新数据，忽略 isFirstLoad 的值，但仍要 Visible && Prepared
     */
    public void setForceLoad(boolean forceLoad) {
        this.forceLoad = forceLoad;
    }
}
