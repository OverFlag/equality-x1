package com.equality.xutils.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.equality.xutils.R;
import com.equality.xutils.model.WifiBean;

import java.util.List;

/**
 * Created by 46786 on 2018/3/24.
 */

public class WifiAdapter extends BaseQuickAdapter<WifiBean, BaseViewHolder> {

    private int selectPosition = -1;

    public WifiAdapter(@Nullable List<WifiBean> data) {
        super(R.layout.item_wifi, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WifiBean item) {
        int position = helper.getLayoutPosition();
        if (position == selectPosition) {
            helper.setVisible(R.id.llNormal, false)
                    .setVisible(R.id.llSelect, true);

        } else {
            helper.setVisible(R.id.llNormal, true)
                    .setVisible(R.id.llSelect, false);

        }
    }

    public void setSelectPosition(int selectPosition) {
        this.selectPosition = selectPosition;
    }
}
