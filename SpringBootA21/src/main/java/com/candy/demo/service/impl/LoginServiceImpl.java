package com.candy.demo.service.impl;

/**
 * @ClassName LoginServiceImpl
 * @Author：Mayuan
 * @Date 2023/9/7/0007 15:41
 * @Description TODO
 * @Version 1.0
 **/
import com.candy.demo.bean.UserInfo;
import com.candy.demo.dao.UserInfoMapper;
import com.candy.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**业务逻辑处理层，处理对应的业务逻辑*/
@Service
public class LoginServiceImpl implements LoginService {
    //    依赖注入持久层
    @Autowired
    UserInfoMapper mapper;

    @Override
    public boolean login(UserInfo userInfo) {
//        调用持久层，判断，用户名密码是否匹配
        List<UserInfo> ls= mapper.login(userInfo);
//       若匹配，则数据库查询结果有返回值，则集合不为空，且有数据返回
        if(ls.size()>0 &&  ls!=null ){
//            有内容则返回true
            return true;
        }else {
//            反之返回false
            return false;
        }

    }
}
