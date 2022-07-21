package com.food4thought.food4thought.controller;

import com.food4thought.food4thought.model.Order;
import com.food4thought.food4thought.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/active")
    public List<Order> getActiveOrders() {
        return orderService.getActiveOrders();
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> postOrder(@RequestBody Order order) throws Exception {

        Order o = orderService.createOrder(order);
        if (o == null) {
            throw new Exception();
        } else {
            return new ResponseEntity<>(o, HttpStatus.CREATED);
        }
    }

    //get /orders/{user}

    @GetMapping("/orders/{userId}")
    public List<Order> getOrdersFromACustomer(@PathVariable long userId) {
        return orderService.getOrdersFromACustomer(userId);
    }
}
