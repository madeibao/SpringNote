package com.candy.demo.service.impl;

import com.candy.demo.bean.UserInfo;
import com.candy.demo.dao.UserInfoMapper;
import com.candy.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserInfoServiceImpl
 * @Author：Mayuan
 * @Date 2023/9/7/0007 15:41
 * @Description TODO
 * @Version 1.0
 **/

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoMapper mapper;

    @Override
    public List<UserInfo> getUserInfoes(UserInfo userinfo) {
        return mapper.getUserInfoes(userinfo);
    }

    /**
     * 新增或编辑用户信息
     * @param userinfo
     * @return
     */
    @Override
    public int editUserInfo(UserInfo userinfo) {
//        根据用户传递的信息，是有传递用户id
//        若传id，则为新增；反之为修改
        Integer userId=userinfo.getId();
        int num=0;
        if(userId!=null){
//           修改
            num= mapper.updateByPrimaryKeySelective(userinfo);
        }else{
//           新增
            num= mapper.insertSelective(userinfo);
        }
        return num;
    }
    //删除操作
    @Override
    public int deleteUserInfoById(Integer id) {
//       在服务端实现参数设置问题
        UserInfo userinfo=new UserInfo();
        userinfo.setId(id);
        userinfo.setIsdelete(1);
//       利用删除标识，进行逻辑删除。将isdelete值设置为1
        return mapper.updateByPrimaryKeySelective(userinfo);
    }
}