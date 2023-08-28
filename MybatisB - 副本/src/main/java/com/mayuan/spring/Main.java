package com.mayuan.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName Main
 * @Author：Mayuan
 * @Date 2022/2/24/0024 20:07
 * @Description TODO
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        AnnotationService annotationService = context.getBean(AnnotationService.class);
        annotationService.add1();
        annotationService.add2();
        annotationService.add3();
        MethodService methodService = context.getBean(MethodService.class);
        methodService.add();
        context.close();
    }

}
