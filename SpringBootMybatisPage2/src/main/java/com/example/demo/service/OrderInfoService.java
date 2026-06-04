package com.example.demo.service;

/**
 * @ClassName OrderInfoService
 * @Author：Mayuan
 * @Date 2023/9/11/0011 14:25
 * @Description TODO
 * @Version 1.0
 **/
import com.example.demo.bean.OrderInfo;
import com.example.demo.mapper.OrderInfoMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderInfoService {

    @Resource
    private OrderInfoMapper orderInfoMapper;

    public List<OrderInfo> getOrderInfoList(int pageNow, int pageSize) {
        PageHelper.startPage(pageNow,pageSize);
        List<OrderInfo> orderInfoList = orderInfoMapper.getOrderInfoList();
        PageInfo<OrderInfo> userPageInfo = new PageInfo<>(orderInfoList);
        return userPageInfo.getList();
    }
}