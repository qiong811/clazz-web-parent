package com.baizhi.controller;

import com.baizhi.entity.TTag;
import com.baizhi.service.TTagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TTag)表控制层
 *
 * @author makejava
 * @since 2021-09-10 20:24:32
 */
@RestController
@RequestMapping("tags")
public class TTagController {
    /**
     * 服务对象
     */
    @Resource
    private TTagService tTagService;

    @GetMapping
    public ResponseEntity<List<TTag>> queryAll() {
        return new ResponseEntity<>(tTagService.queryAll(), HttpStatus.OK);
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    //查一个
    @GetMapping("{id}")
    public ResponseEntity<TTag> queryById(@PathVariable("id") Integer id) {
        TTag tag = this.tTagService.queryById(id);
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    /**
     * 新增数据
     *
     * @param tTag 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TTag> add(@RequestBody TTag tTag) {
        TTag tag = this.tTagService.insert(tTag);
        return new ResponseEntity<>(tag, HttpStatus.CREATED);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
        this.tTagService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * 编辑数据
     *
     * @param tTag 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TTag> edit(TTag tTag) {
        return ResponseEntity.ok(this.tTagService.update(tTag));
    }


}

