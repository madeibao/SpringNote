package com.myuan.test;

import com.mayuan.pagetest.config.SpringConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.mayuan.pagetest.model.*;
import com.mayuan.pagetest.service.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName PagerTest
 * @Author：Mayuan
 * @Date 2023/8/18/0018 9:57
 * @Description TODO
 * @Version 1.0
 *
 *
 * 这里展示的是一个分页查询的案例
 **/
public class PagerTest {

    IUserService userService;

    @Before
    public void init() {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        userService=applicationContext.getBean(IUserService.class);
    }

    @Test
    public void pagerFind() {
        Map<String,Integer> map= new HashMap<String, Integer>();
        //假设当前页面为第一页
        int curretPager=1;
        //每页显示10条
        int end=10;
        //当前起始位置为： （当前页面-1）* 页面显示数量
        map.put("start",(curretPager-1)*end);
        //每页显示数量
        map.put("end",end);
        List<User> users=userService.pagerFind(map);
        System.out.println(users);
    }

    @Test
    public void insert() {
        User user=new User();
        user.setAge(25);
        user.setUser_addr("南京");
        user.setTest_name("杨红玉");
        userService.insert(user);
    }
    
    @Test
    public void delete() {
        userService.delete(4);
    }

    @Test
    public void update(){
        userService.update("李艳");
    }
}
