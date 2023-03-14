package com.woniuxy.servicelayer;

import com.woniuxy.dal.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniumrwang
 * @since 2023-03-07 02:24:52
 */
public interface UserService extends IService<User> {

    User getUserByAccount(String account);
}
