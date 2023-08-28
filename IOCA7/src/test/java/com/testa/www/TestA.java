package com.testa.www;

import com.mayuan.www.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName TestA
 * @Author：Mayuan
 * @Date 2023/8/10/0010 16:53
 * @Description TODO
 * @Version 1.0
 **/


public class TestA {

    private void printBeans() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        //获取容器中所有的bean的名字
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        new TestA().printBeans();
    }
}
