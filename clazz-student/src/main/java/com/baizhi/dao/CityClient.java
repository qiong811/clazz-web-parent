package com.baizhi.dao;

import com.baizhi.entity.TCity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("CITYS")
public interface CityClient {
    @GetMapping("/cities/{id}")
    public ResponseEntity<TCity> queryById(@PathVariable("id") Integer id);
}
