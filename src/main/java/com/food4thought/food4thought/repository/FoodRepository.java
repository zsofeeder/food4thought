package com.food4thought.food4thought.repository;

import com.food4thought.food4thought.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Order, Long> {
}
