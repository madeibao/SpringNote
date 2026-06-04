package com.mayuan.jdk;

import com.mayuan.dao.CustomerDao;

/**
 * @ClassName JDKProxyTest
 * @Author：Mayuan
 * @Date 2022/2/12/0012 15:21
 * @Description TODO
 * @Version 1.0
 **/

public class JDKProxyTest {

    public void test() {
        // 从工厂获得指定的内容（相当于spring获得，但此内容时代理对象）
        CustomerDao customerDao = MyBeanFactory.getBean();
        // 执行方法
        customerDao.add();
        customerDao.update();
        customerDao.delete();
        customerDao.find();
    }

    public static void main(String[] args) {
        new JDKProxyTest().test();
    }
}
