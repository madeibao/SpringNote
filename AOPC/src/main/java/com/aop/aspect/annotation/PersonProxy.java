package com.aop.aspect.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

 /**
 * @author 田治功
 * @create 2021-02-26 16:10
 * @Description
 */


@Component
@Aspect
@Order(1)
public class PersonProxy {
    @Before(value = "execution(* com.aop.aspect.annotation.User.add(..))")
    public void before() {
        System.out.println("前置通知：Person before方法");
    }
}
