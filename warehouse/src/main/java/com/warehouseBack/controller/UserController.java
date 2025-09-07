package com.warehouseBack.controller;


import com.warehouseBack.domain.User;
import com.warehouseBack.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author XAG
 * @since 2025-09-06
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理接口")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/list")
    @ApiOperation(value = "获取用户列表")
    public List<User> getUserList() {
        return userService.getAllUser();
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加用户")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @DeleteMapping
    @ApiOperation(value = "删除用户")
    public void deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
    }

    @PutMapping
    @ApiOperation(value = "更新用户")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }
}

