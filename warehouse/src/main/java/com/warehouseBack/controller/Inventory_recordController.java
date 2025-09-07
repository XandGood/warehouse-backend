package com.warehouseBack.controller;


import com.warehouseBack.domain.Inventory_record;
import com.warehouseBack.service.IInventory_recordService;
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
@RequestMapping("/inventory_record")
@Api(tags = "库存记录管理接口")
public class Inventory_recordController {
    @Autowired
    IInventory_recordService inventory_recordService;

    @GetMapping("list")
    @ApiOperation(value = "获取库存记录列表")
    public List<Inventory_record> getInventoryRecordList(){
        return inventory_recordService.getInventoryRecordList();
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加库存记录")
    public void addInventoryRecord(@RequestBody Inventory_record inventory_record){
         inventory_recordService.addInventoryRecord(inventory_record);
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation(value = "删除库存记录")
    public boolean deleteInventoryRecord(int id) {
        return inventory_recordService.deleteInventoryRecord(id);
    }
}

