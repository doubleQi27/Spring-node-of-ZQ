package net.biancheng.c.domainobject.service.impl;

import net.biancheng.c.domainobject.dao.ProductDao;
import net.biancheng.c.domainobject.entity.Product;
import net.biancheng.c.domainobject.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getProductList() {
        return productDao.getProductList();
    }

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
