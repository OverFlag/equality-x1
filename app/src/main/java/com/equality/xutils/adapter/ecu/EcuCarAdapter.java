package com.equality.xutils.adapter.ecu;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.equality.xutils.R;
import com.equality.xutils.model.BaseGridBean;

import java.util.List;

/**
 * Created by 46786 on 2018/3/24.
 */

public class EcuCarAdapter extends BaseQuickAdapter<BaseGridBean, BaseViewHolder> {

    public EcuCarAdapter(@Nullable List<BaseGridBean> data) {
        super(R.layout.item_ecu_car, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BaseGridBean item) {
        helper.setImageResource(R.id.ivIcon, item.getResId())
                .setText(R.id.tvTxt, item.getName());
    }
}