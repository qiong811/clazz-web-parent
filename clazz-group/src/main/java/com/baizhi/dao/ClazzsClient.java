package com.baizhi.dao;

import com.baizhi.entity.TClazz;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("CLAZZS")
public interface ClazzsClient {
    @GetMapping("/clazzs/{id}")
    public ResponseEntity<TClazz> queryById(@PathVariable("id") Integer id);
}
