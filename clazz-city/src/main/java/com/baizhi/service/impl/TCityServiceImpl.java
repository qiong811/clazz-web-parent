package com.baizhi.service.impl;

import com.baizhi.dao.TCityDao;
import com.baizhi.entity.TCity;
import com.baizhi.service.TCityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TCity)表服务实现类
 *
 * @author makejava
 * @since 2021-09-10 20:19:53
 */
@Service("tCityService")
public class TCityServiceImpl implements TCityService {
    @Resource
    private TCityDao tCityDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TCity queryById(Integer id) {
        return this.tCityDao.queryById(id);
    }

    @Override
    public List<TCity> queryAll() {
        return tCityDao.queryAll();
    }

    /**
     * 分页查询
     *
     * @param tCity       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */


    /**
     * 新增数据
     *
     * @param tCity 实例对象
     * @return 实例对象
     */
    @Override
    public TCity insert(TCity tCity) {
        this.tCityDao.insert(tCity);
        return tCity;
    }

    /**
     * 修改数据
     *
     * @param tCity 实例对象
     * @return 实例对象
     */
    @Override
    public TCity update(TCity tCity) {
        this.tCityDao.update(tCity);
        return this.queryById(tCity.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tCityDao.deleteById(id) > 0;
    }
}
