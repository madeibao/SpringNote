package com.testa.www;

import com.mayuan.www.Dog;
import com.mayuan.www.MyConfig;
import com.mayuan.www.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName TestA
 * @Author：Mayuan
 * @Date 2023/8/2/0002 21:52
 * @Description TODO
 * @Version 1.0
 **/
public class TestA {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println("====================================================");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user.toString());
        Dog dog = applicationContext.getBean("dog", Dog.class);
        System.out.println(dog.toString());
        System.out.println("====================================================");

        System.out.println("------------  测试单例模式 ---------------------------");
        Dog dog1 = applicationContext.getBean("dog", Dog.class);
        Dog dog2 = applicationContext.getBean("dog", Dog.class);
        System.out.println("dog1 == dog2 ? " + (dog1 == dog2));
    }

}
