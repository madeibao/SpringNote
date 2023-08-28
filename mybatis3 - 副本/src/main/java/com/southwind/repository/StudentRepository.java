package com.southwind.repository;

import com.southwind.entity.Student;

/**
 * @ClassName StudentRepository
 * @Author：Mayuan
 * @Date 2020/12/25/0025 20:17
 * @Description TODO
 * @Version 1.0
 **/

public interface StudentRepository {
    public Student findById(long id);
}
