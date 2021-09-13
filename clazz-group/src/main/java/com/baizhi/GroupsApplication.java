package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@MapperScan("com.baizhi.dao")
public class GroupsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GroupsApplication.class, args);
    }
}
