package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by hadoopuser on 11/2/19.
 */
@SpringBootApplication
@MapperScan("com.example.demo.phoenix.mapper")
public class SpringbootMybatisPhoenixApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisPhoenixApplication.class, args);
    }
}
