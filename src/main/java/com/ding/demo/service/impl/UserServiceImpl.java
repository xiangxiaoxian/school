package com.ding.demo.service.impl;

import com.ding.demo.entity.User;
import com.ding.demo.mapper.UserMapper;
import com.ding.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dhr
 * @since 2021-03-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
