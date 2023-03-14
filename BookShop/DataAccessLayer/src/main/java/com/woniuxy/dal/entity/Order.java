package com.woniuxy.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
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
@TableName("t_order")
public class Order {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("orderNum")
    private String orderNum;

    @TableField("totalprice")
    private BigDecimal totalprice;

    @TableField("userId")
    private Long userId;

    @TableField("addressId")
    private Long addressId;

    @TableField("createtime")
    private Date createtime;

    @TableField("state")
    private Integer state;


}
