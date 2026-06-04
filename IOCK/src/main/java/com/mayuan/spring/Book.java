package com.mayuan.spring;

/**
 * @ClassName Book
 * @Author：Mayuan
 * @Date 2022/1/23/0023 17:44
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
