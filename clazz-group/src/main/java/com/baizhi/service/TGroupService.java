package com.baizhi.service;

import com.baizhi.entity.TGroup;

import java.util.List;


/**
 * (TGroup)表服务接口
 *
 * @author makejava
 * @since 2021-09-11 15:22:46
 */
public interface TGroupService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TGroup queryById(Integer id);

    List<TGroup> queryAll();

    /**
     * 新增数据
     *
     * @param tGroup 实例对象
     * @return 实例对象
     */
    TGroup insert(TGroup tGroup);

    /**
     * 修改数据
     *
     * @param tGroup 实例对象
     * @return 实例对象
     */
    TGroup update(TGroup tGroup);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
