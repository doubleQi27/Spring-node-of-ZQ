package net.biancheng.c.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ParamController {
    @RequestMapping("/")
    public String sayHello() {
        return "index";
    }
    /**
     * 通过 HttpServletRequest 获取请求参数
     * @param request
     * @return
     */
    @RequestMapping("/getRequestParam")
    public String requestParam(HttpServletRequest request) {       // HttpServletRequest：封装请求参数
        String name = request.getParameter("name");    // 调用.getParameter 获取 HttpServletRequest 对象中封装的请求参数
        String url = request.getParameter("url");
        System.out.println("name:" + name);
        System.out.println("url:" + url);
        return "index";
    }
}
