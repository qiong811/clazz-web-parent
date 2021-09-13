package com.baizhi.service.impl;

import com.baizhi.dao.*;
import com.baizhi.entity.TStudent;
import com.baizhi.entity.TStudentTag;
import com.baizhi.entity.TTag;
import com.baizhi.service.TStudentService;
import com.baizhi.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * (TStudent)表服务实现类
 *
 * @author makejava
 * @since 2021-09-11 16:26:42
 */
@Service("tStudentService")
public class TStudentServiceImpl implements TStudentService {
    private TStudentTagDao tStudentTagDao;
    private TStudentDao tStudentDao;
    private ClazzsClient clazzsClient;
    private GroupClient groupClient;
    private CityClient cityClient;
    private TagClient tagClient;

    @Autowired
    public TStudentServiceImpl(TStudentTagDao tStudentTagDao, TStudentDao tStudentDao, ClazzsClient clazzsClient, GroupClient groupClient, CityClient cityClient, TagClient tagClient) {
        this.tStudentTagDao = tStudentTagDao;
        this.tStudentDao = tStudentDao;
        this.clazzsClient = clazzsClient;
        this.groupClient = groupClient;
        this.cityClient = cityClient;
        this.tagClient = tagClient;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TStudent queryById(Integer id) {
        TStudent student = this.tStudentDao.queryById(id);
        return student;
    }

    @Override
    public List<TStudent> queryAll() {
        List<TStudent> students = tStudentDao.queryAll();
        students.forEach(student -> {
            Date bir = student.getBir();
            if (!ObjectUtils.isEmpty(bir)) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(bir);
                student.setAge(DateUtil.date2Age(cal));
                student.setStarts(DateUtil.date2Constellation(cal));
                student.setAttr(DateUtil.date2Zodica(cal));
            }
            if (student.getClazz().getId() != null) {
                student.setClazz(clazzsClient.queryById(student.getClazz().getId()).getBody());

            }
            if (student.getGroup().getId() != null) {
                student.setGroup(groupClient.queryById(student.getGroup().getId()).getBody());
            }
            if (student.getCity().getId() != null) {
                student.setCity(cityClient.queryById(student.getCity().getId()).getBody());
            }
            List<TStudentTag> stags = tStudentTagDao.queryById(student.getId());
            if (!ObjectUtils.isEmpty(stags)) {
                List<TTag> tags = new ArrayList<>();
                stags.forEach(stag -> {
                    ResponseEntity<TTag> tTagResponseEntity = tagClient.queryById(stag.getTid());
                    TTag tag = tTagResponseEntity.getBody();
                    tags.add(tag);
                });
                student.setTags(tags);
            }

        });
        return students;
    }


    /**
     * 新增数据
     *
     * @param tStudent 实例对象
     * @return 实例对象
     */
    @Override
    public TStudent insert(TStudent tStudent) {
        this.tStudentDao.insert(tStudent);
        List<TTag> tags = tStudent.getTags();
        if (!ObjectUtils.isEmpty(tags)) {
            tags.forEach(tag -> {
                TStudentTag tStudentTag = new TStudentTag();
                tStudentTag.setSid(tStudent.getId());
                tStudentTag.setTid(tag.getId());
                System.out.println(tStudentTag);
                tStudentTagDao.insert(tStudentTag);
            });
        }

        return tStudent;
    }

    /**
     * 修改数据
     *
     * @param tStudent 实例对象
     * @return 实例对象
     */
    @Override
    public TStudent update(TStudent tStudent) {
        this.tStudentDao.update(tStudent);
        return this.queryById(tStudent.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tStudentDao.deleteById(id) > 0;
    }
}
