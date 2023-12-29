package com.orderCraftSpringApp.service.implementations;

import com.orderCraftSpringApp.model.classes.Order;
import com.orderCraftSpringApp.repository.OrderRepository;
import com.orderCraftSpringApp.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    // TODO: HADXE KHAS IT3AWAD

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order findOrderById(Long orderID) {
        return orderRepository.findById(orderID)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long orderID, Order orderDetails) {
        Order order = findOrderById(orderID);
        order.setOrderSerial(orderDetails.getOrderSerial());
        order.setOrderDate(orderDetails.getOrderDate());
        order.setOrderStatus(orderDetails.getOrderStatus());
        return orderRepository.save(order);
    }

    @Override
    public boolean deleteOrder(Long orderID) {
        Order order = findOrderById(orderID);
        orderRepository.delete(order);
        return true;
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }
}