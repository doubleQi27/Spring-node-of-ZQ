package net.biancheng.c.json.controller;

import net.biancheng.c.json.dao.ProductDao;
import net.biancheng.c.json.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author C语言中文网
 */
@Controller
public class ProductController {
    @Resource
    private ProductDao productDao;
    /**
     * 查看或回显商品信息，get：查看商品信息  update:为修改页回显的商品信息
     */
    @ResponseBody       // 此注解作用于方法上，将方法返回的 java 对象转换为 JSON 格式响应到浏览器前台
    @RequestMapping("/product/{productId}")     // @RequestMapping + @PathVariable：RESTful 风格
    public Product getProduct(@PathVariable("productId") String productId) {
        Product product = productDao.getProductById(productId);
        return product;
    }
    /**
     * 新增商品
     *
     * @param product
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product) {    // @RequestBody 作用于方法，将请求参数（JSON 格式）转换为方法参数（一个具体的 java 类对象）
        productDao.addProduct(product);
        return product;
    }
    /**
     * 删除指定的商品
     *
     * @param productId
     * @return
     */
    @RequestMapping(value = "/product", method = RequestMethod.DELETE)
    public String deleteProduct(String productId) {
        productDao.deleteProduct(productId);
        return "redirect:/products";
    }
    /**
     * 获取商品列表
     *
     * @return
     */
    @ResponseBody     // 可以将返回的数组封装为数组结构的 JSON 数据
    @RequestMapping("/getProductList1")
    public List<Product> getProductList1() {
        List productList = productDao.getProductList();
        return productList;
    }
    /**
     * 修改商品信息
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "/edit-product")
    public String updateProduct(Product product) {
        productDao.updateProduct(product);
        return "redirect:/products";
    }
}
