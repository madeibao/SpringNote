package org.response.www;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName JsonRespon
 * @Author：Mayuan
 * @Date 2024/7/13/星期六 22:22
 * @Description TODO
 * @Version 1.0
 **/
@Controller
@RequestMapping("/return")
public class JsonRespon {

    //返回JSON
    @ResponseBody
    @RequestMapping("json")
    public Person returnJson() {
        Person person = new Person();
        person.setAge(10);
        person.setId(88);
        person.setName("张三");
        return person;
    }

    //返回JSON
    @ResponseBody
    @RequestMapping("jsonlist")
    public List<Person> returnJson2() {
        Person person1 = new Person();
        person1.setAge(10);
        person1.setId(88);
        person1.setName("张三");

        Person person2 = new Person();
        person2.setAge(44);
        person2.setId(22);
        person2.setName("lisi");

        List<Person> persons = Arrays.asList(person1, person2);
        return persons;
    }
}
