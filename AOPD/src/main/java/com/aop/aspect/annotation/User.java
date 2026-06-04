package com.aop.aspect.annotation;

import org.springframework.stereotype.Component;

/**
 * @author 田治功
 * @create 2021-02-26 12:13
 * @Description 被增强类
 */


@Component
public class User {
    public void add() {
        System.out.println("被增强方法：add方法");
    }
}
