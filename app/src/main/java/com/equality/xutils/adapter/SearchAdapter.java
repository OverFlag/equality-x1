package com.equality.xutils.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.equality.xutils.model.SearchBean;

import java.util.List;

/**
 * Created by 46786 on 2018/3/24.
 */

public class SearchAdapter extends BaseQuickAdapter<SearchBean, BaseViewHolder> {

    public SearchAdapter(@Nullable List<SearchBean> data) {
        // TODO  super
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchBean item) {

    }
}
