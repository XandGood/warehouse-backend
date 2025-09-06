package com.warehouseBack.controller;


import com.warehouseBack.domain.Product;
import com.warehouseBack.service.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
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
@RequestMapping("/product")
@Api(tags = "产品管理接口")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("/list")
    @ApiOperation(value = "获取所有产品列表", notes = "查询系统中所有产品的信息")
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

}

