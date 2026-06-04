package org.example.config;

/**
 * @ClassName BeanConfig
 * @Author：Mayuan
 * @Date 2024/6/2/星期日 17:55
 * @Description TODO
 * @Version 1.0
 **/

import org.example.bean.Person;
import org.springframework.context.annotation.*;

@ComponentScan({"org.example"})
@Configuration
public class BeanConfig {

    @Bean
    public Person person() {
        return new Person("张三");
    }

    @Bean
    public Person person2() {
        return new Person("李四");
    }
}