package com.mayuan.jdbc.dao;

import com.mayuan.jdbc.entity.Book;
import java.util.List;

/**
 * @ClassName BookDao
 * @Author：Mayuan
 * @Date 2022/2/26/0026 22:43
 * @Description TODO
 * @Version 1.0
 **/

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
