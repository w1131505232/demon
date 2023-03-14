package com.woniuxy.servicelayer.impl;

import com.woniuxy.dal.entity.OrderItem;
import com.woniuxy.dal.mapper.OrderItemMapper;
import com.woniuxy.servicelayer.OrderItemService;
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
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {

}
