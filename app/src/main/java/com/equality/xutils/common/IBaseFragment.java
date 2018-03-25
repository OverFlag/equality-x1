package com.equality.xutils.common;

import android.os.Bundle;

/**
 * Created by xjh1994 on 16/11/8.
 *
 */
public interface IBaseFragment {

    int getLayoutByXml();

    void initArguments(Bundle data);

    void initView();

    void initData();
}
