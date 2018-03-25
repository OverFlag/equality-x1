package com.equality.xutils.activity.can;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.equality.xutils.R;
import com.equality.xutils.adapter.can.CanGridAdapter;
import com.equality.xutils.common.activity.BaseTitleActivity;
import com.equality.xutils.model.BaseGridBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by 46786 on 2018/3/24.
 */

public class CanTestActivity extends BaseTitleActivity {

    @BindView(R.id.rvGrid)
    RecyclerView rvGrid;

    private List<BaseGridBean> mData = new ArrayList<>();
    private CanGridAdapter mAdapter;

    private String[] names = {
            "压缩测试", "怠速比较测试", "高速测试", "加速测试",
            "断缸测试", "流量统计单元测试", "启动故障信息", "其他测试"
    };

    @Override
    protected String getTitleString() {
        return "总线监控";
    }

    @Override
    public int getViewByXml() {
        return R.layout.activity_can_test;
    }

    @Override
    public void initView() {
        rvGrid.setLayoutManager(new GridLayoutManager(this, 2));
        mAdapter = new CanGridAdapter(mData);
        rvGrid.setAdapter(mAdapter);
    }

    @Override
    public void initData() {
        mData.clear();
        for (int i = 0; i < names.length; i++) {
            BaseGridBean item = new BaseGridBean(names[i]);
            mData.add(item);
        }
        mAdapter.notifyDataSetChanged();
    }
}
