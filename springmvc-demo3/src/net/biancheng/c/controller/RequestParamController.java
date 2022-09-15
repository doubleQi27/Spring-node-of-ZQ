package net.biancheng.c.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/springmvc")
public class RequestParamController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("name") String username, @RequestParam("pass") String password) {
        System.out.println(username + "," + password);
        return "success";
    }
}
