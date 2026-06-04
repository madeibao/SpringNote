package com.mayuan.config;

import com.mayuan.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName BeanConfig
 * @Author：Mayuan
 * @Date 2023/9/17/0017 15:45
 * @Description TODO
 * @Version 1.0
 **/

@ComponentScan({"com.mayuan"})
@Configuration
public class BeanConfig {

    @Bean("person1")
    public Person person1() {
        return new Person("张三");
    }

    @Bean("person2")
    public Person person2() {
        return new Person("李四");
    }
}