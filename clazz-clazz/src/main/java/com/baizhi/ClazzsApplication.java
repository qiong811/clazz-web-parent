package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@MapperScan("com.baizhi.dao")
public class ClazzsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClazzsApplication.class, args);
    }
}
