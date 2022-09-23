package com.glodon.practice.controller;

import com.glodon.practice.entity.Dept;
import com.glodon.practice.service.IDeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 服务提供者的控制层
 * author:c语言中文网 c.biancheng.net
 */
// @RestController 是 @Controller 的子集，
// @RestController 是 @Controller 和 @ResponseBody 两个注解的结合体。
// @ResponseBody 将控制器（处理器）方法的返回值封装成 JSON 数据格式再返回。
@RestController
// @Slf4j 默认日志门面，其对应实现为 Logback
@Slf4j
public class DeptController {

    @Autowired
    private IDeptService deptService;

    // 获取配置文件中的单个属性
    @Value("${server.port}")
    private String serverPort;

    // @RequestMapping + @PathVariable 实现 RESTful 风格请求
    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)    // 只接受 GET 类型请求
    public Dept get(@PathVariable("id") int id) {
        return deptService.get(id);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)     // 只接受 GET 类型请求
    public List<Dept> list() {
        return deptService.selectAll();
    }
}
