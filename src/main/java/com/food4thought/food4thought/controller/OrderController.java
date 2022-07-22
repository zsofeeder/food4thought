package com.food4thought.food4thought.controller;

import com.food4thought.food4thought.model.Order;
import com.food4thought.food4thought.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping()
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/active")
    public List<Order> getActiveOrders() {
        return orderService.getActiveOrders();
    }

    @PostMapping()
    public ResponseEntity<Order> postOrder(@RequestBody Order order) {

        Order o = new Order();

        try {
            o = orderService.createOrder(order);
        } catch (Exception e) {
            log.error("Error while saving order", e);
        }
        return new ResponseEntity<>(o, HttpStatus.CREATED);
    }


    @GetMapping("/{userId}")
    public List<Order> getOrdersByACustomer(@PathVariable long userId) {
        return orderService.getOrdersByACustomer(userId);
    }
}
