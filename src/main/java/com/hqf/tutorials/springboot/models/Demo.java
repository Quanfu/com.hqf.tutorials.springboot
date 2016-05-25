package com.hqf.tutorials.springboot.models;

/**
 * Created by huoquanfu on 2016/5/25.
 */
public class Demo {
    private long id;//主键.
    private String name;//测试名称.

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}