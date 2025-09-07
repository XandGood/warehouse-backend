package com.warehouseBack.service.impl;

import com.warehouseBack.domain.Product;
import com.warehouseBack.dao.ProductDao;
import com.warehouseBack.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author XAG
 * @since 2025-09-06
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductDao, Product> implements IProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getAllProducts() {
        return productDao.selectList(null);
    }
    @Override
    public Product getProductById(Integer id) {
        return productDao.selectById(id);
    }
    @Override
    public boolean updateProduct(Product product) {
        return productDao.updateById(product) > 0;
    }
    @Override
    public boolean deleteProduct(Integer id) {
        return productDao.deleteById(id) > 0;
    }
    @Override
    public boolean addProduct(Product product) {
        return productDao.insert(product) > 0;
    }
}
