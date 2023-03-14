package com.woniuxy.servicelayer.impl;

import com.woniuxy.dal.entity.Order;
import com.woniuxy.dal.mapper.OrderMapper;
import com.woniuxy.servicelayer.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniumrwang
 * @since 2023-03-07 02:24:52
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
