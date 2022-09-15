package net.biancheng.c.domainobject.controller;

import net.biancheng.c.domainobject.entity.Product;
import net.biancheng.c.domainobject.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/getProductList")
    public ModelAndView getProductList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productList");
        List<Product> productList = productService.getProductList();
        modelAndView.addObject(productList);
        return modelAndView;     // 使用 ModelAndView 向 request 域对象中共享数据（注意这里是返回值）
    }

    @RequestMapping("/getProduct")
    public String getProduct(Integer productId, Model model) {       // 使用 Model 向 request 域对象中共享数据
        Product productById = productService.getProductById(productId);
        model.addAttribute("product", productById);
        return "product";
    }
}
