package cn.nnxy.mybatisplustest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author huangjianquan
 * @date 2022/9/30
 **/

@Data
@TableName("user")
public class User {
    /**
     * 自增长
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String school;
}
