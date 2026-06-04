package com.yongli.demo.dao;

import com.yongli.demo.bean.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName PermissionDao
 * @Author：Mayuan
 * @Date 2023/9/6/0006 20:33
 * @Description TODO
 * @Version 1.0
 **/


@Mapper
public interface PermissionDao {

    /*
     * 通过用户id获取权限
     * */

    @Select("select p.* from sys_permission p inner " +
            "join sys_role_permission rp on p.id=rp.permissionId  inner join sys_role_user ru on ru.roleId = rp.roleId where ru.userId = #{userId}")
    List<Permission> listByUserId(Long userId);
}
