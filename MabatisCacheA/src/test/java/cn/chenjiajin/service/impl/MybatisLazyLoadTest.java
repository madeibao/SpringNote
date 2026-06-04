package cn.chenjiajin.service.impl;

/**
 * @ClassName MybatisLazyLoadTest
 * @Author：Mayuan
 * @Date 2023/8/30/0030 18:13
 * @Description TODO
 * @Version 1.0
 **/

import cn.chenjiajin.domain.Order;
import cn.chenjiajin.domain.UserLazy;
import cn.chenjiajin.mapper.UserMapper;
import cn.chenjiajin.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @ClassName MybatisLazyLoadTest
 * @Author：Mayuan
 * @Date 2023/8/30/0030 18:10
 * @Description TODO
 * @Version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisLazyLoadTest {


    @Test
    public void testExtra() {
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Order order = mapper.getOrderAndUserByOrderId(1L);
        System.err.println("订单信息: " + order);
        System.err.println("订单的用户信息: " + order.getUser());
    }


    @Test
    public void testLazy() {
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserLazy user = userMapper.getUserAndOrderListByUserId(1L);
        System.err.println("用户信息: " + user.getName());
        // 但是经过测试之后发现还是无效的，经过一番折腾，发现是因为我在测试的时候，调用了查询出来的对象的toString方法(@Data注解)，所以触发了一次懒加载

        System.err.println("用户的订单信息: ");
        user.getOrderList().forEach(System.err::println);
    }


}