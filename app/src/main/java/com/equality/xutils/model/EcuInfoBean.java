package com.equality.xutils.model;

/**
 * Created by 46786 on 2018/3/24.
 */

public class EcuInfoBean {
    private String key;
    private String value;

    public EcuInfoBean(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
