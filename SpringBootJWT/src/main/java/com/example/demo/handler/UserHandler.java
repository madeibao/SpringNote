package com.example.demo.handler;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.pojo.Users;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserHandler
 * @Author：Mayuan
 * @Date 2023/9/8/0008 15:55
 * @Description TODO
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping("/user")
public class UserHandler {
    /** 注入Service*/

    @Resource
    UserService userService;

    @GetMapping("/login")
    public Map<String, Object> login(Users users) {
        log.info("username:{}", users.getName());
        log.info("password:{}", users.getPassword());
        Map<String, Object> map = new HashMap<>();
        Users login = userService.login(users);
        System.out.println("handler" + login);
        try {
            if (null != login) {
                Map<String, String> payload = new HashMap<>();
                payload.put("id", login.getId() + "");
                payload.put("name", login.getName());
                payload.put("password", login.getPassword());
                // 生成JWT的令牌
                String token = JwtUtils.createToken(payload);
                map.put("state", true);
                map.put("msg", "认证成功");
                // 响应token
                map.put("token", token);
            }
        } catch (Exception e) {
            map.put("state", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }


    @PostMapping("/other")
    public Map<String, Object> test(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        //处理自己业务逻辑
        String token = request.getHeader("token");
        System.out.println("控制器中的Token" + token);
        DecodedJWT verify = JwtUtils.verifyToken(token);
        log.info("用户id: [{}]", verify.getClaim("id").asString());
        log.info("用户name: [{}]", verify.getClaim("name").asString());
        map.put("state", true);
        map.put("msg", "请求成功!");
        return map;
    }
}
