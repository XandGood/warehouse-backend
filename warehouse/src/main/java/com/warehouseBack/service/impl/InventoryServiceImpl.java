package com.warehouseBack.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.warehouseBack.domain.Inventory;
import com.warehouseBack.dao.InventoryDao;
import com.warehouseBack.service.IInventoryService;
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
public class InventoryServiceImpl extends ServiceImpl<InventoryDao, Inventory> implements IInventoryService {
    @Autowired
    private InventoryDao inventoryDao;

    @Override
    public List<Inventory> getInventoryByWarehouseId(Integer warehouseId) {
        LambdaQueryWrapper<Inventory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Inventory::getWarehouse_id, warehouseId);
        return inventoryDao.selectList(queryWrapper);
    }

    @Override
    public List<Inventory> getInventoryByProductId(Integer productId) {
        LambdaQueryWrapper<Inventory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Inventory::getProduct_id, productId);
        return inventoryDao.selectList(queryWrapper);
    }


    @Override
    public List<Inventory> getInventoryList(){
        return inventoryDao.selectList(null);
    }


}
