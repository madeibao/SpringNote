package com.mayuan.www;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MainConfig
 * @Author：Mayuan
 * @Date 2023/8/10/0010 16:52
 * @Description TODO
 * @Version 1.0
 **/

/**
    @Configuration
 * //告诉spring这是一个配置类
 *
 */

@ComponentScan(value = {"com.mayuan.www"})
@Configuration
public class MainConfig {

}