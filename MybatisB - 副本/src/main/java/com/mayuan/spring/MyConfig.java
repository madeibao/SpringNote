package com.mayuan.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ClassName MyConfig
 * @Author：Mayuan
 * @Date 2022/2/24/0024 20:04
 * @Description TODO
 * @Version 1.0
 **/


@Configuration
@ComponentScan("com.mayuan.spring")
@EnableAspectJAutoProxy
public class MyConfig {

}
