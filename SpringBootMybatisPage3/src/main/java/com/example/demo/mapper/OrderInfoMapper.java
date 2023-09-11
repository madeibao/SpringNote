package com.example.demo.mapper;

/**
 * @ClassName OrderInfoMapper
 * @Author：Mayuan
 * @Date 2023/9/11/0011 14:56
 * @Description TODO
 * @Version 1.0
 **/


import com.example.demo.bean.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface OrderInfoMapper {

    List<OrderInfo> getOrderInfoList(RowBounds rowBounds);
}