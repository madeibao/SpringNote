package com.mayuan.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName App
 * @Author：Mayuan
 * @Date 2022/1/23/0023 17:46
 * @Description TODO
 * @Version 1.0
 *
 * 测试Spring的自动装配和赋值操作。
 *
 *     <!-- 为Person里面的自定义类型的属性赋值
 *         property：手动赋值
 *         自动赋值（自动装配）：
 *
 *     自动装配：（仅限于对自定义类型的属性有效）
 *     autowire="default/no"：不自动装配；不自动为car属性赋值
 *
 *     //按照某种规则自动装配
 *     autowire="byName"：按照名字；
 *             private Car car;
 *                 1)、以属性名(car)作为id去容器中找到这个组件，给他赋值；如果找不到就装配null；
 *                 car = ioc.getBean("car");
 *     autowire="byType":
 *             private Car car;
 *                 1)、以属性的类型作为查找依据去容器中找到这个组件；如果容器中有多个这葛类型的组件，报错；
 *                 NoUniqueBeanDefinitionException:
 *                 No qualifying bean of type [com.atguigu.bean.Car] is defined:
 *                 expected single matching bean but found 2: car01,car02
 *                 2)、没找到呢？装配null
 *                 car = ioc.getBean(Car.class);
 *
 *     autowire="constructor":
 *         public Person(Car car)
 *             按照构造器进行赋值；
 *             1）、先按照有参构造器参数的类型进行装配（成功就赋值）；没有就直接为组件装配null即可。
 *             2）、如果按照类型找到了多个；参数的名作为id继续匹配;找到就装配；找不到就null；
 *             3）、不会报错；
 *
 *     自动的为属性赋值：
 *     -->
 **/
public class App {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("application.xml");
        Obj bean = app.getBean(Obj.class);
        System.out.println(bean);
    }

}
