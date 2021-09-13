package com.baizhi.service;

import com.baizhi.entity.TCity;

import java.util.List;


/**
 * (TCity)表服务接口
 *
 * @author makejava
 * @since 2021-09-10 20:19:53
 */
public interface TCityService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TCity queryById(Integer id);

    //查所有
    List<TCity> queryAll();

    /**
     * 新增数据
     *
     * @param tCity 实例对象
     * @return 实例对象
     */
    TCity insert(TCity tCity);

    /**
     * 修改数据
     *
     * @param tCity 实例对象
     * @return 实例对象
     */
    TCity update(TCity tCity);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
