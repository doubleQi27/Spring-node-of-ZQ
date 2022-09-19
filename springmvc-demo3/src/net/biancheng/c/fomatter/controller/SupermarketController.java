package net.biancheng.c.fomatter.controller;

import net.biancheng.c.fomatter.entity.Supermarket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author C语言中文网
 */
@Controller
public class SupermarketController {
    @RequestMapping(value = "/market", method = RequestMethod.POST)
    public String login(Supermarket market, Model model) {
        model.addAttribute("market", market);
        return "success";
    }
}
