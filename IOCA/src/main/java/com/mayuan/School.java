package com.mayuan;

/**
 * @ClassName School
 * @Author：Mayuan
 * @Date 2022/1/18/0018 22:47
 * @Description TODO
 * @Version 1.0
 **/
public class School {
    private Students students;
    private Teachers teachers;

    public School(Students students, Teachers teachers) {
        this.students = students;
        this.teachers = teachers;
    }
    public Students getStudents() {
        return students;
    }

    public Teachers getTeachers() {
        return teachers;
    }
}
