package com.warehouseBack.service.impl;

import com.warehouseBack.domain.User;
import com.warehouseBack.dao.UserDao;
import com.warehouseBack.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
