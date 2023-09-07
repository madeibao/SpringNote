package com.yongli.demo.dto;

import com.yongli.demo.bean.SysUser;

import java.util.List;

/**
 * @ClassName UserDto
 * @Author：Mayuan
 * @Date 2023/9/6/0006 20:36
 * @Description TODO
 * @Version 1.0
 **/
public class UserDto extends SysUser {

    private static final long serialVersionUID = -184009306207076712L;

    private List<Long> roleIds;

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

}
