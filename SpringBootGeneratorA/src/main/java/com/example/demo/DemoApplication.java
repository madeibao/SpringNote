package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

//  http://localhost:8080/user
//   http://localhost:8080/user/1  根据 id 来查询

//  http://localhost:8080/user/page?pageNum=1&pageSize=2


    // postman 测试，选择数据为JSON, 没有 id 参数时，为新增内容
//        {
//            "username":"Rina",
//            "password":"223232"
//        }

// 有 id 参数时间为 更新内容

//    {
//        "id":"2",
//        "username":"Rina",
//        "password":"223232"
//        }


// 删除接口测试：
// Delete    http://localhost:8080/user/12


//POST http://localhost:8080/user/del/batch

//postMan 传递参数
//    [
//        10,11
//        ]



