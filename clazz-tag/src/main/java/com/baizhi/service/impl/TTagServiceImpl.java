package com.baizhi.service.impl;

import com.baizhi.dao.TTagDao;
import com.baizhi.entity.TTag;
import com.baizhi.service.TTagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (TTag)表服务实现类
 *
 * @author makejava
 * @since 2021-09-10 20:24:32
 */
@Service("tTagService")
public class TTagServiceImpl implements TTagService {
    @Resource
    private TTagDao tTagDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TTag queryById(Integer id) {
        return this.tTagDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param tTag 实例对象
     * @return 实例对象
     */
    @Override
    public TTag insert(TTag tTag) {
        tTag.setCreated_at(new Date());
        this.tTagDao.insert(tTag);
        return tTag;
    }

    /**
     * 修改数据
     *
     * @param tTag 实例对象
     * @return 实例对象
     */
    @Override
    public TTag update(TTag tTag) {
        this.tTagDao.update(tTag);
        return this.queryById(tTag.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tTagDao.deleteById(id) > 0;
    }

    @Override
    public List<TTag> queryAll() {
        return tTagDao.queryAll();
    }
}
