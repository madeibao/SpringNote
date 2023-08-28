package com.mayuan.cglib;

/**
 * @ClassName Hello
 * @Author：Mayuan
 * @Date 2022/2/12/0012 15:51
 * @Description TODO
 * @Version 1.0
 **/

public class Hello {
    public String sayHello(String name) {
        System.out.println("Hello," + name);
        return "Hello," + name;
    }
}