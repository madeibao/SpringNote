package com.aop.aspect.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author 田治功
 * @create 2021-02-26 17:32
 * @Description
 */

@Configuration
@ComponentScan(basePackages = {"com.aop"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAOP {

}
