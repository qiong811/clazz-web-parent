package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (TTag)实体类
 *
 * @author makejava
 * @since 2021-09-10 20:24:32
 */
public class TTag implements Serializable {
    private static final long serialVersionUID = -38708128781134832L;

    private Integer id;

    private String name;

    private String type;

    private Date created_at;


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

}

