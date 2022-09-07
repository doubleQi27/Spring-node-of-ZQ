package net.biancheng.c.transaction.dao;

import net.biancheng.c.transaction.entity.OrderEntity;

public interface IOrderDao {

    /**
     * 创建订单
     * @param order
     * @return
     */
    int createOrder(OrderEntity order);

    /**
     * 修改订单状态
     * 将订单状态从未完成（0）修改为已完成（1）
     * @param orderId
     * @param status
     */
    void updateOrderStatus(String orderId, Integer status);
}
