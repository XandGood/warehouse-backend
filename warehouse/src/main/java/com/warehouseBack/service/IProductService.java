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
    /**
     * 根据id查询产品
     * @param id 产品id
     * @return 产品
     */
    Product getProductById(Integer id);
    /**
     * 添加产品
     * @param product 产品
     * @return 是否成功
     */
    boolean addProduct(Product product);
    /**
     * 修改产品
     * @param product 产品
     * @return 是否成功
     */
    boolean updateProduct(Product product);
    /**
     * 删除产品
     * @param id 产品id
     * @return 是否成功
     */
    boolean deleteProduct(Integer id);

}
