package com.equality.xutils.activity.ecu;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.equality.xutils.R;
import com.equality.xutils.adapter.ecu.EcuDataAdapter;
import com.equality.xutils.common.activity.BaseTitleActivity;
import com.equality.xutils.model.EcuCodeBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by 46786 on 2018/3/25.
 * 故障码列表
 */
public class EcuCodeActivity extends BaseTitleActivity {

    @BindView(R.id.rv)
    RecyclerView rv;

    private EcuDataAdapter mAdapter;
    private List<EcuCodeBean> mData = new ArrayList<>();

    private String[] code = {
            "0281", "02B4", "027B", "0233", "02BF", "00E9", "00A6", "00A2"};
    private String[] describe = {
            "SCR尿素喷嘴驱动高端对电源短路", "尿素泵压力传感器电压信号高于上限",
            "SCR催化剂上游温度传感器电压高于上限", "尿素液位传感器电压高于上限",
            "尿素液温度传感器电压高于上限", "环境温度传感器电压高于上限",
            "尿素泵箱加热继电磁阀开路", "尿素泵加热继电器开路"};
    private String[] state = {"当前故障", "当前故障", "当前故障", "当前故障",
            "当前故障", "当前故障", "当前故障", "当前故障"};

    @Override
    protected String getTitleString() {
        return "故障码列表";
    }

    @Override
    public int getViewByXml() {
        return R.layout.activity_base_list;
    }

    @Override
    public void initView() {
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mAdapter = new EcuDataAdapter(mData);
        rv.setAdapter(mAdapter);
    }

    @Override
    public void initData() {
        mData.clear();
        for (int i = 0; i < code.length; i++) {
            mData.add(new EcuCodeBean(code[i], describe[i], state[i]));
        }
        mAdapter.notifyDataSetChanged();
    }
}
