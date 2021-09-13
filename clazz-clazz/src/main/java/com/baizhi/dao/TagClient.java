package com.baizhi.dao;

import com.baizhi.entity.TTag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("TAGS")
public interface TagClient {
    @GetMapping("/tags/{id}")
    public ResponseEntity<TTag> queryById(@PathVariable("id") Integer id);
}
