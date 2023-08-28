package com.mayuan.www;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;
import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON;

/**
 * @ClassName MyConfig
 * @Author：Mayuan
 * @Date 2023/8/2/0002 21:52
 * @Description TODO
 * @Version 1.0
 **/


@Configuration
public class MyConfig {

    @Bean("user")
    @Scope(SCOPE_PROTOTYPE)
    /**
     * 多例模式
     */
    public User getUser(){
        System.out.println("User对象进行创建!");
        return new User("用户", 22, getDog());
    }

    @Bean("dog")
    @Scope(SCOPE_SINGLETON)
    /** 单例模式*/
    public Dog getDog(){
        System.out.println("Dog对象进行创建!");
        return new Dog("金毛", 3);
    }
}
