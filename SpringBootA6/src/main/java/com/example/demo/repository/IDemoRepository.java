package com.example.demo.repository;

import com.example.demo.entity.Demo;
import org.springframework.data.repository.CrudRepository;

/**
 * @ClassName IDemoRepository
 * @Author：Mayuan
 * @Date 2023/8/15/0015 16:45
 * @Description TODO
 * @Version 1.0
 **/

public interface IDemoRepository extends CrudRepository<Demo,Integer> {

}

