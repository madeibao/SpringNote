package com.yongli.demo.service;

import com.yongli.demo.bean.Permission;
import com.yongli.demo.bean.SysUser;
import com.yongli.demo.dao.PermissionDao;
import com.yongli.demo.dao.SysUserDao;
import com.yongli.demo.dto.LoginUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName userDetailsServiceImpl
 * @Author：Mayuan
 * @Date 2023/9/6/0006 20:37
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class userDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername");

        //按照名字查询用户
        SysUser sysUser = sysUserDao.getUser(username);
        if (sysUser == null) {
            throw new AuthenticationCredentialsNotFoundException("用户名不存在");
        }

        LoginUser loginUser = new LoginUser();
        BeanUtils.copyProperties(sysUser, loginUser);
        //通过用户id返回权限表
        List<Permission> permissions = permissionDao.listByUserId(sysUser.getId());
        loginUser.setList(permissions);
        System.out.println("用户"+sysUser.toString());
        System.out.println("权限列表"+permissions.toString());
        return loginUser;
    }
}
