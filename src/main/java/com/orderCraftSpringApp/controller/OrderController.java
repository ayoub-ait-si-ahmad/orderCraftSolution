package com.orderCraftSpringApp.controller;

import com.orderCraftSpringApp.model.classes.Order;
import com.orderCraftSpringApp.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String viewOrders(Model model) {
        List<Order> orders = orderService.findAllOrders();
        model.addAttribute("orders", orders);
        return "/orders/orders";
    }

    @GetMapping("/add")
    public String showAddOrderForm(Model model) {
        model.addAttribute("order", new Order());
        return "/orders/order_form";
    }

    @PostMapping("/add")
    public String addOrder(@ModelAttribute Order order) {
        orderService.saveOrder(order);
        return "redirect:/orders";
    }

    @GetMapping("/update/{orderID}")
    public String showUpdateOrderForm(@PathVariable Long orderID, Model model) {
        Order order = orderService.findOrderById(orderID);
        model.addAttribute("order", order);
        return "/orders/order_form";
    }

    @PostMapping("/update/{orderID}")
    public String updateOrder(@ModelAttribute Order order, @PathVariable Long orderID) {
        orderService.updateOrder(orderID, order);
        return "redirect:/orders";
    }

    @PostMapping("/delete/{orderID}")
    public String deleteOrder(@PathVariable Long orderID) {
        orderService.deleteOrder(orderID);
        return "redirect:/orders";
    }
}