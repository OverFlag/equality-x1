package com.equality.xutils.fragment;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.equality.xutils.R;
import com.equality.xutils.activity.SearchActivity;
import com.equality.xutils.adapter.BlueToothAdapter;
import com.equality.xutils.common.entity.CusSectionEntity;
import com.equality.xutils.common.fragment.BaseLazyFragment;
import com.equality.xutils.model.BluetoothBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 46786 on 2018/3/23.
 */
public class BluetoothFragment extends BaseLazyFragment {

    @BindView(R.id.rv)
    RecyclerView rv;

    private List<CusSectionEntity<BluetoothBean>> mData = new ArrayList<>();
    private BlueToothAdapter mAddapter;

    @Override
    public int getLayoutByXml() {
        return R.layout.fragment_bluetooth;
    }

    @Override
    public void initView() {
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        mAddapter = new BlueToothAdapter(mData);
        rv.setAdapter(mAddapter);
    }

    @Override
    public void initData() {

        mData.add(new CusSectionEntity<BluetoothBean>(true, "已连接"));
        BluetoothBean bean1 = new BluetoothBean("测试用蓝牙", 1);
        mData.add(new CusSectionEntity<BluetoothBean>(bean1));
        mData.add(new CusSectionEntity<BluetoothBean>(true, "附近设备"));
        BluetoothBean bean2 = new BluetoothBean("铁三角蓝牙耳机", 0);
        mData.add(new CusSectionEntity<BluetoothBean>(bean2));
        BluetoothBean bean3 = new BluetoothBean("hskj122", 0);
        mData.add(new CusSectionEntity<BluetoothBean>(bean3));
        BluetoothBean bean4 = new BluetoothBean("小米蓝牙", 0);
        mData.add(new CusSectionEntity<BluetoothBean>(bean4));
        mAddapter.notifyDataSetChanged();
    }

    @OnClick(R.id.llEdtContainer)
    public void onClickView() {
        SearchActivity.newInstacne(getActivity());
    }
}
