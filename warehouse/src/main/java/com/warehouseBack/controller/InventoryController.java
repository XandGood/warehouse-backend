package com.warehouseBack.controller;


import com.warehouseBack.service.IInventoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
}

