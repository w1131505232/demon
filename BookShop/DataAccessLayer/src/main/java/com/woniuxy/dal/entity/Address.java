package com.woniuxy.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author woniumrwang
 * @since 2023-03-07 02:24:52
 */
@Getter
@Setter
@TableName("t_address")
public class Address {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("province")
    private String province;

    @TableField("city")
    private String city;

    @TableField("area")
    private String area;

    @TableField("detailAddress")
    private String detailAddress;

    @TableField("tel")
    private String tel;

    @TableField("reciver")
    private String reciver;

    @TableField("emailCode")
    private String emailCode;

    @TableField("userId")
    private Long userId;

    @TableField("isDefault")
    private String isDefault;


}
