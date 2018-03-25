package com.equality.xutils.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.equality.xutils.R;
import com.equality.xutils.adapter.SearchAdapter;
import com.equality.xutils.common.activity.BaseActivity;
import com.equality.xutils.model.SearchBean;
import com.equality.xutils.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by 46786 on 2018/3/24.
 */

public class SearchActivity extends BaseActivity implements
        BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.OnItemChildClickListener {

    @BindView(R.id.etSearch)
    EditText etSearch;
    @BindView(R.id.tvCancel)
    TextView tvCancel;
    @BindView(R.id.rvExpert)
    RecyclerView rvExpert;

    private SearchAdapter mAdapter;
    private List<SearchBean> mData = new ArrayList<>();

    public static void newInstacne(Context context) {
        context.startActivity(new Intent(context, SearchActivity.class));
    }

    @Override
    public int getViewByXml() {
        return R.layout.activity_search;
    }

    @Override
    public void initView() {
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftKeyboard();
                finish();
            }
        });

        mAdapter = new SearchAdapter(mData);
        mAdapter.setOnItemClickListener(this);
        mAdapter.setOnItemChildClickListener(this);
        rvExpert.setLayoutManager(new LinearLayoutManager(this));
        rvExpert.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvExpert.setAdapter(mAdapter);

        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    if (TextUtils.isEmpty(etSearch.getText().toString().trim())) {
                        ToastUtils.show(SearchActivity.this, "请输入您需要查找的信息");
                    }
                    return true;
                }
                return false;
            }
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String key = s.toString();
                if (key.length() > 0) {
                    mData.clear();
                    mAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int position) {

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int position) {

    }

}
