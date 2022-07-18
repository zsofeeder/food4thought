package com.food4thought.food4thought.service;

import com.food4thought.food4thought.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class FoodService {
    @Autowired
    private FoodRepository foodRepository;

}
