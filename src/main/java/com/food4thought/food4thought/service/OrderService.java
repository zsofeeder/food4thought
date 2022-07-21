package com.food4thought.food4thought.service;

import com.food4thought.food4thought.model.Order;
import com.food4thought.food4thought.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

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

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getOrdersFromACustomer(long customerId) {
        return orderRepository.findAllById(Collections.singleton(customerId));
    }
}
