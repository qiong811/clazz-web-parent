package com.baizhi.dao;

import com.baizhi.entity.TTag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TTag)表数据库访问层
 *
 * @author makejava
 * @since 2021-09-10 20:24:32
 */
public interface TTagDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TTag queryById(Integer id);

    List<TTag> queryAll();

    /**
     * 统计总行数
     *
     * @param tTag 查询条件
     * @return 总行数
     */
    long count(TTag tTag);

    /**
     * 新增数据
     *
     * @param tTag 实例对象
     * @return 影响行数
     */
    int insert(TTag tTag);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TTag> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TTag> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TTag> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TTag> entities);

    /**
     * 修改数据
     *
     * @param tTag 实例对象
     * @return 影响行数
     */
    int update(TTag tTag);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

