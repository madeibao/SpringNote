package com.mayuan.entity;

/**
 * @ClassName Classes
 * @Author：Mayuan
 * @Date 2022/2/26/0026 20:06
 * @Description TODO
 * @Version 1.0
 **/
public class Classes {

    //定义实体类的属性，与class表中的字段对应

    //id===>c_id
    private int id;

    //name===>c_name
    private String name;

    /**
     * class表中有一个teacher_id字段，所以在Classes类中定义一个teacher属性，
     * 用于维护teacher和class之间的一对一关系，通过这个teacher属性就可以知道这个班级是由哪个老师负责的
     */
    private Teacher teacher;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Classes [id=" + id + ", name=" + name + ", teacher=" + teacher+ "]";
    }
}