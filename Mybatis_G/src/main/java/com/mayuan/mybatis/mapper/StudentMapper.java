package com.mayuan.mybatis.mapper;

import com.mayuan.mybatis.entity.StudentA;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName StudentMapper
 * @Author：Mayuan
 * @Date 2022/3/2/0002 21:48
 * @Description TODO
 * @Version .0A
 **/

public interface StudentMapper {
    public List<StudentA> query();
    /**
     * 添加使用map进行传递参数**/
    public List<StudentA> query(Map<String,Object> map );
    /**修改*/
    public int update(Map<String,Object> map);
    /**查询*/
    public List<StudentA> queryById();
    public List<StudentA> show(@Param("ids") int[] ids);

}