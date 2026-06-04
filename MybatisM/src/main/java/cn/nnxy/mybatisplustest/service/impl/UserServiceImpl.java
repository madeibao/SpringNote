package cn.nnxy.mybatisplustest.service.impl;

import cn.nnxy.mybatisplustest.entity.User;
import cn.nnxy.mybatisplustest.mapper.UserMapper;
import cn.nnxy.mybatisplustest.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author huangjianquan
 * @date 2022/9/30
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

}
