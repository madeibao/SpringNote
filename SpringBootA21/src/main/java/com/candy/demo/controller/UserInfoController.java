package com.candy.demo.controller;

/**
 * @ClassName UserInfoController
 * @Author：Mayuan
 * @Date 2023/9/7/0007 15:42
 * @Description TODO
 * @Version 1.0
 **/
import com.candy.demo.bean.UserInfo;
import com.candy.demo.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("/getUserInfoes")
    public PageInfo<UserInfo> getUserInfoes(Integer pageNum, Integer pageSize, UserInfo userinfo){
        System.out.println(pageNum);
        System.out.println(pageSize);
//       调用PageHelper.startPage，跟在后面的第一个select语句会实现分页处理
        PageHelper.startPage(pageNum,pageSize);
//        查询数据结果，返回结果集
        List<UserInfo>  userinfoes=userInfoService.getUserInfoes(userinfo);
//        将再有分页信息的结果响应给前端
        PageInfo<UserInfo> pageInfo=new PageInfo<>(userinfoes);
//       打印最终的结果信息
        System.out.println("pagehelper:::::::::::::::::::");
        System.out.println("total:"+pageInfo.getTotal());
        System.out.println("size:"+pageInfo.getSize());
        System.out.println("list:"+pageInfo.getList());
        System.out.println("pageInfo:"+pageInfo);
        return pageInfo;
    }

    /**新增或修改*/
    @RequestMapping("/editUserInfo")
    public int editUserInfo(UserInfo userinfo){
        return userInfoService.editUserInfo(userinfo);
    }

    /**
     * 删除方法
     */
    @RequestMapping("deleteUserInfoById")
    public int deleteUserInfoById(Integer id){
        return userInfoService.deleteUserInfoById(id);
    }

}
