package com.example.demo.service;

/**
 * @ClassName OrderInfoService
 * @Author：Mayuan
 * @Date 2023/9/11/0011 14:56
 * @Description TODO
 * @Version 1.0
 **/

import com.example.demo.bean.OrderInfo;
import com.example.demo.mapper.OrderInfoMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderInfoService {

    @Resource
    private OrderInfoMapper orderInfoMapper;

    public List<OrderInfo> getOrderInfoList(int pageNow, int pageSize) {
        RowBounds rowBounds = new RowBounds(pageNow,pageSize);
        return orderInfoMapper.getOrderInfoList(rowBounds);
    }
}
