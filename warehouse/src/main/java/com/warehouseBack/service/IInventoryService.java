package com.warehouseBack.service;

import com.warehouseBack.domain.Inventory;
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
public interface IInventoryService extends IService<Inventory> {
    /**
     * 根据仓库Id获取库存
     * @param warehouseId 仓库Id
     * @return 库存
     */
    List<Inventory> getInventoryByWarehouseId(Integer warehouseId);

    /**
     * 根据商品Id获取库存
     * @param productId 商品Id
     * @return 库存
     */
    List<Inventory> getInventoryByProductId(Integer productId);

    /**
     * 根据仓库Id和商品Id获取库存
     * @param warehouseId 仓库id
     * @param productId  商品id
     * @return 库存
     */
    List<Inventory> getInventoryByWarehouseIdAndProductId(Integer warehouseId, Integer productId);
}
