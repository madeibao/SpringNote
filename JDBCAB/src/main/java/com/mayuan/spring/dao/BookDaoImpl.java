package com.mayuan.spring.dao;

import com.mayuan.spring.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: JDBCA
 * @Package: com.mayuan.spring.dao
 * @ClassName: BookDao
 * @Author: mi
 * @Date: 2022/2/20 11:06
 * @Version: 1.0
 */


@Repository
public class BookDaoImpl implements BookDao{
    /**
     * 批量添加数据
     * @param books
     */
    @Override
    public void batchAddBook(List<Object[]> books) {
        String sql = "Insert into t_user values(?,?,?)";
        int[] res = jdbcTemplate.batchUpdate(sql, books);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 批量删除
     */
    @Override
    public void batchDelBook(List<Object[]> ids) {
        String sql = "DELETE FROM t_user WHERE user_id = ?";
        int[] res = jdbcTemplate.batchUpdate(sql, ids);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 批量更新数据
     * @param books
     */
    @Override
    public void batchUpdateBook(List<Object[]> books) {
        String sql = "Update t_user set username = ?,ustates = ? where user_id = ?";
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
        int update = jdbcTemplate.update("insert into t_user values (?,?,?)", args);
        System.out.println("update successful!" + update);
    }

    @Override
    public void update(Book book) {
        Object[] args = {book.getUsername(), book.getUserStatus(), book.getUserId()};
        int update = jdbcTemplate.update("update t_user set username = ?,ustates = ? where user_id = ?", args);
        System.out.println("update successful!" + update);
    }

    @Override
    public void deleteBook(String id) {
        int update = jdbcTemplate.update("delete from t_user  where user_id = ?", id);
        System.out.println("delete successful!" + update);
    }

    @Override
    public int selectCount() {
        String sql = "select count(*) from t_user";
        int count = jdbcTemplate.queryForObject(sql,Integer.class);
        return count;
    }
}
