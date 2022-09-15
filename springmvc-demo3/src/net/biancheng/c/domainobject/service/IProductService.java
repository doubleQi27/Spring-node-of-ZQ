package net.biancheng.c.domainobject.service;

import net.biancheng.c.domainobject.entity.Product;

import java.util.List;

public interface IProductService {

    List<Product> getProductList();

    Product getProductById(Integer productId);
}
