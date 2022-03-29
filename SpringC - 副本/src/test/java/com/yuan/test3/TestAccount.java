package com.yuan.test3;

import com.mayuan.demo1.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName TestAccount
 * @Author：Mayuan
 * @Date 2022/3/10/0010 22:08
 * @Description TODO
 * @Version 1.0
 **/


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/applicationContext.xml")
public class TestAccount {


    @Autowired
    private AccountService accountService;

    @Test
    public void test1(){
        //a给b转账100元
        accountService.transfer("aaa", "bbb", 100);
        System.out.println("[ok]...");
    }
}
