package com.gok.smartpark.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//标记扫描的mapper位置
@MapperScan("com.gok.smartpark.sys.mapper")
public class MybatisPlusApplication {

    public static void main(String[] args) {

        SpringApplication.run(MybatisPlusApplication.class, args);

    }

}
