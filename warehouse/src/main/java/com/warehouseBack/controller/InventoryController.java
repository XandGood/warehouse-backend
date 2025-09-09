package com.warehouseBack.controller;


import com.warehouseBack.domain.Inventory;
import com.warehouseBack.service.IInventoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author XAG
 * @since 2025-09-06
 */
@RestController
@RequestMapping("/inventory")
@Api(tags = "库存管理接口")
public class InventoryController {
    @Autowired
    IInventoryService inventoryService;

    @GetMapping("/WarehouseId/{warehouseId}")
    @ApiOperation(value = "根据仓库id获取库存信息")
    public List<Inventory> getInventoryByWarehouseId(Integer warehouseId){
        return inventoryService.getInventoryByWarehouseId(warehouseId);
    }

    @GetMapping("/ProductId/{productId}")
    @ApiOperation(value = "根据产品id获取库存信息")
    public List<Inventory> getInventoryByProductId(Integer productId){
        return inventoryService.getInventoryByProductId(productId);
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取所有库存信息")
    public List<Inventory> getAllInventory(){
        return inventoryService.getInventoryList();
    }

}

