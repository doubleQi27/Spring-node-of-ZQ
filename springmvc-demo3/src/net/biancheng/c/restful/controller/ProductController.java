package net.biancheng.c.restful.controller;

import net.biancheng.c.restful.dao.ProductDao;
import net.biancheng.c.restful.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author C语言中文网
 */
@Controller
public class ProductController {

    // bean 自动装配，默认 byName，也可 byType
    @Resource
    private ProductDao productDao;
    /**
     * 获取商品列表
     * @param model
     * @return
     */
    @RequestMapping("/products")
    public String getProductList(Model model) {
        List productList = productDao.getProductList();
        model.addAttribute("productList", productList);
        return "product_list";
    }

    /**
     * 查看或回显商品信息，get：查看商品信息  update:为修改页回显的商品信息
     * @param action
     * @param productId
     * @param model
     * @return
     */
    @RequestMapping("/product/{action}/{productId}")     // RESTful风格：@RequestMapping + @PathVariable，参数对应关系不能搞错
    public String getProductList(@PathVariable("action") String action, @PathVariable("productId") String productId, Model model) {
        Product product = productDao.getProductById(productId);
        model.addAttribute("product", product);
        //根据参数 action 判断跳转到商品详细信息页还是商品修改页
        if (action.equals("get")) {
            return "product_info";
        } else {
            return "product_update";
        }
    }

    /**
     * 新增商品
     * @param product
     * @return
     */
    @RequestMapping(value = "/product", method = RequestMethod.POST)   // method 属性，指定请求方式
    public String addProduct(Product product) {
        productDao.addProduct(product);
        return "redirect:/products";         // 视图重定向
    }

    /**
     * 修改商品信息
     * @param product
     * @return
     */
    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public String updateProduct(Product product) {
        productDao.updateProduct(product);
        return "redirect:/products";
    }

    /**
     * 删除商品
     * @param productId
     * @return
     */
    @RequestMapping(value = "/product", method = RequestMethod.DELETE)
    public String deleteProduct(String productId) {
        productDao.deleteProduct(productId);
        return "redirect:/products";
    }
}
