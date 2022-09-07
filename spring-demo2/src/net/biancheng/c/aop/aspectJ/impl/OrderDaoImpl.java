package net.biancheng.c.aop.aspectJ.impl;

import net.biancheng.c.aop.aspectJ.IOrderDao;

public class OrderDaoImpl implements IOrderDao {

    @Override
    public void add() {
        System.out.println("正在执行 OrderDao 中的 add() 方法");
    }
    @Override
    public void delete() {
        System.out.println("正在执行 OrderDao 中的 delete() 方法");
    }
    @Override
    public Integer modify() {
        System.out.println("正在执行 OrderDao 中的 modify() 方法");
        return 1;
    }
    @Override
    public void get() {
        //异常
        int a = 10 / 0;
        System.out.println("正在执行 OrderDao 中的 get() 方法");
    }
}
