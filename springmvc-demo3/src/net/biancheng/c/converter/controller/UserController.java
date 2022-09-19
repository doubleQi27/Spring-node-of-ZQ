// 包说明：converter，数据转换器
package net.biancheng.c.converter.controller;

import net.biancheng.c.converter.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author C语言中文网
 */
@Controller
public class UserController {
    @RequestMapping(value = "/user", method = RequestMethod.POST)    // 只接受 POST 请求
    public String login(User user, Model model) {      // user：请求参数封装为实体类；model：域对象数据共享
        System.out.println(user);
        model.addAttribute("user", user);
        return "success";
    }
}
