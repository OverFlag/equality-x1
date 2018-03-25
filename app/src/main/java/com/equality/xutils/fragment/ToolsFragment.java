package com.equality.xutils.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.equality.xutils.R;
import com.equality.xutils.activity.SearchActivity;
import com.equality.xutils.common.fragment.BaseLazyFragment;
import com.equality.xutils.fragment.tools.CANFragment;
import com.equality.xutils.fragment.tools.ECUFragment;
import com.equality.xutils.fragment.tools.EngineFragment;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 46786 on 2018/3/23.
 */
public class ToolsFragment extends BaseLazyFragment {

    @BindView(R.id.tlCate)
    SlidingTabLayout tlCate;
    @BindView(R.id.vp)
    ViewPager vp;

    private String[] mTitles = {"ECU", "CAN总线", "发动机信息"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    public int getLayoutByXml() {
        return R.layout.fragment_tools;
    }

    @Override
    public void initView() {
        mFragments.clear();
        mFragments.add(new ECUFragment());
        mFragments.add(new CANFragment());
        mFragments.add(new EngineFragment());
        tlCate.setViewPager(vp, mTitles, getActivity(), mFragments);
        tlCate.setCurrentTab(0);
    }

    @Override
    public void initData() {

    }

    @OnClick(R.id.llEdtContainer)
    public void onClickView() {
        SearchActivity.newInstacne(getActivity());
    }
}
