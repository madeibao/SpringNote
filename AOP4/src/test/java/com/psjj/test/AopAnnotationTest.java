package com.psjj.test;

import com.psjj.annotation.target.UserDao;
import com.psjj.config.MyConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = MyConfig.class)
public class AopAnnotationTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void test1() {
        userDao.add();
        userDao.del();
        userDao.update();
        userDao.query();
    }
}
