package com.mayuan.spring;

import java.util.List;

/**
 * @ClassName Obj
 * @Author：Mayuan
 * @Date 2022/1/23/0023 17:44
 * @Description TODO
 * @Version 1.0
 **/
public class Obj {
    private Book book;
    private List<Book> list;

    public Obj() {

    }
    public Obj(Book book, List<Book> list) {
        this.book = book;
        this.list = list;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Obj{" +
                "book=" + book +
                ", list=" + list +
                '}';
    }
}

