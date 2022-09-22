package com.glodon.practice.springbootdemo.springconfig.service.impl;


import com.glodon.practice.springbootdemo.hello.entity.Person;
import com.glodon.practice.springbootdemo.springconfig.service.IPersonService;

public class PersonServiceImpl implements IPersonService {

    // 不使用 @Autowired 自动装配，在 Person 的定义中，已经使用 @Component + @ConfigurationProperties 装配其属性值
    private Person person;

    @Override
    public Person getPersonInfo() {
        return person;
    }
}
