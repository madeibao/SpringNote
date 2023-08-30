package cn.chenjiajin.mapper;

/**
 * @ClassName UserMapper
 * @Author：Mayuan
 * @Date 2023/8/30/0030 18:32
 * @Description TODO
 * @Version 1.0
 **/

import cn.chenjiajin.domain.Order;
import cn.chenjiajin.domain.User;
import cn.chenjiajin.domain.UserLazy;
import cn.chenjiajin.domain.qo.QueryObject;

import java.util.List;

public interface UserMapper {
    void delete(Long id);

    void insert(User user);

    User select(Long id);

    List<User> selectAll();

    void update(User User);

    int selectForCount(QueryObject qo);

    List<User> selectForList(QueryObject qo);



    /**
     * 使用二级缓存
     */
    User findById(int id);

    /**
     *
     * 表示不使用缓存查询
     * @param id
     */
    User findByIdNotCache(int id);

    /**
     * 默认: 刷新缓存
     */
    void updateName(User user);

    /**
     * flushCache="false": 不刷新缓存
     * 不刷新缓存 = 使用缓存,不去发数据库SQL
     */
    void updateNameNotFlush(User user);



    /**
     * flushCache="false": 不刷新缓存
     * 不刷新缓存 = 使用缓存,不去发数据库SQL
     */
    void insertNotCache(User user);



    /**
     * 正常的额外SQL
     * 根据订单id查询 , 返回携带User的信息
     */
    Order getOrderAndUserByOrderId(Long orderId);

    /**
     * 延迟加载
     * 查询用户后 , 发额外SQL 查询该用户的所有订单集合
     */
    UserLazy getUserAndOrderListByUserId(Long userId);
}