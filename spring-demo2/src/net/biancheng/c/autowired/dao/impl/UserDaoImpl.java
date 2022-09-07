package net.biancheng.c.autowired.dao.impl;

import net.biancheng.c.autowired.dao.IUserDao;
import org.springframework.stereotype.Repository;

//@Repository：告诉 spring 容器这是持久层（数据访问）的 Bean
@Repository("userDao")
public class UserDaoImpl implements IUserDao {
    @Override
    public void print() {
        System.out.println("C语言中文网");
    }
}