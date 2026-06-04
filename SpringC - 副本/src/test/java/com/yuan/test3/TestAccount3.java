package com.yuan.test3;

import com.mayuan.demo3.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @ClassName TestAccount2
 * @Author：Mayuan
 * @Date 2022/3/12/0012 9:57
 * @Description TODO
 * @Version 1.0
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/applicationContext3.xml")
public class TestAccount3 {

    @Autowired//accountService这个bean在运行时已经事务增强了，本身就是代理了
    private AccountService accountService;

    @Test
    public void test1(){
        accountService.transfer("bbb", "aaa", 100);
        System.out.println("[ok]...");
    }

}