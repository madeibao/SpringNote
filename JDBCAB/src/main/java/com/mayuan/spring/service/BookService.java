package com.mayuan.spring.service;

import com.mayuan.spring.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import com.mayuan.spring.entity.Book;
import org.springframework.stereotype.Service;


/**
 * @ProjectName: JDBCA
 * @Package: com.mayuan.spring.service
 * @ClassName: BookService
 * @Author: mi
 * @Date: 2022/2/20 11:10
 * @Version: 1.0
 */


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
