package com.mayuan.dao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.mayuan.dao")
@EnableAspectJAutoProxy
public class SpringConfig {

}
