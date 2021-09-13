package com.baizhi.dao;

import com.baizhi.entity.TClazz;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TClazz)表数据库访问层
 *
 * @author makejava
 * @since 2021-09-11 11:18:49
 */
public interface TClazzDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TClazz queryById(Integer id);

    List<TClazz> queryAll();

    /**
     * 统计总行数
     *
     * @param tClazz 查询条件
     * @return 总行数
     */
    long count(TClazz tClazz);

    /**
     * 新增数据
     *
     * @param tClazz 实例对象
     * @return 影响行数
     */
    int insert(TClazz tClazz);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TClazz> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TClazz> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TClazz> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TClazz> entities);

    /**
     * 修改数据
     *
     * @param tClazz 实例对象
     * @return 影响行数
     */
    int update(TClazz tClazz);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

