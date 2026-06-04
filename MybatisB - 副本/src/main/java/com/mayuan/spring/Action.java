package com.mayuan.spring;

import java.lang.annotation.*;

/**
 * @ClassName Action
 * @Author：Mayuan
 * @Date 2022/2/24/0024 20:06
 * @Description TODO
 * @Version 1.0
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
