package dao;

import domain.Student;

import java.util.List;

/**
 * @ClassName StudentDao
 * @Author：Mayuan
 * @Date 2023/8/12/0012 16:41
 * @Description TODO
 * @Version 1.0
 **/

public interface StudentDao {
    /**
     * 增加一个学生
     * @param student
     * @return
     */
    int insertStudent(Student student);

    /**
     * 查询所有学生
     * @return
     */
    List<Student> selectAllStudents();
}
