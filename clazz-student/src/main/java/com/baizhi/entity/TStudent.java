package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (TStudent)实体类
 *
 * @author makejava
 * @since 2021-09-11 16:26:42
 */
@JsonInclude(JsonInclude.Include.NON_NULL)//空值不返回
public class TStudent implements Serializable {
    private static final long serialVersionUID = 646652388905398174L;

    private Integer id;

    private String name;

    private Integer age;

    private String qq;

    private String phone;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT-8")
    private Date bir;

    private String starts;

    private String attr;

    private String mark;

    private TClazz clazz;

    private TGroup group;

    private TCity city;
    private List<TTag> tags;

    public TStudent() {
    }

    public TStudent(Integer id, String name, Integer age, String qq, String phone, Date bir, String starts, String attr, String mark, TClazz clazz, TGroup group, TCity city, List<TTag> tags) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.qq = qq;
        this.phone = phone;
        this.bir = bir;
        this.starts = starts;
        this.attr = attr;
        this.mark = mark;
        this.clazz = clazz;
        this.group = group;
        this.city = city;
        this.tags = tags;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getStarts() {
        return starts;
    }

    public void setStarts(String starts) {
        this.starts = starts;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public TClazz getClazz() {
        return clazz;
    }

    public void setClazz(TClazz clazz) {
        this.clazz = clazz;
    }

    public TGroup getGroup() {
        return group;
    }

    public void setGroup(TGroup group) {
        this.group = group;
    }

    public TCity getCity() {
        return city;
    }

    public void setCity(TCity city) {
        this.city = city;
    }

    public List<TTag> getTags() {
        return tags;
    }

    public void setTags(List<TTag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "TStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", qq='" + qq + '\'' +
                ", phone='" + phone + '\'' +
                ", bir=" + bir +
                ", starts='" + starts + '\'' +
                ", attr='" + attr + '\'' +
                ", mark='" + mark + '\'' +
                ", clazz=" + clazz +
                ", group=" + group +
                ", city=" + city +
                ", tags=" + tags +
                '}';
    }
}

