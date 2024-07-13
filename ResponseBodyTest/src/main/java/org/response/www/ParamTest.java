package org.response.www;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ParamTest
 * @Author：Mayuan
 * @Date 2024/7/13/星期六 18:45
 * @Description TODO
 * @Version 1.0
 **/

@RestController
@RequestMapping("/mvc")
public class ParamTest {
    /*required：是否必须。默认为 true, 表示请求参数中必须包含对应
     的参数，若不存在，将抛出异常*/
    @RequestMapping("/testRequestParam")
    public String testRequestParam(
            @RequestParam(value = "username") String username1,
            @RequestParam(value = "age", required = false) Integer age1) {

        System.out.println("testRequestParam: " + "username=" + username1 + "; " + "age=" + age1);
        return "success";
    }
}
