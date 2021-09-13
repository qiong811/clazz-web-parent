package com.baizhi.entity;

import java.io.Serializable;

/**
 * (TClazz)实体类
 *
 * @author makejava
 * @since 2021-09-11 11:18:49
 */
public class TClazz implements Serializable {
    private static final long serialVersionUID = -53828382023372640L;

    private Integer id;

    private String name;

    private String path;

    private TTag tag;


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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public TTag getTag() {
        return tag;
    }

    public void setTag(TTag tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "TClazz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", tag=" + tag +
                '}';
    }
}

