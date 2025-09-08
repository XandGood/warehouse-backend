package com.warehouseBack.controller;


import com.warehouseBack.annotation.RequireRole;
import com.warehouseBack.domain.User;
import com.warehouseBack.dto.LoginDTO;
import com.warehouseBack.service.IUserService;
import com.warehouseBack.utils.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
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

    @RequireRole
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除用户")
    public void deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
    }

    @RequireRole
    @PutMapping("/update")
    @ApiOperation(value = "更新用户")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }


    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "返回JWT令牌")
    public String login(@RequestParam String username, @RequestParam String password) {
        // 1. 根据用户名查询用户
        User user = userService.getUserByUsername(username);
        if (user == null) {
            return "用户名不存在";
        }

        // 2. 明文比对密码（不加密）
        if (!user.getPassword().equals(password)) {
            return "密码错误";
        }

        // 3. 生成Token并返回
        String token = JwtUtils.generateToken(username);
        return token; // 直接返回Token字符串
    }
}

