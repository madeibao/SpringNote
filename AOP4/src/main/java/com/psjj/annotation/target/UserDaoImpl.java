package com.psjj.annotation.target;

/**
 * @ClassName UserDaoImpl
 * @Author：Mayuan
 * @Date 2022/4/16/0016 20:46
 * @Description TODO
 * @Version 1.0
 **/
public class UserDaoImpl implements UserDao {

    @Override
    public void add() {
        System.out.println("增加方法");
    }

    @Override
    public void del() {
        System.out.println("删除方法");
    }

    @Override
    public void update() {
        System.out.println("修改方法");
    }

    @Override
    public String query() {
        System.out.println("查询方法");
        return "data";
    }