package com.mayuan.pagetest.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName JdbcConfig
 * @Author：Mayuan
 * @Date 2023/8/18/0018 9:46
 * @Description TODO
 * @Version 1.0
 **/

@Configuration
@Data
@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {
    //包地址
    @Value("${jdbc.driver}")
    private String driver;
    //url
    @Value("${jdbc.url}")
    private String url;
    //用户名
    @Value("${jdbc.username}")
    private String username;
    //密码
    @Value("${jdbc.password}")
    private String passwrod;
    //最大连接数
    @Value("${jdbc.max}")
    private int max;
    //最小连接数
    @Value("${jdbc.min}")
    private  int min;
}

