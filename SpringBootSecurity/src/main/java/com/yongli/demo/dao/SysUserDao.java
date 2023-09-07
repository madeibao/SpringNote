package com.yongli.demo.dao;

import com.yongli.demo.bean.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName SysUserDao
 * @Author：Mayuan
 * @Date 2023/9/6/0006 20:34
 * @Description TODO
 * @Version 1.0
 **/


@Mapper
public interface SysUserDao {
    /**通过账号获取用户*/
    @Select("select * from sys_user t where t.username = #{username}")
    SysUser getUser(String username);

}
