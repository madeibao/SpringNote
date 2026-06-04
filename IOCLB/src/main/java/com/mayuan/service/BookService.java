package com.mayuan.service;

 /**
 * @ClassName BookService
 * @Author：Mayuan
 * @Date 2022/1/23/0023 22:54
 * @Description TODO
 * @Version 1.0
 **/

import com.mayuan.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 通过@Service把它加入到容器中
 */

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public void save() {
        System.out.println("bookservice--->正在调用dao帮你保存图书...");
        bookDao.saveBook();
    }
}
