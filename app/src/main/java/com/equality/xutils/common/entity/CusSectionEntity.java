package com.equality.xutils.common.entity;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by 46786 on 2018/3/24.
 */

public class CusSectionEntity<T> extends SectionEntity<T> {

    public CusSectionEntity(T t) {
        super(t);
    }

    public CusSectionEntity(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
        isHeader = header;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
