package com.baizhi.dao;

import com.baizhi.entity.TCity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TCity)表数据库访问层
 *
 * @author makejava
 * @since 2021-09-10 20:19:53
 */
public interface TCityDao {

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
     * 统计总行数
     *
     * @param tCity 查询条件
     * @return 总行数
     */
    long count(TCity tCity);

    /**
     * 新增数据
     *
     * @param tCity 实例对象
     * @return 影响行数
     */
    int insert(TCity tCity);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TCity> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TCity> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TCity> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TCity> entities);

    /**
     * 修改数据
     *
     * @param tCity 实例对象
     * @return 影响行数
     */
    int update(TCity tCity);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

