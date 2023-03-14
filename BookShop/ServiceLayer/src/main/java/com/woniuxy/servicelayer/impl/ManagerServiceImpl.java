package com.woniuxy.servicelayer.impl;

import com.woniuxy.dal.entity.Manager;
import com.woniuxy.dal.mapper.ManagerMapper;
import com.woniuxy.servicelayer.ManagerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 内部员工信息 服务实现类
 * </p>
 *
 * @author woniumrwang
 * @since 2023-03-07 02:24:52
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements ManagerService {

}
