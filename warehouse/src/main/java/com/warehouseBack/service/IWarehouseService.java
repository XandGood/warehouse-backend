package com.warehouseBack.service;

import com.warehouseBack.domain.Warehouse;
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
public interface IWarehouseService extends IService<Warehouse> {
    /**
     * 获取仓库列表
     * @return 仓库列表
     */
    List<Warehouse> getWarehouseList();

    /**
     * 添加仓库
     * @Param warehouse 仓库信息
     * @return 是否添加成功
     */
    boolean addWarehouse(Warehouse warehouse);

    /**
     * 删除仓库
     * @Param warehouseId 仓库id
     * @return 是否删除成功
     */
    boolean deleteWarehouse(int warehouseId);

}
