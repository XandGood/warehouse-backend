package com.warehouseBack.service.impl;

import com.warehouseBack.domain.User;
import com.warehouseBack.dao.UserDao;
import com.warehouseBack.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author XAG
 * @since 2025-09-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUser() {
        return userDao.selectList(null);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.insert(user) > 0;
    }

    @Override
    public boolean deleteUser(Long id) {
        return userDao.deleteById(id) > 0;
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateById(user) > 0;
    }

}
