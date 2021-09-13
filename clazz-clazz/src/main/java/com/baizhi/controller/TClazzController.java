package com.baizhi.controller;

import com.baizhi.entity.TClazz;
import com.baizhi.entity.TTag;
import com.baizhi.service.TClazzService;
import com.baizhi.util.AliYun;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * (TClazz)表控制层
 *
 * @author makejava
 * @since 2021-09-11 11:18:49
 */
@RestController
@RequestMapping("/clazzs")
public class TClazzController {
    /**
     * 服务对象
     */
    @Resource
    private TClazzService tClazzService;

    @GetMapping
    public ResponseEntity<List<TClazz>> queryAll() {
        List<TClazz> clazzes = tClazzService.queryAll();
        return new ResponseEntity<>(clazzes, HttpStatus.OK);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TClazz> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tClazzService.queryById(id));
    }


    @PostMapping
    public ResponseEntity<TClazz> add(MultipartFile logo, @RequestParam("name") String name, @RequestParam("tagid") int tagid) {
        TClazz tClazz = new TClazz();
        try {

            tClazz.setName(name);
            TTag tag = new TTag();
            tag.setId(tagid);
            tClazz.setTag(tag);
            String path = AliYun.uploadPhoto(logo);
            tClazz.setPath("http://clazzweb.oss-cn-beijing.aliyuncs.com/" + path);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(this.tClazzService.insert(tClazz), HttpStatus.CREATED);
    }

    /**
     * 编辑数据
     *
     * @param tClazz 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TClazz> edit(TClazz tClazz) {
        return ResponseEntity.ok(this.tClazzService.update(tClazz));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
        this.tClazzService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

