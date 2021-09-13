package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (TGroup)实体类
 *
 * @author makejava
 * @since 2021-09-11 15:22:46
 */
public class TGroup implements Serializable {
    private static final long serialVersionUID = -11709405055699547L;

    private Integer id;

    private String name;

    private Date created_at;

    private TClazz clazz;

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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public TClazz getClazz() {
        return clazz;
    }

    public void setClazz(TClazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "TGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created_at=" + created_at +
                ", clazz=" + clazz +
                '}';
    }
}

