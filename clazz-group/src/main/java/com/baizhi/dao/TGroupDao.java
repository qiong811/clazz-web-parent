package com.baizhi.dao;

import com.baizhi.entity.TGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TGroup)表数据库访问层
 *
 * @author makejava
 * @since 2021-09-11 15:22:46
 */
public interface TGroupDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TGroup queryById(Integer id);

    List<TGroup> queryAll();

    /**
     * 统计总行数
     *
     * @param tGroup 查询条件
     * @return 总行数
     */
    long count(TGroup tGroup);

    /**
     * 新增数据
     *
     * @param tGroup 实例对象
     * @return 影响行数
     */
    int insert(TGroup tGroup);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TGroup> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TGroup> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TGroup> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TGroup> entities);

    /**
     * 修改数据
     *
     * @param tGroup 实例对象
     * @return 影响行数
     */
    int update(TGroup tGroup);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

