package com.example.demo.mapper;

/**
 * @ClassName OrderInfoMapper
 * @Author：Mayuan
 * @Date 2023/9/11/0011 14:25
 * @Description TODO
 * @Version 1.0
 **/

import com.example.demo.bean.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 接口实现
 * @author ASUS
 */
@Mapper
public interface OrderInfoMapper {

    List<OrderInfo> getOrderInfoList();
}