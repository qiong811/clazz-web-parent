package com.baizhi.service;

import com.baizhi.entity.TClazz;

import java.util.List;


/**
 * (TClazz)表服务接口
 *
 * @author makejava
 * @since 2021-09-11 11:18:49
 */
public interface TClazzService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TClazz queryById(Integer id);

    List<TClazz> queryAll();

    /**
     * 新增数据
     *
     * @param tClazz 实例对象
     * @return 实例对象
     */
    TClazz insert(TClazz tClazz);

    /**
     * 修改数据
     *
     * @param tClazz 实例对象
     * @return 实例对象
     */
    TClazz update(TClazz tClazz);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
