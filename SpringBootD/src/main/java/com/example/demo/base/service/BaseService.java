package com.example.demo.base.service;

import com.example.demo.base.dao.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName BaseService
 * @Author：Mayuan
 * @Date 2023/8/15/0015 10:39
 * @Description TODO
 * @Version 1.0
 **/
public class BaseService<T,M extends BaseMapper<T>> {

    @Autowired
    M mapper;

    public List<T> findList(){
        return mapper.list();
    }

    public int save(T t){
        return mapper.save(t);
    }

    public int delete(Integer id){
        return mapper.delete(id);
    }

    public int update(T t){
        return mapper.update(t);
    }

    public T findById(Integer id){
        return mapper.findById(id);
    }
}
