package com.equality.xutils.adapter.ecu;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.equality.xutils.R;
import com.equality.xutils.model.EcuCodeBean;

import java.util.List;

/**
 * Created by 46786 on 2018/3/25.
 */

public class EcuDataAdapter extends BaseQuickAdapter<EcuCodeBean, BaseViewHolder> {

    public EcuDataAdapter(@Nullable List<EcuCodeBean> data) {
        super(R.layout.item_ecu_code, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, EcuCodeBean item) {
        helper.setText(R.id.tvName, item.getCode())
                .setText(R.id.tvNum, item.getDescribe())
                .setText(R.id.tvUnit, item.getState());

    }
}
