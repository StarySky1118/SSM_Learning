package com.zzy.mybatisx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zzy.mybatisx.mapper")
public class Mybatis002MybatisXApplication {

    public static void main(String[] args) {
        SpringApplication.run(Mybatis002MybatisXApplication.class, args);
    }

}
