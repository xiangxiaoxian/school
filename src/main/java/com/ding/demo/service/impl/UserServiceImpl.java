package com.ding.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ding.common.Result;
import com.ding.demo.entity.User;
import com.ding.demo.mapper.UserMapper;
import com.ding.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * 服务实现类
 *
 * @author dhr
 * @since 2021-03-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

  @Resource private UserMapper userMapper;

  // 登录
  @Override
  public Result login(User user) {
    QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
    userQueryWrapper.eq("username", user.getUsername());
    User loginUser = userMapper.selectOne(userQueryWrapper);
    if (ObjectUtils.isEmpty(loginUser)) {
      return Result.error(400, "用户不存在");
    } else if (!user.getPassword().equals(loginUser.getPassword())) {
      return Result.error(400, "密码错误");
    } else if (loginUser.getStatus().equals(1)) {
      return Result.error(401, "账号被冻结");
    }
    return Result.success("success", loginUser);
  }

  @Override
  public Result registerOrUpdate(User user) {
    if (ObjectUtils.isEmpty(user.getId())) {
      // 注册
      int len = userMapper.insert(user);
      if (0 == len) {
        return Result.error(400, "数据错误,注册失败");
      }
      return Result.success("注册成功", len);
    }
    int len = userMapper.updateById(user);
    if (0 == len) {
      return Result.error(400, "数据错误,修改失败");
    }
    return Result.success("success", len);
  }
}
