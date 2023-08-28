package com.testa.www;

import com.mayuan.www.BeansConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName TestA
 * @Author：Mayuan
 * @Date 2023/8/10/0010 17:02
 * @Description TODO
 * @Version 1.0
 **/
public class TestA {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name:names) {
            System.out.println(name);
        }
        /**
         * @import注入bean的名称为：全类名
         * 包路径.Red
         * 包路径.Yellow
         * 包路径.Blue
         */
    }
}
