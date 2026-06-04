package com.mayuan.spring;

/**
 * @ClassName A
 * @Author：Mayuan
 * @Date 2022/1/21/0021 22:28
 * @Description TODO
 * @Version 1.0
 **/
public class StudentA {

    private StudentB studentB ;

    public void setStudentB(StudentB studentB) {
        this.studentB = studentB;
    }

    public StudentA() { }

    public StudentA(StudentB studentB) {
        this.studentB = studentB;
    }
}