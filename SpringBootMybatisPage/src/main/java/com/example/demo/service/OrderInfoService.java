package com.example.demo.service;

/**
 * @ClassName OrderInfoService
 * @Author：Mayuan
 * @Date 2023/9/11/0011 11:31
 * @Description TODO
 * @Version 1.0
 **/
import com.example.demo.bean.OrderInfo;
import com.example.demo.mapper.OrderInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderInfoService {

    @Resource
    private OrderInfoMapper orderInfoMapper;

    public List<OrderInfo> getOrderInfoList(int pageNow, int pageSize) {
        if(pageNow == 1){
            pageNow = 0;
        }
        return orderInfoMapper.getOrderInfoList(pageNow,pageSize);
    }
}