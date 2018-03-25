package com.equality.xutils.activity.ecu;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.equality.xutils.R;
import com.equality.xutils.adapter.ecu.EcuInfoAdapter;
import com.equality.xutils.common.activity.BaseTitleActivity;
import com.equality.xutils.model.EcuInfoBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by 46786 on 2018/3/24.
 */

public class EcuInfoActivity extends BaseTitleActivity {

    @BindView(R.id.rv)
    RecyclerView rv;

    private EcuInfoAdapter mAdapter;
    private List<EcuInfoBean> mData = new ArrayList<>();

    private String[] keys = {"ECU硬件编号", "ECU应用软件版本", "发动机EOL站", "ECU刷写日期", "ECU测试日期"};
    private String[] values = {"cz2165165165", "v2.15.1221", "001", "2015/01/02", "2015/01/12"};

    @Override
    protected String getTitleString() {
        return "系统信息";
    }

    @Override
    public int getViewByXml() {
        return R.layout.activity_base_list;
    }

    @Override
    public void initView() {
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mAdapter = new EcuInfoAdapter(mData);
        rv.setAdapter(mAdapter);
    }

    @Override
    public void initData() {
        mData.clear();
        for (int i = 0; i < keys.length; i++) {
            mData.add(new EcuInfoBean(keys[i], values[i]));
        }
        mAdapter.notifyDataSetChanged();
    }

}
