package com.example.demo.po;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName User
 * @Author：Mayuan
 * @Date 2023/9/16/0016 19:57
 * @Description TODO
 * @Version 1.0
 **/

@Data
@Getter
@Setter
public class User {
    private Integer id;
    private String username;
    private String password;
    private String perms;
}
