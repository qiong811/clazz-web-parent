package com.baizhi.service;

import com.baizhi.entity.TStudent;

import java.util.List;


/**
 * (TStudent)表服务接口
 *
 * @author makejava
 * @since 2021-09-11 16:26:42
 */
public interface TStudentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TStudent queryById(Integer id);

    List<TStudent> queryAll();

    /**
     * 新增数据
     *
     * @param tStudent 实例对象
     * @return 实例对象
     */
    TStudent insert(TStudent tStudent);

    /**
     * 修改数据
     *
     * @param tStudent 实例对象
     * @return 实例对象
     */
    TStudent update(TStudent tStudent);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
