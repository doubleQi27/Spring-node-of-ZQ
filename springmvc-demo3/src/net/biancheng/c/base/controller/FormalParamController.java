package net.biancheng.c.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormalParamController {
    /**
     * 跳转到 user.html
     * @return
     */
    @RequestMapping("/user")
    public String sayHello() {
        return "user";
    }
    /**
     * 通过形参获取请求参数
     * @param userId
     * @param userName
     * @param password
     * @return
     */
    // http://localhost:8080/springmvc-requestparam-demo/user?userId=123&userName=admin&password=123
    // 方法形参 必须与 请求参数 名称完全一致（区分大小写）
    @RequestMapping("/getFormalParam")
    public String getFormalParam(String userId, String userName, String password) {
        System.out.println("userId：" + userId);
        System.out.println("userName：" + userName);
        System.out.println("password：" + password);
        return "success";
    }
}
