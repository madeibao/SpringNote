package domain;

/**
 * @author HLF
 * @version V1.0
 * @package domain
 * @date 2021/11/2 21:42
 * 保存请求参数值的一个普通类
 * 类中的属性名要和请求中的参数名一样
 */
public class Student {
    private String name;
    private Integer age;

    public Student() {}

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
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
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
