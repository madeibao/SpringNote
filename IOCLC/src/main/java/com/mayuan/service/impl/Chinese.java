package com.mayuan.service.impl;

import com.mayuan.service.Axe;
import com.mayuan.service.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @ClassName Chinese
 * @Author：Mayuan
 * @Date 2022/1/24/0024 22:24
 * @Description TODO
 * @Version 1.0
 **/


@Component
public class Chinese implements Person {

    @Autowired
    @Qualifier("steelAxe")
    private Axe axe;

        //  // axe的setter方法
        //  @Autowired
        //  public void setAxe(@Qualifier("stoneAxe") Axe axe)
        //  {
        //    this.axe = axe;
        //  }
        // 实现Person接口的useAxe()方法


    public void useAxe()  {
        // 调用axe的chop()方法，
        // 表明Person对象依赖于axe对象
        System.out.println(axe.chop());
    }
}