package com.example.demo.base.dao;

import java.util.List;

/**
 * @ClassName BaseMapper
 * @Author：Mayuan
 * @Date 2023/8/15/0015 10:38
 * @Description TODO
 * @Version 1.0
 **/
public interface BaseMapper<T> {
    /**
     * @Author linpq
     * @Description //列表查询
     * @Date 14:32 2022/6/18
     * @Param []
     * @return java.util.List<T>
     **/
    List<T> list();

    /**
     * @Author linpq
     * @Description //对象保存
     * @Date 14:32 2022/6/18
     * @Param [t]
     * @return int
     **/
    int save(T t);

    /**
     * @Author linpq
     * @Description //对象删除
     * @Date 14:32 2022/6/18
     * @Param [id]
     * @return int
     **/
    int delete(Integer id);

    /**
     * @Author linpq
     * @Description //对象修改
     * @Date 14:33 2022/6/18
     * @Param [t]
     * @return int
     **/
    int update(T t);

    /**
     * @Author linpq
     * @Description //根据ID查询对象
     * @Date 14:33 2022/6/18
     * @Param [id]
     * @return T
     **/
    T findById(Integer id);
}
