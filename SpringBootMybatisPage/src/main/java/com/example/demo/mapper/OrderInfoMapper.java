package com.example.demo.mapper;

/**
 * @ClassName OrderInfoMapper
 * @Author：Mayuan
 * @Date 2023/9/11/0011 11:32
 * @Description TODO
 * @Version 1.0
 **/

import com.example.demo.bean.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderInfoMapper {

    /**
     * 分页mapper
     * @param pageNow
     * @param pageSize
     * @return
     */
    List<OrderInfo> getOrderInfoList(@Param("pageNow") int pageNow, @Param("pageSize") int pageSize);
}