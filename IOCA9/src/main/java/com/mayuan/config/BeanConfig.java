package com.mayuan.config;

/**
 * @ClassName BeanConfig
 * @Author：Mayuan
 * @Date 2023/9/17/0017 15:25
 * @Description TODO
 * @Version 1.0
 **/

import com.mayuan.bean.Person;
import org.springframework.context.annotation.*;

@ComponentScan({"com.mayuan"})
@Configuration
public class BeanConfig {

    @Bean
    public Person person(){
        return new Person("张三");
    }

    @Bean
    public Person person2(){
        return new Person("李四");
    }
}
