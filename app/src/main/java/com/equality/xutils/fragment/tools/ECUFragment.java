package com.equality.xutils.fragment.tools;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.equality.xutils.R;
import com.equality.xutils.activity.ecu.EcuCarActivity;
import com.equality.xutils.activity.ecu.EcuCodeActivity;
import com.equality.xutils.activity.ecu.EcuDataActivity;
import com.equality.xutils.activity.ecu.EcuInfoActivity;
import com.equality.xutils.adapter.ToolsGridAdapter;
import com.equality.xutils.common.fragment.BaseFragment;
import com.equality.xutils.model.BaseGridBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 46786 on 2018/3/23.
 */

public class ECUFragment extends BaseFragment implements BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.rvGrid)
    RecyclerView rvGrid;

    private List<BaseGridBean> mData = new ArrayList<>();
    private ToolsGridAdapter mAdapter;

    private String[] names = {"数据监控", "系统信息", "参数标定", "使用帮助", "诊断"};
    private Integer[] resIds = {
            R.drawable.ic_data, R.drawable.ic_info,
            R.drawable.ic_param, R.drawable.ic_helper, R.drawable.ic_diagnosis};

    @Override
    public int getLayoutByXml() {
        return R.layout.fragment_tools_ecu;
    }

    @Override
    public void initView() {
        rvGrid.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mAdapter = new ToolsGridAdapter(mData);
        mAdapter.setOnItemClickListener(this);
        rvGrid.setAdapter(mAdapter);
        rvGrid.setNestedScrollingEnabled(false);
    }

    @Override
    public void initData() {
        mData.clear();
        for (int i = 0; i < names.length; i++) {
            BaseGridBean item = new BaseGridBean(names[i], resIds[i]);
            mData.add(item);
        }
        mAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.ivTitle)
    public void onClickView() {
        startActivity(new Intent(getActivity(), EcuCodeActivity.class));
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        if (0 == position) {
            startActivity(new Intent(getActivity(), EcuDataActivity.class));
        } else if (1 == position) {
            startActivity(new Intent(getActivity(), EcuInfoActivity.class));
        } else if (2 == position) {
            startActivity(new Intent(getActivity(), EcuCarActivity.class));
        } else if (3 == position) {

        }
    }
}
