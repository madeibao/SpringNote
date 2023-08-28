package com.example.demo.config;

import com.example.demo.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyAppConfig
 * @Author：Mayuan
 * @Date 2022/4/4/0004 20:24
 * @Description TODO
 * @Version 1.0
 **/


@Configuration
public class MyAppConfig {

    //将方法的返回值添加到容器中；容器这个组件id就是方法名
    @Bean
    public HelloService helloService(){
        System.out.println("配置类给容器添加了HelloService组件");
        return new HelloService();
    }
}
