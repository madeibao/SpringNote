package com.yongli.demo;

import com.yongli.demo.bean.Permission;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.yongli.demo.dao.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    PermissionDao permissionDao;


    @Test
    public void contextLoads() {
        System.out.println("123");
        List<Permission> list = permissionDao.listByUserId(3L);
        list.forEach(a->System.out.println(a.getPermission()));
    }

}
