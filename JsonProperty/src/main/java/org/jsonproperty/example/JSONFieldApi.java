package org.jsonproperty.example;

/**
 * @ClassName JSONFieldApi
 * @Author：Mayuan
 * @Date 2024/7/6/星期六 12:05
 * @Description TODO
 * @Version 1.0
 **/
import org.springframework.web.bind.annotation.*;

/**
 * @Author:
 * @Description
 * @Date: 上午10:42 2023/11/9
 */
@RestController
@RequestMapping("/json")
public class JSONFieldApi {

    @GetMapping("/test1")
    public Object testJson() {
        JSONFieldData data = new JSONFieldData();
        data.setName("cjAqNP");
        data.setPhone("bdfuNn");
        data.setAge(399);
        return data;
    }

    @PostMapping("/test2")
    public Object testJson2(@RequestBody JSONFieldData data) {
        return data;
    }
}
