package com.warehouseBack.controller;


import com.warehouseBack.domain.Product;
import com.warehouseBack.service.IProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;

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

}

