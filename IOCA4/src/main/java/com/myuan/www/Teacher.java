package com.myuan.www;

/**
 * @ClassName Teacher
 * @Author：Mayuan
 * @Date 2023/8/3/0003 9:43
 * @Description TODO
 * @Version 1.0
 **/
public class Teacher {

    String name;
    int age;
    long TeacherNum;

    public Teacher() {}
    public Teacher(String name, int age, long teacherNum) {
        this.name = name;
        this.age = age;
        TeacherNum = teacherNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getTeacherNum() {
        return TeacherNum;
    }

    public void setTeacherNum(long teacherNum) {
        TeacherNum = teacherNum;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", TeacherNum=" + TeacherNum +
                '}';
    }
}
