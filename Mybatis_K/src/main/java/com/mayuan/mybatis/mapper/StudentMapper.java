package com.mayuan.mybatis.mapper;

import com.mayuan.mybatis.entity.StudentA;

import java.io.IOException;

/**
 * @ClassName StudentMapper
 * @Author：Mayuan
 * @Date 2022/3/6/0006 20:22
 * @Description TODO
 * @Version 1.0
 **/

public interface StudentMapper {

    /** 通过ID 来查找内容 */
    public StudentA findUserById(int id) throws IOException;

}
