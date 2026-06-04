package com.candy.demo.service;

/**
 * @ClassName UserInfoService
 * @Author：Mayuan
 * @Date 2023/9/7/0007 15:40
 * @Description TODO
 * @Version 1.0
 **/
import com.candy.demo.bean.UserInfo;

import java.util.List;

public interface UserInfoService {
    /**  根据条件进行查询用户所有信息 */
    List<UserInfo> getUserInfoes(UserInfo userinfo);

    /** 实现新增或编辑功能 */
    int editUserInfo(UserInfo userinfo);


    /** 根据主键进行删除*/
    int deleteUserInfoById(Integer id);


}
