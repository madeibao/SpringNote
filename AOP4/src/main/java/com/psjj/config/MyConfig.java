package com.psjj.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.psjj.annotation"})//扫描包下的的ioc和di注解
@EnableAspectJAutoProxy//开启aop注解扫描
public class MyConfig {

}
