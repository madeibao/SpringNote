package com.mayuan.spring;

/**
 * @ClassName Person
 * @Author：Mayuan
 * @Date 2022/1/23/0023 16:42
 * @Description TODO
 * @Version 1.0
 *
 * https://www.cnblogs.com/jeremy-blog/p/4025129.html
 * Bean的后置处理器方法和使用对象
 **/

public class Person {
    private String Name;

    public void setName(String name) {
        Name = name;
        System.out.println("Setter............");
    }

    public Person() {
        System.out.println("person constructor.......");
    }


    /**
     * 类的初始化方法
     */
    public void init() {
        System.out.println("init......");
    }

    /**
     * 类的销毁方法
     */
    public void destory() {
        System.out.println("desdtory......");
    }

    @Override
    public String toString() {
        return "person [Name=" + Name + "]";
    }
}