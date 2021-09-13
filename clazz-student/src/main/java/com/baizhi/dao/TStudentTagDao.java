package com.baizhi.dao;

import com.baizhi.entity.TStudentTag;

import java.util.List;

/**
 * (TStudentTag)表数据库访问层
 *
 * @author makejava
 * @since 2021-09-11 17:17:40
 */
public interface TStudentTagDao {

    /**
     * 通过ID查询单条数据
     *
     * @param sid 主键
     * @return 实例对象
     */
    List<TStudentTag> queryById(Integer sid);

    int insert(TStudentTag tStudentTag);

}

