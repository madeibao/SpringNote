package com.mayuan.spring;


import org.springframework.stereotype.Service;

/**
 * @ClassName AnnotationService
 * @Author：Mayuan
 * @Date 2022/2/24/0024 20:06
 * @Description TODO
 * @Version 1.0
 **/

@Service
public class AnnotationService {

    @Action(name = "add-1")
    public void add1() {
        System.out.println("add-1");
    }

    public void add2() {
        System.out.println("add-2");

    }

    @Action(name = "add-3")
    public void add3() {
        System.out.println("add-3");

    }

}
