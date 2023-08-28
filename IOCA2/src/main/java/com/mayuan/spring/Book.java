package com.mayuan.spring;

/**
 * @ClassName Book
 * @Author：Mayuan
 * @Date 2023/7/30/0030 22:41
 * @Description TODO
 * @Version 1.0
 **/
public class Book {

    private String name;
    private int money;

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
