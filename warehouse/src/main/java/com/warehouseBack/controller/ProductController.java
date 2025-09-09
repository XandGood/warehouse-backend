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

    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取产品信息", notes = "根据提供的ID查询产品的详细信息")
    public Product getProductById(@PathVariable("id") Integer id) {
        return productService.getProductById(id);
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加新产品", notes = "根据提供的参数添加新的产品信息")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新产品信息", notes = "根据提供的参数更新产品的详细信息")
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除产品", notes = "根据提供的ID删除产品信息")
    public void deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteProduct(id);
    }

}

