package com.equality.xutils.fragment.tools;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.equality.xutils.R;
import com.equality.xutils.activity.can.CanTestActivity;
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

public class CANFragment extends BaseFragment {

    @BindView(R.id.rvGrid)
    RecyclerView rvGrid;

    private List<BaseGridBean> mData = new ArrayList<>();
    private ToolsGridAdapter mAdapter;

    private String[] names = {"节点故障", "总线配置", "使用帮助"};
    private Integer[] resIds = {R.drawable.ic_error, R.drawable.ic_bus, R.drawable.ic_helper};

    @Override
    public int getLayoutByXml() {
        return R.layout.fragment_tools_can;
    }

    @Override
    public void initView() {
        rvGrid.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mAdapter = new ToolsGridAdapter(mData);
        rvGrid.setAdapter(mAdapter);
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
        startActivity(new Intent(getActivity(), CanTestActivity.class));
    }

}
