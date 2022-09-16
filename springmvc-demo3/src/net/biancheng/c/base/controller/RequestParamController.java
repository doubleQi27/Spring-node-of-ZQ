package net.biancheng.c.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/springmvc")
public class RequestParamController {

    @RequestMapping("/testRequestParam")
    // @RequestParam("name")……括号中的内容与 请求参数名 一样吗，而 控制器方法中的参数名 不必与其一致
    public String testRequestParam(@RequestParam("name") String username, @RequestParam("pass") String password) {
        System.out.println(username + "," + password);
        return "success";
    }
}
