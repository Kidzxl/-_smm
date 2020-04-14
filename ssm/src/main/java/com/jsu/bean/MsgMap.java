package com.jsu.bean;

import java.io.Serializable;

public class MsgMap implements Serializable {
    private Object name;
    private Object value;

    public MsgMap(Object name, Object value) {
        this.name = name;
        this.value = value;
    }

    public Object getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
