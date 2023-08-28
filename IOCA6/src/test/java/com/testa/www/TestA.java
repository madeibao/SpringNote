package com.testa.www;

import com.mayuan.www.MainConfig;
import com.mayuan.www.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName TestA
 * @Author：Mayuan
 * @Date 2023/8/10/0010 16:48
 * @Description TODO
 * @Version 1.0
 **/
public class TestA {

    @Test
    public void test01() {
        //获取容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        //查看容器中类型是Person类的BeanName
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for(String name : beanNamesForType) {
            System.out.println(name);
        }
    }
}
