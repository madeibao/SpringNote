package com.candy.dao;

import com.candy.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    /**根据条件进行查询
        （if标签：根据传入的参数进行动态拼接，传入的参数不为空的时候进行拼接，为空则不拼接）
     */
    List<UserInfo> selectUserInfo(UserInfo userInfo);

    /**根据条件进行查询
     * choose、when、otherwise：类似于java中的switch，从多个条件中选择一个执行
     */
    List<UserInfo> selectUserInfo2(UserInfo userInfo);

    /** foreach标签讲解，传入的参数为集合类型 */
    List<UserInfo> selectUserInfoByIds(List<Integer> ids);

    /**模糊查询讲解*/
    List<UserInfo> selectUserInfoByLike(UserInfo userInfo);

    /** 多参数传递问题解决（方式一，指定参数位置）*/
    List<UserInfo> selectUserByParams(String username,String useraddress);

    /** 多参数传递问题解决（方式二，使用param注解,指定参数的名字）*/
    List<UserInfo> selectUserByParams2(@Param("username") String username, @Param("useraddress") String useraddress);

    /**多参数传递问题解决（方式二，使用param注解,指定参数的名字）*/
    List<UserInfo> selectUserByParams3(@Param("userinfo") UserInfo userInfo, @Param("isDesc") String isDesc);

}