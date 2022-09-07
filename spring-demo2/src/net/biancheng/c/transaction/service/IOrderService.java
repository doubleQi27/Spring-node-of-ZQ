package net.biancheng.c.transaction.service;

import net.biancheng.c.transaction.entity.OrderEntity;

public interface IOrderService {
    /**
     * 创建订单
     * @param order
     * @return
     */
    public void createOrder(OrderEntity order);
}
