package com.mayuan.spring;

import org.springframework.stereotype.Service;

/**
 * @ClassName MethodService
 * @Author：Mayuan
 * @Date 2022/2/24/0024 20:04
 * @Description TODO
 * @Version 1.0
 **/


@Service
public class MethodService {
    public void add() {
        System.out.println("method-add()");
    }
}
