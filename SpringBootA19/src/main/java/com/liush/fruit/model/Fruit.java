package com.liush.fruit.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Fruit
 * @Author：Mayuan
 * @Date 2023/8/27/0027 20:44
 * @Description TODO
 * @Version 1.0
 **/

@Data
@TableName("fruit")
public class Fruit implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer price;

    private Integer count;

}
