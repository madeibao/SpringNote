package com.hehe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @ClassName WebJspApplication
 * @Author：Mayuan
 * @Date 2023/8/21/0021 9:54
 * @Description TODO
 * @Version 1.0
 **/
@SpringBootApplication
public class WebJspApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WebJspApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(WebJspApplication.class, args);
    }
}

