package cn.chenjiajin.mapper;

import cn.chenjiajin.domain.Order;

/**
 * @ClassName OrderMapper
 * @Author：Mayuan
 * @Date 2023/8/30/0030 18:31
 * @Description TODO
 * @Version 1.0
 **/

import java.util.List;

public interface OrderMapper {

    Order getById(Long orderId);

    List<Order> getByUserId(Long userId);

}