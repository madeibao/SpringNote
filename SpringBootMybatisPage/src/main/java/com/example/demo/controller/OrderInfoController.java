package com.example.demo.controller;

/**
 * @ClassName OrderInfoController
 * @Author：Mayuan
 * @Date 2023/9/11/0011 11:31
 * @Description TODO
 * @Version 1.0
 **/

import com.example.demo.bean.OrderInfo;
import com.example.demo.service.OrderInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrderInfoController {

    @Resource
    private OrderInfoService orderInfoService;

    @GetMapping("/getOrderInfoList")
    public List<OrderInfo> getOrderInfoList(@RequestParam(value = "pageNow",defaultValue = "1") int pageNow,
                                            @RequestParam(value = "pageSize",defaultValue = "3") int pageSize){

        return orderInfoService.getOrderInfoList(pageNow,pageSize);
    }
}