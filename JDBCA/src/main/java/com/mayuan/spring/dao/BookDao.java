package com.mayuan.spring.dao;

import java.util.List;
import com.mayuan.spring.entity.Book;


/**
 * @ProjectName: JDBCA
 * @Package: com.mayuan.spring.dao
 * @ClassName: BookDao
 * @Author: mi
 * @Date: 2022/2/20 11:07
 * @Version: 1.0
 */
public interface BookDao {
    /**
     * 添加add
     */
    void add(Book book);
    /**
     * update
     */
    void update(Book book);

    /**
     * delete
     */
    void deleteBook(String id);

    /**
     * count(*)
     */
    int selectCount();

    /**
     * batchAddBooks
     * @param books
     */
    void batchAddBook(List<Object[]> books);

    void batchUpdateBook(List<Object[]> books);

    void batchDelBook(List<Object[]> ids);
}
