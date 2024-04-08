package com.learn.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan({"com.learn.mybatis.repository"})
public class RoledemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(RoledemoApplication.class, args);
    }
}