package com.glodon.practice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class DeptCustomerController {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${service-url.nacos-user-service}")   // 读取配置文件中的某一配置
    private String serverURL;   // 服务提供者

    @GetMapping(value = "/customer/dept/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id){
        return restTemplate.getForObject(serverURL + "/dept/nacos/" + id, String.class);
    }
}
