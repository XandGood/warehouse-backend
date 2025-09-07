package com.warehouseBack.service.impl;

import com.warehouseBack.domain.Inventory_record;
import com.warehouseBack.dao.Inventory_recordDao;
import com.warehouseBack.service.IInventory_recordService;
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
public class Inventory_recordServiceImpl extends ServiceImpl<Inventory_recordDao, Inventory_record> implements IInventory_recordService {
    @Autowired
    private Inventory_recordDao inventory_recordDao;

    @Override
    public List<Inventory_record> getInventoryRecordList() {
        return inventory_recordDao.selectList(null);
    }

    @Override
    public boolean addInventoryRecord(Inventory_record inventory_record) {
        return inventory_recordDao.insert(inventory_record) > 0;
    }

    @Override
    public boolean deleteInventoryRecord(int id) {
        return inventory_recordDao.deleteById(id) > 0;
    }
}
