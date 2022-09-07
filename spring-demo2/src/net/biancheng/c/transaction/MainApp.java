package net.biancheng.c.transaction;

import net.biancheng.c.transaction.entity.OrderEntity;
import net.biancheng.c.transaction.service.IOrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("transaction.xml");
        IOrderService orderService = context.getBean("orderService", IOrderService.class);
        OrderEntity order = new OrderEntity();
        //设置商品 id
        order.setProductId("1");
        //商品数量为 30
        order.setCount(30);
        //商品金额为 600
        order.setMoney(new BigDecimal(600));
        //设置用户 id
        order.setUserId("1");
        //订单状态为未完成
        order.setStatus(0);
        orderService.createOrder(order);
    }
}
