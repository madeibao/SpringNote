package com.candy.demo.dao;

import com.candy.demo.bean.UserInfo;

import java.util.List;

/**
 * @ClassName UserInfoMapper
 * @Author：Mayuan
 * @Date 2023/9/7/0007 15:27
 * @Description TODO
 * @Version 1.0
 **/
public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);


    /** 根据用户名密码查询 */
    List<UserInfo> login(UserInfo userInfo);

    /**根据条件查询数据 */
    List<UserInfo> getUserInfoes(UserInfo userInfo);

}