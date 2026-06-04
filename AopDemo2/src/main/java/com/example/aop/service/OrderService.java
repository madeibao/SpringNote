package com.example.aop.service;

import org.springframework.stereotype.Service;

/**
 *
 * @ClassName OrderService
 * @Author Mayuan
 * @Date 2026/6/4/星期四 11:07
 * @Version 1.0
 **/
@Service
public class OrderService {
    public String createOrder(String productName, Integer quantity) {
        System.out.println("【业务逻辑】正在创建订单: " + productName + ", 数量: " + quantity);
        return "Order{id=1001, product=" + productName + "}";
    }
}