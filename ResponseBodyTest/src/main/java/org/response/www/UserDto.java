package org.response.www;

/**
 * @ClassName UserDto
 * @Author：Mayuan
 * @Date 2024/7/13/星期六 22:38
 * @Description TODO
 * @Version 1.0
 **/
public class UserDto {
    //用户id
    private Long id;
    //姓名
    private String name;
    //年龄
    private Integer age;

    public UserDto() {
    }

    public UserDto(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}