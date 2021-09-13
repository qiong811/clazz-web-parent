package com.baizhi.dao;

import com.baizhi.entity.TGroup;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("GROUPS")
public interface GroupClient {
    @GetMapping("/groups/{id}")
    public ResponseEntity<TGroup> queryById(@PathVariable("id") Integer id);
}
