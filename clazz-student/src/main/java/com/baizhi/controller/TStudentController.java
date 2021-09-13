package com.baizhi.controller;

import com.baizhi.entity.*;
import com.baizhi.service.TStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (TStudent)表控制层
 *
 * @author makejava
 * @since 2021-09-11 16:26:42
 */
@RestController
@RequestMapping("students")
public class TStudentController {
    /**
     * 服务对象
     */
    @Resource
    private TStudentService tStudentService;

    @GetMapping
    public ResponseEntity<List<TStudent>> queryAll() {
        List<TStudent> students = tStudentService.queryAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")

    public ResponseEntity<TStudent> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tStudentService.queryById(id));
    }


    @PostMapping
    public ResponseEntity<TStudent> add(@RequestBody Student student) {
        TStudent tStudent = new TStudent();
//        BeanUtils.copyProperties(student, tStudent);
        tStudent.setName(student.getName());
        tStudent.setQq(student.getQq());
        tStudent.setPhone(student.getPhone());
        tStudent.setBir(student.getBir());
        tStudent.setMark(student.getMark());
        TClazz clazz = new TClazz();
        clazz.setId(student.getClazzId());
        tStudent.setClazz(clazz);
        TGroup group = new TGroup();
        group.setId(student.getGroupId());
        tStudent.setGroup(group);
        TCity city = new TCity();
        city.setId(student.getCityId());
        tStudent.setCity(city);
        List<TTag> tags = new ArrayList<>();
        Integer[] tagIds = student.getTagIds();

        for (Integer tagId : tagIds) {
            TTag tag = new TTag();
            tag.setId(tagId);
            tags.add(tag);
        }
        tStudent.setTags(tags);
        return new ResponseEntity(this.tStudentService.insert(tStudent), HttpStatus.CREATED);
    }

    /**
     * 编辑数据
     *
     * @param tStudent 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TStudent> edit(TStudent tStudent) {
        return ResponseEntity.ok(this.tStudentService.update(tStudent));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tStudentService.deleteById(id));
    }

}

