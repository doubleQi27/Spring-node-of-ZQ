package net.biancheng.c.aop.dao.impl;

import net.biancheng.c.aop.dao.IOrderDao;

public class OrderDaoImpl implements IOrderDao {

    public void add() {
        System.out.println("正在执行 UserDao 的 add() 方法……");
    }

    public void adds() {
        System.out.println("正在执行 UserDao 的 adds() 方法……");
    }

    public void delete() {
        System.out.println("正在执行 UserDao 的 delete() 方法……");
    }

    public void modify() {
        System.out.println("正在执行 UserDao 的 modify() 方法……");
    }

    public void get() {
        System.out.println("正在执行 UserDao 的 get() 方法……");
    }
}
