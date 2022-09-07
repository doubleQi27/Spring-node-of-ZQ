package net.biancheng.c.transaction.dao.impl;

import net.biancheng.c.transaction.dao.IOrderDao;
import net.biancheng.c.transaction.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("orderDao")
public class OrderDaoImpl implements IOrderDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int createOrder(OrderEntity order) {
        String sql = "insert into `order` (order_id,user_id, product_id, `count`, money, status) values (?,?,?,?,?,?)";
        int update = jdbcTemplate.update(sql, order.getOrderId(), order.getUserId(), order.getProductId(), order.getCount(), order.getMoney(), order.getStatus());
        return update;
    }

    @Override
    public void updateOrderStatus(String orderId, Integer status) {
        String sql = " update `order`  set status = 1 where order_id = ? and status = ?;";
        jdbcTemplate.update(sql, orderId, status);
    }
}
