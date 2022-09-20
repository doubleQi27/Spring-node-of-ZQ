package com.glodon.practice.springbootdemo.hello.controller;

import com.glodon.practice.springbootdemo.hello.entity.Cat;
import com.glodon.practice.springbootdemo.hello.entity.Person;
import com.glodon.practice.springbootdemo.hello.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/helloController")
public class HelloController {

    @Resource
    private Person person;
    @Resource
    private Cat cat;
    @Resource
    private Student student;

    @ResponseBody
    @RequestMapping("/hello")
    public Person hello() {
        return person;
    }

    @ResponseBody
    @RequestMapping("/helloKitty")
    public Cat helloKitty(){
        return cat;
    }

    @ResponseBody
    @RequestMapping("/helloStudent")
    public Student helloStudent(){
        return student;
    }
}
