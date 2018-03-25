package com.equality.xutils.model;

/**
 * Created by 46786 on 2018/3/25.
 */

public class EcuCodeBean {
    private String code;
    private String describe;
    private String state;

    public EcuCodeBean(String code, String describe, String state) {
        this.code = code;
        this.describe = describe;
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
