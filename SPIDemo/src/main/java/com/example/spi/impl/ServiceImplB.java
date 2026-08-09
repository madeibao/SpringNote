package com.example.spi.impl;

import com.example.spi.MyService;

/**
 *
 * @ClassName ServiceImplB
 * @Author Mayuan
 * @Date 2026/8/9/星期日 14:55
 * @Version 1.0
 **/
public class ServiceImplB implements MyService {
    @Override
    public void execute() {
        System.out.println("Service Implementation 2 executed.");
    }
}
