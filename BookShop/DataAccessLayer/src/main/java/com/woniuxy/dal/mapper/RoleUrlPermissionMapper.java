package com.woniuxy.dal.mapper;

import com.woniuxy.dal.entity.RoleUrlPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色与菜单、接口权限的对应关系 Mapper 接口
 * </p>
 *
 * @author woniumrwang
 * @since 2023-03-07 02:24:52
 */
@Mapper
public interface RoleUrlPermissionMapper extends BaseMapper<RoleUrlPermission> {

}
