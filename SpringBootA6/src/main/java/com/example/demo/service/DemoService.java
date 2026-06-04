package com.example.demo.service;

import com.example.demo.entity.Demo;
import com.example.demo.repository.IDemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName DemoService
 * @Author：Mayuan
 * @Date 2023/8/15/0015 16:45
 * @Description TODO
 * @Version 1.0
 **/

/**
 * //定义业务逻辑层
 * @author ASUS
 */
@Service("demoService")
public class DemoService {

    /**
     * //自动装配
     */
    @Autowired
    private IDemoRepository demoRepository;

    public void save(Demo demo){
        demoRepository.save(demo);
    }
}
