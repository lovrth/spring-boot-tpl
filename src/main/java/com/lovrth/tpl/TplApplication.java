package com.lovrth.tpl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.lovrth.tpl.v1.mapper"})
public class TplApplication {

    public static void main(String[] args) {
        SpringApplication.run(TplApplication.class, args);
    }

}
