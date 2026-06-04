package com.example.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *
 * @ClassName AopConfig
 * @Author Mayuan
 * @Date 2026/6/4/星期四 11:08
 * @Version 1.0
 **/
@Configuration
@ComponentScan("com.example.aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)  // 启用 AOP 代理
public class AopConfig {
}