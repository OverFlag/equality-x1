package com.equality.xutils.model;

/**
 * Created by 46786 on 2018/3/24.
 */

public class BluetoothBean {
    private int type;
    private int state;
    private String name;
    private int level;

    public BluetoothBean(String name, int state) {
        this.name = name;
        this.state = state;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
