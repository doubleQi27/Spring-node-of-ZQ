package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 在 Spring MVC 中，一个普通的 Java 类只要标注了 @Controller 注解，就会被 Spring MVC 识别成 Controller。
// Controller 类中的每一个处理请求的方法被称为“控制器方法”。
@Controller
public class HelloController {

    // @RequestMapping 注解：将 请求 和 处理请求的控制器方法 关联映射起来，建立映射关系。
    // Spring MVC 的 DispatcherServelt 在拦截到指定的请求后，就会根据这个映射关系将请求分发给指定的控制器方法进行处理。
    @RequestMapping("/")
    public String sayHello() {
        //视图名，视图为：视图前缀+index+视图后缀，即 /WEB-INF/template/index.html
        return "index";
    }

    @RequestMapping("/login")
    public String welcome() {
        //视图名，视图为：视图前缀+login+视图后缀，即 /WEB-INF/template/login.html
        return "login";
    }

    @RequestMapping("/register")
    public String success() {
        //视图名，视图为：视图前缀+register+视图后缀，即 /WEB-INF/template/register.html
        return "register";
    }
}