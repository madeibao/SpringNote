package org.response.www;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName PathVariableAa
 * @Author：Mayuan
 * @Date 2024/7/13/星期六 18:16
 * @Description TODO
 * @Version 1.0
 **/

@RestController
public class PathVariableAa {

    /**
     * 使用”{参数名}“在路径中充当占位符，在方法的参数列表中需要使用@PathVariable注解来修饰形式参数
     * 当请求的时候，在浏览器的地址栏中输入http://ip+port/项目工程路径/test/zhangsan
     * @param username
     * @return
     */
    @RequestMapping(value = "/test/{username}")
    public String testAa(@PathVariable String username) {
        System.out.println(username);
        return "one pathVariable";
    }
}
