package com.warehouseBack.service.impl;

import com.warehouseBack.domain.Inventory;
import com.warehouseBack.dao.InventoryDao;
import com.warehouseBack.service.IInventoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class InventoryServiceImpl extends ServiceImpl<InventoryDao, Inventory> implements IInventoryService {
    @Autowired
    private InventoryDao inventoryDao;
}
