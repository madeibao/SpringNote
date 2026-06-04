package com.mayuan.test3;

import com.mayuan.jdbc.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import com.mayuan.jdbc.entity.Book;


/**
 * @ClassName JDBCAbc
 * @Author：Mayuan
 * @Date 2022/2/26/0026 22:48
 * @Description TODO
 * @Version 1.0
 **/
public class JDBCAbc {
    /**
     * 单增
     */
    @Test
    public void testAdd() {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setUserId(1);
        book.setUsername("Abc");
        book.setUserStatus("online");
        bookService.addBook(book);
    }

    @Test
    public void testUpdate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setUserId(1);
        book.setUsername("Maruko");
        book.setUserStatus("onlines");
        bookService.updateBook(book);
    }


    @Test
    public void testDelete() {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.deleteBook("1");
    }


    @Test
    public void testCount() {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.selectCount();
    }


    @Test
    public void testBatchAddBooks() {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> books = new ArrayList<>();
        Object[] oa = {1, "C", "A"};
        Object[] ob = {2, "C++", "B"};
        Object[] o1 = {3, "java", "a"};
        Object[] o2 = {4, "python", "c"};
        Object[] o3 = {5, "C#", "b"};
        books.add(oa);
        books.add(ob);

        books.add(o1);
        books.add(o2);
        books.add(o3);
        bookService.batchAddBook(books);
    }


    @Test
    public void testBatchUpdate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> books = new ArrayList<>();
        Object[] o1 = {1, "Micah", "3"};
        Object[] o2 = {2, "Maruko", "5"};
        books.add(o1);
        books.add(o2);
        bookService.batchUpdateBook(books);
    }


    @Test
    public void testBatchDelete() {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> ids = new ArrayList<>();
        Object[] o1 = {3};
        Object[] o2 = {5};
        ids.add(o1);
        ids.add(o2);
        bookService.batchDelBook(ids);
    }

}