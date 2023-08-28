package com.mayuan.spring;

/**
 * @ClassName B
 * @Author：Mayuan
 * @Date 2022/1/21/0021 22:29
 * @Description TODO
 * @Version 1.0
 **/
public class StudentB {

    private StudentC studentC ;

    public void setStudentC(StudentC studentC) {
        this.studentC = studentC;
    }

    public StudentB() {
    }

    public StudentB(StudentC studentC) {
        this.studentC = studentC;
    }
}