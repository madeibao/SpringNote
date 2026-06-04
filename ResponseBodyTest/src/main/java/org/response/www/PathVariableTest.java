package org.response.www;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName PathVariableController
 * @Author：Mayuan
 * @Date 2024/7/13/星期六 18:04
 * @Description TODO
 * @Version 1.0
 **/
@RestController
public class PathVariableTest {

    @RequestMapping(value = "/test/{username}/{password}")
    public String testAb(@PathVariable String username, @PathVariable String password) {
        System.out.println(username + "   " + password);
        return "ok";
    }
}
