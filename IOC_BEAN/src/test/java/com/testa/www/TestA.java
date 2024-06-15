package com.testa.www;

import org.example.config.BeanConfig;
import org.example.service.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName TestA
 * @Author：Mayuan
 * @Date 2024/6/2/星期日 17:58
 * @Description TODO
 * @Version 1.0
 **/
public class TestA {

    public static void main(String[] args) {

        //加载配置类获取容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);

        //容器中获取TestService
        TestService testService = annotationConfigApplicationContext.getBean(TestService.class);

        //调用测试方法
        testService.test();
    }
}