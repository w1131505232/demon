package com.woniuxy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User2 {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id2;

    @TableField("name")
    private String name2;

    @TableField("age")
    private Integer age2;

    @TableField("email")
    private String email2;
}
