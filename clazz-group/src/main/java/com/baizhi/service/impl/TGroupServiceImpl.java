package com.baizhi.service.impl;

import com.baizhi.dao.ClazzsClient;
import com.baizhi.dao.TGroupDao;
import com.baizhi.entity.TClazz;
import com.baizhi.entity.TGroup;
import com.baizhi.service.TGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (TGroup)表服务实现类
 *
 * @author makejava
 * @since 2021-09-11 15:22:46
 */
@Service("tGroupService")
public class TGroupServiceImpl implements TGroupService {
    @Resource
    private TGroupDao tGroupDao;
    @Autowired
    private ClazzsClient clazzsClient;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TGroup queryById(Integer id) {
        TGroup group = this.tGroupDao.queryById(id);
        ResponseEntity<TClazz> tClazzResponseEntity = clazzsClient.queryById(group.getClazz().getId());
        TClazz clazz = tClazzResponseEntity.getBody();
        group.setClazz(clazz);
        return group;
    }

    @Override
    public List<TGroup> queryAll() {
        List<TGroup> groups = tGroupDao.queryAll();
        for (int i = 0; i < groups.size(); i++) {
            TGroup group = groups.get(i);
            ResponseEntity<TClazz> tClazzResponseEntity = clazzsClient.queryById(group.getClazz().getId());
            TClazz clazz = tClazzResponseEntity.getBody();
            group.setClazz(clazz);
        }
        return groups;
    }


    /**
     * 新增数据
     *
     * @param tGroup 实例对象
     * @return 实例对象
     */
    @Override
    public TGroup insert(TGroup tGroup) {
        tGroup.setCreated_at(new Date());
        this.tGroupDao.insert(tGroup);
        return tGroup;
    }

    /**
     * 修改数据
     *
     * @param tGroup 实例对象
     * @return 实例对象
     */
    @Override
    public TGroup update(TGroup tGroup) {
        this.tGroupDao.update(tGroup);
        return this.queryById(tGroup.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tGroupDao.deleteById(id) > 0;
    }
}
