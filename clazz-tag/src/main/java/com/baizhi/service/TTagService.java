package com.baizhi.service;

import com.baizhi.entity.TTag;

import java.util.List;

/**
 * (TTag)表服务接口
 *
 * @author makejava
 * @since 2021-09-10 20:24:32
 */
public interface TTagService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TTag queryById(Integer id);


    /**
     * 新增数据
     *
     * @param tTag 实例对象
     * @return 实例对象
     */
    TTag insert(TTag tTag);

    /**
     * 修改数据
     *
     * @param tTag 实例对象
     * @return 实例对象
     */
    TTag update(TTag tTag);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<TTag> queryAll();

}
