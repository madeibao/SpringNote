package com.example.demo.shrio;

import com.example.demo.po.User;
import com.example.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName UserRealm
 * @Author：Mayuan
 * @Date 2023/9/16/0016 20:04
 * @Description TODO
 * @Version 1.0
 **/
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
//      给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        添加资源的授权字符串--硬编码
//        info.addStringPermission("user:add:*");

        // 获取当前登录的用户
        Subject subject = SecurityUtils.getSubject();
        User usernow = (User) subject.getPrincipal();
        // 到数据库查询用户的资源权限
        User userdb =  userService.findById(usernow.getId());

        // 用户动态授权
        info.addStringPermission(userdb.getPerms());
        return info;
    }

    /**
     * 执行认证逻辑
     * @param authenticationToken 携带token过来，token中包含登录的信息（用户输入的信息）
     * @return
     * @throws AuthenticationException
     */


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        // 编写登录验证的逻辑
        // 模拟数据库的用户名和密码
//        String username = "123";
//        String password = "123";
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.findByName(token.getUsername());
//        判断用户名
//        if (!token.getUsername().equals(username)){
////            return new UnknownAccountException("用户不存在");
//            return null;
//        }
////        判断密码
//        return new SimpleAuthenticationInfo("",password,"");
        // 没有该用户时，本身会抛出异常
        if(user==null){
            return null;
        }
        // 登录成功时，将user对象作为principal,user.getPassword是从数据库拿到的数据
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");

    }
}
