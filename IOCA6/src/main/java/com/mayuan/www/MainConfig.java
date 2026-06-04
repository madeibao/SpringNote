package com.mayuan.www;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MainConfig
 * @Author：Mayuan
 * @Date 2023/8/10/0010 16:47
 * @Description TODO
 * @Version 1.0
 **/

/**
 * 告诉spring这是一个配置类*/

@Configuration
public class MainConfig {
    /**给容器中至少一个bean，bean的类型就是返回值得类型，id默认为方法名*/

    @Bean
    public Person person() {
        return new Person("贾一帆", 20);
    }
}