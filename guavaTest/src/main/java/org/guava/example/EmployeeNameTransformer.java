package org.guava.example;

/**
 *
 *
 * @ClassName EmployeeNameTransformer
 * @Author：Mayuan
 * @Date 2024/7/13/星期六 11:56
 * @Description TODO
 * @Version 1.0
 **/

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Collections2;
import java.util.Collection;
import java.util.List;

public class EmployeeNameTransformer {
    static class Employee {
        String name;
        Employee(String name) {
            this.name = name;
        }
        String getName() {
            return name;
        }
    }
    public static void main(String[] args) {
        List<Employee> employees = Lists.newArrayList(
                new Employee("Alice"),
                new Employee("Bob"),
                new Employee("Charlie")
        );
        // 使用Guava的Functions转换
        Collection<String> names = Collections2.transform(employees, Employee::getName);
        Collection<String> nameList = Collections2.transform(employees, employee -> employee.getName());
        System.out.println(names);

        System.out.println("--------------------");
        System.out.println(nameList);

        System.out.println("--------------------");
        Collection<String> nameList2 = Collections2.transform(employees, new Function<Employee, String>() {
            @Override
            public String apply(Employee employee) {
                return employee.getName();
            }
        });
        System.out.println(nameList2);
    }
}
