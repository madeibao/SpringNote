package com.mayuan;

/**
 * @ClassName Person
 * @Author：Mayuan
 * @Date 2021/12/26/0026 20:35
 * @Description TODO
 * @Version 1.0
 **/

public class Person {

    //基本类型直接使用
    //<property name="lastName" value="张三"></property>它会自动进行类型转换
    private String lastName;
    private Integer age;
    private String gender;
    private String email;

    public Person(String lastName, Integer age, String gender) {
        super();
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        System.out.println("三个参数的构造器...age");
    }


    public Person(String lastName, String email, String gender) {
        super();
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        System.out.println("三个参数的构造器...email");
    }


    public Person(String lastName, Integer age, String gender, String email) {
        super();
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        System.out.println("有参构造器...");
    }

    public Person() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("person创建了...");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        System.out.println("setLastName..."+lastName);
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person [lastName=" + lastName + ", age=" + age + ", gender="
                + gender + ", email=" + email  + "]";
    }
}
