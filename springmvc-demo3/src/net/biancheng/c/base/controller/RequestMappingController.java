package net.biancheng.c.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller        //定义控制器类
@RequestMapping("/springmvc")      //所有控制器方法访问的父路径（eg：../springmvc/welcome）
public class RequestMappingController {
    /**
     * @author c语言中文网
     * @RequestMapping value、name、method 属性
     */
    //本控制器方法访问 URL为 ../springmvc/welcome 或 /springmvc/do，允许请求类型为 GET 请求
    @RequestMapping(value = {"/welcome", "/do"}, name = "跳转到欢迎页", method = RequestMethod.GET)
    public String testValue() {
        return "welcome";
    }
    /**
     * @author c语言中文网
     * @RequestMapping 注解 params 属性
     */
    @RequestMapping(value = "/testParam", params = {"name=springmvc", "url=http://c.biancheng.net"})
    public String params() {
        return "param";
    }

    /**
     * @author c语言中文网
     * @RequestMapping 注解 headers 属性
     */
    @RequestMapping(value = "/testHeader", headers = {"Content-Type=application/json", "Referer=http://c.biancheng.net"})
    public String headers() {
        return "header";
    }
}
