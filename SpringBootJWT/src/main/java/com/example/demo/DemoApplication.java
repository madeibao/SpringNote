package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

/**
 * @author ASUS
 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        String substring = UUID.randomUUID().toString().toUpperCase().replaceAll("-", "").substring(0,10);
        System.out.println(substring);
    }

}

//   http://localhost:8080/user/login?name=马远&password=1233

//   test with postman

