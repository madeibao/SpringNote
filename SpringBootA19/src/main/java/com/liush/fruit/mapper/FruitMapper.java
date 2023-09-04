package com.liush.fruit.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liush.fruit.model.Fruit;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName FruitMapper
 * @Author：Mayuan
 * @Date 2023/8/27/0027 20:48
 * @Description TODO
 * @Version 1.0
 **/

@Mapper
public interface FruitMapper extends BaseMapper<Fruit> { }
