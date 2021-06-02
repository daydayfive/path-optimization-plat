package com.cqu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cqu.mapper")
public class TransferOrderWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransferOrderWebApplication.class, args);
    }

}
