package net.biancheng.c.aop.aspectJ.annotation.dao.impl;

import net.biancheng.c.aop.aspectJ.annotation.dao.IUserDao;
import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDaoImpl implements IUserDao {

    @Override
    public void add() {
        System.out.println("正在执行 UserDao 的 add 方法");
    }
    @Override
    public void delete() {
        System.out.println("正在执行 UserDao 的 delete 方法");
    }
    @Override
    public int modify() {
        System.out.println("正在执行 UserDao 的 modify 方法");
        return 1;
    }
    @Override
    public void get() {
        System.out.println("正在执行 UserDao 的 get 方法");
    }
}
