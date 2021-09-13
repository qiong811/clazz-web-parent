package com.baizhi.controller;

import com.baizhi.entity.TCity;
import com.baizhi.service.TCityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TCity)表控制层
 *
 * @author makejava
 * @since 2021-09-10 20:19:53
 */
@RestController
@RequestMapping("/cities")
public class TCityController {
    /**
     * 服务对象
     */
    @Resource
    private TCityService tCityService;

    @GetMapping
    public ResponseEntity<List<TCity>> queryAll() {
        List<TCity> list = tCityService.queryAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TCity> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tCityService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tCity 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TCity> add(@RequestBody TCity tCity) {
        TCity city = tCityService.insert(tCity);
        return new ResponseEntity<>(city, HttpStatus.CREATED);
    }

    /**
     * 编辑数据
     *
     * @param tCity 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TCity> edit(TCity tCity) {
        return ResponseEntity.ok(this.tCityService.update(tCity));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.tCityService.deleteById(id));
    }

}

