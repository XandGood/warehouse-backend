package com.warehouseBack.service.impl;

import com.warehouseBack.domain.Warehouse;
import com.warehouseBack.dao.WarehouseDao;
import com.warehouseBack.service.IWarehouseService;
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
public class WarehouseServiceImpl extends ServiceImpl<WarehouseDao, Warehouse> implements IWarehouseService {
    @Autowired
    private WarehouseDao warehouseDao;

    @Override
    public List<Warehouse> getWarehouseList() {
        return warehouseDao.selectList(null);
    }

    @Override
    public boolean addWarehouse(Warehouse warehouse) {
        return warehouseDao.insert(warehouse) > 0;
    }

    @Override
    public boolean deleteWarehouse(int warehouseId) {
        return warehouseDao.deleteById(warehouseId) > 0;
    }

}
