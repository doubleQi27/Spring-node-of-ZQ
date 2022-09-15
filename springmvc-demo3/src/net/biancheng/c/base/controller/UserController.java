package net.biancheng.c.base.controller;

import net.biancheng.c.base.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    /**
     * 通过实体类获取请求参数
     *
     * @param user
     * @return
     */
    @RequestMapping("/getUser")
    public String getUser(User user) {
        System.out.println("userId：" + user.getUserId());
        System.out.println("userName：" + user.getUserName());
        System.out.println("password：" + user.getAge());
        return "success";
    }
}
