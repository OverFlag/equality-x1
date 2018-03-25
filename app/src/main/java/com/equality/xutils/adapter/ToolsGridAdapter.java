package com.equality.xutils.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.equality.xutils.R;
import com.equality.xutils.model.BaseGridBean;

import java.util.List;

/**
 * Created by 46786 on 2018/3/23.
 */
public class ToolsGridAdapter extends BaseQuickAdapter<BaseGridBean, BaseViewHolder> {

    public ToolsGridAdapter(@Nullable List<BaseGridBean> data) {
        super(R.layout.item_tools, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BaseGridBean item) {
        helper.setText(R.id.tvTxt, item.getName())
                .setImageResource(R.id.ivIcon, item.getResId());
    }
}
