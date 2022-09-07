package net.biancheng.c.autowired.controller;

import net.biancheng.c.autowired.service.IUserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

//@Component：告诉 spring 容器这是个 Bean
//@Controller：告诉 spring 容器这是控制层的 Bean
//@Repository：告诉 spring 容器这是持久层（数据访问）的 Bean
//@Service：告诉 spring 容器这是业务层的 Bean
@Controller("userController")
public class UserController {
    //@Resource：按照 Bean 的名称进行自动装配
    @Resource
    private IUserService userService;

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public void doStr() {
        userService.out();
        System.out.println("专注于分享优质编程教程。");
    }

}
