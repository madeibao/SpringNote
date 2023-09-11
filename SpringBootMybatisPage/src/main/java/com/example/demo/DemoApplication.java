package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ASUS
 */

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

// http://localhost:8080/getOrderInfoList/?pageNow=2&pageSize=2
// 用PostMan 来进行测试

// 使用原生Limit关键字进行分页