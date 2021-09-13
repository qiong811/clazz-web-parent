package com.baizhi.entity;

import java.io.Serializable;

/**
 * (TCity)实体类
 *
 * @author makejava
 * @since 2021-09-10 20:19:53
 */
public class TCity implements Serializable {
    private static final long serialVersionUID = -87641016656997079L;

    private Integer id;

    private String name;


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

    @Override
    public String toString() {
        return "TCity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

