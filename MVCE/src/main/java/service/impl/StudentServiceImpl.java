package service.impl;

import dao.StudentDao;
import domain.Student;
import org.springframework.stereotype.Service;
import service.StudentService;
import javax.annotation.Resource;

import java.util.List;

/**
 * @ClassName StudentServiceImpl
 * @Author：Mayuan
 * @Date 2023/8/12/0012 16:43
 * @Description TODO
 * @Version 1.0
 **/


@Service
public class StudentServiceImpl implements StudentService {

    /**
     * 默认使用byType，如果byType找不到则使用byName(studentDao)
     */

    @Resource
    private StudentDao studentDao;

    @Override
    public int addStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public List<Student> queryStudents() {
        return studentDao.selectAllStudents();
    }
}
