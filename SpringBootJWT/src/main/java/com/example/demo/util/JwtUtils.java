package com.example.demo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;


/**
 * @ClassName JwtUtils
 * @Author：Mayuan
 * @Date 2023/9/8/0008 15:52
 * @Description TODO
 * @Version 1.0
 **/
public class JwtUtils {
    /**Token过期时间，单位:秒，默认半小时过期*/

    private static final long EXPIRATION = 60 * 2L * 1000;

    //密钥，一般长度较长，内容较复杂
    private static final String SECRET = "235404A1A2";

    /**
     * --------------------------------------------------------------------- <br>
     * @Title:createToken
     * @Author:ren
     * @Description:创建Token
     * @Parameters:[claimMap]
     * @Return:[java.util.Map<java.lang.String,java.lang.String>]
     * @Throws:
     * @Version:1.0
     * @Date:2023/8/16 14:40
     * --------------------------------------------------------------------- <br>
     */
    public static String createToken(Map<String, String> claimMap) {
        // 当前时间戳加上设定的毫秒数（1秒 == 1000毫秒）
        System.out.println("预定的过期时间" + EXPIRATION);
        // 得到当前时间 + 过期时间
/**       System.out.println(new Date().getTime() + EXPIRATION); */
        System.out.println(System.currentTimeMillis()+EXPIRATION);
        // Token正式的失效时间（有效时间）
        Date expiration = new Date(System.currentTimeMillis()+EXPIRATION);
        //设置JWT头部
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        // 创建token
        JWTCreator.Builder builder = JWT.create();
        System.out.println("创建Token的参数claimMap:" + claimMap);
        // 使用 Lambda创建 payLoad
        claimMap.forEach((k, v) -> {
            builder.withClaim(k, v);
        });
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(expiration));
        //添加头部，可省略保持默认，默认即 map中的键值对
        return builder.withHeader(map)
                // 设置过期时间
                .withExpiresAt(expiration)
                // 设置签名解码算法
                .sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * --------------------------------------------------------------------- <br>
     * @Title:verifyToken
     * @Author:ren
     * @Description:验证ToKen
     * @Parameters:[token]
     * @Return:[java.lang.String]
     * @Throws:
     * @Version:1.0
     * @Date:2023/8/16 14:40
     * --------------------------------------------------------------------- <br>
     */
    public static DecodedJWT verifyToken(String token) {
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
        System.out.println("验证Token的函数得到的Token:" + verify.getToken());
        System.out.println("验证Token的函数得到的Header:" + verify.getHeader());
        return verify;
    }
}
