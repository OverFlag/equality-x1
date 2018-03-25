package com.equality.xutils.activity.ecu;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.equality.xutils.R;
import com.equality.xutils.adapter.ecu.EcuCarAdapter;
import com.equality.xutils.common.activity.BaseTitleActivity;
import com.equality.xutils.model.BaseGridBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by 46786 on 2018/3/24.
 */

public class EcuCarActivity extends BaseTitleActivity {


    @BindView(R.id.rv)
    RecyclerView rv;

    private EcuCarAdapter mAdapter;
    private List<BaseGridBean> mData = new ArrayList<>();

    String[] keys = {
            "发动机启动控制", "进气预加热", "油中有水报警",
            "排期制动", "多态开关", "车上启动停止"};
    Integer[] values = {
            R.drawable.ic_helper, R.drawable.ic_helper, R.drawable.ic_helper,
            R.drawable.ic_helper, R.drawable.ic_helper, R.drawable.ic_helper};

    @Override
    protected String getTitleString() {
        return "整车功能项";
    }

    @Override
    public int getViewByXml() {
        return R.layout.activity_base_list;
    }

    @Override
    public void initView() {
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mAdapter = new EcuCarAdapter(mData);
        rv.setAdapter(mAdapter);
    }

    @Override
    public void initData() {
        mData.clear();
        for (int i = 0; i < keys.length; i++) {
            mData.add(new BaseGridBean(keys[i], values[i]));
        }
        mAdapter.notifyDataSetChanged();
    }

}
