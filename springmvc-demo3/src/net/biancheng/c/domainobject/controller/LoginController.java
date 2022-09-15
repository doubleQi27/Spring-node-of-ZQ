package net.biancheng.c.domainobject.controller;

import net.biancheng.c.domainobject.entity.User;
import net.biancheng.c.domainobject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    // 注解注入，不用配置 bean。byName 注入
    @Autowired
    private IUserService userService;

    @RequestMapping("/user")
    public String sayHello() {
        return "user";
    }

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request) {     // 使用 Servlet API 向 request 域对象中共享数据
        User user2 = userService.getUserByUserName(user.getUserName());
        if (user2 != null && user2.getPassword().equals(user.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", user2);
            return "redirect:/getProductList";
        }
        request.setAttribute("msg", "账号或密码错误！");
        return "user";
    }
}
