package com.baizhi.entity;

public class GroupClazz {
    private String name;
    private Integer clazzId;

    public GroupClazz() {
    }

    public GroupClazz(String name, Integer clazzId) {
        this.name = name;
        this.clazzId = clazzId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClazzId() {
        return clazzId;
    }

    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }

    @Override
    public String toString() {
        return "GroupClazz{" +
                "name='" + name + '\'' +
                ", clazzId=" + clazzId +
                '}';
    }
}
