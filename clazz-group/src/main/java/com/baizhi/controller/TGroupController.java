package com.baizhi.controller;

import com.baizhi.entity.GroupClazz;
import com.baizhi.entity.TClazz;
import com.baizhi.entity.TGroup;
import com.baizhi.service.TGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TGroup)表控制层
 *
 * @author makejava
 * @since 2021-09-11 15:22:46
 */
@RestController
@RequestMapping("groups")
public class TGroupController {
    /**
     * 服务对象
     */
    @Resource
    private TGroupService tGroupService;

    @GetMapping
    public ResponseEntity<List<TGroup>> queryAll() {
        return new ResponseEntity<>(tGroupService.queryAll(), HttpStatus.OK);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TGroup> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tGroupService.queryById(id));
    }


    @PostMapping
    public ResponseEntity<TGroup> add(@RequestBody GroupClazz groupClazz) {
        System.out.println(groupClazz);
        TGroup tGroup = new TGroup();
        tGroup.setName(groupClazz.getName());
        TClazz clazz = new TClazz();
        clazz.setId(groupClazz.getClazzId());
        tGroup.setClazz(clazz);
        return new ResponseEntity(this.tGroupService.insert(tGroup), HttpStatus.CREATED);
    }

    /**
     * 编辑数据
     *
     * @param tGroup 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TGroup> edit(TGroup tGroup) {
        return ResponseEntity.ok(this.tGroupService.update(tGroup));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tGroupService.deleteById(id));
    }

}

