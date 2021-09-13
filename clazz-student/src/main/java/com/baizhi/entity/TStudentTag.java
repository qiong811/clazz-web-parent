package com.baizhi.entity;

import java.io.Serializable;

/**
 * (TStudentTag)实体类
 *
 * @author makejava
 * @since 2021-09-11 17:17:40
 */
public class TStudentTag implements Serializable {
    private static final long serialVersionUID = -42375408639834201L;

    private Integer sid;

    private Integer tid;


    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public TStudentTag() {
    }

    public TStudentTag(Integer sid, Integer tid) {
        this.sid = sid;
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "TStudentTag{" +
                "sid=" + sid +
                ", tid=" + tid +
                '}';
    }
}

