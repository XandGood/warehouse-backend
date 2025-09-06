package com.warehouseBack.service;

import com.warehouseBack.domain.Product;
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
public interface IProductService extends IService<Product> {
    /**
     * 查询所有产品
     * @return 产品列表
     */
    List<Product> getAllProducts();
}
