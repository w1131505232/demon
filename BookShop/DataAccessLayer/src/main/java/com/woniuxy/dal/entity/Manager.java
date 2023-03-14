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
 * 内部员工信息
 * </p>
 *
 * @author woniumrwang
 * @since 2023-03-07 02:24:52
 */
@Getter
@Setter
@TableName("t_manager")
public class Manager {

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户代码（登录系统使用）
     */
    @TableField("user_code")
    private String userCode;

    /**
     * 用户姓名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 登录密码
     */
    @TableField("user_password")
    private String userPassword;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 手机号码
     */
    @TableField("cellphone")
    private String cellphone;

    /**
     * 账户是否锁定（1-锁定，0-未锁定）
     */
    @TableField("locked")
    private String locked;

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
