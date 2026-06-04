package com.yuan.test3;

import com.mayuan.demo2.AccountService;
import javax.annotation.Resource;
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
@ContextConfiguration("classpath*:/applicationContext2.xml")
public class TestAccount2 {

    //注入业务bean,因为accountService没有aop功能，所以需要增强其功能
    //也即需要为其设置代理类，完成事务控制
//	@Autowired
    @Resource(name="accountServiceProxy")
    private AccountService accountService;

    @Test
    public void test1(){
        accountService.transfer("bbb", "aaa", 100);
        System.out.println("[ok]...");
    }
}
