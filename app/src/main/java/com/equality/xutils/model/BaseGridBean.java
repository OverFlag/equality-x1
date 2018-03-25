package com.equality.xutils.model;

/**
 * Created by 46786 on 2018/3/23.
 */

public class BaseGridBean {
    private String name;
    private int resId;

    public BaseGridBean(String name) {
        this.name = name;
    }

    public BaseGridBean(String name, int resId) {
        this.name = name;
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
