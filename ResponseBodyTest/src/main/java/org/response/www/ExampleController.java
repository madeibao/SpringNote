package org.response.www;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ExampleController
 * @Author：Mayuan
 * @Date 2024/7/13/星期六 17:51
 * @Description TODO
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api")
public class ExampleController {

    @GetMapping("/data")
    @ResponseBody
    public Map<String, String> getData() {
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        data.put("key2", "value2");
        return data;
    }
}