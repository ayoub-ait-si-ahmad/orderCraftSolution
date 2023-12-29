package com.orderCraftSpringApp.service.interfaces;

import com.orderCraftSpringApp.model.classes.Order;

import java.util.List;

public interface OrderService {
    // TODO: HADXE KHAS IT3AWAD
    Order findOrderById(Long orderID);
    Order saveOrder(Order order);
    Order updateOrder(Long orderID, Order order);
    boolean deleteOrder(Long orderID);
    List<Order> findAllOrders();
}