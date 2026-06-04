package service;

import domain.Student;

import java.util.List;

/**
 * @ClassName StudentService
 * @Author：Mayuan
 * @Date 2023/8/12/0012 16:43
 * @Description TODO
 * @Version 1.0
 **/


public interface StudentService {
    int addStudent(Student student);

    List<Student> queryStudents();
}
