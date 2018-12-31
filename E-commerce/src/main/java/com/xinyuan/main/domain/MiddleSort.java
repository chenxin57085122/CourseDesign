package com.xinyuan.main.domain;

public class MiddleSort {
    private Integer id;

    private Integer largeId;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLargeId() {
        return largeId;
    }

    public void setLargeId(Integer largeId) {
        this.largeId = largeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}