package com.warehouseBack.service;

import com.warehouseBack.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author XAG
 * @since 2025-09-06
 */
public interface IUserService extends IService<User> {
    /**
     * 获取所有用户
     * @return 用户列表
     */
    List<User> getAllUser();

    /**
     * 添加用户
     * @param user 用户信息
     * @return 是否添加成功
     */
    boolean addUser(User user);

    /**
     * 删除用户
     * @param id 用户id
     * @return 是否删除成功
     */
    boolean deleteUser(Long id);

    /**
     * 更新用户信息
     * @param user 用户信息
     * @return 是否更新成功
     */
    boolean updateUser(User user);


    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 用户信息（不含密码明文，或仅用于验证）
     */
    User getUserByUsername(String username);

    /**
     * 根据id查询用户
     * @param id 用户id
     *  @return 用户信息
     */
    User getUserById(Long id);


}
