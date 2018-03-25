package com.equality.xutils.adapter.ecu;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.equality.xutils.R;
import com.equality.xutils.model.EcuInfoBean;

import java.util.List;

/**
 * Created by 46786 on 2018/3/24.
 */

public class EcuInfoAdapter extends BaseQuickAdapter<EcuInfoBean, BaseViewHolder> {

    public EcuInfoAdapter(@Nullable List<EcuInfoBean> data) {
        super(R.layout.item_ecu_info, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, EcuInfoBean item) {
        helper.setText(R.id.tvKey, item.getKey())
                .setText(R.id.tvValue, item.getValue());
    }
}
