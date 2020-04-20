package com.happier.flowering;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.happier.flowering.mapper")
@EnableScheduling
public class FloweringApplication {

    public static void main(String[] args) {
        SpringApplication.run(FloweringApplication.class, args);
    }

}
