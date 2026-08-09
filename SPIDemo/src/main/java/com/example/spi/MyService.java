package com.example.spi;

/**
 *
 * SPI 机制接口的实现
 *
 * Java SPI（Service Provider Interface）是 JDK 内置的一种服务发现机制，核心思想是：
 * 面向接口编程 + 配置化装配。它允许框架定义接口规范，第三方提供实现，运行时自动加载所有实现类，无需硬编码。
 *
 * @ClassName MyService
 * @Author：Mayuan
 * @Date 2026/8/9/星期日 14:53
 * @Version 1.0
 **/
public interface MyService {
    void execute();
}
