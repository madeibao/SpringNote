package com.psjj.test;

import com.psjj.xml.target.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:bean.xml")
public class AopTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void test1() {
        userDao.add();
        System.out.println("----------------");
        userDao.del();
        System.out.println("----------------");
        userDao.update();
        System.out.println("----------------");
        userDao.query();
    }
}
