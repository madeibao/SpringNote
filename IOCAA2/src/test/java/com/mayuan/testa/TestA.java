package com.mayuan.testa;

import com.mayuan.config.BeanConfig;
import com.mayuan.service.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName TestA
 * @Author：Mayuan
 * @Date 2023/9/17/0017 15:46
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