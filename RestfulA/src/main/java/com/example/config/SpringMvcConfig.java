package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @ClassName SpringMvcConfig
 * @Author：Mayuan
 * @Date 2023/9/14/0014 11:00
 * @Description TODO
 * @Version 1.0
 **/

/**、创建springmvc的配置文件，加载controller对应的bean
 * @author ASUS*/

@Configuration
@ComponentScan("com.example.controller")
@EnableWebMvc
public class SpringMvcConfig {
}
