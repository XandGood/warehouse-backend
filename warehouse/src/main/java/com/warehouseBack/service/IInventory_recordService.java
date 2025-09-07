package com.warehouseBack.service;

import com.warehouseBack.domain.Inventory_record;
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
public interface IInventory_recordService extends IService<Inventory_record> {
    /**
     * 查询库存列表
     * @return 库存列表
     */
    List<Inventory_record> getInventoryRecordList();
    /**
     * 添加库存记录
     * @param inventory_record 库存信息
     * @return 是否添加成功
     */
    boolean addInventoryRecord(Inventory_record inventory_record);
    /**
     * 删除库存记录
     * @param id 库存记录id
     * @return 是否删除成功
     */
    boolean deleteInventoryRecord(int id);
}
