package cn.nnxy.mybatisplustest.mapper;

import cn.nnxy.mybatisplustest.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author huangjianquan
 * @date 2022/9/30
 **/


@Mapper
public interface UserMapper extends BaseMapper<User> {

}
