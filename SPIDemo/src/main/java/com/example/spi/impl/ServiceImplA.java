package com.example.spi.impl;

import com.example.spi.MyService;

/**
 *
 * @ClassName ServiceImplA
 * @Author Mayuan
 * @Date 2026/8/9/星期日 14:54
 * @Version 1.0
 **/
public class ServiceImplA implements MyService {
    @Override
    public void execute() {
        System.out.println("Service Implementation 1 executed.");
    }
}
