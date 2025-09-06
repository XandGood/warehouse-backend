package com.warehouseBack.controller;


import com.warehouseBack.service.IWarehouseService;
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
@RequestMapping("/warehouse")
@Api(tags = "仓库管理接口")
public class WarehouseController {
    @Autowired
    IWarehouseService warehouseService;


}

