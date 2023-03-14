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
@TableName("t_book")
public class Book {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("name")
    private String name;

    @TableField("typeId")
    private Integer typeId;

    @TableField("provider")
    private String provider;

    @TableField("author")
    private String author;

    @TableField("price")
    private BigDecimal price;

    @TableField("detail")
    private String detail;

    @TableField("imgsrc")
    private String imgsrc;

    @TableField("collectioncount")
    private Integer collectioncount;

    @TableField("storecount")
    private Integer storecount;

    @TableField("buycount")
    private Integer buycount;

    /**
     * 点击量
     */
    @TableField("readcount")
    private Integer readcount;

    @TableField("createtime")
    private Date createtime;

    @TableField("updatetime")
    private Date updatetime;


}
