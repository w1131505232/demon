package com.woniuxy.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 菜单和接口权限定义
 * </p>
 *
 * @author woniumrwang
 * @since 2023-03-07 02:24:52
 */
@Getter
@Setter
@TableName("t_url_permission")
public class UrlPermission {

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 权限代码
     */
    @TableField("code")
    private String code;

    /**
     * 权限名称
     */
    @TableField("name")
    private String name;

    /**
     * 权限对应的url
     */
    @TableField("url")
    private String url;

    /**
     * 上级菜单id
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 菜单权限还是接口权限：1-菜单权限，2-接口权限
     */
    @TableField("url_type")
    private String urlType;

    /**
     * 创建时间
     */
    @TableField("insert_time")
    private Date insertTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;


}
