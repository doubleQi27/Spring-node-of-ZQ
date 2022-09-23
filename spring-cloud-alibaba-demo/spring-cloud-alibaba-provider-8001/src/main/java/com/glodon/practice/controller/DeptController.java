package com.glodon.practice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController          // = @Controller + @ResponseBody
@Slf4j                   // 日志门面，对应原生实现为 Logback
public class DeptController {

    @Value("${server.port}")        // 读取配置文件中的某个具体配置
    private String serverPort;

    // @GetMapping = @RequestMapping(..., method = RequestMethod.GET)
    // RESTful 风格
    @GetMapping(value = "/dept/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return "<h2>服务访问成功！</h2>服务名：spring-cloud-alibaba-provider<br /> 端口号： " + serverPort + "<br /> 传入的参数：" + id;
    }
}
