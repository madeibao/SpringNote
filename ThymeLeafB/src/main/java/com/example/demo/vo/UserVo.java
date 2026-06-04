package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName UserVo
 * @Author：Mayuan
 * @Date 2021/12/26/0026 15:32
 * @Description TODO
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
public class UserVo implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private Date created;
}
