package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Arrays;
import java.util.Date;

public class Student {
    private String name;
    private String qq;
    private String phone;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT-8")
    private Date bir;
    private String mark;
    private Integer clazzId;
    private Integer groupId;
    private Integer cityId;
    private Integer[] tagIds;

    public Student() {
    }

    public Student(String name, String qq, String phone, Date bir, String mark, Integer clazzId, Integer groupId, Integer cityId, Integer[] tagIds) {
        this.name = name;
        this.qq = qq;
        this.phone = phone;
        this.bir = bir;
        this.mark = mark;
        this.clazzId = clazzId;
        this.groupId = groupId;
        this.cityId = cityId;
        this.tagIds = tagIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getClazzId() {
        return clazzId;
    }

    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer[] getTagIds() {
        return tagIds;
    }

    public void setTagIds(Integer[] tagIds) {
        this.tagIds = tagIds;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", qq='" + qq + '\'' +
                ", phone='" + phone + '\'' +
                ", bir=" + bir +
                ", mark='" + mark + '\'' +
                ", clazzId=" + clazzId +
                ", groupId=" + groupId +
                ", cityId=" + cityId +
                ", tagIds=" + Arrays.toString(tagIds) +
                '}';
    }
}
