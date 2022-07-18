package com.food4thought.food4thought.controller;

import com.food4thought.food4thought.repository.OrderRepository;
import com.food4thought.food4thought.model.Order;
import com.food4thought.food4thought.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/active_orders")
    public List<Order> getActiveOrders() {
        return orderService.getActiveOrders();
    }




}
