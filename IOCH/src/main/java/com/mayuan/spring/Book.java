package com.mayuan.spring;

/**
 * @ClassName Book
 * @Author：Mayuan
 * @Date 2022/1/23/0023 16:05
 * @Description TODO
 * @Version 1.0
 *
 *
 * 例子讲解的市 Bean对象的初始化的方法，
 * 默认的是单例模式对象方法。
 *
 * 分为单实例和多实例的情况，
 * 单实例和多实例的情况不同
 * 多实例的情况，容器关闭，不会创建销毁的方法。
 **/


public class Book {
    public String bookName;
    public String author;

    public void myInit(){
        System.out.println("这是图书的初始化方法。。。");
    }

    public void myDeatory(){
        System.out.println("这是图书的销毁方法");
    }

    public Book() {
        System.out.println("book被创建");
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
