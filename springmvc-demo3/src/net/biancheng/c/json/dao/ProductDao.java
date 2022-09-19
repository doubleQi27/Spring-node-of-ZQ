package net.biancheng.c.json.dao;

import net.biancheng.c.json.entity.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository("productDao")
public class ProductDao {

    private static Map<String, Product> products = null;

    static {
        products = new HashMap<String, Product>();

        Product product = new Product();
        product.setProductId("1");
        product.setProductName("茅台");
        product.setPrice(new BigDecimal(9999));
        product.setStock(1000);
        product.setIntroduction("茅台酒是大曲酱香型酒的鼻祖。");

        Product product1 = new Product();
        product1.setProductId("2");
        product1.setProductName("五粮液");
        product1.setPrice(new BigDecimal(8888));
        product1.setStock(1000);
        product1.setIntroduction("五粮液，四川省宜宾市特产，中国国家地理标志产品。");

        Product product2 = new Product();
        product2.setProductId("3");
        product2.setProductName("信阳毛尖");
        product2.setPrice(new BigDecimal(7777));
        product2.setStock(1000);
        product2.setIntroduction("信阳毛尖又称豫毛峰，属绿茶类，是中国十大名茶之一，也是河南省著名特产之一；");

        Product product3 = new Product();
        product3.setProductId("4");
        product3.setProductName("深州大蜜桃");
        product3.setPrice(new BigDecimal(6666));
        product3.setStock(1000);
        product3.setIntroduction("深州蜜桃，河北省深州市特产，中国国家地理标志产品。");

        products.put(product.getProductId(), product);
        products.put(product1.getProductId(), product1);
        products.put(product2.getProductId(), product2);
        products.put(product3.getProductId(), product3);
    }
    /**
     * 获取商品列表
     *
     * @return
     */
    public List getProductList() {
        List productList = new ArrayList();
        Set<String> keys = products.keySet();
        for (String key : keys) {
            Product product = products.get(key);
            productList.add(product);
        }
        return productList;
    }
    /**
     * 根据商品 id 获取商品信息
     *
     * @param productId
     * @return
     */
    public Product getProductById(String productId) {
        return products.get(productId);
    }
    /**
     * 新增商品
     *
     * @param product
     */
    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }
    /**
     * 修改商品
     *
     * @param product
     */
    public void updateProduct(Product product) {
        products.put(product.getProductId(), product);
    }
    /**
     * 删除商品
     *
     * @param productId
     */
    public void deleteProduct(String productId) {
        products.remove(productId);
    }
}
