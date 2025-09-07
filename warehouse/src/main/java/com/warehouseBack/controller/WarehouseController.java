package com.warehouseBack.controller;


import com.warehouseBack.domain.Warehouse;
import com.warehouseBack.service.IWarehouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/warehouse")
@Api(tags = "仓库管理接口")
public class WarehouseController {
    @Autowired
    IWarehouseService warehouseService;

    @GetMapping("/list")
    @ApiOperation(value = "查询仓库列表")
    public List<Warehouse> getWarehouseList(){
        return warehouseService.getWarehouseList();
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加仓库")
    public void addWarehouse(@RequestBody Warehouse warehouse){
        warehouseService.addWarehouse(warehouse);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除仓库")
    public void deleteWarehouse(@RequestParam("id") Integer id){
        warehouseService.deleteWarehouse(id);
    }


}

