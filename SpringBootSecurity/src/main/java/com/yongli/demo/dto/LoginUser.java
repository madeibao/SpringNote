package com.yongli.demo.dto;

/**
 * @ClassName LoginUser
 * @Author：Mayuan
 * @Date 2023/9/6/0006 20:35
 * @Description TODO
 * @Version 1.0
 **/
import com.yongli.demo.bean.Permission;
import com.yongli.demo.bean.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.util.StringUtils;

public class LoginUser extends SysUser implements UserDetails {

    private List<Permission>  list;

    public List<Permission> getList() {
        return list;
    }

    public void setList(List<Permission> list) {
        this.list = list;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {



        return  list.stream().filter(p->!StringUtils.isEmpty(p.getPermission())).map(p-> new SimpleGrantedAuthority(p.getPermission()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
