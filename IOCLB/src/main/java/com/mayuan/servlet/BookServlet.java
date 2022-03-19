package com.mayuan.servlet;

/**
 * @ClassName BookServlet
 * @Author：Mayuan
 * @Date 2022/1/23/0023 22:54
 * @Description TODO
 * @Version 1.0
 **/


import com.mayuan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



@Controller
public class BookServlet {

    /**
     *  自动装配，自动为这个属性赋值
     */

    @Autowired
    private BookService bookService;

    public void doGet(){
        bookService.save();
    }

}
