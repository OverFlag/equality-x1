package com.equality.xutils.fragment.tools;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.equality.xutils.R;
import com.equality.xutils.adapter.ToolsGridAdapter;
import com.equality.xutils.common.fragment.BaseFragment;
import com.equality.xutils.model.BaseGridBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by 46786 on 2018/3/23.
 */

public class EngineFragment extends BaseFragment {

    @BindView(R.id.rvGrid)
    RecyclerView rvGrid;

    private List<BaseGridBean> mData = new ArrayList<>();
    private ToolsGridAdapter mAdapter;

    private String[] names = {"Read/ClearDTC", "Read/Clear OBD DTC", "端口测试"};
    private Integer[] resIds = {R.drawable.ic_dtc, R.drawable.ic_obd, R.drawable.ic_port};

    @Override
    public int getLayoutByXml() {
        return R.layout.fragment_tools_engine;
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
}
