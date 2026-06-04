package com.mayuan.spring.dao;

import com.mayuan.spring.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName UserDao
 * @Author：Mayuan
 * @Date 2022/3/3/0003 21:52
 * @Description TODO
 * @Version 1.0
 **/

public interface UserDao {
    /**
     * 根据用户名和密码查询用户
     */
    List<User> getUserByCon(@Param("name") String userName, @Param("pass") String password);

    /**
     * 根据用户名和密码查询用户
     */
    List<User> getUserByCon1(@Param("name") String userName,@Param("pass") String password);

    /**
     * 更新用户
     */
    Integer updateUser(User user);

    /**
     * 根据用户名或者password查询 如果没有用户名和密码默认按照id查询
     * 只能按照三个条件中的一个查询
     */
    List<User> getUserByCondition(@Param("id") Integer id,@Param("userName") String userName,@Param("password") String password);

    /**
     * 用集合查询满足集合内条件的记录
     */
    List<User> getUser(List<String> passwordList);
}
