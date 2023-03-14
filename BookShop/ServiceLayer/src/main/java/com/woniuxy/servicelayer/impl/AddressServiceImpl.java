package com.woniuxy.servicelayer.impl;

import com.woniuxy.dal.entity.Address;
import com.woniuxy.dal.mapper.AddressMapper;
import com.woniuxy.servicelayer.AddressService;
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
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

}
