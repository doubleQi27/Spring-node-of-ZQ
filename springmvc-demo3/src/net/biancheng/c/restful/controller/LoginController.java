package net.biancheng.c.restful.controller;

import net.biancheng.c.restful.dao.UserDao;
import net.biancheng.c.restful.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author C语言中文网
 */
@Controller
public class LoginController {
    @Autowired
    private UserDao userDao;
    /**
     * 登录
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request) {    // 请求参数封装到实体类 user，HttpServletRequest 形参用于域对象共享数据

        User loginUser = userDao.getUserByUserName(user.getUserName());

        if (loginUser != null && loginUser.getPassword().equals(user.getPassword())) {
            HttpSession session = request.getSession();
            //将用户信息放到 session 域中
            session.setAttribute("loginUser", loginUser);
            //重定向到商品列表
            return "redirect:/products";
        }
        request.setAttribute("msg", "账号或密码错误");
        return "login";
    }
}
