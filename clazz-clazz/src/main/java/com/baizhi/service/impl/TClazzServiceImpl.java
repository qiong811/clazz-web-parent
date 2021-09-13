package com.baizhi.service.impl;

import com.baizhi.dao.TClazzDao;
import com.baizhi.dao.TagClient;
import com.baizhi.entity.TClazz;
import com.baizhi.entity.TTag;
import com.baizhi.service.TClazzService;
import com.baizhi.util.AliYun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TClazz)表服务实现类
 *
 * @author makejava
 * @since 2021-09-11 11:18:49
 */
@Service("tClazzService")
public class TClazzServiceImpl implements TClazzService {
    @Resource
    private TClazzDao tClazzDao;
    @Autowired
    private TagClient tagClient;


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TClazz queryById(Integer id) {
        TClazz clazz = this.tClazzDao.queryById(id);
        ResponseEntity<TTag> tTagResponseEntity = tagClient.queryById(clazz.getTag().getId());
        TTag tag = tTagResponseEntity.getBody();
        clazz.setTag(tag);
        return clazz;
    }

    @Override
    public List<TClazz> queryAll() {
        List<TClazz> clazzes = tClazzDao.queryAll();
        for (int i = 0; i < clazzes.size(); i++) {
            TClazz clazz = clazzes.get(i);
            String[] split = clazz.getPath().split("com/");
            AliYun.testDownLoad(split[1]);
            clazz.setPath("D:\\headimg\\" + split[1]);
            Integer id = clazz.getTag().getId();
            ResponseEntity<TTag> tTagResponseEntity = tagClient.queryById(id);
            TTag tag = tTagResponseEntity.getBody();
            clazz.setTag(tag);
        }
        return clazzes;
    }


    /**
     * 新增数据
     *
     * @param tClazz 实例对象
     * @return 实例对象
     */
    @Override
    public TClazz insert(TClazz tClazz) {
        this.tClazzDao.insert(tClazz);
        return tClazz;
    }

    /**
     * 修改数据
     *
     * @param tClazz 实例对象
     * @return 实例对象
     */
    @Override
    public TClazz update(TClazz tClazz) {
        this.tClazzDao.update(tClazz);
        return this.queryById(tClazz.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tClazzDao.deleteById(id) > 0;
    }
}
