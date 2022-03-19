package com.mayuan.service;

/**
 * @ClassName BookServiceExt
 * @Author：Mayuan
 * @Date 2022/1/23/0023 23:04
 * @Description TODO
 * @Version 1.0
 **/

import com.mayuan.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookServiceExt extends BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public void save() {
        System.out.println("bookSServiceExt被调用了...");
    }
}
