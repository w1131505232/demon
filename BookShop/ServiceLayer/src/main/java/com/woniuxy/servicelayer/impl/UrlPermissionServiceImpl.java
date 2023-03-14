package com.woniuxy.servicelayer.impl;

import com.woniuxy.dal.entity.UrlPermission;
import com.woniuxy.dal.mapper.UrlPermissionMapper;
import com.woniuxy.servicelayer.UrlPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单和接口权限定义 服务实现类
 * </p>
 *
 * @author woniumrwang
 * @since 2023-03-07 02:24:52
 */
@Service
public class UrlPermissionServiceImpl extends ServiceImpl<UrlPermissionMapper, UrlPermission> implements UrlPermissionService {

}
