package com.mayuan.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mayuan.jdbc.entity.Book;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName BookDaoImpl
 * @Author：Mayuan
 * @Date 2022/2/26/0026 22:44
 * @Description TODO
 * @Version 1.0
 **/

@Repository
public class BookDaoImpl implements BookDao{
    /**
     * 批量添加数据
     * @param books
     */
    @Override
    public void batchAddBook(List<Object[]> books) {
        String sql = "Insert into book values(?,?,?)";
        int[] res = jdbcTemplate.batchUpdate(sql, books);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 批量删除
     */
    @Override
    public void batchDelBook(List<Object[]> ids) {
        String sql = "DELETE FROM book WHERE user_id = ?";
        int[] res = jdbcTemplate.batchUpdate(sql, ids);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 批量更新数据
     * @param books
     */
    @Override
    public void batchUpdateBook(List<Object[]> books) {
        String sql = "Update book set username = ?,ustates = ? where user_id = ?";
        int[] res = jdbcTemplate.batchUpdate(sql, books);
        System.out.println(Arrays.toString(res));
    }



    /**
     * 注入JdbcTemplate
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 添加方法
     * @param book 书
     */
    @Override
    public void add(Book book) {
        Object[] args = {book.getUserId(),book.getUsername(),book.getUserStatus()};
        int update = jdbcTemplate.update("insert into book values (?,?,?)", args);
        System.out.println("update successful!" + update);
    }

    @Override
    public void update(Book book) {
        Object[] args = {book.getUsername(), book.getUserStatus(), book.getUserId()};
        int update = jdbcTemplate.update("update book set username = ?,ustates = ? where user_id = ?", args);
        System.out.println("update successful!" + update);
    }

    @Override
    public void deleteBook(String id) {
        int update = jdbcTemplate.update("delete from book  where user_id = ?", id);
        System.out.println("delete successful!" + update);
    }

    @Override
    public int selectCount() {
        String sql = "select count(*) from book";
        int count = jdbcTemplate.queryForObject(sql,Integer.class);
        return count;
    }
}
