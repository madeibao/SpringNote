package com.mayuan.mybatis.dao;

import com.mayuan.mybatis.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName StudentDao
 * @Author：Mayuan
 * @Date 2023/8/31/0031 14:49
 * @Description TODO
 * @Version 1.0
 **/
public interface StudentDao {

    /**
     * 更新学生信息
     * @Parameter Student student
     */

    int updateStudent(Student student);


    /**${}占位符的使用，使用@Param命名参数*/
    List<Student> queryStudent(@Param("studentName") String name);

    /** ${} 按照某一列来进行排序*/
    List<Student> queryStudentOrderByColName(@Param("myName") String myName,
                                             @Param("colName") String colName,
                                             @Param("tableName") String tableName);



    Student selectById(Integer id);



    long countStudent();



    /**Map 类型映射*/
    Map<Object,Object> selectMap(@Param("stuid") Integer id);

}
