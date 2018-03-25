package com.equality.xutils.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.equality.xutils.R;
import com.equality.xutils.activity.SearchActivity;
import com.equality.xutils.adapter.WifiAdapter;
import com.equality.xutils.common.fragment.BaseLazyFragment;
import com.equality.xutils.model.WifiBean;
import com.equality.xutils.utils.WifiUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 46786 on 2018/3/23.
 */
public class WIFIFragment extends BaseLazyFragment
        implements BaseQuickAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    public static final String TAG = WIFIFragment.class.getSimpleName();

    @BindView(R.id.srl)
    SwipeRefreshLayout srl;
    @BindView(R.id.rv)
    RecyclerView rv;

    private List<WifiBean> mData = new ArrayList<>();
    private WifiAdapter mAdapter;
    private WifiUtils mWifiUtils;

    @Override
    public int getLayoutByXml() {
        return R.layout.fragment_wifi;
    }

    @Override
    public void initView() {
        srl.setOnRefreshListener(this);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        mAdapter = new WifiAdapter(mData);
        mAdapter.setOnItemClickListener(this);
        rv.setAdapter(mAdapter);
    }

    @Override
    public void initData() {
        for (int i = 0; i < 5; i++) {
            WifiBean bean = new WifiBean("test", "-48dbm");
            mData.add(bean);
        }
        mAdapter.notifyDataSetChanged();

        mWifiUtils = new WifiUtils(getActivity());
        if (mWifiUtils.isOpenWifi()) {
            String mScanResult = mWifiUtils.getScanResult();
            Log.e(TAG, "initData: " + mScanResult);
        }
        // ToastUtils.show(getActivity(), "请手动打开无线网开关");
    }

    @Override
    public void onRefresh() {
        String mScanResult = mWifiUtils.getScanResult();
        Log.e(TAG, "initView: " + mScanResult);

        srl.setRefreshing(false);
    }

    @OnClick(R.id.llEdtContainer)
    public void onClickView() {
        SearchActivity.newInstacne(getActivity());
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        mAdapter.setSelectPosition(position);
        mAdapter.notifyDataSetChanged();
    }
}
