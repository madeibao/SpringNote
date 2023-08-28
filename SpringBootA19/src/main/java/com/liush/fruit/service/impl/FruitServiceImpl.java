package com.liush.fruit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liush.fruit.mapper.FruitMapper;
import com.liush.fruit.model.Fruit;
import com.liush.fruit.service.FruitService;
import org.springframework.stereotype.Service;

/**
 * @ClassName FruitServiceImpl
 * @Author：Mayuan
 * @Date 2023/8/27/0027 20:53
 * @Description TODO
 * @Version 1.0
 **/

@Service
public class FruitServiceImpl extends ServiceImpl<FruitMapper, Fruit> implements FruitService {
}
