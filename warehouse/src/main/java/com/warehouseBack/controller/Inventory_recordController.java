package com.warehouseBack.controller;


import com.warehouseBack.service.IInventory_recordService;
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
@RequestMapping("/inventory_record")
@Api(tags = "库存记录管理接口")
public class Inventory_recordController {
    @Autowired
    IInventory_recordService inventory_recordService;
}

