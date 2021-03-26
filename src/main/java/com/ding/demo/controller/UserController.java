package com.ding.demo.controller;


import com.ding.common.Result;
import com.ding.demo.entity.User;
import com.ding.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  用户
 * </p>
 *
 * @author dhr
 * @since 2021-03-23
 */
@Api(tags = {"用户相关"},value = "UserController")
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation("登录")
    @PostMapping
    public Result login(@RequestBody User user){
        return userService.login(user);
    }

    @ApiOperation("注册/修改资料")
    @PutMapping
    public Result registerOrUpdate(@RequestBody User user){
        return userService.registerOrUpdate(user);
    }

}
