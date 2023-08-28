package com.jiuqi.springjdbc.dao.impl;

import com.jiuqi.springjdbc.dao.UserDao;
import com.jiuqi.springjdbc.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author JiuQi 玖柒
 * @date 2021/5/13 19:08
 */
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(User user) {
        return jdbcTemplate.update("insert into t_user(name,pwd,age,birthday) values(?,?,?,?)", user.getName(), user.getPwd(), user.getAge(), user.getBirthday());
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update("update t_user set pwd=? where id=?", user.getPwd(), user.getId());
    }

    @Override
    public List<User> sel() {
        return jdbcTemplate.query("select * from t_user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                // 由列名定位列
                User user = new User();
                user.setAge(rs.getInt("age"));
                user.setBirthday(rs.getDate("birthday"));
                user.setName(rs.getString("name"));
                user.setId(rs.getInt("id"));
                user.setPwd(rs.getString("pwd"));
                return user;
            }
        });
    }

    @Override
    public int del(int id) {
        return jdbcTemplate.update("delete from t_user where id=?", id);
    }
}
