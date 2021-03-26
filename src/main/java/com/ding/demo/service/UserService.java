package com.ding.demo.service;

import com.ding.common.Result;
import com.ding.demo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dhr
 * @since 2021-03-23
 */
public interface UserService extends IService<User> {

    Result login(User user);

    Result registerOrUpdate(User user);
}
