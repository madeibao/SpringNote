package com.wjb.service;

import com.wjb.face.service.BookService;

/**
 * @Description
 * @Author jianbo wang
 * @Date:2021/12/2 0002 10:48
 */
public class BookServiceImpl implements BookService {
    @Override
    public void show(int p1, int p2) {
        System.out.println("bookService"+"***"+p1+"***"+p2);
    }

}
