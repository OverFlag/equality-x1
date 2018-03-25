package com.equality.xutils.model;

/**
 * Created by 46786 on 2018/3/24.
 */

public class WifiBean {
    private String name;
    private String level;

    public WifiBean() {
    }

    public WifiBean(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
