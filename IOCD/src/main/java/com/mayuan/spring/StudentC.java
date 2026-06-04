package com.mayuan.spring;

/**
 * @ClassName C
 * @Author：Mayuan
 * @Date 2022/1/21/0021 22:29
 * @Description TODO
 * @Version 1.0
 **/

public class StudentC {

    private StudentA studentA ;

    public void setStudentA(StudentA studentA) {
        this.studentA = studentA;
    }

    public StudentC() {
    }

    public StudentC(StudentA studentA) {
        this.studentA = studentA;
    }
}