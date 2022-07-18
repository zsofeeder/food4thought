package com.food4thought.food4thought.service;

import com.food4thought.food4thought.model.Order;
import com.food4thought.food4thought.model.OrderState;
import com.food4thought.food4thought.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.food4thought.food4thought.model.OrderState.AT_CUSTOMER;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getActiveOrders() {
        List<Order> allOrders = orderRepository.findAll();
        return allOrders.stream().filter(Order::isActive).collect(Collectors.toList());

        /* allOrders.stream().forEach(o -> {
            if (o.getState() != AT_CUSTOMER) {
                activeOrders.add(o);
            }
        });

        for (Order o : allOrders) {
            if (o.isActive()) {
                activeOrders.add(o);
            }
        }
        return activeOrders; */
    }
}
