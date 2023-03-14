package com.woniuxy.servicelayer.impl;

import com.woniuxy.dal.entity.RoleUrlPermission;
import com.woniuxy.dal.mapper.RoleUrlPermissionMapper;
import com.woniuxy.servicelayer.RoleUrlPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色与菜单、接口权限的对应关系 服务实现类
 * </p>
 *
 * @author woniumrwang
 * @since 2023-03-07 02:24:52
 */
@Service
public class RoleUrlPermissionServiceImpl extends ServiceImpl<RoleUrlPermissionMapper, RoleUrlPermission> implements RoleUrlPermissionService {

}
