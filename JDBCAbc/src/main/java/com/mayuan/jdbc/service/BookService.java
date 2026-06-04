package com.mayuan.jdbc.service;

import com.mayuan.jdbc.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.mayuan.jdbc.entity.Book;

/**
 * @ClassName BookService
 * @Author：Mayuan
 * @Date 2022/2/26/0026 22:45
 * @Description TODO
 * @Version 1.0
 **/

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public void addBook(Book book) {
        bookDao.add(book);
    }

    public void updateBook(Book book) {
        bookDao.update(book);
    }

    public void deleteBook(String id) {
        bookDao.deleteBook(id);
    }

    public void selectCount(){
        int count = bookDao.selectCount();
        System.out.println(count);
    }

    public void batchAddBook(List<Object[]> books){
        bookDao.batchAddBook(books);
    }

    public void batchUpdateBook(List<Object[]> books) {
        bookDao.batchUpdateBook(books);
    }

    public void batchDelBook(List<Object[]> ids) {
        bookDao.batchDelBook(ids);
    }
}
