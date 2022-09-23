package com.glodon.practice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RefreshScope    // 配置自动更新
public class ConfigClientController {

    @Value("${config.info}")
    private String ConfigInfo;

    @GetMapping("/config/info")
    public String getConfigInfo(){
        return ConfigInfo;
    }
}
