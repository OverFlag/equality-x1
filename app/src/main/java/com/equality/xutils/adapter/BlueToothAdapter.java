package com.equality.xutils.adapter;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.equality.xutils.R;
import com.equality.xutils.common.entity.CusSectionEntity;
import com.equality.xutils.model.BluetoothBean;

import java.util.List;

/**
 * Created by 46786 on 2018/3/24.
 */

public class BlueToothAdapter extends BaseSectionQuickAdapter<CusSectionEntity<BluetoothBean>, BaseViewHolder> {

    public BlueToothAdapter(List<CusSectionEntity<BluetoothBean>> data) {
        super(R.layout.item_bluetooth, R.layout.item_bluetooth_title, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, CusSectionEntity<BluetoothBean> item) {
        if (item.isHeader()) {
            helper.setText(R.id.tvTitle, item.getHeader());
        }
    }

    @Override
    protected void convert(BaseViewHolder helper, CusSectionEntity<BluetoothBean> item) {
        if (!item.isHeader()) {
            BluetoothBean bean = item.getT();
            helper.setText(R.id.tvName, bean.getName());

            // 状态
            int state = bean.getState();
            if (state == 1) {
                helper.setGone(R.id.tvState, true);
            } else {
                helper.setGone(R.id.tvState, false);
            }
            // 类型
            int type = bean.getType();
            if (type == 1) {

            } else {

            }
        }
    }
}
